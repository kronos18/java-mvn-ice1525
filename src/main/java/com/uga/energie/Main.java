package com.uga.energie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Max on 06-Jun-16.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("=============================");
        System.out.println("====== Menu =================");
        System.out.println("=============================");
        System.out.println("== 1 : Unzip and insert into Database...");
        System.out.println("=============================");
        String s = Main.readLine("");

        if (Integer.parseInt(s) == 1)
            Main.UnzipAndInsertIntoDatanase();
        else
            System.out.println("Commande inconnue...");

        System.out.println("Press enter to close...");
        Main.readLine("");
    }

    private static void UnzipAndInsertIntoDatanase() {
        System.out.println("UnzipAndInsertIntoDatanase.......");
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
