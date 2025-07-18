package com.jst;

import java.sql.SQLException;

public class UserController {

	public static void main(String[] args) {
		try {
			User user = new User("100", "Ravi", "ravi.v@gmail.com", "9091234567", "Delhi");
			UserDao dao = new UserDao();
			dao.checkTableExists();
			dao.insertUser(user);
			dao.selectAllUsers();
			dao.selectUser("100");
			dao.updateUser(user);
			dao.deleteUser("100");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
