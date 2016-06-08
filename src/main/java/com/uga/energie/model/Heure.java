package com.uga.energie.model;

import com.uga.energie.Parse.p_Maison;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by jack on 06/06/16.
 */
public class Heure {
    private int id;
    private java.sql.Date heure;

    public Heure(int id, String heure) {
        this.id = id;
        try {
            SimpleDateFormat parserSDF = new SimpleDateFormat("HH:mm");
            java.util.Date d = parserSDF.parse(heure);
            this.heure = new java.sql.Date(d.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Heure (){

    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public void setHeure(java.sql.Date heure){
        this.heure = heure;
    }
    public java.sql.Date getHeure(){
        return this.heure;
    }


    @Override
    public String toString() {
        return heure.toString();
    }
}

