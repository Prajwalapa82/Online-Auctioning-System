
<%@page import="com.dts.core.util.CoreList"%>
<%@page import="java.util.Enumeration"%>
<%@page import="com.dts.project.dao.CategoryDAO"%>
<%@page import="com.dts.project.model.CategoryModel"%>
<HTML>
	<HEAD>
	    <link  href="css/item.css" rel="stylesheet" type="text/css">
		<TITLE>Online Auctioning </TITLE>
	    
</HEAD>
	<body background="white">
	<jsp:include page="Selleroption.jsp"></jsp:include>
		<div class="table">
		<center><h1>Add Your item</h1></center>
		<br><br>
			<form action="ireg" method="post">
			<center>
			<label>Item name</label>
			<div><input type="text" name="iname" required="required"/></div>
			<label>Item Description</label>
			<div><input type="text" name="idsc" required="required"/></div>
			<label>Category</label>
			<div><select name="category">
			<option value="">select</option>
			<option>Electronic</option>
			<option>Tech.</option>
			<option>Fashion</option>
			<option>Style</option>
			<option>House</option>
			<option>Furniture</option>
			<option>Vechile</option>
			<option>Art</option>
			</select></div>
			<label>Starting Price</label>
			<div><input type="text" name="isr" required="required"/></div>
			<label>Bid Increment price</label>
			<div><input type="text" name="icr" required="required"/></div>
			<label><img  id="blah" alt="plaese upload item pic" width="120" height="120"  /></label>
			<div><input type="file" name="image" accept="image/*" onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])"></div>
			<br><br>
			<div><input type="submit" name="submit" value="Add"></div>
			<div><input type="hidden"  name="loginid" hidden="" value="<%=(String)session.getAttribute("user") %>"/></div>
			</center>
			</div>
			</form>	
	</body>
</HTML>
