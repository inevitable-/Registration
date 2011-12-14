<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" media="all" href="../styles/login.css" />
    </head>
    <body>
        <div id="header">
                    <h1 class="title">A U D I O P H I L E</h1>
                    <font color="red">Invalid Username/Password</font>
        </div>
        <div id="container" class="shadow">
            <table id="middle">
                <tr>
                    <td>
            <div id="branding" class="box">
                <img src="../images/logo.png" alt="Audiophile" id="logo" />
            </div>
                    </td>
                    <td>
            <div id="content" class="box">
                <form action="../AuthenticationController" method="post">
                    <table>
                        <tr>
                            <td><input class="form" type="text" name="username" value="Username" /></td>
                        </tr>
                        <tr>
                            <td><input class="form" type="password" name="password" value="Password" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input class="form" id="UserLogin" type="submit" value="Log In" />
                            or <a href ="Registration.jsp">Sign Up</a>
                            </td>
                        </tr>
                    </table>
                </form>
            </div>
                    </td>
                </tr>
            </table>
        </div>
            <div id="footer"></div>
    </body>
</html>
