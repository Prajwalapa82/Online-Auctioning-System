

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.DriverManager"%>
		<%@page import="java.sql.ResultSet"%>
		<%@page import="java.sql.Statement"%>
		<%@page import="java.sql.Connection"%>
		<%
					
	%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#buy {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  border-color: gray;
  list-style: outside;
}

#buy td, #buy th {
  border: 1px solid #ddd;
  padding: 8px;
  border-spacing: inherit;
  
}

#buy tr:nth-child(even){background-color:AliceBlue;}

#buy tr:hover {background-color: MintCream;}

#buy th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}
#buy thead{
  font-weight: bolder;
  background-color: threedshadow;
}
input[type=text]{
 border: 5px none #1C6EA4;
 background-color: transparent;
 width: 172px;
}
input[type=submit]{
 color:white;
  padding: 8px 12px;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: content-box;
   background-color: mediumseagreen;
}
#h{
 color: rgba(255,255,255,.3);
background: #1a1a1a;
text-shadow: 0 0 15px rgba(255,255,255,.5), 0 0 10px rgba(255,255,255,.5);
}
</style>
<body>
<div id="h"><h1>Buyer's Application</h1></div>
<form action="appr" method="post" >
		<table id="buy">
		<thead>
		<tr>
		<td>Login id</td>
		<td>First name</td>
		<td>Middle name</td>
		<td>Last name</td>
		<td>Email</td>
		<td>Contact number</td>
		<td>Action</td>
		</tr>
		</thead>
		<tbody>
			<%
		try{
			ResultSet resultSet=null;
			Connection con = null;
			PreparedStatement ps=null;
			String st="n";
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction","prajwal");
			String sql ="select loginid,pwd,fname,mname,lname,email,cno,ltype from buyerprofile where status=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,st);
			resultSet =ps.executeQuery(); 
		while(resultSet.next()){
		%>
		<tr>
		<td ><input type="text" name="lid" readonly="readonly" value='<%=resultSet.getString(1) %>'></td>
		<input type="hidden" name="pwd" value='<%=resultSet.getString(2) %>'>
		<td><input type="text" name="fname" readonly="readonly" value='<%=resultSet.getString(3) %>'></td>
		<td><input type="text" name="mname"readonly="readonly" value='<%=resultSet.getString(4) %>'></td>
		<td><input type="text" name="lname" readonly="readonly"value='<%=resultSet.getString(5) %>'></td>
		<td><input type="text" name="email"readonly="readonly" value='<%=resultSet.getString(6) %>'></td>
		<td><input type="text" name="cno" readonly="readonly"value='<%=resultSet.getString(7) %>'></td>
		<input type="hidden" name="ltype"readonly="readonly" value='<%=resultSet.getString(8) %>'>
		<td>
		 <input type="submit" name="submit" value="approve">
		</td>
		</tr>
		<%
		}
		} catch (Exception e) {
		e.printStackTrace();
		}
		%>
		</table>
		</form>
		<br><br><br>
		
  </body>
</html>