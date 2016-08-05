/**
 * Created by Lenovo on 08/06/2016.
 */
package com.uga.energie.dataSource;

import org.apache.maven.wagon.resource.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static org.apache.maven.wagon.providers.ssh.ScpHelper.getResource;
import static org.apache.maven.wagon.providers.ssh.ScpHelper.getResourceFilename;


public class ConnectionClass {

    private static Connection dataSource;


    private ConnectionClass() {
        Properties props = new Properties();
        FileInputStream fileProperty = null;
        try {
            fileProperty = new FileInputStream("src/main/resources/db.properties");
            props.load(fileProperty);
            dataSource = DriverManager.getConnection(props.getProperty("postgresql.url"), props.getProperty("postgresql.username"), props.getProperty("postgresql.password"));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getDataSource() {
        if (null == dataSource) {
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
        return dataSource;
    }
}
