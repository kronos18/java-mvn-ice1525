package com.uga.energie.controllers.restitutionData.modelToDisplay;

import com.uga.energie.model.Appareil;
import com.uga.energie.model.TypeAppareil;

/**
 * Created by Max on 02-Jul-16.
 */
public class ItemToDisplay_ConsoAppareilParDate
{
    private Appareil m_Appareil;
    private TypeAppareil m_AppareilType;

    public ItemToDisplay_ConsoAppareilParDate(Appareil app, TypeAppareil type){
        m_Appareil = app;
        m_AppareilType = type;
    }

    public String getAppareilName(){
        return m_Appareil.getName();
    }

    public String getAppareilType(){
        return m_AppareilType.getName();
    }

    public String getAppareilMaison(){
        return String.valueOf(m_Appareil.getIdMaison());
    }

    public int getAppareilID(){
        return m_Appareil.getId();
    }
}