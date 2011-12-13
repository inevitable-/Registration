
<%@ page import="schema.DB" %> 
<%@ page import="controller.RegistrationController" %>
 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" type="text/css" media="all" href="../styles/base.css" />
    </head>
    <body>
            <div id="header-container">
                 <%@include  file="../defaults/navigation.html"%>
            </div>
        <div id="container" class="shadow">
            <div id="content">
       
      
                <form action="../RegistrationController" method="post">
               
                <table>
                    <tr>
                        <td>Username</td>
                        <td><input type="text" name="username" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" /></td>
                    </tr>
                    
                     <tr>
                        <td>Re-Type Password</td>
                        <td><input type="password" name="retypepassword" /></td>
                    </tr>
                    
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="first_name" /></td>
                    </tr>
                      <tr>
                        <td>Middle Name</td>
                        <td><input type="text" name="middle_name" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="last_name" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="text" name="gender" /></td>
                    </tr>
                
                    <tr>
                        <td><input type="submit" value="Register" /></td>
                        <td><input type="reset" value="Clear" /></td>
                    </tr>
                </table>
                </form>
            </div>
            <div id="footer">
            
            </div>
        </div>
    </body>
</html>
 