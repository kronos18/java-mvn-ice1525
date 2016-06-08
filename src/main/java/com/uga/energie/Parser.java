package com.uga.energie;

import com.uga.energie.model.Appareil;
import com.uga.energie.model.Maison;
import com.uga.energie.model.Quartier;

import java.io.File;
import java.io.FilenameFilter;
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

        //todo :)
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
        String[] fileName = sFileName.split("-");
        int iNumQuartier = Integer.parseInt(fileName[0]) - 1000000;
        int iNumMaison = Integer.parseInt(fileName[1]) - 2000000;
        int iNumAppareil = Integer.parseInt(fileName[2]) - 3000000;

        //Quartier
        Quartier quartier = new Quartier(iNumQuartier);

        //Maison
        Maison maison = new Maison(iNumMaison, quartier);
        quartier.addMaison(maison);

        //Type Appareil

        //Appareil
        Appareil appareil = new Appareil(iNumAppareil, "", null, maison);
        maison.addAppareil(appareil);

        return quartier;
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
