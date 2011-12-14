<%@page language="java" import="java.util.*" %>
<html>
	<head>
		<title>Data Page</title>
		</head>
	<body> 
		<table border="1" align="center" width="303">
	<tr>
		<td width="119"><b>FirstName</b></td>
		<td width="168"><b>MiddleName</b></td>
		<td width="168"><b>LastName</b></td>
		<td width="168"><b>Email</b></td>
		<td width="168"><b>Gender</b></td>
	</tr>
	
		<%Iterator itr;%>
		<% List data= (List)request.getAttribute("data");
		for (itr=data.iterator(); itr.hasNext(); )
	{
		%>
		<tr>
				<td width="119"><%=itr.next()%></td>
				<td width="168"><%=itr.next()%></td>
				<td width="168"><%=itr.next()%></td>
				<td width="168"><%=itr.next()%></td>
				<td width="168"><%=itr.next()%></td>
			</tr>
		<%}%>
		<tr>
	<td> <a href = "views/editProfile.jsp"> Edit Profile </a> </td>
	</tr>
		
	</table>
 		<div id="post" align ="center">
               <br/><br/>
             <form action="ProfileController" method="post">
             <table> 
             <tr> 
             <td> <textarea name="post" rows="3" cols="50">
                </textarea>
                </td>
                <td><input type="submit" name="button" value="Post"/></td>
                </tr>
                </table>
                </form>
            </div>
            
            
            

				<a href ="views/index.jsp"> Back to home </a>
	</body>
</html>