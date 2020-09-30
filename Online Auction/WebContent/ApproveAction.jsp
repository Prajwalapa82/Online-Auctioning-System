<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.DriverManager"%>
		<%@page import="java.sql.ResultSet"%>
		<%@page import="java.sql.Statement"%>
		<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
String lid=request.getParameter("loginid");
ResultSet resultSet=null;
Connection con = null;
PreparedStatement ps=null;
String st="y";
try{
Class.forName("oracle.jdbc.driver.OracleDriver");
con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","eauction","prajwal");
String sql ="update buyerprofile set status=? where login id=?";
ps=con.prepareStatement(sql);
ps.setString(1,st);
ps.setString(2, lid);
int i=ps.executeUpdate();
if (i>0){
%>
<jsp:forward page="AdminHomep.jsp"></jsp:forward>
<%
}
} catch (Exception e) {
	e.printStackTrace();
	}

%>

</body>
</html>