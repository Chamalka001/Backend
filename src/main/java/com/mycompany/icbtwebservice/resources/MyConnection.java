package com.mycompany.icbtwebservice.resources;

import java.sql.*;

/**
 *
 * @author tharindulakshan
 */
public class MyConnection {

    public static Connection con = null;
    public static Statement st;
    public static PreparedStatement pst;

    public static Connection getConnection() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc_restaurent_system?createDatabaseIfNotExist=true&autoReconnect=true&useSSL=false", "root", "1234");
            st = con.createStatement();
            System.out.println("Connection Success!");

        } catch (Exception e) {

            System.out.println("Database Error: " + e.getMessage());

        }

        return con;

    }

}
