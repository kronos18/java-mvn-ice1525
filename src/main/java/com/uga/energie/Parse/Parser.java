package com.uga.energie.Parse;

import com.uga.energie.Optimizer;
import com.uga.energie.model.*;
import com.uga.energie.repository.Repository;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 06-Jun-16.
 */
public class Parser {

    private String m_sPathToParse;
    private int nbFilesToParse;
    private int nbFilesThreated;

    public Parser(String sPathToParse) {
        m_sPathToParse = sPathToParse;
    }

    public List<p_Quartier> Parse(int nbFilesToParse) {
        this.nbFilesToParse = nbFilesToParse;
        List<p_Quartier> lsRes = new ArrayList<p_Quartier>();
        List<File> lsTXTFiles = new ArrayList<File>();

        findFilesInDir(new File(m_sPathToParse), lsTXTFiles);

        int iNbFileParsed = 0;
        for (File file : lsTXTFiles) {
            this.nbFilesThreated = iNbFileParsed;
            p_Quartier quartierFromTXTFile = getQuartierFromTXTFile(file);

            //Execute des algos de compression de donnees. On peut choisir d'optimiser ou non en supprimant les zéro et/ou en utilisant ou non les tables Date et Heure
            Optimizer opt = new Optimizer(quartierFromTXTFile, true, true);
            opt.FromParserToJDBC();

            /*Respect des insertions en base*/
            /*Ordre:
            * 1 : Toutes les dates
            * 2 : Toutes les heures
            * 3 : Toutes les quartiers
            * 4 : Toutes les maisons
            * 5 : Toutes les types d'appareil
            * 6 : Toutes les appareils
            * 7 : Toutes les consommations
            * */

            /*Insertion des elements*/
//            insertDates(opt.getListeDate());
//            insertHeures(opt.getListeHeure());
//            insertQuartiers(opt.getListeQuartier());
//            insertMaisons(opt.getListeMaison());
//            insertTypesAppareil(opt.getListeTypeAppareil());
//            insertAppareils(opt.getListeAppareil());
//            insertConsommations(opt.getListeConsommation());

//            lsRes.add(quartierFromTXTFile);
            iNbFileParsed++;

            if (nbFilesToParse == iNbFileParsed)
                break;
        }

        return lsRes;
    }

    public String getM_sPathToParse() {
        return m_sPathToParse;
    }

    public void setM_sPathToParse(String m_sPathToParse) {
        this.m_sPathToParse = m_sPathToParse;
    }

    public int getNbFilesToParse() {
        return nbFilesToParse;
    }

    public void setNbFilesToParse(int nbFilesToParse) {
        this.nbFilesToParse = nbFilesToParse;
    }

    public int getNbFilesThreated() {
        return nbFilesThreated;
    }

    public void setNbFilesThreated(int nbFilesThreated) {
        this.nbFilesThreated = nbFilesThreated;
    }

    public String getPathToParse() {
        return m_sPathToParse;
    }

    public void setPathToParse(String sPath) {
        m_sPathToParse = sPath;
    }

    private void insertConsommations(List<Consommation> listeConsommation) {
        Iterator iterator;
        System.out.println("Insertion consommation");
        iterator = listeConsommation.iterator();
        while (iterator.hasNext()) {
            Consommation consommation = (Consommation) iterator.next();
            Repository.getConsommationRepository().create(consommation);
        }
    }

    private void insertAppareils(List<Appareil> listeAppareil) {
        Iterator iterator;
        System.out.println("Insertion appareil");
        iterator = listeAppareil.iterator();
        while (iterator.hasNext()) {
            Appareil appareil = (Appareil) iterator.next();
            Repository.getAppareilRepository().create(appareil);
        }
    }

    private void insertTypesAppareil(List<TypeAppareil> listeTypeAppareil) {
        Iterator iterator;
        System.out.println("Insertion type appareil");
        iterator = listeTypeAppareil.iterator();
        while (iterator.hasNext()) {
            TypeAppareil typeAppareil = (TypeAppareil) iterator.next();
            Repository.getTypeAppareilRepository().create(typeAppareil);
        }
    }

    private void insertMaisons(List<Maison> listeMaison) {
        Iterator iterator;
        System.out.println("Insertion maison");
        iterator = listeMaison.iterator();
        while (iterator.hasNext()) {
            Maison maison = (Maison) iterator.next();
            Repository.getMaisonRepository().create(maison);
        }
    }

