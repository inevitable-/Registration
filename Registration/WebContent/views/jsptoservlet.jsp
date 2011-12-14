<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
	request.setAttribute("Company Name","Roseindia");
	request.setAttribute("Address","Rohini,Delhi");
	String strViewPage="../ProfileController";
	RequestDispatcher dispatcher = request.getRequestDispatcher(strViewPage);
	if (dispatcher != null){
	dispatcher.forward(request, response);
	} 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>