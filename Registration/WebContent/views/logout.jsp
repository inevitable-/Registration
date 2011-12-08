<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    request.getSession(true).invalidate();
    response.setHeader ( "Pragma", "no-cache");
    response.setDateHeader ( "Expires", 0);
    response.setHeader ( "Cache Remove", "no-cache");
    response.setHeader ( "Cache Remove", "no-store");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logged out</title>
</head>
<body>
<a href="login.jsp">Successfully Logout</a>
</body>
</html>