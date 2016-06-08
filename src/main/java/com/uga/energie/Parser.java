package com.uga.energie;

import com.uga.energie.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Max on 06-Jun-16.
 */
public class Parser {

    private String m_sPathToParse;

    public Parser(String sPathToParse)
    {
        m_sPathToParse = sPathToParse;
    }

    public String getPathToParse(){
        return m_sPathToParse;
    }
    public void setPathToParse(String sPath)
    {
        m_sPathToParse = sPath;
    }

    public List<Quartier> Parse()
    {
        List<Quartier> lsRes = new ArrayList<Quartier>();
        List<File> lsTXTFiles = new ArrayList<File>();

        findFilesInDir(new File(m_sPathToParse), lsTXTFiles);

        for (File file : lsTXTFiles) {
            lsRes.add(getQuartierFromTXTFile(file));
        }

        return lsRes;
    }

    private Quartier getQuartierFromTXTFile(File file)
    {
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
        Quartier quartier = new Quartier(iNumQuartier);

        //Maison
        Maison maison = new Maison(iNumMaison, quartier);
        quartier.addMaison(maison);

        //Type Appareil : todo voir quels types on pourrait mettre...
        TypeAppareil typeAppareil = null;

        //Appareil
        String sAppName = getAppareilNameFromFile(lsLines);
        Appareil appareil = new Appareil(iNumAppareil, sAppName, typeAppareil, maison);
        maison.addAppareil(appareil);
//        typeAppareil.addAppareil(appareil);

        //Consommation
        List<Consommation> lsConso = getAllConsommationFromFile(lsLines, appareil);
        for (Consommation conso : lsConso) {
            appareil.addConsommation(conso);
        }

        return quartier;
    }

    private List<Consommation> getAllConsommationFromFile(List<String> lsFileLines, Appareil appareil){
        List<Consommation> lsRes = new ArrayList<Consommation>();

        for (String sLine : lsFileLines) {
            if (sLine.indexOf("PROJECT ") >= 0 ||
                    sLine.indexOf("HOUSEHOLD") >= 0 ||
                    sLine.indexOf("APPLIANCE") >= 0 ||
                    sLine.length() <= 1 ||
                    sLine.indexOf("DATE(dd/mm/yy)") >= 0 )
                continue;

            //      22/01/98	15:50	0	000000
            String[] line = sLine.split("\t");
            String sDate = line[0];
            String sHeure = line[1];
            int iState = Integer.parseInt(line[2]);
            int iValue = Integer.parseInt(line[3]);

            Date date = new Date(0, sDate);
            Heure heure = new Heure(0, sHeure);
            Consommation conso = new Consommation(date, heure, appareil, iState, iValue);
            lsRes.add(conso);
        }

        return lsRes;
    }

    private String getAppareilNameFromFile(List<String> lsFileLines){
        String sAppName = null;

        for (String s : lsFileLines) {
            if (s.indexOf("APPLIANCE") > -1){
                sAppName = s.split(" : ")[1];;
                break;
            }
        }

        return sAppName;
    }

    private List<String> readFile(File file){
        List<String> lsLines = new ArrayList<String>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                lsLines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lsLines;
    }

    private void findFilesInDir(File dirToParse, List<File> allTXTFiles)
    {
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
