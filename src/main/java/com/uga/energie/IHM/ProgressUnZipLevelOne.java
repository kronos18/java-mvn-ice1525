package com.uga.energie.IHM;

import com.uga.energie.UnZip;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

class ProgressUnZipLevelOne extends Timer implements ActionListener{
    private JProgressBar bar;

    private Double count = 0.0;
    private int totalCount = 0;

    private String OUTPUT_FOLDER;
    private String INPUT_FOLDER;

    private  ZipInputStream zis = null;

    public ProgressUnZipLevelOne(int delay, JProgressBar bar, String in, String out) {
        super(delay,null);
        this.bar = bar;
        this.bar.setStringPainted(true);

        this.OUTPUT_FOLDER = out;
        this.INPUT_FOLDER = in;

        try {

            //create output directory is not exists
            File folder = new File(OUTPUT_FOLDER);
            if (!folder.exists()) {
                folder.mkdir();
            }

            //get the zip file content
            zis = new ZipInputStream(new FileInputStream(in));
            //get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {
                totalCount++;
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();

            zis = new ZipInputStream(new FileInputStream(INPUT_FOLDER));

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        byte[] buffer = new byte[1024];
        try {
            ZipEntry ze = zis.getNextEntry();

            if (ze == null) {
                /*
                bar.setValue(0);
                bar.setString("");
                bar.setStringPainted(false);
                */
                zis.closeEntry();
                zis.close();
                this.stop();
            }
            else{

                String fileName = ze.getName();
                File newFile = new File(OUTPUT_FOLDER + File.separator + fileName);

                System.out.println("file unzip : " + newFile.getAbsoluteFile());

                //create all non exists folders
                //else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);

                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }

                fos.close();

                count ++;
                Double d = count / totalCount * 100;
                bar.setValue(d.intValue());
                bar.setString("Desarchivage fichier principal; fichier " + count.intValue() + " sur " + totalCount);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}