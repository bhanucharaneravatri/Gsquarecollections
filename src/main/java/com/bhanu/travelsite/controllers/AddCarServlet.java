/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite.controllers;

import com.bhanu.travelsite.dao.CarRentalCompanyDao;
import com.bhanu.travelsite.factories.ConnectionFactory;
import com.bhanu.travelsite.model.Car;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author charanbhanu4
 */
@WebServlet(name = "AddCarServlet", urlPatterns = {"/addCar"})
public class AddCarServlet extends HttpServlet {

    private final ConnectionFactory cf=new ConnectionFactory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String make=request.getParameter("make");
        String model=request.getParameter("model");
        String registrationNumber=request.getParameter("registrationNumber");
        String rentalGroup=request.getParameter("rentalGroup");
        double costPerDay=Double.parseDouble(request.getParameter("costPerDay"));
        Car c=new Car(0, make,  model, registrationNumber, rentalGroup, costPerDay);
        CarRentalCompanyDao cd= new CarRentalCompanyDao();
            cf.getConnected();
            cd.addCar(c);
            cf.getDisconnected();
        
        response.getWriter().print("Car Added Successfully");       
    }

}
