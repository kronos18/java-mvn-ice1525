package com.uga.energie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class Maison {
    private int id;
    private Quartier quartier;
    private List<Appareil> m_lsAppareil;

    public Maison(int id, Quartier quartier) {
        this.id = id;
        this.quartier = quartier;
        this.m_lsAppareil = new ArrayList<Appareil>();
    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public Quartier getQuartier() {
        return quartier;
    }
    public void setQuartier(Quartier quartier){
        this.quartier = quartier;
    }
    public List<Appareil> getListeAppareil() {
        return m_lsAppareil;
    }
    public void addAppareil(Appareil appareil){
        this.m_lsAppareil.add(appareil);
    }

    @Override
    public String toString() {
        return "Maison{" +
                "  id=" + id +
                "  quartier=" + quartier.getId() +
                "}";
    }
}
