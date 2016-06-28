package com.uga.energie.controllers;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Ivan on 28/06/2016.
 */
public class ChronoActionListener implements ActionListener {
    private static int heure = 0, minute = 0, seconde = 0;
    private final JLabel jLabel;

    public ChronoActionListener(JLabel jLabel) {
        this.jLabel = jLabel;
    }

    public void actionPerformed(ActionEvent e) {

        seconde++;
        if (seconde == 60) {
            seconde = 0;
            minute++;
        }
        if (minute == 60) {
            minute = 0;
            heure++;
        }
        /* on rafraichit le label */
        jLabel.setText(heure + ":" + minute + ":" + seconde);
    }


    public static int getHeure() {
        return heure;
    }

    public static void setHeure(int heure) {
        ChronoActionListener.heure = heure;
    }

    public static int getMinute() {
        return minute;
    }

    public static void setMinute(int minute) {
        ChronoActionListener.minute = minute;
    }

    public static int getSeconde() {
        return seconde;
    }

    public static void setSeconde(int seconde) {
        ChronoActionListener.seconde = seconde;
    }

    public JLabel getjLabel() {
        return jLabel;
    }
}
