<%@page import="com.auction.profile.update.UpdateProfileBuyer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My profile</title>
</head>
<body>

<%@page import="com.dts.dae.model.Profile"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page  import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<HTML>
	<HEAD>
		<TITLE>Online Auctioning </TITLE>
	    <style type="text/css">
input[type=text], select {
  padding: 12px 20px;
  margin: 8px ;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  }
  input[type=tel], select {
  padding: 12px 20px;
  margin: 8px ;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
   }
   input[type=email], select {
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
 #d{
  color:navy;
  font-family: Gabriola;
  font-weight: bold;
 }
 #h{
  color:green;
  font-family: Gabriola;
  font-weight: bold;
  font-size: x-large;
 }
        </style>
</HEAD> 
	<BODY >
	<jsp:include page="BuyerOption.jsp"></jsp:include>
	<center>
	
	<div id="h"><br><br><br><br><h1>Update Profile</h1></div>
     <%
     String loginid=(String)session.getAttribute("user");
     Profile pf=new UpdateProfileBuyer().getProfile(loginid);
%>

   <form action="upb" method="post">
   <table>
   <tr>
   <td><div id="d">Login id:</td><td><input type="text" name="lid" required="required" value='<%=pf.getLoginid()%>'></td></div>
   </tr>
   <tr>
   <td> <div id="d">First name:</td><td><input type="text" name="fname" required="required" value='<%=pf.getFirstname()%>'></td></div>
     </tr>
     <tr>
     <td><div id="d">Middle name:</td><td><input type="text" name="mname"required="required" value='<%=pf.getMiddlename()%>'></td></div>
      </tr>
      <tr>
      <td><div id="d">Last name:</td><td><input type="text" name="lname"required="required" value='<%=pf.getLastname()%>'></td></div>
      </tr>
      <tr>
        <td><div id="d">contact number:</td><td><input type="tel" name="cno"required="required"required="required" value='<%=pf.getPhoneNo()%>'></td></div>
       </tr>
       <tr>
       <td><div id="d">email:</td><td><input type="email" name="email"required="required" value='<%=pf.getEmail()%>'  > </td>  </div>
      </tr>
       <tr>
       <td><div id="d">address:</td><td><input type="email" name="addr"required="required" value='<%=pf.getAddress()%>'  > </td>  </div>
      </tr>
       <tr>
       <td><div id="d">city:</td><td><input type="email" name="city"required="required" value='<%=pf.getCity()%>'  > </td>  </div>
      </tr>
       <tr>
       <td><div id="d">pincode:</td><td><input type="email" name="pinc" value='<%=pf.getPincode()%>'  > </td>  </div>
      </tr>
       <tr>
       <td><div id="d">state:</td>
       <td><select name="state" required="required" >
                   <option><%=pf.getState() %></option>
                   <option value="">select</option>
                   <option> Andhra Pradesh</option>
                   <option>Assam</option>
                   <option>Gujarat</option>
                   <option>Haryana</option>
                   <option>Jharkhand </option>
                   <option>Karnataka</option>
                   <option>Kerala</option>
                   <option>Madhya Pradesh</option>
                   <option>Maharashtra </option>
                   <option>Meghalaya</option>
                   <option>Odisha</option>
                   <option>Punjab</option>
                   <option>Tamil Nadu</option>
                   <option>Telangana </option>
                   <option>Uttar Pradesh</option>
                   <option>West Bengal</option>
                   </select>
                </td>
      </tr>
      <tr>
      <td></td><div><td><input type="submit" value="submit"></div></td>
      </tr>
        </table>
   </form>
   </center>
	</BODY>
</HTML>

</body>
</html>