package model;

import java.sql.*;
import schema.DB;
public class User {
	
	public static ResultSet searchUser(String wildcard, String user_id){
		ResultSet rs = null;
		
		try{
			String query = "select * from user where username like '%"+wildcard+"%' and user_id != "+user_id+"";
			System.out.println(query);
			rs = DB.query(query);
		}catch(Exception e){}
	
		return rs;
		
	}

	public static void addFriend(String friend_id, String user_id){
		try{
			String query = String.format("insert into friend values (null, %s, %s);", friend_id, user_id);
			DB.addQuery(query);
		}catch(Exception e){}
	}
	
	public static ResultSet showPending(String user_id){
		ResultSet rs = null;
		
		try{
			String query = "select * from friend where friend_user_id = "+user_id;
			System.out.println(query);
			rs = DB.query(query);
		}catch(Exception e){}
	
		return rs;
	}
	
	public static ResultSet describeUser(String user_id){
		ResultSet rs = null;
		
		try{
			String query = "select * from user where user_id = "+user_id;
			System.out.println(query);
			rs = DB.query(query);
		}catch(Exception e){}
	
		return rs;
	}
//	public static void acceptFriend(){
//		
//	}
//	
//	public static void viewPending()(
//			
//	)
	
}
