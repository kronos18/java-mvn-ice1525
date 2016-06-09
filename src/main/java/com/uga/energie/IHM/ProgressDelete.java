package com.uga.energie.IHM;

import com.uga.energie.UnZip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

class ProgressDelete extends Timer implements ActionListener{
    private JProgressBar bar;
    private Double count = 0.0;
    private File directory;
    private String OUTPUT_FOLDER;

    public ProgressDelete(int delay, JProgressBar bar, String OUTPUT_FOLDER) {
        super(delay,null);
        this.bar = bar;
        this.bar.setStringPainted(true);

        directory = new File(OUTPUT_FOLDER + "\\data");

        //make sure directory exists
        if(!directory.exists()){
            System.out.println("Directory does not exist.");
            System.exit(0);

        }
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try{
            bar.setValue(0);
            bar.setString("Suppression des dossiers et des fichiers....");
            UnZip.delete(directory);
            bar.setValue(100);
            bar.setString("Suppression des dossiers et fichiers effectuées");
            this.stop();
        }
        catch(Exception ex){
            ex.printStackTrace();
            System.exit(0);
        }
    }
}