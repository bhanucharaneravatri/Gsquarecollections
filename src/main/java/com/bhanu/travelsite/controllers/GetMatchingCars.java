/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite.controllers;

import com.bhanu.travelsite.dao.CarRentalCompanyDao;
import com.bhanu.travelsite.model.Car;
import com.bhanu.travelsite.model.Criteria;
import com.bhanu.travelsite.model.DatePeriod;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author charanbhanu4
 */
@WebServlet(name = "GetMatchingCars", urlPatterns = {"/GetMatchingCars"})
public class GetMatchingCars extends HttpServlet {
    private List<String >converttolist(String [] a){
    
        List<String > ans=new ArrayList<>();
        if(a==null||a.length==0)
        return ans;
        else
        return Arrays.asList(a);
    }
            


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,NullPointerException,ServletException
    {
        
        String[] make=request.getParameterValues("make");
        String[] rentalGroup=request.getParameterValues("RentalGroup");
        String mx=request.getParameter("maxCostPerDay");        
        double maxCostPerDay=50;
        if(mx!=null && !mx.isEmpty())
        {
             maxCostPerDay=Double.parseDouble(mx);
        }
        String mn=request.getParameter("minCostPerDay");
        double minCostPerDay=0;
        if(mn!=null && !mn.isEmpty())
        {
             minCostPerDay=Double.parseDouble(mn);
        }
        String startDate= request.getParameter("startDate");
        String endDate= request.getParameter("endDate");
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
                    
        Criteria c=new Criteria(converttolist(make),converttolist(rentalGroup)
                ,maxCostPerDay,minCostPerDay,new DatePeriod(start,end));
        CarRentalCompanyDao cd= new CarRentalCompanyDao();
                int page = 1;
        int recordsPerPage = 10;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(
                request.getParameter("page"));
        List<Car> cars=cd.getMatchingCars(c,(page - 1) * recordsPerPage,
            recordsPerPage);
        int noOfRecords = cd.getNoOfCars();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0
                                       / recordsPerPage);
        request.setAttribute("cars", cars);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        if(cars.isEmpty())
            response.getWriter().print("Sorry there are no Matching Cars on your selected criteria, Here are the list of all cars");       
        else    
        response.getWriter().print(cars);
      /*RequestDispatcher rd
            = request.getRequestDispatcher("MatchingCarsDisplay.jsp");
        rd.forward(request, response);
      */
    }   
}
