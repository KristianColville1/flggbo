package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    public static Connection connect() {
        Connection connection = null;
        try {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:gbbo.db");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.out.println("Failed to connect db");
        }
        return connection;
    }
}
