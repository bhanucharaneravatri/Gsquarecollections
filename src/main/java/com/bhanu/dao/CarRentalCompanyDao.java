/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.dao;
import com.bhanu.travelsite.model.Car;
import com.bhanu.travelsite.model.CarRentalCompany;
import com.bhanu.travelsite.model.Criteria;
import com.bhanu.travelsite.model.DatePeriod;
import com.bhanu.travelsite.model.NewClass;
import com.bhanu.travelsite.model.Renter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;


/**
 *
 * @author charanbhanu4
 */
public class CarRentalCompanyDao {
    private int noOfCars;
    public void fetchData() 
    {
        
        JSONArray ja;
        try {
            ja=NewClass.function().optJSONArray("results");
            getConnected();
        for(int i=0;i<100000;i++)
        {
            if(ja.optJSONObject(i)!=null)
            {
            JSONObject jo=ja.optJSONObject(i);
            String make=(String)jo.get("Make");
            String model=(String)jo.get("Model");
            String rentalGroup=(String)jo.get("Category");
            addCar(new Car(make,model,RandomStringUtils.randomAlphanumeric(10),rentalGroup,Math.random() *50 + 1 ));
            }
        }
        }
         catch (Exception ex) {
            Logger.getLogger(CarRentalCompanyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
           private final String url="jdbc:mysql://localhost:3306/CarRental";
           private Connection con;
    public void getConnected()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,"root","root");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CarRentalCompanyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void getDisconnected() 
    {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(CarRentalCompanyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public List<String> getAllMakes()
    {
        try{
            getConnected();
            String sqlquery="SELECT DISTINCT make FROM cars";
            PreparedStatement st=con.prepareStatement(sqlquery);
            ResultSet rs;
            rs=st.executeQuery();
            List<String> makes=new ArrayList<>();   
            while(rs.next())
            {
                String make=rs.getString("make");
                makes.add(make);
            }
            rs.close();
            getDisconnected();
            return makes;
            }
        catch(SQLException e){
        }
        return null;
    }
    public List<String> getAllGroups() 
    {
        try{
            getConnected();
            String sqlquery="SELECT DISTINCT RentalGroup FROM cars";
            PreparedStatement st=con.prepareStatement(sqlquery);
            ResultSet rs;
            rs=st.executeQuery();
            List<String> RentalGroups=new ArrayList<>();   
            while(rs.next())
            {
                String RentalGroup=rs.getString("RentalGroup");
                RentalGroups.add(RentalGroup);
            }
            rs.close();
            getDisconnected();
            return RentalGroups;
            }
        catch(SQLException e){
        }
        return null;
    }
    public void addCar(Car c) {
        try{
                String sqlquery2="insert into cars values(0,?,?,?,?,?)";
                PreparedStatement st;
                st = con.prepareStatement(sqlquery2);
                st.setString(1,c.getMake());
                st.setString(2,c.getModel());
                st.setString(3,c.getRegistrationNumber());
                st.setDouble(4,c.getCostPerDay());
                st.setString(5,c.getRentalGroup());
                st.executeUpdate();
                st.close();
            }
        catch(SQLException e){
        }
    }
     public List<Car> getAllCarsPerPage(int offset, int noOfRecords)
    {
        try{
            getConnected();
            String query = "select SQL_CALC_FOUND_ROWS * from cars limit " + offset + ", " + noOfRecords;
        
            PreparedStatement st;
            st = con.prepareStatement(query);
            ResultSet rs;
            rs=st.executeQuery();
            List<Car> cars=new ArrayList<>();   
            while(rs.next())
            {
                String make=rs.getString("make");
                String model=rs.getString("model");
                String registrationNumber=rs.getString("registrationNumber");
                double costPerDay=rs.getDouble("costPerDay");
                String rentalGroup= rs.getString("rentalgroup");
                cars.add(new Car(make,model,registrationNumber,rentalGroup,costPerDay));
            }
            rs.close();
            rs = st.executeQuery("SELECT Count('id') from cars");
  
            if (rs.next())
               this.noOfCars = rs.getInt(1);
            
            getDisconnected();
            return cars;
            }
        catch(SQLException e){
        }
        
        return null;
    }
    public List<Car> getAllCars()
    {
        try{
            getConnected();
            String sqlquery="select * from cars";
            PreparedStatement st;
            st = con.prepareStatement(sqlquery);
            ResultSet rs;
            rs=st.executeQuery();
            List<Car> cars=new ArrayList<>();   
            while(rs.next())
            {
                String make=rs.getString("make");
                String model=rs.getString("model");
                String registrationNumber=rs.getString("registrationNumber");
                double costPerDay=rs.getDouble("costPerDay");
                String rentalGroup= rs.getString("rentalgroup");
                cars.add(new Car(make,model,registrationNumber,rentalGroup,costPerDay));
            }
            rs.close();
            getDisconnected();
            return cars;
            }
        catch(SQLException e){
        }
        
        return null;
    }
    public HashSet<Renter> getAllRenters()
    {
      try{
            getConnected();
            String sqlquery1="select * from renters";
           PreparedStatement st=con.prepareStatement(sqlquery1);
           HashSet<Renter> renters;
           ResultSet rs;
           rs= st.executeQuery();
           renters = new HashSet<>();
                while(rs.next())
                {
                    String make=rs.getString("make");
                    String model=rs.getString("model");
                    String registrationNumber=rs.getString("registrationNumber");
                    double costPerDay=rs.getDouble("costPerDay");
                    String rentalGroup= rs.getString("rentalgroup");
                    Car c=new Car(make,model,registrationNumber,rentalGroup,costPerDay);
                    String LastName=rs.getString("LastName");
                    String FirstName=rs.getString("FirstName");
                    String drivingLicense=rs.getString("drivingLicense");
                    LocalDate startDate=rs.getObject("startDate", LocalDate.class);
                    LocalDate endDate=rs.getObject("endDate", LocalDate.class);
                    LocalDate birthDate=rs.getObject("birthDate", LocalDate.class);
                    
                    Renter r=new Renter(LastName,FirstName,drivingLicense,
                            birthDate,
                            new DatePeriod( startDate,endDate),
                            c);
                    renters.add(r);    
            }
            rs.close();
            getDisconnected();
            return renters;
            }
        catch(SQLException e){
        }
        return null;
    }  
    public List<Car> getMatchingCars(Criteria criteria)  {
        List<Car> cars=getAllCars();
        HashSet<Renter> renters=getAllRenters();
        List<String> makes=getAllMakes();
        List<String> groups= getAllGroups();
        CarRentalCompany c;
        c = new CarRentalCompany();
        c.setRenters(renters);
        c.setCars(cars);
        c.setMakeCars();
        c.setGroups(groups);
        c.setMakes(makes);
        c.setRentalGroupCars();
        c.setMakeCars();
        getDisconnected();
        return c.matchingCars(criteria);
    }
    public int getNoOfCars() { return this.noOfCars; }
}
