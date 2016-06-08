package com.uga.energie.model;

/**
 * Created by jack on 06/06/16.
 */
public class Heure {
    private int id;
    private String heure;

    public Heure(int id, String heure) {
        this.id = id;
        this.heure = heure;
    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public void addHeure(String heure){
        this.heure = heure;
    }
    public String getHeure(){
        return this.heure;
    }

    @Override
    public String toString() {
        return heure;
    }
}

