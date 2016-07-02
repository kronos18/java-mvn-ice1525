package com.uga.energie.IHM;

import com.uga.energie.Parse.Parser;
import com.uga.energie.UnZip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ProgressInsertDB extends Timer implements ActionListener {
    private JProgressBar bar;
    private Parser parser;

    public ProgressInsertDB(int delay, JProgressBar bar, Parser parser) {
        super(delay, null);
        this.bar = bar;
        this.parser = parser;
        this.bar.setStringPainted(true);

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (null != this.parser) {
            Double pourcentageActuel = ((double) parser.getNbFilesThreated() / (double) parser.getNbFilesToParse()) * 100;
//            System.out.println("Progress bar : OK | nbCurr : " + parser.getNbFilesThreated() + "  | nbTotal : " + parser
//                    .getNbFilesToParse() + " | pourcentage : " + pourcentageActuel);

            bar.setValue(pourcentageActuel.intValue());
            bar.setString("Insertion des fichiers " + pourcentageActuel.intValue() + " %");
//            bar.revalidate();
            if (parser.getNbFilesThreated() == parser.getNbFilesToParse()) {
                this.stop();
            }
        }
    }
}