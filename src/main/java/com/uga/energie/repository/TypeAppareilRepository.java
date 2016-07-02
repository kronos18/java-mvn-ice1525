package com.uga.energie.repository;

import com.uga.energie.model.TypeAppareil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class TypeAppareilRepository implements CRUDInteface<TypeAppareil> {

    private static final String INSERT = "insert into uga.TypeAppareil(id, name) values( ? ,? )";
    private static final String FIND_BY_ID = "select * from uga.TypeAppareil";
    private final Connection dataSource;

    public TypeAppareilRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(TypeAppareil currentModel) {
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
    public TypeAppareil findById(int id) {
        TypeAppareil typeAppareil = null;
        Connection connection = dataSource;

        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                typeAppareil = new TypeAppareil(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeAppareil;
    }

    public void update(TypeAppareil currentModel) {

    }

    public void delete(int id) {

    }
}
