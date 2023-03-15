<%-- 
    Document   : display
    Created on : Mar 13, 2023, 9:52:13 PM
    Author     : charanbhanu4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>Display Page</title>
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
               
    <table border="1" cellpadding="5" cellspacing="5">
	<tr>
		<th>Make</th>
		<th>Model</th>
		<th>Rental Group</th>
		<th>Registration Number</th>
                <th>Cost Per Day</th>

	</tr>

	<c:forEach var="car" items="${cars}">
		<tr>
			<td>${car.getMake()}</td>
			<td>${car.getModel()}</td>
			<td>${car.getRentalGroup()}</td>
			<td>${car.getRegistrationNumber()}</td>
                        <td>${car.getCostPerDay()}</td>
		</tr>
	</c:forEach>

    </table>
        <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
	<td><a href="GetAllCars?page=${currentPage - 1}">Previous</a></td>
    </c:if> 
        
        <%--For displaying Page numbers. The when condition does not display
			a link for the current page--%>

<table border="1" cellpadding="5" cellspacing="5">
	<tr>
		<c:forEach begin="1" end="${noOfPages}" var="i">
			<c:choose>
				<c:when test="${currentPage eq i}">
					<td>${i}</td>
				</c:when>
				<c:otherwise>
					<td><a href="GetAllCars?page=${i}">${i}</a></td>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</tr>
</table>

<%--For displaying Next link --%>

<c:if test="${currentPage lt noOfPages}">
	<td><a href="GetAllCars?page=${currentPage + 1}">Next</a></td>
</c:if>
        
    
    
</body>
    
</html>


