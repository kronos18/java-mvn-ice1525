package com.uga.energie.model;

/**
 * Created by jack on 06/06/16.
 */
public class Appareil {
    private final int id;

    public Appareil(int id) {
        this.id = id;
    }

    
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Appareil{" +
                "id=" + id +
                '}';
    }
}
