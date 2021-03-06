package com.uga.energie.model;

import com.uga.energie.Parse.p_Quartier;
import com.uga.energie.Parse.p_TypeAppareil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jack on 06/06/16.
 */
public class TypeAppareil {
    private int id;
    private String name;

    public TypeAppareil(int id, String sName) {
        this.id = id;
        this.name = sName;
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

    @Override
    public boolean equals(Object object)
    {
        boolean sameSame = false;

        if (object != null && object instanceof p_TypeAppareil)
        {
            sameSame = this.id == ((p_TypeAppareil) object).getId();
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
