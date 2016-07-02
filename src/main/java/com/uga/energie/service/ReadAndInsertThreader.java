package com.uga.energie.service;

import com.uga.energie.Optimizer;
import com.uga.energie.Parse.Parser;
import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.model.*;
import com.uga.energie.repository.Repository;

import javax.swing.*;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 01-Jul-16.
 */
public class ReadAndInsertThreader extends Thread {

    String m_sPathToParse;
    int m_iNbFilesToRead;
    boolean m_isOptimizeZero;
    boolean m_isOptimizeDate;
    private Timer timer;

    public ReadAndInsertThreader(String sPathToParse, int iNbFilesToRead, boolean isOptimizeZero, boolean isOptimizeDate, Timer timer) {
        super();
        this.timer = timer;
        m_sPathToParse = sPathToParse;
        m_iNbFilesToRead = iNbFilesToRead;
        m_isOptimizeZero = isOptimizeZero;
        m_isOptimizeDate = isOptimizeDate;
    }

    public void run() {
//        this.timer.start();
        Parser parser = new Parser(m_sPathToParse);

//        List<p_Quartier> lsQuartier = parser.Parse(m_iNbFilesToRead);
        parser.Parse(m_iNbFilesToRead);
//
//        //Execute des algos de compression de donnees. On peut choisir d'optimiser ou non en supprimant les zéro et/ou en utilisant ou non les tables Date et Heure
//        Optimizer opt = new Optimizer(lsQuartier, m_isOptimizeZero, m_isOptimizeDate);
//        opt.FromParserToJDBC();

        //Tu peux maintenant acceder aux objets à inserrer en base, par exemple la liste des appareils :
//
    }
}
