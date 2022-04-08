package lib.methods.connectivity;

import java.sql.Connection;
import java.sql.DriverManager;


public class CVDB {
	public static Connection getConnection(String username, String password, String database) {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://localhost/" + database,
				username,
				password
			);

		} catch (Exception e) {
			System.out.println("ERROR: Unable to connect to database (" + e.getMessage() + ")");
		}

		return connection;
	}
	public static Connection getDB() {
		return CVDB.getConnection("root", "", "covid_application_beta");
	}
}
