package com.uga.energie;

import com.uga.energie.model.Quartier;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Max on 06-Jun-16.
 */
public class Main {

    String INPUT_ZIP_FILE = "C:\\Temp\\AnalyseFonctionnelleEnergie\\data.zip";
    String OUTPUT_FOLDER = "C:\\Temp\\AnalyseFonctionnelleEnergie\\output";


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        String s = "";
        do {
            System.out.println("=============================");
            System.out.println("====== Menu =================");
            System.out.println("=============================");
            System.out.println("== 1 : Unzip");
            System.out.println("== 2 : Read and insert");
            System.out.println("== 9 : exit");
            System.out.println("=============================");
            s = main.readLine();

            if (Integer.parseInt(s) == 1)
                main.Unzip();
            else if (Integer.parseInt(s) == 2)
                main.ReadAndInsert();
            else if (Integer.parseInt(s) == 9)
                ;
            else
                System.out.println("Commande inconnue...");

            System.out.println("");
        } while (Integer.parseInt(s) != 9);

        System.out.println("Press enter to close...");
        main.readLine();
    }

    private void ReadAndInsert() {
        String sPathToRead = "C:\\Temp\\AnalyseFonctionnelleEnergie\\output\\data";

        // parse le dossier dans lequel ont ete dezippees les donnees
        Parser parser = new Parser(sPathToRead);
        List<Quartier> lsQuartier = parser.Parse();

        //todo : Executer des algos de compression de donnees

        //todo : inserer la liste de quartier dans la bdd avec JDBC
    }

    private void Unzip() {
        System.out.println("Start to unzip...");

        UnZip unzip = new UnZip();
        unzip.unZipAllFiles(INPUT_ZIP_FILE, OUTPUT_FOLDER);

        System.out.println("Unzip done !");
    }

    private String readLine() throws IOException {
        String format = "";

        if (System.console() != null) {
            return System.console().readLine(format);
        }
        System.out.print(String.format(format));
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        return reader.readLine();
    }
    }
