package com.uga.energie;

import com.uga.energie.Parse.p_Appareil;
import com.uga.energie.Parse.p_Consommation;
import com.uga.energie.Parse.p_Maison;
import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.model.*;
import com.uga.energie.repository.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08-Jun-16.
 */
public class Optimizer {
    private p_Quartier p_quartier;

    List<Quartier> m_lsResQuartier;
    List<Appareil> m_lsResAppareil;
    List<TypeAppareil> m_lsResTypeAppareil;
    List<Maison> m_lsResMaison;
    List<Heure> m_lsResHeure;
    List<Date> m_lsResDate;
    List<Consommation> m_lsResConsommation;
    boolean m_bOptiRemoveZero;
    boolean isOptiUseDateAndHeure;
    private MaisonRepository maisonRepository = Repository.getMaisonRepository();
    private QuartierRepository quartierRepository = Repository.getQuartierRepository();
    private AppareilRepository appareilRepository = Repository.getAppareilRepository();
    private ConsommationRepository consommationRepository = Repository.getConsommationRepository();


    public Optimizer(p_Quartier p_quartier, boolean isOptRemoveZero, boolean bOptiUseDateAndHeure) {
        this.p_quartier = p_quartier;
        this.m_bOptiRemoveZero = isOptRemoveZero;
        this.isOptiUseDateAndHeure = bOptiUseDateAndHeure;
    }

    public List<Quartier> getListeQuartier() {
        return this.m_lsResQuartier;
    }

    public List<Appareil> getListeAppareil() {
        return this.m_lsResAppareil;
    }

    public List<TypeAppareil> getListeTypeAppareil() {
        return this.m_lsResTypeAppareil;
    }

    public List<Maison> getListeMaison() {
        return this.m_lsResMaison;
    }

    public List<Heure> getListeHeure() {
        return this.m_lsResHeure;
    }

    public List<Date> getListeDate() {
        return this.m_lsResDate;
    }

    public List<Consommation> getListeConsommation() {
        return this.m_lsResConsommation;
    }

    public void FromParserToJDBC() {
//        TODO Les listes sont inaproprier pour une traitement de grosse masse de donnee (explosion memoire), il faut donc inserer a la volee
        m_lsResQuartier = new ArrayList<Quartier>();
        m_lsResAppareil = new ArrayList<Appareil>();
        m_lsResTypeAppareil = new ArrayList<TypeAppareil>();
        m_lsResMaison = new ArrayList<Maison>();
        m_lsResHeure = new ArrayList<Heure>();
        m_lsResDate = new ArrayList<Date>();
        m_lsResConsommation = new ArrayList<Consommation>();


        if (null == quartierRepository.findById(p_quartier.getId())) {
            System.out.println("Insertion quartier");
            Quartier quartier = new Quartier(p_quartier.getId(), "" + p_quartier.getId());
            quartierRepository.create(quartier);
        }
        System.out.println("Insertion des maisons");
        for (p_Maison pMaison : p_quartier.getListeMaisons()) {
            if (null == maisonRepository.findById(pMaison.getId())) {
                Maison maison = new Maison(pMaison.getId(), pMaison.getQuartier().getId());
                maisonRepository.create(maison);
            }
            System.out.println("Insertion des appareils");
            for (p_Appareil pAppareil : pMaison.getListeAppareil()) {

                int iAppareilTypeAppareil = getTypeAppareilIDForAppareil(pAppareil);

                if (null == appareilRepository.findById(pAppareil.getId())) {
                    Appareil appareil = new Appareil(pAppareil.getId(),
                                                     pAppareil.getName(),
                                                     iAppareilTypeAppareil,
                                                     pAppareil.getMaison().getId());
                    appareilRepository.create(appareil);
                }

                int bPreviousConsoStateInserted = -1;
                System.out.println("Insertion des consommations");
                for (p_Consommation pConsommation : pAppareil.getListeConsommation()) {

                    int iConsoDateID = getDateIDForConsommation(pConsommation);
                    int iConsoHeureID = getHeureIDForConsommation(pConsommation);


                    //Si on doit optimiser en supprimant les zéro et en utilisant les tables Heure et Date
                    Consommation consommation = new Consommation(iConsoDateID,
                                                                 iConsoHeureID,
                                                                 pConsommation.getAppareil().getId(),
                                                                 pConsommation.getEtat(),
                                                                 pConsommation.getEnergy_wh());
                    boolean isNotZeroValue = (bPreviousConsoStateInserted == -1) || (pConsommation.getEtat() != bPreviousConsoStateInserted) || (pConsommation
                            .getEnergy_wh() > 0);

                    if (m_bOptiRemoveZero && isOptiUseDateAndHeure) {
                        //Algo =
                        //Si bPreviousConsoStateInserted n'a jamais été configuré, insert l'objet conso.
                        //Sinon si c.State est différent de bPreviousConsoStateInserted, insert l'objet conso.
                        //Sinon si c.Energy_wh et > 0, insert l'objet conso.
                        //Sinon n'insert pas l'objet conso = opti. (le state est égal au précédent inserré en BDD et Energy_wh vaut 0).

                        boolean bCanInsertConso = false;

                        if (isNotZeroValue) {
                            bCanInsertConso = true;
                        }

                        if (bCanInsertConso) {
                            consommationRepository.create(consommation);
                            bPreviousConsoStateInserted = pConsommation.getEtat();
                        }
                    }
                    //Si on ne doit pas optimiser en supprimant les zéro et qu'on doit utiliser les tables Heure et Date
                    else if (!m_bOptiRemoveZero && isOptiUseDateAndHeure) {
                        consommationRepository.create(consommation);
                    }
                    //Si on doit optimiser en supprimant les zéro et qu'on ne doit pas utiliser les tables Heure et Date
                    else if (m_bOptiRemoveZero && !isOptiUseDateAndHeure) {
                        boolean bCanInsertConso = false;

                        if (isNotZeroValue) {
                            bCanInsertConso = true;
                        }

                        if (bCanInsertConso) {
                            //TODO : modifier Consommation pour qu'il accepte une Date et un Time à la place des id
                            //m_lsResConsommation.add(new Consommation(iConsoDateID, iConsoHeureID, c.getAppareil().getId(), c.getEtat(), c.getEnergy_wh()));
                            bPreviousConsoStateInserted = pConsommation.getEtat();
                        }
                    }
                    //Si on ne doit pas optimiser en supprimant les zéro et qu'on ne doit pas utiliser les tables Heure et Date
                    else if (!m_bOptiRemoveZero && !isOptiUseDateAndHeure) {
                        //TODO : modifier Consommation pour qu'il accepte une Date et un Time à la place des id
                        //m_lsResConsommation.add(new Consommation(iConsoDateID, iConsoHeureID, c.getAppareil().getId(), c.getEtat(), c.getEnergy_wh()));
                    }
                }
            }
        }

    }

