package com.uga.energie.model;

/**
 * Created by jack on 06/06/16.
 */
public class Appareil {
    private int id;
    private String name;
    private TypeAppareil typeAppareil;
    private Maison maison;

    public Appareil(int id, String sName, TypeAppareil typeAppareil, Maison maison) {
        this.id = id;
        this.name = sName;
        this.typeAppareil = typeAppareil;
        this.maison = maison;
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

    public Maison getMaison() {
        return maison;
    }

    public void setMaison(Maison maison) {
        this.maison = maison;
    }

    public TypeAppareil getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(TypeAppareil typeAppareil) {
        this.typeAppareil = typeAppareil;
    }

    @Override
    public String toString() {
        return "Appareil{" +
                "  id=" + id +
                "  name=" + name +
                "  typeAppareil=" + typeAppareil.getId() +
                "  maison=" + maison.getId() +
                '}';
    }
}
