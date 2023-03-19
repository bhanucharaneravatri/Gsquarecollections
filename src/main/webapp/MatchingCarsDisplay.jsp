<%-- 
    Document   : MatchingCarsDisplay
    Created on : Mar 18, 2023, 11:13:45 PM
    Author     : ebc
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html/json; charset=UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>Display Page</title>
        <style>
.myDIV {
  width: 100%;
  padding: 50px 0;
  text-align: center;
  background-color: lightblue;
  margin-top: 20px;
}
</style>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script>
            $(document).on("click", ".bookcar", function() {  // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            var params = {
            ID: $("#"+this.id+".ID").text(),
            Make: $("#"+this.id+".Make").text(),
            Model: $("#"+this.id+".Model").text(),
            RentalGroup: $("#"+this.id+".RentalGroup").text(),
            CostPerDay: $("#"+this.id+".CostPerDay").text(),
            RegistrationNumber: $("#"+this.id+".RegistrationNumber").text(),
            Drivinglicense:$("#"+this.id+".Drivinglicense").val(),
            StartDate:$("#"+this.id+".StartDate").val(),
            EndDate:$("#"+this.id+".EndDate").val()
            };
            var id=this.id;
        $.post("book",$.param(params), function(responseText) {// Execute Ajax POST request on URL of "someservlet" and execute the following function with Ajax response JSON...
        console.log(id);
        $("#"+id+".booked").text(responseText);
        });
    });
   function myFunction(s) {

var x = document.getElementById(s);
  if (x.style.display === "none") {
    x.style.display = "block";
  } else {
    x.style.display = "none";
  }
}
function validate(theForm){
  if(theForm.username.value.length===0){
  alert("UserId can't be blank");
  theForm.username.focus();
   return false;
  }else if(theForm.password1.value.length===0){
  alert("Password can't be blank");
  theForm.password1.focus();
  return false;
  }else if(theForm.password1.value.length<6){
  alert("Password length can't be less than 6 char");
  theForm.password1.focus();
  return false;
  }
}
        </script>
         
    </head>
    <body>
         
        <div class="links">
        <a href="aboutus.jsp">About us</a>
        <a href="welcome.jsp">Home</a>
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
                <th>ID</th>
		<th>Make</th>
		<th>Model</th>
		<th>Rental Group</th>
		<th>Registration Number</th>
                <th>Cost Per Day</th>
                <th>Book Car</th>
                <th>More Details</th>


	</tr>

	<c:forEach var="car" items="${cars}" varStatus="loop" >
	    <tr>
                <td><div id="${loop.count}" class="ID">${car.getCarId()}</div></td>
                <td><div id="${loop.count}" class="Make">${car.getMake()}</div></td>
                <td><div id="${loop.count}" class="Model">${car.getModel()}</div></td>
                <td><div id="${loop.count}" class="RentalGroup">${car.getRentalGroup()}</div></td>
                <td><div id="${loop.count}" class="RegistrationNumber">${car.getRegistrationNumber()}</div></td>
                <td><div id="${loop.count}" class="CostPerDay">${car.getCostPerDay()}</div></td>
                        <td>
                                <button onclick="myFunction('${loop.count}b')">Book car</button>
                                <div id="${loop.count}b"class="myDIV" style="display: none">
                                <input type="text" id="${loop.count}" class="Drivinglicense" placeholder="Driving License Number"/>
                                Enter Start Date<input type="date" id="${loop.count}" class="StartDate"/>
                                Enter End Date<input type="date" id="${loop.count}" class="EndDate"/>
                                <button id="${loop.count}" class="bookcar">submit</button>
                                </div>
                                <div id ="${loop.count}" class="booked"></div>
                                  
                        </td>
                        <td><a href="https://www.google.com/search?q=${car}">Get More Details</a></td>
                </tr>  
       </c:forEach>

    </table>
        <%--For displaying Previous link except for the 1st page --%>
    <c:if test="${currentPage != 1}">
	<td><a href="GetMatchingCars?page=${currentPage - 1}">Previous</a></td>
    </c:if> 
        
        <%--For displaying Page numbers. The when condition does not display
			a link for the current page--%>

<table border="1" cellpadding="5" cellspacing="5">
	<tr>
                        <c:forEach begin="${currentPage-8<=0?1:currentPage-8}" end="${currentPage+8>noOfPages?noOfPages:currentPage+8}" var="i"> 
                            <c:choose>
                                <c:when test="${currentPage eq i}">
                                        <td>${i}</td>
                                 </c:when>
                                <c:otherwise>
                                    <td><a href="GetMatchingCars?page=${i}">${i}</a></td>
                                </c:otherwise>
                            </c:choose>
			</c:forEach>
	</tr>
</table>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
	<td><a href="GetMatchingCars?page=${currentPage + 1}">Next</a></td>
</c:if>
           
</body>
    
</html>