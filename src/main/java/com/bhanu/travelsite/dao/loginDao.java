/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.dao;
import com.bhanu.travelsite.factories.ConnectionFactory;
import com.bhanu.travelsite.model.loginmodel;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
/**
 *
 * @author charanbhanu4
 */
public class loginDao  {
        private final ConnectionFactory cf=new ConnectionFactory();
    public Object[] check(loginmodel lm)  
    {
        Object[] ans=new Object[4];
        ans[0]=false;
        ans[1]="";
        ans[2]="";
        ans[3]=LocalDate.now();
        try{
        cf.getConnected();
         String sqlQuery1="select * from login where username=? and password=?";
        PreparedStatement st=cf.con.prepareStatement(sqlQuery1);
        st.setString(1,lm.getUserName());
        st.setString(2,lm.getPassword());
        ResultSet rs=st.executeQuery();
        
        if(rs.next()) {
            ans[0]=true;
            ans[1]=ans[1]+rs.getString("firstName");
            ans[2]=ans[2]+rs.getString("lastName");
            ans[3]=rs.getDate("dateOfBirth");
            rs.close();
            cf.getConnected();
            return ans;
            }
        }
        catch(SQLException e)
        {
        }  
        return ans;
    }

    public int add(loginmodel lm) {
        try{
            cf.getConnected();
            String sqlquery="select * from login where username=?";
            PreparedStatement s;
            s=cf.con.prepareStatement(sqlquery);
            s.setString(1, lm.getUserName());
            ResultSet r;
            r=s.executeQuery();
            if(r.next())
            {
                r.close();
                s.close();
                cf.con.close();
                return 1;                
            }
            String sqlquery2="insert into login values(0,?,?,'user',?,?,?)";
            PreparedStatement st;
            st=cf.con.prepareStatement(sqlquery2);
            st.setString(1,lm.getUserName());
            st.setString(2,lm.getPassword());
            st.setString(3,lm.getFirstName());
            st.setDate(5,Date.valueOf(lm.getDateOfBirth()));
            st.setString(4,lm.getLastName());
            st.executeUpdate();
            s.close();
            st.close();
            r.close();
            cf.getDisconnected();
            return 3;
            }
        catch(SQLException e){
        return 2;
        }
  }
}