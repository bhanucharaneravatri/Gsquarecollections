<%-- 
    Document   : login
    Created on : Mar 11, 2023, 10:09:41 AM
    Author     : charanbhanu4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="style.css"/>
        
</head>
    <body>
                <form action="login" method="post" >
            <table border = "0">
                <tr align="left" valign="top">
                    <td>User Name:</td>
                    <td><input type="text" name ="username" class="inputbox"/></td>
                </tr>
                <tr align="left" valign="top">
                    <td>Password:</td>
                    <td><input type="password" name ="password" class="inputbox"/></td>
                </tr>
                <tr align="left" valign="top">
                    <td></td>
                    <td><input type="submit" name="submit" 
                               value="login" class="btn btn-primary"/></td>
                </tr>
            </table>
        </form>
        <a href="Register.jsp">New User?</a>
    </body>
    
    
        
        
</html>
