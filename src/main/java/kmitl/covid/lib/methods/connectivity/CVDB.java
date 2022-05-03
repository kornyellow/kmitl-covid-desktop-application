package kmitl.covid.lib.methods.connectivity;

import kmitl.covid.lib.korn.kornutil.KornEncryption;
import kmitl.covid.other.Config;

import java.sql.Connection;
import java.sql.DriverManager;

public class CVDB {
	public static Connection getConnection(String server, String username, String password) {
		if (CVDB.connection != null) return CVDB.connection;
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(
				"jdbc:mysql://" + server + "/covid_desktop_application",
				username,
				password
			);
		} catch (Exception e) {
			System.out.println("ERROR: Unable to connect to database (" + e.getMessage() + ")");
		}
		CVDB.connection = connection;
		return connection;
	}
	public static Connection getDB() {
		if (Config.isLocalhost) return CVDB.getConnection(
			"localhost",
			"root",
			""
		);
		return CVDB.getConnection(
			"171.6.144.227",
			KornEncryption.getUsername(),
			KornEncryption.getPassword()
		);
	}

	private static Connection connection;
}
