<%-- 
    Document   : welcome
    Created on : Mar 11, 2023, 10:10:03 AM
    Author     : charanbhanu4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Page</title>
         <link rel="stylesheet" href="style.css"/>
    </head>
    <body>
        <div class="links">
        <a href="aboutus.jsp">About us</a>
        <a href="videos.jsp">Videos</a>
        </div>
        
        <form action="logout">
            <div class="btn-right">
            <input type="submit" value="logout" class="btn btn-primary">
            </div>
        </form>
        <%
            response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");//http 1.1
            response.setHeader("Pragma","no-cache");//http 1.0
            //response.setHeader("Expires",0);//proxies
            if(session.getAttribute("username")==null)
            {
            response.sendRedirect("login.jsp");
            }
            %>
        <h1>Welcome Admin</h1>
        
        <form action="GetAllCars" method="get">
        <input type="submit" value="GetAllCars">
        </form>
        
        <form action="FetchData" method="get">    
        <input type="submit" value="Add mock data">
        </form>
        <form action="addCar" method="get">
            <input type="text" name="make" placeholder="make">
            <br>
            <input type="text" name="model" placeholder="model">
            <br>
            <input type="text" name="registrationNumber" placeholder="registrationNumber">
            <br>
            <input type="text" name="rentalGroup" placeholder="rentalGroup">
            <br>
            <input type="number" name="costPerDay" placeholder="costPerDay" min="0" max="50">
            <br>
            <input type="submit" value="Add Car">
        </form>
        
        
    </body>
</html>
