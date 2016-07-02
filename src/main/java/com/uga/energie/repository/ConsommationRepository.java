package com.uga.energie.repository;

import com.uga.energie.model.Consommation;
import com.uga.energie.model.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class ConsommationRepository implements CRUDInteface<Consommation> {

    private static final String INSERT = "insert into uga.Consommation(iddate, idheure, idappareil, etat, energy_wh ) values( ? ,? ,? ,?, ? )";
    private static final String FIND_BY_ID = "select * from uga.Consommation";
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
    public Date findById(int id) {
        try {
            Connection connection = this.connection;
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Consommation currentModel) {

    }

    public void delete(int id) {

    }
}
