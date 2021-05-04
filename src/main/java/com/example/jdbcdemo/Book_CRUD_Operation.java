package com.example.jdbcdemo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Book_CRUD_Operation {

    //CREATE
    public boolean insertBook(Connection connection, Book book) {
        String query = "INSERT INTO BOOK VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, book.getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException exception) {
            return false;
        }
    }

    //READ
    public Book selectBook(Connection connection, int id) {
        String query = "SELECT * FROM BOOK B WHERE B.ID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            Book book = new Book();
            while (rs.next()) {
                book.setId(rs.getInt(1));
                book.setName(rs.getString(2));
                book.setAuthor(rs.getString(3));
                book.setPrice(rs.getInt(4));
            }
            return book;
        }
        catch (SQLException exception) {
            return null;
        }
    }

    //UPDATE
    public boolean updateBook(Connection connection, int id, Book book) {
        String query = "UPDATE BOOK SET BOOKID = ?, BOOKNAME = ?, AUTHOR = ?, PRICE = ?" +
                "WHERE BOOKID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, book.getId());
            ps.setString(2, book.getName());
            ps.setString(3, book.getAuthor());
            ps.setInt(4, book.getPrice());
            ps.setInt(5, id);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException exception) {
            return false;
        }
    }

    //DELETE
    public boolean deleteBook(Connection connection, int id) {
        String query = "DELETE FROM BOOK WHERE BOOKID = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        }
        catch (SQLException exception) {
            return false;
        }
    }
}
