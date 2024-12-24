/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class MySQL {
    
    private static Connection connection;
    
    static {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/resources/Database/prettyBee.db");
        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    public static ResultSet execute(String query) throws Exception{

            Statement statement = connection.createStatement();

            if (query.startsWith("SELECT")) {
                return statement.executeQuery(query);
            } else {
                statement.executeUpdate(query);
                return null;
            }

    }

}
