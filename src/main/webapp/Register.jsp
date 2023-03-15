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
                    <td>User Name:</td>
                    <td><input type="text" name="username" placeholder="Enter User Name"/></td>
                </tr>
                <tr align="left" valign="top">
                    <td>Password:</td>
                    <td><input type="text" name="password1" placeholder="Enter Password"/> </td>
                </tr>
                <tr align="left" valign="top">
                    <td>ReEnter Password:</td>
                    <td><input type="text" name="password2" placeholder="Enter Password"/> </td>
                </tr>
                <tr align="left" valign="top">
                    <td></td>
                    <td><input type="submit" name="submit" 
                               value="Register" class="submitButton"/></td>
                </tr>
            </table>
           
        </form>
                <a href="login.jsp">Already Registered?</a>

    </body>
</html>
