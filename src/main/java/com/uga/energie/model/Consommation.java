package com.uga.energie.model;

/**
 * Created by jack on 06/06/16.
 */
public class Consommation {
    private Date date;
    private Heure heure;
    private Appareil appareil;
    private int etat;
    private int energy_wh;

    public Consommation(Date date, Heure heure, Appareil appareil, int etat, int energy_wh) {
        this.date = date;
        this.heure = heure;
        this.appareil = appareil;
        this.etat = etat;
        this.energy_wh = energy_wh;
    }


    public Date getDate() {
        return date;
    }
    public void setDate(Date date){
        this.date = date;
    }
    public Heure getHeure() {
        return heure;
    }
    public void setHeure(Heure heure){
        this.heure = heure;
    }
    public Appareil getAppareil() {
        return appareil;
    }
    public void setAppareil(Appareil appareil){
        this.appareil = appareil;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat){
        this.etat = etat;
    }
    public int getEnergy_wh() {
        return energy_wh;
    }
    public void setEnergy_wh(int energy){
        this.energy_wh = energy;
    }

    @Override
    public String toString() {
        return "Consommation{" +
                "  date=" + date.toString() +
                "  heure=" + heure.toString() +
                "  appareil=" + appareil.getId() +
                "  etat=" + etat +
                "  energy_wh=" + energy_wh +
                '}';
    }
}
