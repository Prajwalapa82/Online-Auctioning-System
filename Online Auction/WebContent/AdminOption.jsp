<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link  href="css/adm.css" rel="stylesheet" type="text/css">
</head>
<body>
<ul ><br>
 <li><a href="AdminHome.jsp">Home</a></li>
 <li><a href="#">User</a>
      <ul>
      <li><a href="#">Seller</a>
         <ul>
          <li><a href="PendingSeller.jsp">Requests</a></li>
          <li><a href="Update.jsp">Update</a></li>
         </ul>
      </li>
      <li><a href="#">Buyer</a>
      <ul>
          <li><a href="PendingBuyer.jsp">Requests</a></li>
          <li><a href="Update.jsp">Update</a></li>
         </ul>
      </li>
      </ul>
 </li>
    <li><a>Auction</a>
    <ul>
    <li><a href="PendingItem.jsp">Requests</a></li>
    <li><a href="UpdateItem.jsp">Update</a></li>
    <li><a href="AdminAuctionItemsToday.jsp">View Auction</a></li>
    <li><a href="AdminAuctionItemsEndday.jsp">View Auction</a></li>
    </ul>
    </li>
    <li><a href='AdminProfile.jsp'>Profile</a></li>
     <li><a href='AdminPasswordUpdate.jsp'>Security</a>
              <ul>
              <li><a href="AdminPasswordUpdate.jsp">Update password</a></li>
              </ul>
             </li>
    <li><a href="LogoutAction.jsp">Logout</a></li>
</ul>
</body>
</html>