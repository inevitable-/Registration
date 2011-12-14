package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import schema.DB;
import model.*;

import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class AuthenticationController
 */
@WebServlet("/AuthenticationController")
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String username;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		DB connect = new DB();
		RegistrationModel hash = new RegistrationModel();
		Connection query = connect.db();
		AuthenticationModel get = new AuthenticationModel();
		ResultSet rs = null;
		ProfileModel get2 = new ProfileModel();
		
		 boolean login= false;
		 username= request.getParameter("username");
		 String password = hash.md5(request.getParameter("password"));
	
		try {
			if(username!="" && password!=""){
				Statement ps = query.createStatement();
			    rs=ps.executeQuery(get.query(username,password));
			    login=rs.next();			
			}
			
			else if(username =="" || password ==""){
				out.println("Please don't leave a blank.");
			}
			
			
			
		} catch (SQLException e) {
			out.println("Query Error");
		}
		
		
		if (login) {
		    request.getSession().setAttribute("usernames", username);
		    rs = DB.query("select * from user where username = '" + username + "'");
		    try {
				while(rs.next()){
					request.getSession().setAttribute("user_id", rs.getString("user_id"));
				}
			} catch (Exception e) {}
		    response.sendRedirect("views/index.jsp"); 
		    
		} else {
			out.println("Invalid username/password Try again");
		    response.sendRedirect("views/loginerror.jsp");
		}

	
           
	}
	
	public String storeInfo(){
		String usernames = username;
		return usernames;
	}
	

}
