package com.uga.energie.model;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by jack on 06/06/16.
 */
public class Heure {
    private int id;
    private Time heure;

    public Heure(int id, String heure) {
        this.id = id;
        try {
            SimpleDateFormat parserSDF = new SimpleDateFormat("HH:mm");
            java.util.Date d = parserSDF.parse(heure);
            this.heure = new java.sql.Time(d.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Heure() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHeure(Time heure) {
        this.heure = heure;
    }

    public Time getHeure() {
        return this.heure;
    }


    @Override
    public String toString() {
        return heure.toString();
    }
}

