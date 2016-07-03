package com.uga.energie.repository;

import com.uga.energie.model.Maison;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class MaisonRepository implements CRUDInteface<Maison> {

    private static final String INSERT = "insert into uga.Maison(id, idquartier) values( ? ,? )";
    private static final String FIND_BY_ID = "select * from uga.Maison where id = ?";
    private static final String FIND_ALL = "select * from uga.Maison";
    private final Connection dataSource;

    public MaisonRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(Maison currentModel) {
        Connection connection = dataSource;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getId());
            preparedStatement.setObject(2, currentModel.getIdQuartier());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public Maison findById(int id) {
        Maison maison = null;
        Connection connection = dataSource;

        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setObject(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                maison = new Maison(rs.getInt("id"), rs.getInt("idquartier"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maison;
    }

    public void update(Maison currentModel) {

    }

    public void delete(int id) {

    }

    public List<Maison> findAll() {
        Maison maison = null;
        Connection connection = dataSource;
        List<Maison> maisonList = null;

        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
            rs = preparedStatement.executeQuery();
            maisonList = new LinkedList<Maison>();
            while (rs.next()) {
                // read the result set
                maisonList.add(new Maison(rs.getInt("id"), rs.getInt("idquartier")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maisonList;
    }

}
