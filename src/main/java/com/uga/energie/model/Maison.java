package com.uga.energie.model;

import com.uga.energie.Parse.p_Maison;
import com.uga.energie.Parse.p_TypeAppareil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class Maison {
    private int id;
    private int idquartier;

    public Maison(int id, int idquartier) {
        this.id = id;
        this.idquartier = idquartier;
    }

    public Maison(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuartier() {
        return idquartier;
    }

    public void setIdQuartier(int idquartier) {
        this.idquartier = idquartier;
    }


    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof p_Maison)
        {
            sameSame = this.id == ((p_Maison) object).getId();
        }

        return sameSame;
    }

    @Override
    public String toString() {
        return "Maison{" +
                "  id=" + id +
                "  quartier=" + idquartier +
                "}";
    }
}
