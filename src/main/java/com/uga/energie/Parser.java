package com.uga.energie;

import com.uga.energie.model.Quartier;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 06-Jun-16.
 */
public class Parser {

    private String m_sPathToParse;

    public Parser(String sPathToParse)
    {
        m_sPathToParse = sPathToParse;
    }

    public String getPathToParse(){
        return m_sPathToParse;
    }
    public void setPathToParse(String sPath)
    {
        m_sPathToParse = sPath;
    }

    public List<Quartier> Parse()
    {
        List<Quartier> lsRes = new ArrayList<Quartier>();

        //todo :)

        return lsRes;
    }
}
