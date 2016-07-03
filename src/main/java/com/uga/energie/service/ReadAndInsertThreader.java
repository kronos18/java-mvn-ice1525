package com.uga.energie.service;

import com.uga.energie.IHM.MainFrame;
import com.uga.energie.IHM.ProgressInsertDB;
import com.uga.energie.Parse.Parser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Max on 01-Jul-16.
 */
public class ReadAndInsertThreader implements Runnable {

    String m_sPathToParse;
    int m_iNbFilesToRead;
    boolean m_isOptimizeZero;
    boolean m_isOptimizeDate;
    private JButton jButtonReadAll;
    private JButton jButtonReadTen;
    private JProgressBar jProgressBarBottom;
    private MainFrame mainFrame;
    private boolean isWaterInsertion;
    private Timer timer;
    private Parser parser;

    public ReadAndInsertThreader(MainFrame mainFrame, String sPathToParse,
                                 int iNbFilesToRead,
                                 boolean isOptimizeZero,
                                 boolean isOptimizeDate,
                                 boolean isWaterInsertion,
                                 Timer timer,
                                 JButton jButtonReadAll,
                                 JButton jButtonReadTen,
                                 JProgressBar jProgressBarBottom) {
        super();
        this.mainFrame = mainFrame;
        this.isWaterInsertion = isWaterInsertion;
        this.timer = timer;
        m_sPathToParse = sPathToParse;
        m_iNbFilesToRead = iNbFilesToRead;
        m_isOptimizeZero = isOptimizeZero;
        m_isOptimizeDate = isOptimizeDate;
        this.jButtonReadAll = jButtonReadAll;
        this.jButtonReadTen = jButtonReadTen;
        this.jProgressBarBottom = jProgressBarBottom;
        this.parser = null;
    }


    public void run() {
        JDialog dialog = initPleaseWaitJdialog();
        this.mainFrame.setEnabled(false);
        this.timer.start();
        this.parser = new Parser(m_sPathToParse);
        ProgressInsertDB progressInsert = new ProgressInsertDB(1000,
                                                               jProgressBarBottom,
                                                               this.parser);
//        List<p_Quartier> lsQuartier = parser.Parse(m_iNbFilesToRead);
        progressInsert.start();
        this.parser.Parse(m_iNbFilesToRead, isWaterInsertion, this.mainFrame,this.timer);
        this.jButtonReadAll.setEnabled(true);
        this.jButtonReadTen.setEnabled(true);


        /*Enlevez le message pour patienter */
        dialog.setVisible(false);

        /*Reactivation de la MainFrame*/
        this.mainFrame.setEnabled(true);
//        //Execute des algos de compression de donnees. On peut choisir d'optimiser ou non en supprimant les zéro et/ou en utilisant ou non les tables Date et Heure
//        Optimizer opt = new Optimizer(lsQuartier, m_isOptimizeZero, m_isOptimizeDate);
//        opt.FromParserToJDBC();

        //Tu peux maintenant acceder aux objets à inserrer en base, par exemple la liste des appareils :
//
    }

    private JDialog initPleaseWaitJdialog() {
        JDialog dialog = new JDialog();
        JLabel label = new JLabel("Veuillez patienter s'il vous plait ...");
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        dialog.setLocationRelativeTo(mainFrame);
        dialog.setTitle("Please Wait...");
        dialog.setSize(new Dimension(200, 100));
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        dialog.add(label);
//        dialog.pack();
        dialog.setVisible(true);
        return dialog;
    }

    public Parser getParser() {
        return parser;
    }

    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public boolean isM_isOptimizeDate() {
        return m_isOptimizeDate;
    }

    public void setM_isOptimizeDate(boolean m_isOptimizeDate) {
        this.m_isOptimizeDate = m_isOptimizeDate;
    }

    public boolean isM_isOptimizeZero() {
        return m_isOptimizeZero;
    }

    public void setM_isOptimizeZero(boolean m_isOptimizeZero) {
        this.m_isOptimizeZero = m_isOptimizeZero;
    }

    public int getM_iNbFilesToRead() {
        return m_iNbFilesToRead;
    }

    public void setM_iNbFilesToRead(int m_iNbFilesToRead) {
        this.m_iNbFilesToRead = m_iNbFilesToRead;
    }

    public String getM_sPathToParse() {
        return m_sPathToParse;
    }

    public void setM_sPathToParse(String m_sPathToParse) {
        this.m_sPathToParse = m_sPathToParse;
    }
}
