package com.uga.energie;

import com.uga.energie.Parse.p_Appareil;
import com.uga.energie.Parse.p_Consommation;
import com.uga.energie.Parse.p_Maison;
import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 08-Jun-16.
 */
public class Optimizer {
    private List<p_Quartier> m_lsP_Quartier;

    List<Quartier> m_lsResQuartier;
    List<Appareil> m_lsResAppareil;
    List<TypeAppareil> m_lsResTypeAppareil;
    List<Maison> m_lsResMaison;
    List<Heure> m_lsResHeure;
    List<Date> m_lsResDate;
    List<Consommation> m_lsResConsommation;

    public Optimizer(List<p_Quartier> lsP_Quartier){
        this.m_lsP_Quartier = lsP_Quartier;
    }

    public List<Quartier> getListeQuartier(){
        return this.m_lsResQuartier;
    }
    public List<Appareil> getListeAppareil(){
        return this.m_lsResAppareil;
    }
    public List<TypeAppareil> getListeTypeAppareil(){
        return this.m_lsResTypeAppareil;
    }
    public List<Maison> getListeMaison(){
        return this.m_lsResMaison;
    }
    public List<Heure> getListeHeure(){
        return this.m_lsResHeure;
    }
    public List<Date> getListeDate(){
        return this.m_lsResDate;
    }
    public List<Consommation> getListeConsommation(){
        return this.m_lsResConsommation;
    }

    public void FromParserToJDBC(){
        m_lsResQuartier = new ArrayList<Quartier>();
        m_lsResAppareil = new ArrayList<Appareil>();
        m_lsResTypeAppareil = new ArrayList<TypeAppareil>();
        m_lsResMaison = new ArrayList<Maison>();
        m_lsResHeure = new ArrayList<Heure>();
        m_lsResDate = new ArrayList<Date>();
        m_lsResConsommation = new ArrayList<Consommation>();

        for (p_Quartier q : m_lsP_Quartier){

            if (!m_lsResQuartier.contains(q))
                m_lsResQuartier.add(new Quartier(q.getId(), "" + q.getId()));

            for (p_Maison m : q.getListeMaisons()){

                if (!m_lsResMaison.contains(m))
                    m_lsResMaison.add(new Maison(m.getId(), m.getQuartier().getId()));

                for(p_Appareil a : m.getListeAppareil()){

                    if (!m_lsResAppareil.contains(a))
                        m_lsResAppareil.add(new Appareil(a.getId(), a.getName(), 0/*a.getTypeAppareil().getId()*/, a.getMaison().getId()));//TODO : manager typeAppareil

                    for (p_Consommation c : a.getListeConsommation()){

                        //if (!m_lsResConsommation.contains(c))
                        m_lsResConsommation.add(new Consommation(0, 0, c.getAppareil().getId(), c.getEtat(), c.getEnergy_wh()));//TODO : manager les dates et heures
                    }
                }
            }

        }
    }
}
