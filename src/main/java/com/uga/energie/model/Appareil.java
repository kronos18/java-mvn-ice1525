package com.uga.energie.model;

import com.uga.energie.Parse.p_Appareil;
import com.uga.energie.Parse.p_Maison;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class Appareil {
    private int id;
    private String name;
    private int idTypeAppareil;
    private int idMaison;

    public Appareil(int id, String sName, int idtypeAppareil, int idmaison) {
        this.id = id;
        this.name = sName;
        this.idTypeAppareil = idtypeAppareil;
        this.idMaison = idmaison;
    }

    public Appareil(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdMaison() {
        return idMaison;
    }

    public void setIdMaison(int idmaison) {
        this.idMaison = idmaison;
    }

    public int getIdTypeAppareil() {
        return idTypeAppareil;
    }

    public void setIdTypeAppareil(int idtypeAppareil) {
        this.idTypeAppareil = idtypeAppareil;
    }


    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof p_Appareil)
        {
            sameSame = this.id == ((p_Appareil) object).getId();
        }

        return sameSame;
    }


    @Override
    public String toString() {
        return "Appareil{" +
                "  id=" + id +
                "  name=" + name +
                "  typeAppareil=" + idTypeAppareil +
                "  maison=" + idMaison +
                '}';
    }
}
