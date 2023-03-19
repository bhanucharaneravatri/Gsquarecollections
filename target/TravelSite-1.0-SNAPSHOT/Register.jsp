<%-- 
    Document   : Register
    Created on : Mar 11, 2023, 1:23:07 PM
    Author     : charanbhanu4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
        <link rel="stylesheet" href="style.css"/>
        <script type="text/javascript">
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
        <form action="Register" method="post" onSubmit="return validate(this)">
            <table border = "0">
                <tr align="left" valign="top">
                    <td>first Name:</td>
                    <td><input type="text" name="firstName" placeholder="Enter first Name"/></td>
                </tr>
                <tr align="left" valign="top">
                    <td>Last Name:</td>
                    <td><input type="text" name="lastName" placeholder="Enter last Name"/></td>
                </tr>
                <tr align="left" valign="top">
                    <td>User Name:</td>
                    <td><input type="text" name="username" placeholder="Enter email id"/></td>
                </tr>
                <tr align="left" valign="top">
                    <td>Password:</td>
                    <td><input type="text" name="password1" placeholder="Enter Password"/> </td>
                </tr>
                <tr align="left" valign="top">
                    <td>ReEnter Password:</td>
                    <td><input type="text" name="password2" placeholder="Enter Password again"/> </td>
                </tr>
                
                <tr align="left" valign="top">
                    <td>Date of Birth:</td>
                    <td><input type="date" name="dateOfBirth"/> </td>
                </tr>
                <tr align="left" valign="top">
                    <td></td>
                    <td><input type="submit" value="Register" class="btn btn-primary"/></td>
                </tr>
            </table>
           
        </form>
                <a href="login.jsp">Already Registered?</a>

    </body>
</html>
