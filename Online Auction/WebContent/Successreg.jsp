<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style type="text/css">
  #message{
	text-align: center;
	color:blue;
	font-size:25px;
	font-family: Times New Roman;
	font-variant: inherit;
	font-weight: 900;
	font-size-adjust: inherit;
	font-stretch: extra-condensed;
	font: italic; 
  }
</style>
<body> 
   <jsp:include page="Registerform.jsp"></jsp:include>
   <center>
 <span id="message"><p>Your aplication has successfully submitted you can login after Admin will approve </p>
   </center>
</body>
</html>