package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookDAO {

    public static void addBook(String title, String author) {
        String sql = "INSERT INTO books (title, author) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listBooks() {
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.printf(
                        "ID: %d | Title: %s | Author: %s | Status: %s%n",
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("status")
                );
            }

            if (!found) {
                System.out.println("No books found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}