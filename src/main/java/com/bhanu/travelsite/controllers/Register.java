/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite.controllers;

import com.bhanu.travelsite.dao.loginDao;
import com.bhanu.travelsite.model.loginmodel;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author charanbhanu4
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String dateOfBirth=request.getParameter("dateOfBirth");
        String username=request.getParameter("username");
        String password=request.getParameter("password1");
        loginmodel lm=new loginmodel();
        DateTimeFormatter f = DateTimeFormatter.ofPattern( "uuuu-MM-dd" );
        lm.setFirstName(firstName);
        lm.setLastName(lastName);
        lm.setDateOfBirth(LocalDate.parse(dateOfBirth, f));
        lm.setUserName(username);
        lm.setPassword(password);
        loginDao dao=new loginDao();
        int r=dao.add(lm);
        String op;
        if(r==1)
            op="username already exists";
        else if(r==2)
            op="database error";
        else
            op="user added";
        response.getWriter().println(op);
        }
}
