package com.uga.energie.service;

import com.uga.energie.IHM.ProgressInsertDB;
import com.uga.energie.Parse.Parser;

import javax.swing.*;

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
    private Timer timer;
    private Parser parser;

    public ReadAndInsertThreader(String sPathToParse,
                                 int iNbFilesToRead,
                                 boolean isOptimizeZero,
                                 boolean isOptimizeDate,
                                 Timer timer,
                                 JButton jButtonReadAll,
                                 JButton jButtonReadTen,
                                 JProgressBar jProgressBarBottom) {
        super();
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
//        this.timer.start();
        this.parser = new Parser(m_sPathToParse);
        ProgressInsertDB progressInsert = new ProgressInsertDB(1000,
                                                               jProgressBarBottom,
                                                               this.parser);
        progressInsert.start();
//        List<p_Quartier> lsQuartier = parser.Parse(m_iNbFilesToRead);
        this.parser.Parse(m_iNbFilesToRead);
        this.jButtonReadAll.setEnabled(true);
        this.jButtonReadTen.setEnabled(true);


//        //Execute des algos de compression de donnees. On peut choisir d'optimiser ou non en supprimant les zéro et/ou en utilisant ou non les tables Date et Heure
//        Optimizer opt = new Optimizer(lsQuartier, m_isOptimizeZero, m_isOptimizeDate);
//        opt.FromParserToJDBC();

        //Tu peux maintenant acceder aux objets à inserrer en base, par exemple la liste des appareils :
//
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
