package controller;

import schema.DB;
import model.RegistrationModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request,
            HttpServletResponse response)
throws ServletException, IOException {
	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		DB connect = new DB();
		RegistrationModel hash = new RegistrationModel();
		Connection query = connect.db();
		ResultSet rs;
		RegistrationModel get = new RegistrationModel();
		
		
		String name =request.getParameter("first_name"); 
		String lastname=request.getParameter("last_name");
		String username= request.getParameter("username");
		String password = hash.md5(request.getParameter("password"));
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String middle_name=request.getParameter("middle_name");
		boolean validate;
	    int updateQuery;
		
		if(name != "" && lastname!="" &&username!="" && password !="" && 
				 gender !="" &&  middle_name!="" &&  email!="" ){
			
			try {
				
				Statement ps = query.createStatement();
			    rs=ps.executeQuery(get.validate(username));
			    validate=rs.next();
			    
			    if(validate){
			   response.sendRedirect("http://localhost/Registration/views/ValidateReg.jsp");
			    }
			    
			    else{
				ps = query.createStatement();
			   updateQuery=ps.executeUpdate(get.add(username, password, 
			      name, middle_name, lastname, email, gender));
			   
			
				 
           if(updateQuery!=0){
        	   out.println("<html><head></head>" +
        	   		"<body><a href='http://localhost/Registration/views/login.jsp'>" +
        	   		"Successfully added</a><body></html>");
           }
           
           else {
   			out.println("failed");
   		}
				ps.close();
				query.close();
	    }		
				
			} catch (SQLException e) {
				out.println(""+get.add(username, password, 
					      name, middle_name, lastname, email, gender));
				e.printStackTrace();
			}
		
	}
		else {
			response.sendRedirect("http://localhost/Registration/views/ValidateReg.jsp");
		}
		
	}
}
