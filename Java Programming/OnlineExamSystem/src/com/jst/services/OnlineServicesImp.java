package com.jst.services;

import java.sql.Connection;
import java.sql.Statement;

import com.jst.db.DatabaseConnection;
import com.jst.model.Questions;

public class OnlineServicesImp implements OnlineService {
	
	public Connection connection;

	@Override
	public int addQuestion(Questions questions) {
		
		connection = DatabaseConnection.getConnection();
		Statement statement = connection.createStatement();
		int addQuestion = statement.executeUpdate();
		return addQuestion;
	}

}
