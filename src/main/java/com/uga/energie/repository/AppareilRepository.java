package com.uga.energie.repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class AppareilRepository implements CRUDInteface {

    public static final String INSERT = "insert into uga.typeappareil( name ) values( ? )";
    private final Connection dataSource;

    public AppareilRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public <T> void create(T currentModel) {
        Connection connection = null;
        try {
            connection = dataSource;
            String querySQL = INSERT;
            PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setObject(1, "test");
            preparedStatement.executeUpdate();

            ResultSet rs;
            preparedStatement = connection.prepareStatement("select * from uga.typeappareil");
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

    @Override
    public <T> void findById(int id) {

    }

    @Override
    public <T> void update(String tableName, T currentModel) {

    }

    @Override
    public <T> void delete(int id, T currentModel) {

    }
}
