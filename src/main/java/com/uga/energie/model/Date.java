package com.uga.energie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class Date {
    private int id;
    private String date;

    public Date(int id, String date) {
        this.id = id;
        this.date = date;
    }


    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public void addDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }

    @Override
    public String toString() {
        return date;
    }
}
