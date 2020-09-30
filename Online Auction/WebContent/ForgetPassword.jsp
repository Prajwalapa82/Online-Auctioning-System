<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password reset</title>
<link href="css/for.css"  rel="stylesheet" type="text/css">
</head>

<body>
<div>
<ul><br>
   <li><a href="index.jsp">Home</a></li>
    <li><a href="LoginForm.jsp">Login</a></li>
     <li><a href="Registerform.jsp">Register</a></li>
      <li><a href="help.jsp">Help</a></li>
</ul>
</div>
<form action="for" method="post">
<br><br><br><br>

<div id="h"><h1>RESET YOUR PASSWORD</h1></div>
<center>
<div>
<table>
  <tr>
  <td id="c">User Id</td>
 <div><td><input type="text" name="lid" value="" required="required"></td></div>
 </tr>
 <tr>
  <td id="c">Email</td>
  <div><td><input type="email" name="email" value="" required="required"></td></div>
  </tr>
  </table>
  </div>
  <input type="submit"  value="Reset" >
  </center>
</form>
</body>
</html>