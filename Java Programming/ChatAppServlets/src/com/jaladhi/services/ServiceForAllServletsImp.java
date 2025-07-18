package com.jaladhi.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.jaladhi.constants.ApplicationConstants;
import com.jaladhi.db.ConnectDataBase;
import com.jaladhi.db.DataBaseSqlQueries;
import com.jaladhi.entity.MemberDataStructure;
import com.jaladhi.util.EncryptionUtility;

public class ServiceForAllServletsImp implements ServiceForAllServlets {

	Connection connection = ConnectDataBase.getDataBaseConnection();

	@Override
	public boolean checkUserNameInMember(String toUsername, String fromUsername) {
		boolean toUsernameCorrect = false;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(DataBaseSqlQueries.GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME);
			preparedStatement.setString(1, toUsername);
			ResultSet resultSet = preparedStatement.executeQuery();
			toUsernameCorrect = resultSet.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return toUsernameCorrect;
	}

	@Override
	public void insertMessage(String toUsername, String fromUsername, String message) {
		try {
			int toCode = getCodeFromMemberByUserName(toUsername, fromUsername);
			int fromCode = getCodeFromMemberByUserName(toUsername, fromUsername);
			PreparedStatement preparedStatement = connection.prepareStatement(DataBaseSqlQueries.INSERT_MESSAGE,
					Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, generateCurrentDateTime());
			preparedStatement.setInt(2, fromCode);
			preparedStatement.setInt(3, toCode);
			preparedStatement.setString(4, message);
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			resultSet.next();
			long messageCode = resultSet.getLong(1);
			insertNotification(toCode, fromUsername, messageCode);
			resultSet.close();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertNotification(int toCode, String fromUsername, long messageCode) {
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DataBaseSqlQueries.INSERT_NOTIFICATION);
			preparedStatement.setString(1, generateCurrentDateTime());
			preparedStatement.setInt(2, toCode);
			preparedStatement.setLong(3, messageCode);
			preparedStatement.setString(4, ApplicationConstants.MESSAGE_NOTIFICATION);
			preparedStatement.executeUpdate();
			preparedStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int getCodeFromMemberByUserName(String toUsername, String fromUsername) {
		int getCode = 0;
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement(DataBaseSqlQueries.GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME);
			preparedStatement.setString(1, toUsername);
			ResultSet resultSet = preparedStatement.executeQuery();
			getCode = resultSet.getInt(ApplicationConstants.CODE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return getCode;
	}

	public static String generateCurrentDateTime() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat(ApplicationConstants.DATE_FORMAT);
		String strDate = formatter.format(date);
		return strDate;
	}

	@Override
	public MemberDataStructure getMemberByUserName(String username, String password) {
		MemberDataStructure memberDataStructure = null;
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DataBaseSqlQueries.GET_MEMBER_TABLE_BY_USERNAME);
			preparedStatement.setString(1, username);
			ResultSet resultSet = preparedStatement.executeQuery();
			int code = resultSet.getInt(ApplicationConstants.CODE);
			String pp = resultSet.getString(ApplicationConstants.E_PASSWORD).trim();
			String pk = resultSet.getString(ApplicationConstants.K_PASSWORD).trim();
			String decryptedPassword = EncryptionUtility.decrypt(pp, pk);
			boolean correct = decryptedPassword.equals(password);
			memberDataStructure = new MemberDataStructure(username, code, correct);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return memberDataStructure;
	}

}
