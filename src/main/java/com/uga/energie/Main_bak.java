package com.uga.energie;

import com.uga.energie.Parse.Parser;
import com.uga.energie.Parse.p_Quartier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by Max on 06-Jun-16.
 */
public class Main_bak {

    public static final String PATH_TO_READ = "D:\\Temp\\AnalyseFonctionnelleEnergie\\output\\data";
    public static final String INPUT_ZIP_FILE = "D:\\Temp\\AnalyseFonctionnelleEnergie\\data.zip";
    public static final String OUTPUT_FOLDER = "D:\\Temp\\AnalyseFonctionnelleEnergie\\output";


    public static void main(String[] args) throws IOException {

        Main_bak mainBak = new Main_bak();
        String s = "";
        do {
            System.out.println("=============================");
            System.out.println("====== Menu =================");
            System.out.println("=============================");
            System.out.println("== 1 : Unzip");
            System.out.println("== 2 : Read and insert");
            System.out.println("== 9 : exit");
            System.out.println("=============================");
            s = mainBak.readLine();

            if (Integer.parseInt(s) == 1) {
                mainBak.Unzip();
            } else if (Integer.parseInt(s) == 2) {
                mainBak.ReadAndInsert();
            } else if (Integer.parseInt(s) == 9) {
                ;
            } else {
                System.out.println("Commande inconnue...");
            }

            System.out.println("");
        } while (Integer.parseInt(s) != 9);

        System.out.println("Press enter to close...");
        mainBak.readLine();
    }

    private void ReadAndInsert() {
        String sPathToRead = PATH_TO_READ;

        // parse le dossier dans lequel ont ete dezippees les donnees
        Parser parser = new Parser(sPathToRead);
        List<p_Quartier> lsQuartier = parser.Parse(0, false, null, null);

        //todo : Executer des algos de compression de donnees

        //todo : inserer la liste de quartier dans la bdd avec JDBC
    }

    private void Unzip() {
        System.out.println("Start to unzip...");

        UnZip unzip = new UnZip();
        UnZip.unZipAllFiles(INPUT_ZIP_FILE, OUTPUT_FOLDER);

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
