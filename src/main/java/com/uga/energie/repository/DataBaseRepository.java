package com.uga.energie.repository;

import com.uga.energie.model.DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class DataBaseRepository implements CRUDInteface<DataBase> {

    private static final String FIND_CURRENT_SIZE = "select pg_database_size(pg_database.datname) as size from pg_database where pg_database.datname = 'postgres'";
    private final Connection dataSource;

    public DataBaseRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void create(DataBase currentModel) {

    }

    @Override
    public DataBase findById(int id) {
        return null;
    }

    @Override
    public void update(DataBase currentModel) {

    }

    @Override
    public void delete(int id) {

    }

    //TODO A faire
    public int getCurrentSize() {
        Connection connection = dataSource;
        int currentSize = 0;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CURRENT_SIZE);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                currentSize = rs.getInt("size");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return currentSize;
    }

}
