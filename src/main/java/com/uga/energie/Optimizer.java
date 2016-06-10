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

                    int iAppareilTypeAppareil = getTypeAppareilIDForAppareil(a);

                    if (!m_lsResAppareil.contains(a))
                        m_lsResAppareil.add(new Appareil(a.getId(), a.getName(), iAppareilTypeAppareil, a.getMaison().getId()));

                    for (p_Consommation c : a.getListeConsommation()){

                        int iConsoDateID = getDateIDForConsommation(c);
                        int iConsoHeureID = getHeureIDForConsommation(c);

                        //if (!m_lsResConsommation.contains(c))
                        m_lsResConsommation.add(new Consommation(iConsoDateID, iConsoHeureID, c.getAppareil().getId(), c.getEtat(), c.getEnergy_wh()));
                    }
                }
            }

        }
    }

    private int getTypeAppareilIDForAppareil(p_Appareil a){
        int iRes = 0;

        //Verifie si le TypeAppareil a deja ete ajoute ou non dans la liste precedement.
        TypeAppareil appTypeAppareil = new TypeAppareil(0, a.getTypeAppareil().getName());
        for(TypeAppareil typeApp : m_lsResTypeAppareil){
            if (typeApp.getName() == appTypeAppareil.getName()){
                iRes = typeApp.getId();
                break;
            }
        }

        //Le TypeAppareil n'a pas ete trouve, on l'ajoute à la liste.
        if (iRes == 0) {
            iRes = m_lsResTypeAppareil.size() + 1;
            appTypeAppareil.setId(iRes);
            m_lsResTypeAppareil.add(appTypeAppareil);
        }

        return iRes;
    }

    private int getDateIDForConsommation(p_Consommation c){
        int iRes = 0;

        //Verifie si la date a deja ete ajoutee ou non dans la liste precedement.
        Date consoDate = new Date(0, c.getDate());
        for(Date date : m_lsResDate){
            if (date.getDate() == consoDate.getDate()){
                iRes = date.getId();
                break;
            }
        }

        //La date n'a pas ete trouvee, on l'ajoute à la liste.
        if (iRes == 0) {
            iRes = m_lsResDate.size() + 1;
            consoDate.setId(iRes);
            m_lsResDate.add(consoDate);
        }

        return iRes;
    }

    private int getHeureIDForConsommation(p_Consommation c){
        int iRes = 0;

        //Verifie si l'Heure a deja ete ajoutee ou non dans la liste precedement.
        Heure consoHeure = new Heure(0, c.getHeure());
        for(Heure heure : m_lsResHeure){
            if (heure.getHeure() == consoHeure.getHeure()){
                iRes = heure.getId();
                break;
            }
        }

        //L'heure n'a pas ete trouvee, on l'ajoute à la liste.
        if (iRes == 0) {
            iRes = m_lsResHeure.size() + 1;
            consoHeure.setId(iRes);
            m_lsResHeure.add(consoHeure);
        }

        return iRes;
    }

}
