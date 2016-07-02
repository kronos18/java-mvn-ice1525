package com.uga.energie.repository;

import com.uga.energie.model.Quartier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class QuartierRepository implements CRUDInteface<Quartier> {

    private static final String INSERT = "insert into uga.Quartier(id, name) values( ? ,? )";
    private static final String FIND_BY_ID = "select * from uga.Quartier";
    private final Connection dataSource;

    public QuartierRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(Quartier currentModel) {
        Connection connection = dataSource;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getId());
            preparedStatement.setObject(2, currentModel.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public Quartier findById(int id) {
        Quartier quartier = null;
        Connection connection = dataSource;

        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                quartier = new Quartier(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quartier;
    }

    public void update(Quartier currentModel) {

    }

    public void delete(int id) {

    }
}
