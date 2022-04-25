package kmitl.covid.lib.methods.connectivity;

import kmitl.covid.lib.korn.kornutil.KornEncryption;

import java.sql.Connection;
import java.sql.DriverManager;

public class CVDB {
	public static Connection getConnection(String username, String password) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
				"jdbc:mysql://171.6.148.38/covid_desktop_application",
				username,
				password
			);
		} catch (Exception e) {
			System.out.println("ERROR: Unable to connect to database (" + e.getMessage() + ")");
		}
		return connection;
	}
	public static Connection getDB() {
		return CVDB.getConnection(
			KornEncryption.getUsername(),
			KornEncryption.getPassword()
		);
	}
}