    private void insertQuartiers(List<Quartier> listeQuartier) {
        Iterator iterator;
        System.out.println("Insertion quartier");
        iterator = listeQuartier.iterator();
        while (iterator.hasNext()) {
            Quartier quartier = (Quartier) iterator.next();
            Repository.getQuartierRepository().create(quartier);
        }
    }

    private void insertHeures(List<Heure> listeHeure) {
        Iterator iterator;
        System.out.println("Insertion heure");
        iterator = listeHeure.iterator();
        while (iterator.hasNext()) {
            Heure heure = (Heure) iterator.next();
            Repository.getHeureRepository().create(heure);
        }
    }

    private void insertDates(List<Date> listeDate) {
        Iterator iterator = listeDate.iterator();
        while (iterator.hasNext()) {
            Date date = (Date) iterator.next();
            Repository.getDateRepository().create(date);
        }
    }

    private p_Quartier getQuartierFromTXTFile(File file) {
        if (!file.isFile())
            return null;

        //File name = 1000080-200099-3000048.txt
        String sFileName = file.getName().replace(".txt", "");
        List<String> lsLines = readFile(file);

        String[] fileName = sFileName.split("-");
        int iNumQuartier = Integer.parseInt(fileName[0]) - 1000000;
        int iNumMaison = Integer.parseInt(fileName[1]) - 2000000;
        int iNumAppareil = Integer.parseInt(fileName[2]) - 3000000;

        //Quartier
        p_Quartier quartier = new p_Quartier(iNumQuartier);

        //Maison
        p_Maison maison = new p_Maison(iNumMaison, quartier);
        quartier.addMaison(maison);

        //Type Appareil : todo voir quels types on pourrait mettre à la place de inconnu...
        p_TypeAppareil typeAppareil = new p_TypeAppareil(1, "Inconnu");

        //Appareil
        String sAppName = getAppareilNameFromFile(lsLines);
        p_Appareil appareil = new p_Appareil(iNumAppareil, sAppName, typeAppareil, maison);
        maison.addAppareil(appareil);
        typeAppareil.addAppareil(appareil);

        //Consommation
        List<p_Consommation> lsConso = getAllConsommationFromFile(lsLines, appareil);
        for (p_Consommation conso : lsConso) {
            appareil.addConsommation(conso);
        }

        return quartier;
    }

    private List<p_Consommation> getAllConsommationFromFile(List<String> lsFileLines, p_Appareil appareil) {
        List<p_Consommation> lsRes = new ArrayList<p_Consommation>();

        for (String sLine : lsFileLines) {
            if (sLine.indexOf("PROJECT ") >= 0 ||
                    sLine.indexOf("HOUSEHOLD") >= 0 ||
                    sLine.indexOf("APPLIANCE") >= 0 ||
                    sLine.length() <= 1 ||
                    sLine.indexOf("DATE(dd/mm/yy)") >= 0)
                continue;

            //      22/01/98	15:50	0	000000
            String[] line = sLine.split("\t");
            String sDate = line[0];
            String sHeure = line[1];
            int iState = Integer.parseInt(line[2]);
            int iValue = Integer.parseInt(line[3]);

            p_Consommation conso = new p_Consommation(sDate, sHeure, appareil, iState, iValue);
            lsRes.add(conso);
        }

        return lsRes;
    }

    private String getAppareilNameFromFile(List<String> lsFileLines) {
        String sAppName = null;

        for (String s : lsFileLines) {
            if (s.indexOf("APPLIANCE") > -1) {
                sAppName = s.split(" : ")[1];
                break;
            }
        }

        return sAppName;
    }

    private List<String> readFile(File file) {
        List<String> lsLines = new ArrayList<String>();
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                lsLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lsLines;
    }

    private void findFilesInDir(File dirToParse, List<File> allTXTFiles) {
        if (dirToParse.isFile()) {
            allTXTFiles.add(dirToParse);

        } else if (dirToParse.isDirectory()) {
            List<File> lsFilesInDir = new ArrayList<File>(Arrays.asList(dirToParse.listFiles()));
            for (File file : lsFilesInDir) {
                findFilesInDir(file, allTXTFiles);
            }
        }
    }
}
