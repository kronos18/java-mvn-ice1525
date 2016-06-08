package com.uga.energie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class TypeAppareil {
    private int id;
    private String name;
    private List<Appareil> m_lsAppareil;

    public TypeAppareil(int id, String sName) {
        this.id = id;
        this.name = sName;
        this.m_lsAppareil = new ArrayList<Appareil>();
    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public List<Appareil> getListeAppareil() {
        return m_lsAppareil;
    }
    public void addAppareil(Appareil appareil){
        this.m_lsAppareil.add(appareil);
    }

    @Override
    public String toString() {
        return "TypeAppareil{" +
                "  id=" + id +
                "  name=" + name +
                "}";
    }
}
