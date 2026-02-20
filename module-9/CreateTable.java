package javaapplication1;

import java.sql.*;

public class CreateTable {

    Connection con;
    Statement stmt;

    public CreateTable() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/databasedb?serverTimezone=UTC";
            con = DriverManager.getConnection(url, "student1", "pass");

            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error connecting to database.");
            e.printStackTrace();
            System.exit(0);
        }

        try {
            stmt.executeUpdate("DROP TABLE address33");
            System.out.println("Table address33 dropped");
        } catch (SQLException e) {
            System.out.println("Table address33 does not exist (this is fine)");
        }

        try {
            stmt.executeUpdate(
                    "CREATE TABLE address33(" +
                    "ID int PRIMARY KEY, " +
                    "LASTNAME varchar(40), " +
                    "FIRSTNAME varchar(40), " +
                    "STREET varchar(40), " +
                    "CITY varchar(40), " +
                    "STATE varchar(40), " +
                    "ZIP varchar(40)" +
                    ")"
            );
            System.out.println("Table address33 created");
        } catch (SQLException e) {
            System.out.println("Table address33 creation failed");
            e.printStackTrace();
        }

        try {
            stmt.close();
            con.close();
            System.out.println("Database connections closed");
        } catch (SQLException e) {
            System.out.println("Connection close failed");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CreateTable();
    }
}