package com.uga.energie.repository;

import com.uga.energie.model.Appareil;
import com.uga.energie.model.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class AppareilRepository implements CRUDInteface<Appareil> {

    private static final String INSERT = "insert into uga.appareil(id, name,idTypeAppareil,idMaison ) values( ? ,? ,? ,? )";
    private static final String FIND_BY_ID = "select * from uga.appareil";
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
    public Date findById(int id) {
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
        return null;
    }

    public void update(Appareil currentModel) {

    }

    public void delete(int id) {

    }
}
