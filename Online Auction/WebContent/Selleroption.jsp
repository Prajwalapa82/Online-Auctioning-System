
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Seller page</title>
<link  href="css/seler.css" rel="stylesheet" type="text/css">
</head>
<body>
	   <ul><br>
           <li class="active"><a href='SellerHome.jsp'>Home</a></li>
            <li><a href='Item.jsp'>Item</a>
              <ul>
                 <li><a href="SellItem.jsp">Sell item</a></li> 
                 <li><a href="UpdateItem.jsp">Your item</a></li> 
                 <li><a href="UpdateItem.jsp">update item</a></li> 
                 <li><a href="DeleteItem.jsp">delete item</a></li>
              </ul>
           </li>
           <li><a href='#'>Auction</a>
                <ul>
                 <li><a href="AuctionItemsToday.jsp">Recent Auction </a></li> 
                 <li><a href="LastAuction.jsp">Finished Auction</a></li> 
                 <li><a href="#">ViewBid</a></li> 
                 <li><a href="#">view status</a></li>
                 <li><a href="Recipt.jsp">Deliver item</a></li>
                </ul>
           </li>
           <li><a href='SellerProfile.jsp'>Profile</a></li>
           <li><a href='SellerPasswordUpdate.jsp'>Security</a>
              <ul>
              <li><a href="SellerPasswordUpdate.jsp">Update password</a></li>
              </ul>
             </li>
           <li><a href='help.jsp'>Help</a></li>
           <li><a href="LogoutAction.jsp">Logout</a></li>   
           </ul>    
</body>
</html>