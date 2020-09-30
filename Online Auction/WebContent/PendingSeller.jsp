<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
#sell {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
  border-color: gray;
  list-style: outside;
}

#sell td, #buy th {
  border: 1px solid #ddd;
  padding: 8px;
  border-spacing: inherit;
  
}

#sell tr:nth-child(even){background-color:AliceBlue;}

#sell tr:hover {background-color: MintCream;}

#sell th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: center;
  background-color: #4CAF50;
  color: white;
}
#sell thead{
  font-weight: bolder;
  background-color: threedshadow;
}
</style>
<body>
 <div id="h"><h1>Seller's application</h1></div>
<form action="app" method="post" >
		<table id="sell">
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
			String sql ="select loginid,pwd,fname,mname,lname,email,cno,ltype from sellerprofile where status=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,st);
			resultSet =ps.executeQuery(); 
		while(resultSet.next()){
		%>
		<tr>
		<td ><input type="text" name="lid"  value='<%=resultSet.getString(1) %>'></td>
		<input type="hidden" name="pwd" value='<%=resultSet.getString(2) %>'>
		<td><input type="text" name="fname" value='<%=resultSet.getString(3) %>'></td>
		<td><input type="text" name="mname" value='<%=resultSet.getString(4) %>'></td>
		<td><input type="text" name="lname" value='<%=resultSet.getString(5) %>'></td>
		<td><input type="text" name="email" value='<%=resultSet.getString(6) %>'></td>
		<td><input type="text" name="cno" value='<%=resultSet.getString(7) %>'></td>
		<input type="hidden" name="ltype" value='<%=resultSet.getString(8) %>'>
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
</body>
</html>