package com.uga.energie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Max on 06-Jun-16.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        String s = "";
        do {
            System.out.println("=============================");
            System.out.println("====== Menu =================");
            System.out.println("=============================");
            System.out.println("== 1 : Unzip");
            System.out.println("== 2 : Read and insert");
            System.out.println("== 9 : exit");
            System.out.println("=============================");
            s = Main.readLine("");

            if (Integer.parseInt(s) == 1)
                Main.Unzip();
            else if (Integer.parseInt(s) == 2)
                Main.ReadAndInsert();
            else if (Integer.parseInt(s) == 9)
                ;
            else
                System.out.println("Commande inconnue...");
        } while (Integer.parseInt(s) != 9);

        System.out.println("Press enter to close...");
        Main.readLine("");
    }

    private static void ReadAndInsert() {
        System.out.println("todo :)");
    }

    private static void Unzip() {
        System.out.println("todo :)");
    }

    private static String readLine(String format, Object... args) throws IOException {
        if (System.console() != null) {
            return System.console().readLine(format, args);
        }
        System.out.print(String.format(format, args));
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        return reader.readLine();
    }

    private char[] readPassword(String format, Object... args)
            throws IOException {
        if (System.console() != null)
            return System.console().readPassword(format, args);
        return this.readLine(format, args).toCharArray();
    }

    }
