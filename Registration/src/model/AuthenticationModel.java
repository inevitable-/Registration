package model;

import controller.AuthenticationController;

public class AuthenticationModel {
	AuthenticationController query = new AuthenticationController();
	
	public String query(String usernames , String passwords){	
			
		String query="select `username`,`password`" +
				" from user where username='"+usernames+"' and " +
				"password='"+passwords+"' ";
		
		return query;
		
	}
	
}
