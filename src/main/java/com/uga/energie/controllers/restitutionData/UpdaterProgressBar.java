package com.uga.energie.controllers.restitutionData;

import com.uga.energie.IHM.MainFrame;
import com.uga.energie.IHM.ProgressInsertDB;
import com.uga.energie.Parse.Parser;

import javax.swing.*;

/**
 * Created by Lenovo on 04/07/2016.
 */
public class UpdaterProgressBar implements Runnable {

    private MainFrame mainFrame;
    private JProgressBar jProgressBar;
    private Parser parser;

    public UpdaterProgressBar(MainFrame mainFrame, JProgressBar jProgressBar, Parser parser) {
        this.mainFrame = mainFrame;
        this.jProgressBar = jProgressBar;
        this.parser = parser;
    }

    public void run() {
        ProgressInsertDB progressInsert = new ProgressInsertDB(1000,
                                                               jProgressBar,
                                                               this.parser);
//        List<p_Quartier> lsQuartier = parser.Parse(m_iNbFilesToRead);
        progressInsert.start();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    public JProgressBar getjProgressBar() {
        return jProgressBar;
    }

    public void setjProgressBar(JProgressBar jProgressBar) {
        this.jProgressBar = jProgressBar;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }
}
