package com.uga.energie.IHM;

import com.uga.energie.UnZip;

import javax.swing.Timer;
        import javax.swing.JProgressBar;
        import java.awt.event.ActionListener;
        import java.awt.event.ActionEvent;
import java.io.File;

class ProgressUnZipLevelTwo extends Timer implements ActionListener{
    private JProgressBar bar;
    private Double count = 0.0;
    private File[] listOfFiles;
    private String OUTPUT_FOLDER;

    public ProgressUnZipLevelTwo(int delay, JProgressBar bar, String OUTPUT_FOLDER) {
        super(delay,null);
        this.bar = bar;
        this.bar.setStringPainted(true);

        this.OUTPUT_FOLDER = OUTPUT_FOLDER;
        File folder = new File(OUTPUT_FOLDER + "\\data");
        listOfFiles = folder.listFiles();
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        File file = listOfFiles[count.intValue()];
        if (file.isFile()) {
            System.out.println(file.getAbsolutePath());
            UnZip.unZipIt(file.getAbsolutePath(), OUTPUT_FOLDER);
            count++;
        }
        Double d = count / listOfFiles.length * 100;

        bar.setValue(d.intValue());
        bar.setString("Desarchivage fichier " + count.intValue() + " sur " + listOfFiles.length);
        if(count == listOfFiles.length)this.stop();
    }
}