package com.uga.energie.repository;

import com.uga.energie.model.Maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class MaisonRepository implements CRUDInteface<Maison> {

    private static final String INSERT = "insert into uga.Maison(id, idquartier) values( ? ,? )";
    private static final String FIND_BY_ID = "select * from uga.Maison";
    private final Connection dataSource;

    public MaisonRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(Maison currentModel) {
        try {
            Connection connection = dataSource;
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getId());
            preparedStatement.setObject(2, currentModel.getIdQuartier());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public void findById(int id) {
        try {
            Connection connection = dataSource;
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
    }

    public void update(Maison currentModel) {

    }

    public void delete(int id) {

    }
}
