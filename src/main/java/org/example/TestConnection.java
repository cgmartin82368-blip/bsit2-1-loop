package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println("Connected to MySQL successfully!");
            System.out.println("Database: " +
                    conn.getCatalog());
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            System.out.println(e.getMessage());
        }
    }
}
