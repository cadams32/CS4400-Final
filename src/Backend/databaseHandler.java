package Backend;

import java.sql.Connection;

public class databaseHandler {
	
	private Connection connection;
	
	public databaseHandler() {
		dataBaseConnection DBC = new dataBaseConnection();
		connection = DBC.createConnection();
	}
	
	public static void login(String username, String password) {
		try {
		
		} catch(Exception e) {
			
		}
	}
	

}
