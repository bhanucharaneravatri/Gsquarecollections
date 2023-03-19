/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.factories;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ebc
 */
public class ConnectionFactory {
    public String url="jdbc:mysql://localhost:3306/carrental";
    public Connection con;
    public void getConnected()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con=DriverManager.getConnection(url,"root","root");
        } catch (ClassNotFoundException | SQLException ex) {
        }
    }
    public void getDisconnected() 
    {
        try {
            this.con.close();
        } catch (SQLException ex) {
        }
    }
    
}
