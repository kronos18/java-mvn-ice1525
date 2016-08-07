/**
 * Created by Lenovo on 08/06/2016.
 */
package com.uga.energie.dataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class ConnectionClass {

    private static Connection dataSource;


    private ConnectionClass() {
        if (null == dataSource) {
            configureDataSource();
        }
    }

    public static Connection getDataSource() {
        if (null == dataSource) {
            configureDataSource();
        }
        return dataSource;
    }

    private static void configureDataSource() {
        Properties props = new Properties();
        FileInputStream fileProperty = null;
        try {
            fileProperty = new FileInputStream("src/main/resources/db.properties");
            props.load(fileProperty);
            dataSource = DriverManager.getConnection(props.getProperty("postgresql.url"), props.getProperty("postgresql.username"), props.getProperty("postgresql.password"));
            dataSource.setAutoCommit(false);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
