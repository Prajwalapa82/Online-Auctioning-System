
<HTML>
	<HEAD>
		<TITLE>Registration page </TITLE>
       <link href="css/reg.css" rel="stylesheet" type="text/css">
</HEAD>

<body>
 <div class=head>
<ul><br>
   <li><a href='index.jsp'>Home</a></li>
   <li><a href='LoginForm.jsp'>Login</a></li>
   <li><a href='help.jsp'>Help</a></li>
</ul>
<br>
 <br>
   <h1>Registration Form</h1>
   <h2>Please Register to our familar</h2>
</div>
     <form action="reg" method="post" name="register" onSubmit="return validation()">
     <!--  --<form action="registerAction.do" method="post" name="register" onSubmit="return validate()" >-->                
    <center>
     <table>
     <br><br>
     <div class="h">Personal Details</div>
     <br><br>
         <span id="massage" style="color: red ;font-weight: bold"></span>
     <tr>
       <th><td>Login Id</td><td><input type="text" name="loginid" id="lid" value="" autocomplete="off" 
       pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Login Id must be contain One upper case, one lower case and one number" required="This Should be filled" style="width: 173px; "></td>
        <td style="width: 240px; "><h3 style="color:red">**Please Enter One Upercase,one lowecase and one number</h3></span></td>
       <tr>
     <tr>
       <th><td>Password</td><td><input type="password" name="password" id="pwd" value="" autocomplete="off" placeholder="password" required="This Should be filled" style="width: 173px; "
         pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}" title="Password most contain atleast one number,one Upercase and lowercase letter and  its contain min-8 and max-16 more character"></td>
        <td style="width: 240px; "><h4 style="color:red">**Please Enter One Upercase,one lowecase and one number</h4></span>
        </td>   
       <td>confirm pasword</td><td><input type="password" name="cpwd"  id="cpwd" value="" autocomplete="off"  placeholder="confirm password" required="This Should be filled" style="width: 173px;"></td></th><th></th>
         <td style="width: 240px; "></td>
      </tr>
     <tr>
       <th><td>First name</td><td><input type="text" name="firstname" placeholder="firstname" autocomplete="off" required="This Should be filled" style="width: 173px; "></td>
         <td style="width: 240px; "></td>
          <td>Middle name</td><td><input type="text" name="middlename" placeholder="middlename" autocomplete="off" style="width: 173px;"></td>
            <td style="width: 240px;"></td>
            <td>last name</td><td><input type="text" name="lastname" placeholder="lastname" autocomplete="off" required="This Should be filled" style="width: 173px;"></td>
             <td style="width: 240px; "></td>
     </tr>
     <tr>
      <th><td>DOB</td><th><input type="date" name="bdate"  id="dob" value="" autocomplete="off" style="width: 173px; " required="This Should be filled" min="1919-01-01" max="2000-12-31">
        <td style="width: 240px; ">
          </td>
      <td>Gender</td>
      <td>
         <input type="radio"name="gender" value="M" required="Please select gender">male
         <input type="radio"name="gender"value="F" required="Please select gender">female
      </td>
       <td style="width: 240px; "></td>
      <td>E-Mail</td>
      <td><input type="email" name="email" id="email" value="" autocomplete="off" style="width: 173px;"
      pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" ></td>
       <td style="width: 240px; "></td>
     </tr>
     <tr>
      <th><td>Contact number</td>
      <td><input type="tel" name="mobnumber"  id="cno" value="" autocomplete="off" required="This Should be filled" pattern=".{10,10}" title="Please Enter 10 digt number" style="width: 173px;">
     <td style="width: 240px; "></td>
      <td>Registration Type</td>
      <td>
      <select name="type" required="please select the type" id="type" >
          <option value="" >(Selcet)</option>
          <option >buyer</option>
          <option >seller</option>
      </select>
      </td>
     </tr>
    </table>
    <br><br>
    
    <table align="center" >
    <div class="h">Adress Details</div>
   <br><br>
     <tr>
      <th><td>Address</td><td><textarea rows="2" name="address" required="required"style="width: 173px;" required="This Should be filled"></textarea></td>
      <td>City</td><td><input type="text" name="city" style="width: 173px;" required="This Should be filled"></td>
      <td>Pincode</td><td><input type="text" name="pincode"style="width: 173px;" id="pin" required="This Should be filled" min="100000" max="999999"></td>
     </tr>
     <tr>
      <th><td>Country</td>
           <td> <input type="text" readonly="readonly" name="country" value="India">   </td>
                <td>State</td>
                <td>
                <select name="state" required="required">
                   <option value="">select</option>
                   <option> Andhra Pradesh</option>
                   <option>Assam</option>
                   <option>Gujarat</option>
                   <option>Haryana</option>
                   <option>Jharkhand </option>
                   <option>Karnataka</option>
                   <option>Kerala</option>
                   <option>Madhya Pradesh</option>
                   <option>Maharashtra </option>
                   <option>Meghalaya</option>
                   <option>Odisha</option>
                   <option>Punjab</option>
                   <option>Tamil Nadu</option>
                   <option>Telangana </option>
                   <option>Uttar Pradesh</option>
                   <option>West Bengal</option>
                   </select>
                </td>
                </tr>
                <div class="btn">
                     <tr align="right">
     <td style="width: 90px; height:90px; "><input name="Input" type="submit" value="Register">
     </td>
     </tr>
       </div>
     </table>
     </center>
	</form>
<script type="text/javascript"> 
  function validation(){
	  
	  var pwd=document.register.password.value;
	  var cpwd=document.register.cpwd.value;
	 
	  }
	  if (cpwd == pwd) {
		 return true;
	}
	  else{
		  alert("Password and confirmpassword should be mattched");
		  return false;
	  }
	 
  } 
</script>
</BODY>
</HTML>

