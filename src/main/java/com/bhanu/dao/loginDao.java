/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.dao;

import com.bhanu.travelsite.model.loginmodel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author charanbhanu4
 */
public class loginDao  {
        String url="jdbc:mysql://localhost:3306/CarRental";      
        
    public boolean check(loginmodel lm)  
    {   try{
         String sqlQuery1="select * from login where username=? and password=?";
       
        Class.forName("com.mysql.jdbc.Driver");
        Connection con=DriverManager.getConnection(url,"root","root");
        PreparedStatement st=con.prepareStatement(sqlQuery1);
        st.setString(1,lm.getUserName());
        st.setString(2,lm.getPassword());
        ResultSet rs=st.executeQuery();
        
        if(!rs.next()) {
        } else {
            rs.close();
            return true;
        }
        }
        catch(ClassNotFoundException | SQLException e)
        {
        }  
        return false;
    }

    public boolean add(loginmodel lm) {
        try{
            String sqlquery="select * from login where username=?";
            String sqlquery2="insert into login values(?,?,'user')";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,"root","root");
            PreparedStatement st;
            st=con.prepareStatement(sqlquery2);
            PreparedStatement s;
            s=con.prepareStatement(sqlquery);
            s.setString(1, lm.getUserName());
            ResultSet r;
            r=s.executeQuery();
            if(r.next())
            {
            return false;
            }
            st.setString(1,lm.getUserName());
            st.setString(2,lm.getPassword());
            st.executeUpdate();
            s.close();
            st.close();
            r.close();
            }
        catch(ClassNotFoundException | SQLException e){
        }
        return true;
    }
    
}
