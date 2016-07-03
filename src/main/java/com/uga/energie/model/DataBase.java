package com.uga.energie.model;

/**
 * Created by Lenovo on 03/07/2016.
 */
public class DataBase {
    private String name;
    private int sizeEmptyDB;
    private int currentSize;

    public DataBase(String name, int sizeEmptyDB, int currentSize) {
        this.name = name;
        this.sizeEmptyDB = sizeEmptyDB;
        this.currentSize = currentSize;
    }

    public DataBase() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSizeEmptyDB() {
        return sizeEmptyDB;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public void setSizeEmptyDB(int sizeEmptyDB) {
        this.sizeEmptyDB = sizeEmptyDB;
    }
}
