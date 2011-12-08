package schema;

import java.sql.*;



public class DB {

public Connection db(){
	Connection con= null;
	
	String connectionURL = "jdbc:mysql://localhost:3306/registration"; 

	try{
	Class.forName("com.mysql.jdbc.Driver").newInstance(); 
	con=  DriverManager.getConnection(connectionURL,"root", "");
	} catch(Exception ex){
		
	
	}
	
	return con;

}
}
 
