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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author charanbhanu4
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {


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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String u=request.getParameter("username");
        String p=request.getParameter("password");
        loginmodel lm=new loginmodel();
        lm.setUserName(u);
        lm.setPassword(p);
        loginDao dao=new loginDao();
        Object l[]=dao.check(lm);
        HttpSession session=request.getSession();
            if((boolean)l[0])
            {
                if(u.equals("charan.bhanu4@gmail.com"))
                {
                    session.setAttribute("username",u);
                    response.sendRedirect("welcomeAdmin.jsp");
                }
                else
                {
                    session.setAttribute("username",u);
                    session.setAttribute("password",p);
                    session.setAttribute("firstName",l[1]);
                    session.setAttribute("lastName",l[2]);
                    session.setAttribute("dateOfBirth", l[3]);
                    response.sendRedirect("welcome.jsp");
                }
            }
            else
            {
                response.getWriter().print("wrong password and username");
                
            }
    }
    
}

 

