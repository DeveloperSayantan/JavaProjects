
<link type="text/css" rel="stylesheet" href="css/menu.css"/>
                <%if(session.getAttribute("userEmail") != null){ %>
                
                    <div class="upper">
                    <nav>
                    <ul>
                    	<li class="index"><a href="dashboard.jsp" title="Home">Home</a></li>
                        <li class="about"><a href="CustomerRegistrationServlet" title="Register">Register</a></li>
                        <li class="about"><a href="#ViewRegisters" title="View Registers">View Registers</a></li>
                        <li class="about"><a href="#Advertisement" title="Advertisement">Advertisement</a></li>
                        <li class="about"><a href="#admin" title="My Account"><%=session.getAttribute("userEmail") %></a></li>
                        <li class="about"><a href="AdminLogoutServlet" title="Logout">Logout</a></li>
                    </ul>
                    </nav>
                    </div>
                <%}else{%>
                    <div class="upper">
                    <nav>
                    <ul>
                        <li class="index"><a href="index.jsp" title="Home">Home</a></li>
                        <li class="userlogin"><a href="index.jsp" title="Login">Login</a></li>
                        <li class="about"><a href="#Advertisement" title="Advertisement">Advertisement</a></li>
                        <li class=" contact"><a href="#contact" title="Contact">Contact</a></li>
                    </ul>
                    </nav>
                    </div>
                
                <%}%>