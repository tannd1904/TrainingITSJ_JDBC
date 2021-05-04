package com.example.jdbcdemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;

@SpringBootApplication
public class JdbcDemoApplication {

    public static void main(String[] args) {

        //Get Connection
        Connection connection = CheckConnection.getConnection();

        Book_CRUD_Operation crud = new Book_CRUD_Operation();
        Book bookInsert = new Book(4, "Tay Du Ki", "Ngo Thua An", 50000);
        if (crud.insertBook(connection,bookInsert)) {
            System.out.println("Insert Successfully");
        } else {
            System.out.println("Failed to Insert");
        }

        Book bookRead = crud.selectBook(connection, 3);
        if (!bookRead.equals(null)) {
            System.out.println("Book name: " + bookRead.getName());
        } else {
            System.out.println("Failed to Get book");
        }

        Book bookUpdate = new Book(2, "Doraemon", "Tan ND", 20000);
        if (crud.updateBook(connection, bookUpdate.getId(), bookUpdate)) {
            System.out.println("Update Successfully");
        } else {
            System.out.println("Failed to Update");
        }

        if (crud.deleteBook(connection, 4)) {
            System.out.println("Delete Successfully");
        } else {
            System.out.println("Failed to Delete");
        }
    }

}
