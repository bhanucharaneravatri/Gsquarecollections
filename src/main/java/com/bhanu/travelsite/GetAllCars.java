/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite;

import com.bhanu.dao.CarRentalCompanyDao;
import com.bhanu.travelsite.model.Car;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author charanbhanu4
 */
@WebServlet(name = "GetAllCars", urlPatterns = {"/GetAllCars"})
public class GetAllCars extends HttpServlet {
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
     {
         int page = 1;
        int recordsPerPage = 20;
        if (request.getParameter("page") != null)
            page = Integer.parseInt(
                request.getParameter("page"));
         CarRentalCompanyDao cd= new CarRentalCompanyDao();
        List<Car> cars=cd.getAllCarsPerPage((page - 1) * recordsPerPage,
            recordsPerPage);
        int noOfRecords = cd.getNoOfCars();
        int noOfPages = (int)Math.ceil(noOfRecords * 1.0
                                       / recordsPerPage);
        request.setAttribute("cars", cars);
        request.setAttribute("noOfPages", noOfPages);
        request.setAttribute("currentPage", page);
        RequestDispatcher rd
            = request.getRequestDispatcher("display.jsp");
        rd.forward(request, response);
        
    }
        
 }
