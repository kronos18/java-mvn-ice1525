package com.uga.energie.Parse;

import com.uga.energie.model.Appareil;
import com.uga.energie.model.Quartier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class p_Appareil {
    private int id;
    private String name;
    private p_TypeAppareil typeAppareil;
    private p_Maison maison;
    private List<p_Consommation> m_lsConsommation;

    public p_Appareil(int id, String sName, p_TypeAppareil typeAppareil, p_Maison maison) {
        this.id = id;
        this.name = sName;
        this.typeAppareil = typeAppareil;
        this.maison = maison;
        this.m_lsConsommation = new ArrayList<p_Consommation>();
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

    public p_Maison getMaison() {
        return maison;
    }

    public void setMaison(p_Maison maison) {
        this.maison = maison;
    }

    public p_TypeAppareil getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(p_TypeAppareil typeAppareil) {
        this.typeAppareil = typeAppareil;
    }
    public List<p_Consommation> getListeConsommation() {
        return m_lsConsommation;
    }
    public void addConsommation(p_Consommation conso){
        this.m_lsConsommation.add(conso);
    }

    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof p_Appareil) {
            sameSame = this.id == ((p_Appareil) object).getId();
        }
        else if (object != null && object instanceof Appareil) {
            sameSame = this.id == ((Appareil) object).getId();
        }
        return sameSame;
    }

    @Override
    public String toString() {
        return "Appareil{" +
                "  id=" + id +
                "  name=" + name +
                "  typeAppareil=" + typeAppareil.getId() +
                "  maison=" + maison.getId() +
                '}';
    }
}
