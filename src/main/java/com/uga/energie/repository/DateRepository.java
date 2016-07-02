package com.uga.energie.repository;

import com.uga.energie.model.Date;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Lenovo on 08/06/2016.
 */
public class DateRepository implements CRUDInteface<Date> {

    private static final String INSERT = "insert into uga.Date(id, ddate) values( ? ,? )";
    private static final String FIND_BY_ID = "select * from uga.Date";
    private final Connection dataSource;

    public DateRepository(Connection dataSource) {
        this.dataSource = dataSource;
    }


    public void create(Date currentModel) {
        try {
            Connection connection = dataSource;
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setObject(1, currentModel.getId());
            preparedStatement.setObject(2, currentModel.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    //TODO A faire
    public Date findById(int id) {
        Date date = null;
        Connection connection = dataSource;
        try {
            ResultSet rs;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                date = new Date(rs.getInt("id"), rs.getDate("ddate"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return date;
    }

    public void update(Date currentModel) {

    }

    public void delete(int id) {

    }
}
