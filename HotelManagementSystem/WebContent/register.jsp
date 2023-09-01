<%@page import = "java.util.Random" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link type="text/css" rel="stylesheet" href="css/register.css"/>
</head>
<body>
<%@ include file="menu.jsp" %>

		<% Random r = new Random();
		int x = r.nextInt(9000);
		String tid = "CUST-"+ x;
		%>
		<div class="wraper" align = "center">
		<h1>Customer Register</h1>
		<form action="CustomerRegistrationServlet" method="post">
			<table>
			<tr>
			
				<td> <input type = "hidden" value= "<%=tid%>" name = "cust_id" >
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="firstname" Placeholder="Firstname" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="lastname" Placeholder="Lastname" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="email" Placeholder="Email" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="number" name="mobile" Placeholder="Mobile" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="occupation" Placeholder="Occupation" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="address" Placeholder="Address" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input list="day" name="holiday" Placeholder="Holiday" required="">
				<datalist id="day">
  				<option value="1">
  				<option value="2">
  				<option value="3">
  				<option value="4">
  				<option value="5">
  				<option value="6">
  				<option value="7">
  				<option value="8">
  				<option value="9">
  				<option value="10">
  				<option value="11">
  				<option value="12">
  				<option value="13">
  				<option value="14">
  				<option value="15">
  				<option value="16">
  				<option value="17">
  				<option value="18">
  				<option value="19">
  				<option value="20">
				</datalist>
				</td>
			</tr>
			<tr>
				<td>
				<input list="room" name="roomtype" Placeholder="RoomType" required="">
				<datalist id="room">
  				<option value="Single Bedroom">
  				<option value="Double Bedroom">
  				<option value="Hallroom">
				</datalist>
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="Submit"> 
				</td>
			</tr>
		</table>
		</form>
		     
		</div>
		
		<div>
                    <%if(request.getAttribute("failuremsg") != null) {%>
                    	<p><font color="red">${failuremsg}</font> </p>
                    <%} %>
                    </div>
                    <div>
                    <%if(request.getAttribute("succcess") != null) {%>
                    	<p><font color=green>${succcess}</font> </p>
                    	<%} %>
                    	</div>
               
</body>
</html>