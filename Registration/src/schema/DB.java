package schema;

import java.sql.*;



public class DB {
	private static Connection conn = null;
	private static String database = "registration";
	private static String username ="root";
	private static String password ="";
	private static String url = "jdbc:mysql://localhost:3306/registration"; 
	private static String driver = "com.mysql.jdbc.Driver";
	
	private static void connect(){
		try{
			Class.forName(driver).newInstance(); 
			conn =  DriverManager.getConnection(url,username, password);
			System.out.println("Successfully connected to the database");
		}catch(Exception e){}
	}
	
	public static ResultSet query(String query){
		ResultSet rs = null;
		System.out.println(query);
		try{
			connect();
			Statement stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("Succwessfully executed the query");
		}catch(Exception e){}
		return rs;
	}
	
	public static void addQuery(String query){
		
		System.out.println(query);
		try{
			connect();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.execute();
			System.out.println("Succwessfully executed the query");
		}catch(Exception e){}
	}
	
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
 
