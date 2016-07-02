package com.uga.energie.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class Date {
    private int id;
    private java.sql.Date ddate;

    public Date(int id, String date) {
        this.id = id;

        try {
            SimpleDateFormat parserSDF = new SimpleDateFormat("dd/MM/yy");
            java.util.Date d = parserSDF.parse(date);
            this.ddate = new java.sql.Date(d.getTime());

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Date(int id, java.sql.Date date) {
        this.ddate = date;
        this.id = id;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(java.sql.Date date) {
        this.ddate = date;
    }

    public java.sql.Date getDate() {
        return this.ddate;
    }

    @Override
    public String toString() {
        return ddate.toString();
    }
}
