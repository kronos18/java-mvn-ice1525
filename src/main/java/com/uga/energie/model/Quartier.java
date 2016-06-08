package com.uga.energie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class Quartier {
    private int id;
    private List<Maison> m_lsMaison;

    public Quartier(int id) {
        this.id = id;
        this.m_lsMaison = new ArrayList<Maison>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addMaison(Maison maison) {
        this.m_lsMaison.add(maison);
    }

    public List<Maison> getListeMaisons() {
        return this.m_lsMaison;
    }

    @Override
    public String toString() {
        return "Quartier{" +
                "  id=" + id +
                "}";
    }
}
