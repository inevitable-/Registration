package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationModel {

	public String add(String usernames , String passwords , String names 
			, String middle_names , String lastnames , String emails , String genders){
		String query="INSERT INTO `user`" +
				" (`username`,`password`,`first_name`,`middle_name`,`last_name`,`email`,`gender`)" +
				" VALUES ('"+usernames+"', '"+passwords+"', '"+names+"', '"+middle_names+"'" +
						", '"+lastnames+"', '"+emails+"', '"+genders+"')";
		return query;
		
	}
	
	public String validate(String usernames){
		
		String query="select `username`"+
				" from user where username='"+usernames+"'";
		
		return query;
	}
	
	public String md5(String password){
    	
    	 
        MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			
			e.printStackTrace();
		}
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();

        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<byteData.length;i++) {
    		String hex=Integer.toHexString(0xff & byteData[i]);
   	     	if(hex.length()==1) hexString.append('0');
   	     	hexString.append(hex);
    	}
    	
    	return hexString.toString();
	}
	
	public boolean validateEmail(String email){
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
		CharSequence inputStr = email; 
		boolean isValid = false;
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
		isValid = true;  
		}  
		return isValid;  
		}
	
	
}
