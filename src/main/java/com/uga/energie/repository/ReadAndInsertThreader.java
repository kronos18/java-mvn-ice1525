package com.uga.energie.repository;

import com.uga.energie.Optimizer;
import com.uga.energie.Parse.Parser;
import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.model.*;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Max on 01-Jul-16.
 */
public class ReadAndInsertThreader extends Thread {

    String m_sPathToParse;
    int m_iNbFilesToRead;
    boolean m_isOptimizeZero;
    boolean  m_isOptimizeDate;

    public ReadAndInsertThreader(String sPathToParse, int iNbFilesToRead, boolean isOptimizeZero, boolean isOptimizeDate){
        super();
 ;
        m_sPathToParse = sPathToParse;
        m_iNbFilesToRead = iNbFilesToRead;
        m_isOptimizeZero = isOptimizeZero;
        m_isOptimizeDate = isOptimizeDate;
    }

    public void run(){
        Parser parser = new Parser(m_sPathToParse);

        List<p_Quartier> lsQuartier = parser.Parse(m_iNbFilesToRead);

        //Execute des algos de compression de donnees. On peut choisir d'optimiser ou non en supprimant les zéro et/ou en utilisant ou non les tables Date et Heure
        Optimizer opt = new Optimizer(lsQuartier, m_isOptimizeZero, m_isOptimizeDate);
        opt.FromParserToJDBC();

        //Tu peux maintenant acceder aux objets à inserrer en base, par exemple la liste des appareils :
        List<Date> listeDate = opt.getListeDate();
        List<Heure> listeHeure = opt.getListeHeure();
        List<Quartier> listeQuartier = opt.getListeQuartier();
        List<Maison> listeMaison = opt.getListeMaison();
        List<TypeAppareil> listeTypeAppareil = opt.getListeTypeAppareil();
        List<Appareil> listeAppareil = opt.getListeAppareil();
        List<Consommation> listeConsommation = opt.getListeConsommation();
        System.out.println("Insertion date");
        Iterator iterator = listeDate.iterator();
        while (iterator.hasNext()) {
            Date date = (Date) iterator.next();
            Repository.getDateRepository().create(date);
        }

        System.out.println("Insertion heure");
        iterator = listeHeure.iterator();
        while (iterator.hasNext()) {
            Heure heure = (Heure) iterator.next();
            Repository.getHeureRepository().create(heure);
        }
        System.out.println("Insertion quartier");
        iterator = listeQuartier.iterator();
        while (iterator.hasNext()) {
            Quartier quartier = (Quartier) iterator.next();
            Repository.getQuartierRepository().create(quartier);
        }
        System.out.println("Insertion maison");
        iterator = listeMaison.iterator();
        while (iterator.hasNext()) {
            Maison maison = (Maison) iterator.next();
            Repository.getMaisonRepository().create(maison);
        }
        System.out.println("Insertion type appareil");
        iterator = listeTypeAppareil.iterator();
        while (iterator.hasNext()) {
            TypeAppareil typeAppareil = (TypeAppareil) iterator.next();
            Repository.getTypeAppareilRepository().create(typeAppareil);
        }
        System.out.println("Insertion appareil");
        iterator = listeAppareil.iterator();
        while (iterator.hasNext()) {
            Appareil appareil = (Appareil) iterator.next();
            Repository.getAppareilRepository().create(appareil);
        }
        System.out.println("Insertion consommation");
        iterator = listeConsommation.iterator();
        while (iterator.hasNext()) {
            Consommation consommation = (Consommation) iterator.next();
            Repository.getConsommationRepository().create(consommation);
        }
    }
}
