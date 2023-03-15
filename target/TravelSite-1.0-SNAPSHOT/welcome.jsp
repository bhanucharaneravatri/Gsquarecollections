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
    <h1>Welcome</h1>
    ${username}
    <form action="GetAllCars" method="get">
    <input type="submit" value="GetAllCars">
    </form>
    
    <form action="GetMatchingCars" method="get">
        
        <div><!-- comment -->
            <input type="number" name="maxCostPerDay"placeholder="maxcostPerDay" min="0" max="50">
            <input type="number" name="minCostPerDay"placeholder="mincostPerDay" min="0" max="50">
        </div>
        <div>
            start <input type = "date" name="startDate">  
            end <input type = "date" name="endDate" >  
        </div>
        
        <div>
        VW<input type=checkbox  name="make"value="VW">
        benz<input type=checkbox  name="make"value="benz">
        maruti<input type=checkbox  name="make"value="maruti">
        tata<input type=checkbox  name="make" value="tata">
        bmw<input type=checkbox  name="make" value="bmw">
        audi<input type=checkbox  name="make" value="audi">
        </div>
        
        
        
        <div>
        luxury<input type=checkbox value="luxury" name="RentalGroup">
        sedan<input type=checkbox value="sedan" name="RentalGroup">
        mini<input type=checkbox value="mini" name="RentalGroup">
        </div>
        
        
    <input type="submit" value="GetMatchingCars">
    </form>
    </body>
</html>
