package bigbox.util;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private static Connection connection;

	private DBUtil() {
	}

	public static synchronized Connection getConnection() throws SQLException {
		try {

			// set the db url, username, and password
			String url = "jdbc:mysql://localhost:3306/bigbox";
			String username = "root";
			String password = "sesame";

			// get and return connection
			connection = DriverManager.getConnection(url, username, password);
			return connection;
		} catch (SQLException e) {
			System.out.println(e);
			throw e;
		}
	}

	public static synchronized void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				System.out.println(e);
				;
			} finally {
				connection = null;
			}
		}
	}
}
