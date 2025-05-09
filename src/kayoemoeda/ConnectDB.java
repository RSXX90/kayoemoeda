/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kayoemoeda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Jeffrey
 */
public class ConnectDB {
    public static void main(String[] args) {
        String jdbcurl = "jdbc:sqlite:db/trydb.db";
        
        System.out.println("Connect To DB");
        
        try {
            Connection connection = DriverManager.getConnection(jdbcurl);
            String sql = "SELECT * FROM users";
            
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                
                System.out.println(name + " " + email);
            }
        } catch (Exception e) {
            System.out.println("Error connecting to SQLite database");
            e.printStackTrace();
        }
    }
}
