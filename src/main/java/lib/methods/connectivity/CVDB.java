package lib.methods.connectivity;

import other.Config;

import java.sql.Connection;
import java.sql.DriverManager;


public class CVDB {
	public static Connection getConnection(String username, String password) {
		Connection connection = null;
		try {
			String server = "localhost/covid_application_beta";
			if (!Config.isLocalhostDatabase)
				server = "185.78.164.34/test";

			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(
				"jdbc:mysql://" + server,
				username,
				password
			);

		} catch (Exception e) {
			System.out.println("ERROR: Unable to connect to database (" + e.getMessage() + ")");
		}

		return connection;
	}
	public static Connection getDB() {
		if (Config.isLocalhostDatabase)
			return CVDB.getConnection("root", "");
		return CVDB.getConnection("tubtong_beta", "EaEPH40NJ9Mr");
	}
}
