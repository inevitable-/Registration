package controller;


import java.io.*;

import java.util.*;

import java.sql.*;

import javax.servlet.*;

import schema.DB;
import model.ProfileModel;
import model.RegistrationModel;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.netbeans.modules.web.monitor.data.Constants.Http;

@WebServlet("/ProfileController")

public class ProfileController extends HttpServlet{



		private ServletConfig config;

		String page="/views/profile.jsp";
		String currentUser;
		int id;

  		public void init(ServletConfig config)

  		throws ServletException{

  			this.config=config;

  		}

  			public void doGet(HttpServletRequest request, HttpServletResponse response)

  			throws ServletException,IOException
  		{
  			
  				DB con = new DB();
  				ProfileModel query = new ProfileModel();
  				Connection connection= con.db();
  				ResultSet rs;
  				HttpSession session = request.getSession(true);
  				currentUser= (String) session.getAttribute("usernames");
  				response.setContentType("text/html");
                
  				List dataList= new ArrayList(); 

  				
  				
  				try {

  					Statement s = connection.createStatement();
 
  					s.executeQuery (query.profileInfo(currentUser));

  					rs = s.getResultSet();

  					while (rs.next ()){

  						dataList.add(rs.getString("first_name"));
  						dataList.add(rs.getString("middle_name"));
  						dataList.add(rs.getString("last_name"));
  						dataList.add(rs.getString("email"));
  						dataList.add(rs.getString("gender"));

  					}

  					rs.close ();

  					s.close ();

  				}catch(Exception e){

  					System.out.println("Exception is ;"+e);

  				}

  				request.setAttribute("data",dataList);


  				RequestDispatcher dispatcher = request.getRequestDispatcher(page);

  				if (dispatcher != null){

  					dispatcher.forward(request, response);

  				} 

  	}
  		
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  			  
  				RegistrationModel hash = new RegistrationModel();
  				HttpSession session = request.getSession(true);
  				String message = request.getParameter("post");
  				String date = model.GetDateNow.date();
  				String username = request.getParameter("username");
  				String password = hash.md5(request.getParameter("password"));
  				String firstname = request.getParameter("first_name");
  				String middlename = request.getParameter("middle_name");
  				String lastname = request.getParameter("last_name");
  				String email = request.getParameter("email");
  				String gender = request.getParameter("gender");
  				PrintWriter out = response.getWriter();
  				int updateQuery = 0;
  				DB con = new DB();
  				ProfileModel query = new ProfileModel();
  				Connection connection= con.db();
  				ResultSet rs;
  				Statement s;
  				
			
				try {
					s = connection.createStatement();
					rs =s.executeQuery(query.profileId(currentUser));
					while(rs.next()){
						id = rs.getInt("user_id");
						
					}
					s.executeUpdate (query.insertPost(message, date, id));
					
					if(!username.equals("") && !password.equals("") && !firstname.equals("") &&
							!middlename.equals("") && !lastname.equals("") && !email.equals("")
							&& !gender.equals("")){
					updateQuery=s.executeUpdate(query.editInfo(username, password, firstname, 
							middlename, lastname, email, gender, currentUser));
					
					session.setAttribute("usernames",username);
					response.sendRedirect("views/successEdit.jsp");
					}
					
					if(updateQuery==0){
						response.sendRedirect("views/errorUpdate.jsp");
					}
				} catch (SQLException e) {
					out.println("Error");
				}
  				 
				
  			
  			}

}