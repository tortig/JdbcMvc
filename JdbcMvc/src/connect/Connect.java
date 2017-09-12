package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
	final static String DATABASE_URL = "jdbc:mysql://localhost/univ";
	private static Connection con = null;
	
	public static Connection connectDB(){
		try{
			con = DriverManager.getConnection(DATABASE_URL,"root","admin");
		} catch(SQLException e){
			e.printStackTrace();
		}
		return con;
		
	}
}
