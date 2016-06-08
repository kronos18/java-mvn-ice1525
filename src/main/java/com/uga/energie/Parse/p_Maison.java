package com.uga.energie.Parse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class p_Maison {
    private int id;
    private p_Quartier quartier;
    private List<p_Appareil> m_lsAppareil;

    public p_Maison(int id, p_Quartier quartier) {
        this.id = id;
        this.quartier = quartier;
        this.m_lsAppareil = new ArrayList<p_Appareil>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public p_Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(p_Quartier quartier) {
        this.quartier = quartier;
    }

    public List<p_Appareil> getListeAppareil() {
        return m_lsAppareil;
    }

    public void addAppareil(p_Appareil appareil) {
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
