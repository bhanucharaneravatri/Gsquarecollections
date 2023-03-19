/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite.controllers;

import com.bhanu.travelsite.dao.CarRentalCompanyDao;
import com.bhanu.travelsite.model.Car;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author ebc
 */
@WebServlet(name = "book", urlPatterns = {"/book"})
public class book extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Car car;
        String cpd= request.getParameter("CostPerDay");
        double CostPerDay=0;
        if(cpd!=null)
        {
            CostPerDay=Double.parseDouble(cpd);
        } 
        car = new Car(Integer.parseInt(request.getParameter("ID")),request.getParameter("Make"),
                request.getParameter("Model"),
                request.getParameter("RegistrationNumber"),
                request.getParameter("RentalGroup"),
                CostPerDay);
        String drivingLicense=request.getParameter("DrivingLicense");
        String startDate= request.getParameter("StartDate");
        String endDate= request.getParameter("EndDate");
        LocalDate start;
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu-MM-dd" ) ;
        if(startDate!=null && !startDate.isEmpty())
        {
            start = LocalDate.parse(startDate, f);
        }
        else
            start=LocalDate.now();
        LocalDate end;
        if(endDate!=null && !endDate.isEmpty())
        {
            end = LocalDate.parse(endDate, f);
        }
        else
            end=LocalDate.of(2023,4,1);
        CarRentalCompanyDao cd=new CarRentalCompanyDao();
        HttpSession session=request.getSession();
        boolean status=cd.rentACar(car,(String)session.getAttribute("firstName"),
                (String)session.getAttribute("lastName"),
                drivingLicense,
                (Date)session.getAttribute("dateOfBirth"),
                 start, end);
            response.setContentType("text/plain");
          response.setCharacterEncoding("UTF-8");
          if(status)
          response.getWriter().print("booked");
    }
}