package model;


public class ProfileModel {
	

	  
		public String profileInfo(String username){
	
			String query="select * from `user` where username='"+username+"'";
			
			return query;		
			
		}
		
		public String editInfo(String usernames , String passwords , String names 
				, String middle_names , String lastnames , String emails, String gender,
				String currentUser){
			String query="UPDATE `user`" +
					" SET `username` ='"+usernames+"' ,`password` ='"+passwords+"',`first_name` ='"+ names+"'," +
					"`middle_name` ='"+middle_names+"',`last_name` ='"+lastnames+"',`email` ='"+emails+"' , " +
					"`gender` ='"+gender+"'"+
					" WHERE `username` ='"+currentUser+"'";
			return query;
			
		}
		
	  public String insertPost(String message,String created,
			  int user_id){
		  String query="INSERT INTO `post`" +
			" (`message`,`created`,`user_id`)" +
			" VALUES ('"+message+"', '"+created+"', "+user_id+")";
		  
		return query;
		  
	  }
	  
	  public String profileId(String username){
		  String query="select user_id from `user` where username='"+username+"'";
		  return query;
	  }
	 

}
