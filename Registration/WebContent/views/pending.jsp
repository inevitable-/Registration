<%@page import="model.User" %>
<%@page import="java.sql.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<% 
	String keyword = request.getParameter("q");
	ResultSet users = User.showPending((String)session.getAttribute("user_id"));
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
				<%
					ResultSet user = User.describeUser(users.getString("user_id"));
				%>
					<% while(user.next()){ %>
					<div class="result">
						<form action="" method="post">
							<h2><%= user.getString("username") %></h2>
							<input type="hidden" value="<%= user.getString("user_id")%>" name="user_id" />
							<input type="submit" value ="Accept Friend Request">
						</form>
					</div>
					<% } %>
				<% } %>
			</div>
			<div id="footer">
			
			</div>
		</div>
</body>
</html>