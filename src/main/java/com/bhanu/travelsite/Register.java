/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.bhanu.travelsite;

import com.bhanu.dao.loginDao;
import com.bhanu.travelsite.model.loginmodel;
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
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String u=request.getParameter("username");
        String p=request.getParameter("password1");
        loginmodel lm=new loginmodel();
        lm.setUserName(u);
        lm.setPassword(p);
        loginDao dao=new loginDao();
        boolean newUserCreated=dao.add(lm);
        if(newUserCreated)
        response.getWriter().println("login created successfully");
        else
        response.getWriter().println("username already exists please try a new one");
        
    }


}