    private int getTypeAppareilIDForAppareil(p_Appareil a) {
        int iRes = 0;

        //Verifie si le TypeAppareil a deja ete ajoute ou non dans la liste precedement.
        TypeAppareil appTypeAppareil = new TypeAppareil(0, a.getTypeAppareil().getName());

        TypeAppareilRepository typeAppareilRepository = Repository.getTypeAppareilRepository();
        int id = typeAppareilRepository.getId(appTypeAppareil.getName());
        if (-1 != id) {
            iRes = id;
        }


        //Le TypeAppareil n'a pas ete trouve, on l'ajoute à la liste.
        else {
            iRes = typeAppareilRepository.createAndGetId(appTypeAppareil);
        }

        return iRes;
    }

    private int getDateIDForConsommation(p_Consommation c) {
        int iRes = 0;

        //Verifie si la date a deja ete ajoutee ou non dans la liste precedement.
        Date consoDate = new Date(0, c.getDate());

        DateRepository dateRepository = Repository.getDateRepository();
        int id = dateRepository.getId(consoDate.getDate());
        if (-1 != id) {
            iRes = id;
        }

        //La date n'a pas ete trouvee, on l'ajoute à la base.
        else {
            /*INSERTION DES DATES ET HEURES*/
            iRes = dateRepository.createAndGetId(consoDate);
        }

        return iRes;
    }

    private int getHeureIDForConsommation(p_Consommation c) {
        int iRes = 0;

        //Verifie si l'Heure a deja ete ajoutee ou non dans la liste precedement.
        Heure consoHeure = new Heure(0, c.getHeure());
        HeureRepository heureRepository = Repository.getHeureRepository();
        int id = heureRepository.getId(consoHeure.getHeure());

        if (-1 != id) {
            iRes = id;
        }

        //L'heure n'a pas ete trouvee, on l'ajoute à la liste.
        else {
             /*INSERTION DES DATES ET HEURES*/
            iRes = heureRepository.createAndGetId(consoHeure);
            //            m_lsResHeure.add(consoHeure);
        }

        return iRes;
    }
}
