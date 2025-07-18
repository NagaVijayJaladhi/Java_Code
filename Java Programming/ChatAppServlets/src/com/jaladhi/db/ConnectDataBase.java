package com.jaladhi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDataBase {

	public static Connection getDataBaseConnection() {
		Connection connection = null;
		try {
			Class.forName(DataBaseSqlQueries.DATA_BASE_DRIVER_NAME);
			connection = DriverManager.getConnection(DataBaseSqlQueries.DATA_BASE_URL);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
