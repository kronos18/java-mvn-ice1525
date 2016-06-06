package com.uga.energie;

import java.sql.*;
import java.util.Properties;

/**
 * Created by jack on 06/06/16.
 */
public class MainJDBC {
    public static void main(String[] args) {
        Connection connection = null;
        try {

            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "postgres");
            // create a database connection
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/postgres", props);
//            Statement statement = connection.createStatement();
            String querySQL = "insert into uga.typeappareil( name ) values( ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(querySQL);
            preparedStatement.setObject(1, "test");
            preparedStatement.executeUpdate();
//            statement.executeUpdate(querySQL);


            ResultSet rs;
            preparedStatement = connection.prepareStatement("select * from uga.typeappareil");
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                // read the result set
                System.out.println("name = " + rs.getString("name"));
                System.out.println("id = " + rs.getInt("id"));
            }
        } catch (SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
    }
}
