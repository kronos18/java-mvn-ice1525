package com.uga.energie.Parse;

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

    public List<p_Quartier> Parse()
    {
        List<p_Quartier> lsRes = new ArrayList<p_Quartier>();
        List<File> lsTXTFiles = new ArrayList<File>();

        findFilesInDir(new File(m_sPathToParse), lsTXTFiles);

        for (File file : lsTXTFiles) {
            lsRes.add(getQuartierFromTXTFile(file));
        }

        return lsRes;
    }

    private p_Quartier getQuartierFromTXTFile(File file)
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
        p_Quartier quartier = new p_Quartier(iNumQuartier);

        //Maison
        p_Maison maison = new p_Maison(iNumMaison, quartier);
        quartier.addMaison(maison);

        //Type Appareil : todo voir quels types on pourrait mettre...
        p_TypeAppareil typeAppareil = null;

        //Appareil
        String sAppName = getAppareilNameFromFile(lsLines);
        p_Appareil appareil = new p_Appareil(iNumAppareil, sAppName, typeAppareil, maison);
        maison.addAppareil(appareil);
//        typeAppareil.addAppareil(appareil);

        //Consommation
        List<p_Consommation> lsConso = getAllConsommationFromFile(lsLines, appareil);
        for (p_Consommation conso : lsConso) {
            appareil.addConsommation(conso);
        }

        return quartier;
    }

    private List<p_Consommation> getAllConsommationFromFile(List<String> lsFileLines, p_Appareil appareil){
        List<p_Consommation> lsRes = new ArrayList<p_Consommation>();

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

            p_Consommation conso = new p_Consommation(sDate, sHeure, appareil, iState, iValue);
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
