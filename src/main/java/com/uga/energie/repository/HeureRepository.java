package com.uga.energie.repository;

import com.uga.energie.model.Heure;

import java.sql.*;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class HeureRepository implements CRUDInteface<Heure> {

    private static final String INSERT = "insert into uga.Heure(id, heure) values( ? ,?)";
    private static final String INSERT_WITHOUT_ID = "insert into uga.Heure( heure) values( ?) RETURNING id";
    private static final String FIND_BY_ID = "select * from uga.Heure where id = ?";
    private static final String FIND_ID_FROM_HEURE = "select id from uga.Heure where heure = ?";

    private final Connection dataSource;

    public HeureRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(Heure currentModel) {
        Connection connection = dataSource;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getId());
            preparedStatement.setObject(2, currentModel.getHeure());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    public int createAndGetId(Heure currentModel) {
        Connection connection = dataSource;
        int id = 0;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_WITHOUT_ID);
            preparedStatement.setObject(1, currentModel.getHeure());
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    //TODO A faire
    public Heure findById(int id) {
        Heure heure = null;
        Connection connection = dataSource;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                heure = new Heure(rs.getInt("id"), rs.getString("heure"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heure;
    }


    public void update(Heure currentModel) {

    }

    public void delete(int id) {

    }

    public int getId(Time heureToCmp) {
        Connection connection = dataSource;
        int id = -1;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_FROM_HEURE);
            preparedStatement.setObject(1, heureToCmp);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
