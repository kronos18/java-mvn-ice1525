package com.uga.energie.controllers.restitutionData;

import com.uga.energie.model.Maison;
import com.uga.energie.repository.Repository;

import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 02-Jul-16.
 */
public class ConsoMaisonTotalDerniereHeureController {

    List<Maison> maisonList;

    public ConsoMaisonTotalDerniereHeureController() {
        maisonList = new ArrayList<Maison>();
    }

    public DefaultTableModel getTableModel(DefaultTableModel model) {
        maisonList = Repository.getMaisonRepository().findAll();

        //VIDER LA TABLE
        while (model.getRowCount() != 0) {
            model.removeRow(0);
        }

        for (Maison maison : maisonList) {
            model.addRow(new Object[]
                                 {
                                         maison.getId()
                                 });
        }
        return model;
    }

    public Maison getItemSelected(int idRawSelected) {
        return maisonList.get(idRawSelected);
    }

    public String getConsommationOfMaisonForLastHour(int idRowSelected) throws ParseException {
        int consommationTotalValue = 0;

        Maison itemSelected = getItemSelected(idRowSelected);

//        //TODO : utiliser le repository pour calculer
        consommationTotalValue = Repository.getConsommationRepository().getConsommationTotalByMaisonId(itemSelected.getId());

        return String.valueOf(consommationTotalValue);
    }

    public List<Maison> getMaisonList() {
        return maisonList;
    }

    public void setMaisonList(List<Maison> maisonList) {
        this.maisonList = maisonList;
    }
}