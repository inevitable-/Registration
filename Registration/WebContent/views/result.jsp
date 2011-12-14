<%@page import="model.User" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	String keyword = request.getParameter("q");
	ResultSet users = User.searchUser(keyword, (String)session.getAttribute("user_id"));
	int counter = 0;
	
	if(request.getParameter("friend_id") != null){
		String friend_id = request.getParameter("friend_id");
		String user_id = (String)session.getAttribute("user_id");
		
		User.addFriend(friend_id, user_id);
		out.println("Friend add successful");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
			<div id="header">
				
			</div>
			<div id="content">
				<% while(users.next()){ %>
					<div class="result">
						<form action="" method="post">
							<h2><%= users.getString("username") %></h2>
							<input type="hidden" value="<%= users.getString("user_id")%>" name="friend_id" />
							<input type="submit" value ="Add as a Friend">
						</form>
					</div>
				<% } %>
			</div>
			<div id="footer">
			
			</div>
		</div>
</body>
</html>