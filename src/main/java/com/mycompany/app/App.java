package com.mycompany.app;

import java.sql.*;


public class App {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

//step2 create  the connection object
            Connection con = DriverManager
                    .getConnection("jdbc:mysql://localhost:13306/testdb?useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&allowPublicKeyRetrieval=true", "newuser", "Abc123");

//step3 create the statement object
            Statement stmt = con.createStatement();

//step4 execute query

            String strSelect = "select first_name, last_name from customers";
            System.out.println("The SQL query is: " + strSelect); // Echo For debugging
            System.out.println();

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records are:");
            while (rset.next()) {
                String firstName = rset.getString("first_name");
                String lastName = rset.getString("last_name");
                System.out.println(firstName + ", " + lastName);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
