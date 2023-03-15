<%-- 
    Document   : videos
    Created on : Mar 11, 2023, 10:36:03 AM
    Author     : charanbhanu4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="links">
        <a href="aboutus.jsp">About us</a>
        </div>
        <form action="logout">
            <div class="btn-right">
            <input type="submit" value="logout" class="btn btn-primary">
            </div>
        </form>
         <%response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");//http 1.1
            response.setHeader("Pragma","no-cache");//http 1.0
            //response.setHeader("Expires",0);//proxies
            if(session.getAttribute("username")==null)
            {
            response.sendRedirect("login.jsp");
        }
            %>
            <iframe width="560" height="315" src="https://www.youtube.com/embed/WQfhSOPiEM8" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
            </body>
</html>
