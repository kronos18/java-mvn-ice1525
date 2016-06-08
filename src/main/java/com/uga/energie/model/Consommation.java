package com.uga.energie.model;

import com.uga.energie.Parse.p_Consommation;

/**
 * Created by jack on 06/06/16.
 */
public class Consommation {
    private int idDate;
    private int idHeure;
    private int idAppareil;
    private int etat;
    private int energy_wh;

    public Consommation(int idDate, int idHeure, int idAppareil, int etat, int energy_wh) {
        this.idDate = idDate;
        this.idHeure = idHeure;
        this.idAppareil = idAppareil;
        this.etat = etat;
        this.energy_wh = energy_wh;
    }

    public Consommation(){

    }

    public int getIdDate() {
        return idDate;
    }
    public void setIdDate(int idDate){
        this.idDate = idDate;
    }
    public int getIdHeure() {
        return idHeure;
    }
    public void setIdHeure(int idHeure){
        this.idHeure = idHeure;
    }
    public int getIdAppareil() {
        return idAppareil;
    }
    public void setIdAppareil(int idAppareil){
        this.idAppareil = idAppareil;
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
                "  date=" + idDate +
                "  heure=" + idHeure +
                "  appareil=" + idAppareil +
                "  etat=" + etat +
                "  energy_wh=" + energy_wh +
                '}';
    }
}
