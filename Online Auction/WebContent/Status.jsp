<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="com.dts.project.dao.BidderDAO"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Status.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <%
 String target="Success.jsp?status=Item Assigned Failed";
  String itemname=request.getParameter("itemname");
int bidderid=Integer.parseInt(request.getParameter("bidderid"));
boolean flag=new BidderDAO().updatStatusDetails(itemname,bidderid);
if(flag)
{  
target="Success.jsp?status=Item Assigned Successfully";
}
RequestDispatcher rd=request.getRequestDispatcher(target);
rd.forward(request,response);
%>
  </body>
</html>
