
<HTML>
	<HEAD>
		<TITLE>Login page </TITLE>
		<link href="css/login.css"  rel="stylesheet" type="text/css">   
        
</HEAD>

	<body>
	<header>
       <div class="head">
          <ul>
             <li><a href='index.jsp'>Home</a></li>
             <li><a href='Registerform.jsp'>Register</a></li>
             <li><a href='help.jsp'>Help</a></li>
         </ul><br><br><br><br>
         </div>
         <div class="tittle">
       <h1>Login</h1>
       <h2>Please enter correct USER Id and PASSWORD</h2>	
      </div>
      <!--  --<div class="image">
       <img  src="images/aa.jpg" >
      </div>-->	
	</header>
	<form action="loginAction.do" name ="login" onsubmit="return validate()">
	<center>
	<div class="table">
	  <p>User Name</p>
     	<div class="textbox1">
           <input type="text" name=username placeholder="**user id**">
        </div>
        <p>Password</p>
        <div class="textbox2">     
         <input type="password" name=password placeholder="**password**">
        </div>
        <div class="btn">
          <input type="submit" name=send value=Login>
         <div id="l"> <a href="ForgetPassword.jsp">Forget password</a>
      </div>
     </div>
     </center>
     </form>
     <%if(request.getParameter("status")!=null) {%>
				<font color="white"><b>  <%=request.getParameter("status") %></b></font>
				<%} %>
				  <script language="JavaScript" type="text/javascript">
//You should create the validator only after the definition of the HTML form
  var frmvalidator  = new Validator("login");
  
 
  frmvalidator.addValidation("username","req","Please enter your User Name");
  
  frmvalidator.addValidation("password","req","Please enter your Password");
  </script>