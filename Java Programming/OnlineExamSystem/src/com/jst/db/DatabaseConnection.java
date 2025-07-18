package com.jst.db;

import java.security.SecureRandom;
import java.sql.*;
import java.util.Random;

import com.jst.utlity.OnlineConstant;

public class DatabaseConnection {
	static Connection con;

	public static Connection getConnection() throws Exception {
		Class.forName(OnlineConstant.DRIVER_NAME);
		return DriverManager.getConnection(OnlineConstant.DB_URL, OnlineConstant.USER_NAME, OnlineConstant.PASSWORD);
	}

	public static ResultSet getResultFromSqlQuery(String sqlQueryString) {
		ResultSet rs = null;
		try {
			con = getConnection();
			rs = con.createStatement().executeQuery(sqlQueryString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return rs;
	}

	public static int insertUpdateFromSqlQuery(String sqlQueryString) {
		int result=0;
		try {
			if (con == null) {
				getConnection();
			}
			result=con.createStatement().executeUpdate(sqlQueryString);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static String randompasswordgeneration() {
		Random random = new SecureRandom();
		final int PASSWORD_LENGTH = 10;
		
		String password = "";
		for (int i = 0; i < PASSWORD_LENGTH; i++) {
			int index = (int) (random.nextDouble() * OnlineConstant.LETTERS.length());
			password += OnlineConstant.LETTERS.substring(index, index + 1);
		}
		return password;
	}
}
