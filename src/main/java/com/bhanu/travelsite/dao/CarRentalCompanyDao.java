/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bhanu.travelsite.dao;

import com.bhanu.travelsite.factories.ConnectionFactory;
import com.bhanu.travelsite.model.Car;
import com.bhanu.travelsite.model.CarRentalCompany;
import com.bhanu.travelsite.model.Criteria;
import com.bhanu.travelsite.model.DatePeriod;
import com.bhanu.travelsite.model.NewClass;
import com.bhanu.travelsite.model.Renter;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.commons.lang.RandomStringUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author charanbhanu4
 */
public class CarRentalCompanyDao {

    private int noOfCars;
    private final ConnectionFactory cf = new ConnectionFactory();

    public void fetchData() {

        JSONArray ja;
        try {
            ja = NewClass.function().optJSONArray("results");
            cf.getConnected();
            for (int i = 0; i < 100000; i++) {
                if (ja.optJSONObject(i) != null) {
                    JSONObject jo = ja.optJSONObject(i);
                    String make = (String) jo.get("Make");
                    String model = (String) jo.get("Model");
                    String rentalGroup = (String) jo.get("Category");
                    addCar(new Car(0, make, model, RandomStringUtils.randomAlphanumeric(10), rentalGroup, Math.random() * 50 + 1));
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(CarRentalCompanyDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getAllMakes() {
        try {
            cf.getConnected();
            String sqlquery = "SELECT DISTINCT make FROM cars";
            PreparedStatement st = cf.con.prepareStatement(sqlquery);
            ResultSet rs;
            rs = st.executeQuery();
            List<String> makes = new ArrayList<>();
            while (rs.next()) {
                String make = rs.getString("make");
                makes.add(make);
            }
            rs.close();
            cf.getDisconnected();
            return makes;
        } catch (SQLException e) {
        }
        return null;
    }

    public List<String> getAllGroups() {
        try {
            cf.getConnected();
            String sqlquery = "SELECT DISTINCT RentalGroup FROM cars";
            PreparedStatement st = cf.con.prepareStatement(sqlquery);
            ResultSet rs;
            rs = st.executeQuery();
            List<String> RentalGroups = new ArrayList<>();
            while (rs.next()) {
                String RentalGroup = rs.getString("RentalGroup");
                RentalGroups.add(RentalGroup);
            }
            rs.close();
            cf.getDisconnected();
            return RentalGroups;
        } catch (SQLException e) {
        }
        return null;
    }

    public void addCar(Car c) {
        try {
            String sqlquery2 = "insert into cars values(0,?,?,?,?,?)";
            PreparedStatement st;
            st = cf.con.prepareStatement(sqlquery2);
            st.setString(1, c.getMake());
            st.setString(2, c.getModel());
            st.setString(4, c.getRegistrationNumber());
            st.setDouble(5, c.getCostPerDay());
            st.setString(3, c.getRentalGroup());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
        }
    }

    public List<Car> getAllCarsPerPage(int offset, int noOfRecords) {
        try {
            cf.getConnected();
            String query = "select SQL_CALC_FOUND_ROWS * from cars limit " + offset + ", " + noOfRecords;
            PreparedStatement st;
            st = cf.con.prepareStatement(query);
            ResultSet rs;
            rs = st.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                int carid = rs.getInt("carid");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String registrationNumber = rs.getString("registrationNumber");
                double costPerDay = rs.getDouble("costPerDay");
                String rentalGroup = rs.getString("rentalgroup");
                cars.add(new Car(carid, make, model, registrationNumber, rentalGroup, costPerDay));
            }
            rs.close();
            rs = st.executeQuery("SELECT Count('carid') from cars");

            if (rs.next()) {
                this.noOfCars = rs.getInt(1);
            }

            cf.getDisconnected();
            return cars;
        } catch (SQLException e) {
        }

        return null;
    }

    public List<Car> getAllCars() {
        try {
            cf.getConnected();
            String sqlquery = "select * from cars";
            PreparedStatement st;
            st = cf.con.prepareStatement(sqlquery);
            ResultSet rs;
            rs = st.executeQuery();
            List<Car> cars = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("carid");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String registrationNumber = rs.getString("registrationNumber");
                double costPerDay = rs.getDouble("costPerDay");
                String rentalGroup = rs.getString("rentalgroup");
                cars.add(new Car(id, make, model, registrationNumber, rentalGroup, costPerDay));
            }
            rs.close();
            cf.getDisconnected();
            return cars;
        } catch (SQLException e) {
        }
        return null;
    }

    public HashSet<Renter> getAllRenters() {
        try {
            cf.getConnected();
            String sqlquery1 = "select * from renters";
            String sqlquery2 = "select * from cars where carId=?";
            PreparedStatement st1 = cf.con.prepareStatement(sqlquery1);
            PreparedStatement st2 = cf.con.prepareStatement(sqlquery2);
            HashSet<Renter> renters;
            ResultSet rs1;
            rs1 = st1.executeQuery();
            renters = new HashSet<>();
            while (rs1.next()) {
                int carId = rs1.getInt("carId");
                st2.setInt(1, carId);
                ResultSet rs2;
                rs2 = st2.executeQuery();
                String make = rs2.getString("make");
                String model = rs2.getString("model");
                String registrationNumber = rs2.getString("registrationNumber");
                double costPerDay = rs2.getDouble("costPerDay");
                String rentalGroup = rs2.getString("rentalgroup");
                rs2.close();
                Car c = new Car(carId, make, model, registrationNumber, rentalGroup, costPerDay);
                String LastName = rs1.getString("LastName");
                String FirstName = rs1.getString("FirstName");
                String drivingLicense = rs1.getString("drivingLicense");
                LocalDate startDate = rs1.getObject("startDate", LocalDate.class);
                LocalDate endDate = rs1.getObject("endDate", LocalDate.class);
                LocalDate birthDate = rs1.getObject("birthDate", LocalDate.class);
                Renter e;
                e = new Renter(FirstName, LastName, drivingLicense,
                        birthDate,
                        new DatePeriod(startDate, endDate),
                        c);
                renters.add(e);
            }
            rs1.close();
            cf.getDisconnected();
            return renters;
        } catch (SQLException e) {
        }
        return null;
    }

    public List<Car> getMatchingCars(Criteria criteria, int offset, int noOfRecords) {
        List<Car> cars = new ArrayList<>();
        List<String> makes = criteria.getMake();
        int makelength = makes.size();
        List<String> rentalGroups = criteria.getRentalGroup();
        int rglength = rentalGroups.size();
        Date start = Date.valueOf(criteria.getDatePeriod().getStart());
        Date end = Date.valueOf(criteria.getDatePeriod().getEnd());
        try {
            cf.getConnected();
            String query = "select SQL_CALC_FOUND_ROWS * from cars";
            if (makelength != 0) {
                query = query + "where (make=?";
            }
            while (makelength > 1) {
                query = query + " or make=?";
                makelength--;
            }
            query = query + ")";
            if (rglength != 0) {
                query = query + " and (rentalGroup=? ";
            }
            while (rglength > 1) {
                query = query + " or rentalGroup=? ";
                rglength--;
            }
            query = query + ")";
            query = query + " and (costPerDay is between " + start + " and " + end + ")";
            query = query + " limit " + offset + ", " + noOfRecords;
            PreparedStatement st;
            st = cf.con.prepareStatement(query);
            ResultSet rs;
            rs = st.executeQuery();
            while (rs.next()) {
                String make = rs.getString("make");
                String model = rs.getString("model");
                String registrationNumber = rs.getString("registrationNumber");
                double costPerDay = rs.getDouble("costPerDay");
                String rentalGroup = rs.getString("rentalgroup");
                cars.add(new Car(0, make, model, registrationNumber, rentalGroup, costPerDay));
            }
            rs.close();
            rs = st.executeQuery("SELECT Count('id') from cars");
            if (rs.next()) {
                this.noOfCars = rs.getInt(1);
            }
            cf.getDisconnected();
            CarRentalCompany c = new CarRentalCompany();
            HashSet<Renter> renters = getAllRenters();
            c.setRenters(renters);
            return cars.stream().filter(car -> c.isAvailable(car, criteria)).collect(Collectors.toList());
        } catch (SQLException e) {
        }

        /*
        HashSet<Renter> renters=getAllRenters();
        List<String> makes=getAllMakes();
        List<String> groups= getAllGroups();
        CarRentalCompany c;
        c = new CarRentalCompany();
        c.setRenters(renters);
        c.setCars(cars);
        c.setGroups(groups);
        c.setMakes(makes);
        c.setRentalGroupCars();
        c.setMakeCars();
        return c.matchingCars(criteria);
         */
        return cars;
    }

    public int getNoOfCars() {
        return this.noOfCars;
    }

    public boolean rentACar(Car c, String firstName, String lastName, String drivingLicense, Date dob, LocalDate StartDate, LocalDate EndDate) {
        try {
            cf.getConnected();
            String sqlquery = "insert into renters values(0,?,?,?,?,?,?,?)";
            PreparedStatement st;
            st = cf.con.prepareStatement(sqlquery);
            st.setDate(1, dob);
            st.setString(2, lastName);
            st.setString(3, firstName);
            st.setString(4, drivingLicense);
            st.setDate(5, Date.valueOf(StartDate));
            st.setDate(6, Date.valueOf(EndDate));
            st.setInt(7, c.getCarId());
            st.executeUpdate();
            //st.close();
            //cf.getDisconnected();
            return true;
        } catch (SQLException ex) {
            return false;
       }
    }


    public void returnACar(String username) {
        try {
            cf.getConnected();
            String sqlQuery = "delete from renters where username=?";
            PreparedStatement st;
            st = cf.con.prepareStatement(sqlQuery);
            st.executeQuery();
            st.close();
            cf.getDisconnected();
        } catch (SQLException ex) {
        }
    }
}
