<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.dts.dae.dao.ProfileDAO,com.dts.dae.model.Profile,com.dts.dae.dao.SecurityDAO"%> 
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Auction</title>
<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
</head>
<body>
<br>
		<%
			String target = "LoginForm.jsp?ls=Invalid username and password";
				try{
				 Profile  rb=new Profile();
				 String username = request.getParameter("username");
		         rb.setLoginid(username);
		         rb.setPassword(request.getParameter("password"));
		         
		         String role=new SecurityDAO().loginCheck(username,request.getParameter("password"));
		         if(role.equals("Admin"))
		         { 
		            target = "AdminHome.jsp?status=Welcome "+username;
		            session.setAttribute("user",username);
		            session.setAttribute("role",role);
		         } 
		         else if(role.equals("seller"))
		         {
		        	 target = "SellerHome.jsp?status=Welcome "+username;
			            session.setAttribute("user",username);
			            session.setAttribute("role",role);
		         } 
		         else if(role.equals("buyer"))
		         { 
		            target = "CustomerHome.jsp?status=Welcome "+username;
		            session.setAttribute("user",username);
		            session.setAttribute("role",role);
		         }  
		         else{
		        	 target = "LoginForm.jsp?ls=Invalid username and password";
		         }
				}
		         catch(Exception e){e.printStackTrace();
		         out.println("I have some error please login again");
	        	 %>
	        	 <jsp:include page="LoginForm.jsp"></jsp:include>
	        	 <%
		            } 
		        RequestDispatcher rd = request.getRequestDispatcher(target);
		        rd.forward(request,response);
		        %>
	</body>
</html>