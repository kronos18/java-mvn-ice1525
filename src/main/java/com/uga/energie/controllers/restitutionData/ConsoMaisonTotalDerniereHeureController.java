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

    public ConsoMaisonTotalDerniereHeureController(){
        maisonList = new ArrayList<Maison>();
    }

    public DefaultTableModel getTableModel(DefaultTableModel model){
        maisonList = Repository.getMaisonRepository().findAll();

        //VIDER LA TABLE
        while(model.getRowCount() != 0){
            model.removeRow(0);
        }

        int _ColumnNumMaison = 1;
        int _ColumnNomAppareil = 2;
        int _ColumnTypeAppareil = 3;

        for (Maison maison: maisonList) {
            model.addRow(new Object[]
                {
                        maison.getId()
                });
        }

        return model;
    }

    public Maison getItemSelected(int idRawSelected){
        return maisonList.get(idRawSelected);
    }

    public String getConsommationOfMaisonForLastHour(int idRowSelected) throws ParseException {
        int iRes = 0;

        Maison itemSelected = getItemSelected(idRowSelected);

//        //TODO : utiliser le repository pour calculer
//        SimpleDateFormat parserSDF = new SimpleDateFormat("dd/MM/yyyy");
//        java.util.Date d = parserSDF.parse(sJour + "/" + sMois + "/" + sAnnee);
//        java.sql.Date selectedDate = new java.sql.Date(d.getTime());

        iRes = Repository.getConsommationRepository().getConsommationTotalByMaisonId(itemSelected.getId());

        return String.valueOf(iRes);
    }
}