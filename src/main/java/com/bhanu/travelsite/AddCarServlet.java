/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite;

import com.bhanu.dao.CarRentalCompanyDao;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String make=request.getParameter("make");
        String model=request.getParameter("model");
        String registrationNumber=request.getParameter("registrationNumber");
        String rentalGroup=request.getParameter("rentalGroup");
        double costPerDay=Double.parseDouble(request.getParameter("costPerDay"));
        Car c=new Car( make,  model, registrationNumber, rentalGroup, costPerDay);
        CarRentalCompanyDao cd= new CarRentalCompanyDao();
            cd.getConnected();
            cd.addCar(c);
            cd.getDisconnected();
        
        response.getWriter().print("Car Added Successfully");       
    }

}
