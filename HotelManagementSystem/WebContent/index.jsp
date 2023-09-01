<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link type="text/css" rel="stylesheet" href="css/index.css"/>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<div class ="wraper" align="center">
	
	<h1>Login Here</h1>
		<form  method="post" action="AdminLoginServlet" >
                        
                 <table >
                  <tr>
				<td>
				<input type="text" name="id" Placeholder="User Id" required="">
				</td>
			</tr>
                  <tr>
				<td>
				<input type="text" name="email" Placeholder="Email" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="password" name="password" Placeholder="Password" required="">
				</td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="Login"> 
				</td>
			</tr>
			
            </table>
            </form>			
	</div>
	<div>
            <%if(request.getAttribute("fail")!= null) {%>
						<p><font color="orange">${fail}</font></p>
					<%} %></div>
	 
</body>
</html>