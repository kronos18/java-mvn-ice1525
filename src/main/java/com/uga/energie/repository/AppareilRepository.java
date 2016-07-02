package com.uga.energie.repository;

import com.uga.energie.controlleursRestitutionDesDonnees.Controller_ConsoAppareilParDate;
import com.uga.energie.controlleursRestitutionDesDonnees.itemToDisplay_ConsoAppareilParDate;
import com.uga.energie.model.Appareil;
import com.uga.energie.model.Date;
import com.uga.energie.model.TypeAppareil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class AppareilRepository implements CRUDInteface<Appareil> {

    private static final String INSERT = "insert into uga.appareil(id, name,idTypeAppareil,idMaison ) values( ? ,? ,? ,? )";
    private static final String GetAppareilWithMaisonAndType = "select app.id as appid, app.name as appname, app.idmaison as maisonid, tapp.id as typeid, tapp.name as typename from uga.appareil app, uga.typeappareil tapp order by app.name;";
    private static final String GetAppareilConsoOfTheDay_WithoutOpti = "select sum(energy_wh) as totalconso from uga.consommation c left join uga.\"date\" d on c.iddate = d.id where idappareil = ? and ddate = ?";
    private static final String FIND_BY_ID = "select * from uga.appareil where id = ?";
    private final Connection dataSource;

    public AppareilRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(Appareil currentModel) {
        Connection connection = dataSource;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getId());
            preparedStatement.setObject(2, currentModel.getName());
            preparedStatement.setObject(3, currentModel.getIdTypeAppareil());
            preparedStatement.setObject(4, currentModel.getIdMaison());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public Appareil findById(int id) {
        Appareil appareil = null;
        Connection connection = dataSource;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                appareil = new Appareil(rs.getInt("id"), rs.getString("name"), rs.getInt("idTypeAppareil"), rs.getInt("idMaison"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appareil;
    }

    public List<itemToDisplay_ConsoAppareilParDate> GetAppareilWithMaisonAndType(){
        List<itemToDisplay_ConsoAppareilParDate> lsRes = new ArrayList<itemToDisplay_ConsoAppareilParDate>();
        Connection connection = dataSource;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(GetAppareilWithMaisonAndType);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                TypeAppareil type = new TypeAppareil(rs.getInt("typeid"), rs.getString("typename"));
                Appareil app = new Appareil(rs.getInt("appid"), rs.getString("appname"), rs.getInt("typeid"), rs.getInt("maisonid"));

                lsRes.add(new itemToDisplay_ConsoAppareilParDate(app, type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lsRes;
    }

    public void update(Appareil currentModel) {

    }

    public void delete(int id) {

    }

    public int getAppareilConsommationThisDay(java.sql.Date selectedDate, int appareilID) {
        int iRes = 0;
        Connection connection = dataSource;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(GetAppareilConsoOfTheDay_WithoutOpti);
            preparedStatement.setObject(1, appareilID);
            preparedStatement.setObject(2, selectedDate);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                iRes = rs.getInt("totalconso");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return iRes;
    }
}
