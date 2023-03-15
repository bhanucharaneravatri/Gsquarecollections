/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite;

import com.bhanu.dao.CarRentalCompanyDao;
import com.bhanu.travelsite.model.Car;
import com.bhanu.travelsite.model.Criteria;
import com.bhanu.travelsite.model.DatePeriod;
import java.io.IOException;
import java.io.PrintWriter;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException,NullPointerException
    {
        
        String[] make=request.getParameterValues("make");
        String[] rentalGroup=request.getParameterValues("RentalGroup");
        String mx=request.getParameter("maxCostPerDay");        
        double maxCostPerDay=50;
        if(!mx.isEmpty())
        {
             maxCostPerDay=Double.parseDouble(mx);
        }
        String mn=request.getParameter("minCostPerDay");
        double minCostPerDay=0;
        if(!mn.isEmpty())
        {
             minCostPerDay=Double.parseDouble(mn);
        }
        String startDate= request.getParameter("startDate");
        String endDate= request.getParameter("endDate");
        LocalDate start;
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu-MM-dd" ) ;
        if(!startDate.isEmpty())
        {
         start = LocalDate.parse(startDate, f);
        }
        else
            start=LocalDate.now();
        LocalDate end;
        if(!endDate.isEmpty())
        {
         end = LocalDate.parse(endDate, f);
        }
        else
            end=LocalDate.of(2023,4,1);
                    
        Criteria c=new Criteria(converttolist(make),converttolist(rentalGroup)
                ,maxCostPerDay,minCostPerDay,new DatePeriod(start,end));
        CarRentalCompanyDao cd= new CarRentalCompanyDao();
        List<Car> ans;
        ans=cd.getMatchingCars(c);
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<html> <head><link rel=\"stylesheet\" href=\"style.css\"/></head><body>");
        for(Car i:ans)
        {
               out.print("<table border = '0'> "+
                "   <tr align='left' valign='top'>"+
                "    <td>Make</td>"+
                         " <td>"+
                        i.getMake()+
                        "</td>"+
                         "</tr>"+
                "   <tr align='left' valign='top'>"+
                "    <td>Model</td>"+
                         " <td>"+
                        i.getModel()+
                        "</td>"+
                         "</tr>"+                
                "<tr align='left' valign='top'>"+
                    "<td>Registration Number</td>"+
                        " <td>"+
                        i.getRegistrationNumber()+
                        "</td>"+                                          
            "    </tr>"+
                    
                "<tr align='left' valign='top'>"+
                    "<td>Rental Group</td>"+
                        "<td>"+
                        i.getRentalGroup()+
                        "</td>"+
            "    </tr>"+
                    
                "<tr align='left' valign='top'>"+
                    "<td>CostPerDay</td>"+
                        "<td>"+
                        i.getCostPerDay()+
                        "</td>"+
            "    </tr>"+
            "</table><br>");
        }
        out.print("</html></body>");
    }   
}
