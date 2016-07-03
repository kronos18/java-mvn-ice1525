package com.uga.energie.repository;

import com.uga.energie.model.Appareil;
import com.uga.energie.model.Consommation;
import com.uga.energie.model.Maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class ConsommationRepository implements CRUDInteface<Consommation> {

    private static final String INSERT = "insert into uga.Consommation(iddate, idheure, idappareil, etat, energy_wh ) values( ? ,? ,? ,?, ? )";
    private static final String FIND_BY_ID = "select * from uga.Consommation where id = ?";
    private static final String GET_CONSO_TOTAL_BY_MAISON_ID = "select energy_wh as conso_totale from uga.Consommation where id = ?";
    private final Connection connection;

    public ConsommationRepository(Connection dataSource) {
        this.connection = dataSource;
    }


    public void create(Consommation currentModel) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getIdDate());
            preparedStatement.setObject(2, currentModel.getIdHeure());
            preparedStatement.setObject(3, currentModel.getIdAppareil());
            preparedStatement.setObject(4, currentModel.getEtat());
            preparedStatement.setObject(5, currentModel.getEnergy_wh());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public Consommation findById(int id) {
        Consommation consommation = null;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                consommation = new Consommation(rs.getInt("iddate"),
                                                rs.getInt("idheure"),
                                                rs.getInt("idappareil"),
                                                rs.getInt("etat"),
                                                rs.getInt("energy_wh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommation;
    }

    public Consommation getByAppareilId(int id) {
        Consommation consommation = null;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                consommation = new Consommation(rs.getInt("iddate"),
                                                rs.getInt("idheure"),
                                                rs.getInt("idappareil"),
                                                rs.getInt("etat"),
                                                rs.getInt("energy_wh"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommation;
    }

    public void update(Consommation currentModel) {

    }

    public void delete(int id) {

    }

    public int getConsommationTotalByMaisonId(int maisonId) {
        int consommation = 0;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, maisonId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                consommation = rs.getInt("conso_total");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consommation;
    }
}
