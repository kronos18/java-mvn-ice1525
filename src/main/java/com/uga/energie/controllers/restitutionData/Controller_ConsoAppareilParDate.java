package com.uga.energie.controllers.restitutionData;

import com.uga.energie.controllers.restitutionData.modelToDisplay.ItemToDisplay_ConsoAppareilParDate;
import com.uga.energie.repository.Repository;

import javax.swing.table.DefaultTableModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 02-Jul-16.
 */
public class Controller_ConsoAppareilParDate {

    List<ItemToDisplay_ConsoAppareilParDate> m_itemsToDisplay;

    public Controller_ConsoAppareilParDate(){
        m_itemsToDisplay = new ArrayList<ItemToDisplay_ConsoAppareilParDate>();
    }

    public DefaultTableModel getTableModel(DefaultTableModel model){
        m_itemsToDisplay = Repository.getAppareilRepository().GetAppareilWithMaisonAndType();

        //VIDER LA TABLE
        while(model.getRowCount() != 0){
            model.removeRow(0);
        }

        int _ColumnNumMaison = 1;
        int _ColumnNomAppareil = 2;
        int _ColumnTypeAppareil = 3;

        for (ItemToDisplay_ConsoAppareilParDate item: m_itemsToDisplay) {
            model.addRow(new Object[]
                {
                        item.getAppareilMaison(),
                        item.getAppareilName(),
                        item.getAppareilType()
                });
        }

        return model;
    }

    public ItemToDisplay_ConsoAppareilParDate getItemSelected(int idRawSelected){
        return m_itemsToDisplay.get(idRawSelected);
    }

    public String getConsommationOfItem(int idRawSelected, String sJour, String sMois, String sAnnee) throws ParseException {
        int iRes = 0;

        ItemToDisplay_ConsoAppareilParDate itemSelected = getItemSelected(idRawSelected);

        //TODO : utiliser le repository pour calculer
        SimpleDateFormat parserSDF = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date d = parserSDF.parse(sJour + "/" + sMois + "/" + sAnnee);
        java.sql.Date selectedDate = new java.sql.Date(d.getTime());

        iRes = Repository.getAppareilRepository().getAppareilConsommationThisDay(selectedDate, itemSelected.getAppareilID());

        return String.valueOf(iRes);
    }
}