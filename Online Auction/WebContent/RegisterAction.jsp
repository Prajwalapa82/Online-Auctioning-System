<%@ page language="java" pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.dts.dae.dao.ProfileDAO,com.dts.dae.model.Profile"%> 
<%
 	String path = request.getContextPath();
 String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>My JSP 'RegisterAction.jsp' starting page</title>

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
		<br>
		<%
			String target="Registerform.jsp?regs=Registration Failed"; 
				try{
				 Profile rb = new Profile();
				rb.setLoginid(request.getParameter("loginid"));
			    rb.setPassword(request.getParameter("password"));
		        rb.setFirstname(request.getParameter("firstname"));
		        rb.setMiddlename(request.getParameter("middlename"));
		        rb.setLastname(request.getParameter("lastname")); 
		        rb.setBdate(request.getParameter("bdate"));
		        rb.setGender(request.getParameter("gender"));
		        rb.setEmail(request.getParameter("email"));
		        rb.setPhoneNo(request.getParameter("phoneno"));
		        rb.setRegtype(request.getParameter("regtype"));
		        rb.setAddress(request.getParameter("address"));
		        rb.setCity(request.getParameter("city")); 
		        rb.setState(request.getParameter("state")); 
		        rb.setCountry(request.getParameter("country"));
		        rb.setPincode(request.getParameter("pincode"));
		        rb.setStatus(1); 
		        int questid=0; 
		        if(request.getParameter("ch")!=null) 
		        { 
		            //rb.setSecretQuestionID(questid); 
		            //rb.setOwnSecretQuestion(request.getParameter("ownquest")); 
		        } 
		        else 
		        { 
		            questid=Integer.parseInt(request.getParameter("squest")); 
		            //rb.setSecretQuestionID(questid); 
		            //rb.setOwnSecretQuestion("Not Mentioned"); 
		        } 
		        //rb.setSecretAnswer(request.getParameter("sanswer")); 
		        //rb.setLocale(request.getLocale().toString()); 
		        boolean flag=new ProfileDAO().registration(rb);
		        
		        if(flag) 
		           target = "LoginForm.jsp?ls=Registration Success"; 
		        else  
		            target = "Registerform.jsp?regs=Registration Failed"; 
		            }catch(Exception e){}
		        RequestDispatcher rd = request.getRequestDispatcher(target);
		        rd.forward(request,response);
		%>
	</body>
</html>
