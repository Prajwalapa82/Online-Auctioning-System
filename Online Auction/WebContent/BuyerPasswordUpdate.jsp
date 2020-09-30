<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Update</title>
</head>
<style>
input[type=text], select {
  padding: 12px 20px;
  margin: 8px ;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  }
  input[type=password], select {
  padding: 12px 20px;
  margin: 8px ;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  }
   input[type=submit], select {
  color:white;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
   background-color: mediumseagreen;
}
input[type=submit]:hover{
  background-color: blue;
 }
 label{
 color:navy;
  font-family: Gabriola;
  font-weight: bold;
 }
 #h
 {
  color:green;
  font-family: Gabriola;
  font-weight: bold;
  font-size: x-large;
 }
 
</style>

<body>
<jsp:include page="BuyerOption.jsp"></jsp:include>
<br><br>
<form action="upw" method="post">
<br><br><br><br>
<br><br><br><br>
<br><br><br><br>
<center>
 <div id="h"><h1>Updadte password</h1></div>
  <div>
  <label>User id</label>
  <div><input type="text" readonly="readonly" name="lid" value="<%=(String)session.getAttribute("user") %>"></div>
  <label>Old Password </label>
<div><input type="password" name="opassword"></div>
<label>New password </label>
<div><input type="password" name="newpwd"></div>
<label>Re-renter your password</label>
<div><input type="password" name="cnpwd"></div>
      <br>
      <input type="submit" value="Submit">
  </div>
  </center>
  </form>
</body>
</html>