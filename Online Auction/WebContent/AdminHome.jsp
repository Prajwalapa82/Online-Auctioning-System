<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADMIN HOME</title>
</head>
<style>
#wel{
text-align:center;
color: #A7DD3C;
background:transparent;
text-shadow: 2px 0 0px #800040, 3px 2px 0px rgba(77,0,38,0.5), 
3px 0 3px #FF002B, 5px 0 3px #800015, 6px 2px 3px rgba(77,0,13,0.5), 
6px 0 9px #FF5500, 8px 0 9px #802A00, 9px 2px 9px rgba(77,25,0,0.5), 
9px 0 18px #FFD500, 11px 0 18px #806A00, 12px 2px 18px rgba(77,66,0,0.5), 
12px 0 30px #D4FF00, 14px 0 30px #6A8000, 15px 2px 30px rgba(64,77,0,0.5), 15px 0 45px #80FF00,
 17px 0 45px #408000, 17px 2px 45px rgba(38,77,0,0.5);
}
</style>
<body>
<%
String id=(String)session.getAttribute("user");
%>
<jsp:include page="AdminOption.jsp"></jsp:include>
<center>
<marquee direction="left" >

<div id="wel"><h1> WEL-COME TO ADMIN HOME </h1></div>
</marquee>
<jsp:include page="PendingBuyer.jsp"></jsp:include>
<jsp:include page="PendingSeller.jsp"></jsp:include>
</center>
</body>
</html>