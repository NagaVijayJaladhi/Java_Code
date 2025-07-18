package com.jst;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

	private static final String JDBC_USER_NAME = "root";
	private static final String JDBC_PASSWORD = "";
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
	
	private static final String CREATE_USERS_SQL = "CREATE TABLE USERS (ID VARCHAR(10), NAME VARCHAR(100), EMAIL VARCHAR(30), MOBILE VARCHAR(12), CITY VARCHAR(100));";
	private static final String INSERT_USERS_SQL = "INSERT INTO USERS (ID, NAME, EMAIL, MOBILE, CITY) VALUES (?, ?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "SELECT ID,NAME,EMAIL,MOBILE,CITY FROM USERS WHERE ID =?";
	private static final String SELECT_ALL_USERS = "SELECT * FROM USERS;";
	private static final String DELETE_USERS_SQL = "DELETE FROM USERS WHERE ID = ?;";
	private static final String UPDATE_USERS_SQL = "UPDATE USERS SET NAME = ?, EMAIL= ?, MOBILE=?, CITY =? WHERE ID = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void checkTableExists() {
		try {
			DatabaseMetaData dbmd = getConnection().getMetaData();
			ResultSet rs = dbmd.getTables(null, null, "USERS", null);
			if(rs.next()) {
				System.out.println("Users Table Exits");
			} else {
				Statement st = getConnection().createStatement();
				st.executeUpdate(CREATE_USERS_SQL);
				System.out.println("Users Table Created Successfully.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getMobile());
			preparedStatement.setString(5, user.getCity());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public User selectUser(String id) {
		User user = null;
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setString(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String city = rs.getString("city");
				user = new User(id, name, email, mobile, city);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String city = rs.getString("city");
				User user = new User(id, name, email, mobile, city);
				users.add(user);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(String id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setString(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getName());
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getMobile());
			statement.setString(4, user.getCity());
			statement.setString(5, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
}
