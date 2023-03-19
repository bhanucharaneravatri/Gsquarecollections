<%-- 
    Document   : welcome
    Created on : Mar 12, 2023, 8:57:39 PM
    Author     : charanbhanu4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>Welcome Page</title>
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
    <h1>Welcome ${firstName} ${lastName}</h1>
    
    <form action="GetAllCars" method="get">
    <input type="submit" value="GetAllCars">
    </form>
    
    <form action="GetMatchingCars" method="get">
        
        <div><!-- comment -->
            Enter your budget<br>
            <input type="number" name="maxCostPerDay"placeholder="maxcostPerDay" min="0" max="50">
            <input type="number" name="minCostPerDay"placeholder="mincostPerDay" min="0" max="50">
        </div>
        <div>
            Booking period<br>
            start <input type = "date" name="startDate">  
            end <input type = "date" name="endDate" >  
        </div>
        
        <div>
            Get Matching Cars of Popular Brands<br>    
        Volkswagen<input type=checkbox  name="make"value="Volkswagen">
        Nissan<input type=checkbox  name="make"value="Nissan">
        Mitsubishi<input type=checkbox  name="make"value="Mitsubishi">
        Mercedes-Benz<input type=checkbox  name="make" value="Mercedes-Benz">
        Kia<input type=checkbox  name="make" value="Kia">
        Toyota<input type=checkbox  name="make" value="Toyota">
        Volvo<input type=checkbox  name="make" value="Volvo">
        Chevrolet<input type=checkbox  name="make" value="Chevrolet">
        Jeep<input type=checkbox  name="make" value="Jeep">
        GMC<input type=checkbox  name="make" value="GMC">
        Porsche<input type=checkbox  name="make" value="Porsche">
        Honda<input type=checkbox  name="make" value="Honda">
        </div>
        
        
        
        <div>
           Filter by Rental Group<br>    
        SUV<input type=checkbox value="SUV" name="RentalGroup">
        Sedan<input type=checkbox value="Sedan" name="RentalGroup">
        Hatchback<input type=checkbox value="Hatchback" name="RentalGroup">
        </div>
        
        
    <input type="submit" value="GetMatchingCars">
    </form>
    </body>
</html>
