package com.uga.energie.Parse;

import com.uga.energie.model.Quartier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class p_Quartier {
    private int id;
    private List<p_Maison> m_lsMaison;

    public p_Quartier(int id) {
        this.id = id;
        this.m_lsMaison = new ArrayList<p_Maison>();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addMaison(p_Maison maison) {
        this.m_lsMaison.add(maison);
    }

    public List<p_Maison> getListeMaisons() {
        return this.m_lsMaison;
    }

    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof p_Quartier) {
            sameSame = this.id == ((p_Quartier) object).getId();
        }
        else if (object != null && object instanceof Quartier) {
            sameSame = this.id == ((Quartier) object).getId();
        }
        return sameSame;
    }

    @Override
    public String toString() {
        return "Quartier{" +
                "  id=" + id +
                "}";
    }
}
