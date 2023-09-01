<%@page import="javax.swing.event.ListDataListener"%>
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

		<% Random r = new Random();
		int x = r.nextInt(900);
		int tid = x;
		%>
		<div class="wraper" align = "center">
		<h1>Student Register</h1>
		<form action="StudentRegistrationServlet" method="post">
			<table>
			<tr>
			
				<td> <input type = "hidden" value= "<%=tid%>" name = "stu_id" >
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
				<input type="text" name="address" Placeholder="Address" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input list="coursename" name="coursename" Placeholder="CourseName" required="">
				<datalist id="coursename">
  				<option value="MCA">
  				<option value="B.tech">
  				<option value="Diploma">
				</datalist>
				</td>
			</tr>
			<tr>
				<td>
				<input type="text" name="password" Placeholder="Password" required="">
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