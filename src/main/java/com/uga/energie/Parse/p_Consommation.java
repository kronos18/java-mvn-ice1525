package com.uga.energie.Parse;

/**
 * Created by jack on 06/06/16.
 */
public class p_Consommation {
    private String date;
    private String heure;
    private p_Appareil appareil;
    private int etat;
    private int energy_wh;

    public p_Consommation(String date, String heure, p_Appareil appareil, int etat, int energy_wh) {
        this.date = date;
        this.heure = heure;
        this.appareil = appareil;
        this.etat = etat;
        this.energy_wh = energy_wh;
    }


    public String getDate() {
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    public String getHeure() {
        return heure;
    }
    public void setHeure(String heure){
        this.heure = heure;
    }
    public p_Appareil getAppareil() {
        return appareil;
    }
    public void setAppareil(p_Appareil appareil){
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
