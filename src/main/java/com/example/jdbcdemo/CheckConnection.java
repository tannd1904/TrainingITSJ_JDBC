package com.example.jdbcdemo;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CheckConnection {
    //This class is used to check connection
    public static Connection getConnection() {
        Connection conn = null;

        String url = "jdbc:sqlserver://;databaseName=BooksManagement";
        String user = "sa";
        String password = "123456";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connect succesfully");
        }
        catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Failed to connect");
        }

        return conn;
    }
}
