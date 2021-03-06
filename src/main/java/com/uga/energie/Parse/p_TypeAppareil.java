package com.uga.energie.Parse;

import com.uga.energie.model.Quartier;
import com.uga.energie.model.TypeAppareil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class p_TypeAppareil {
    private int id;
    private String name;
    private List<p_Appareil> m_lsAppareil;

    public p_TypeAppareil(int id, String sName) {
        this.id = id;
        this.name = sName;
        this.m_lsAppareil = new ArrayList<p_Appareil>();
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

    public List<p_Appareil> getListeAppareil() {
        return m_lsAppareil;
    }

    public void addAppareil(p_Appareil appareil) {
        this.m_lsAppareil.add(appareil);
    }

    @Override
    public boolean equals(Object object) {
        boolean sameSame = false;

        if (object != null && object instanceof p_TypeAppareil) {
            sameSame = this.id == ((p_TypeAppareil) object).getId();
        }
        else if (object != null && object instanceof TypeAppareil) {
            sameSame = this.id == ((TypeAppareil) object).getId();
        }
        return sameSame;
    }

    @Override
    public String toString() {
        return "TypeAppareil{" +
                "  id=" + id +
                "  name=" + name +
                "}";
    }
}
