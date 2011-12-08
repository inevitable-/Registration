<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" media="all" href="../styles/base.css" />
    </head>
    <body>
        <div id="header">
            <div id="header-container">
                <%@include  file="../defaults/navigation.html"%>
            </div>
        </div>
        <div id="container" class="shadow">
            <div id="content">
                <div id="user-navigation">
                   
                    <% 
                    if(session.getAttribute("usernames")!=null && 
                       session.getAttribute("passwords")!=null)
                    { 
                    	out.println(String.format("Welcome %s", session.getAttribute("usernames"))); 
                    	%> <a href="logout.jsp">Logout</a> <% 
                       
                    }else if(session.getAttribute("usernames")==null && 
                            session.getAttribute("passwords")==null){ %>
                    <a href="login.jsp">Login</a> or <a href="Registration.jsp">Sign up</a>                    
                    <% } %>
                </div>
            </div>
            <div id="footer"></div>
        </div>
    </body>
</html>
