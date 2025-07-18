package com.jaladhi.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jaladhi.constants.ApplicationConstants;
import com.jaladhi.db.DataBaseSqlQueries;

public class AddFriendRequest extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType(ApplicationConstants.SET_CONTENT_TYPE_JSON);
			String responseJson = "";
			BufferedReader br = request.getReader();
			String line = null;
			String jsonString = "";
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				jsonString = jsonString + line;
			}
			Gson gson = new Gson();
			System.out.println(jsonString);

			JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			HttpSession Session = request.getSession();
			String fromUsername = jsonObject.get(ApplicationConstants.FROM_USER_NAME).getAsString();
			String toUsername = jsonObject.get(ApplicationConstants.TO_USER_NAME).getAsString();

			PreparedStatement preparedStatement;
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/tmchatdb");
			preparedStatement = connection.prepareStatement(DataBaseSqlQueries.GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME);
			preparedStatement.setString(1, toUsername);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
			boolean toUsernameCorrect = resultSet.next();
			System.out.println("yo");
			PreparedStatement preparedStatement1 = connection.prepareStatement(DataBaseSqlQueries.GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME);
			preparedStatement1.setString(1, fromUsername);
			ResultSet resultSet1;
			resultSet1 = preparedStatement1.executeQuery();
			boolean fromUsernameCorrect = resultSet1.next();
			if (toUsernameCorrect) {
				int code = resultSet1.getInt(ApplicationConstants.CODE);
				int toUsernameCode = resultSet.getInt(ApplicationConstants.CODE);
				System.out.println(code + toUsernameCode);
				preparedStatement.close();
				resultSet.close();
				preparedStatement = connection.prepareStatement(DataBaseSqlQueries.SELECT_FROM_FRIEND_OR_AND);
				preparedStatement.setInt(1, toUsernameCode);
				preparedStatement.setInt(2, code);
				preparedStatement.setInt(3, code);
				preparedStatement.setInt(4, toUsernameCode);
				System.out.println("yoo");
				resultSet = preparedStatement.executeQuery();
				boolean correct1 = resultSet.next();
				if (!(correct1)) {
					preparedStatement.close();
					resultSet.close();
					System.out.println("43");
					preparedStatement = connection.prepareStatement(DataBaseSqlQueries.SELECT_FROM_FRIEND_REQUEST_OR);
					preparedStatement.setInt(1, toUsernameCode);
					preparedStatement.setInt(2, code);
					preparedStatement.setInt(3, code);
					preparedStatement.setInt(4, toUsernameCode);
					System.out.println("3434");
					resultSet = preparedStatement.executeQuery();
					boolean correct = resultSet.next();
					if (toUsernameCode == code) {
						JsonObject responseJsonObject = new JsonObject();
						responseJsonObject.addProperty(ApplicationConstants.SUCCESS, false);
						responseJsonObject.addProperty(ApplicationConstants.EXCEPTION, ApplicationConstants.YOUR_SELF);
						responseJson = responseJsonObject.toString();
						pw.print(responseJson);
						return;
					}
					System.out.println("yooo");
					if (!(correct)) {
						System.out.println("hyyyyyyy");
						preparedStatement.close();
						resultSet.close();
						preparedStatement = connection.prepareStatement(DataBaseSqlQueries.INSERT_FRIEND_REQUEST, Statement.RETURN_GENERATED_KEYS);
						preparedStatement.setInt(1, code);
						preparedStatement.setInt(2, toUsernameCode);
						preparedStatement.executeUpdate();
						System.out.println("yoooo");
						preparedStatement = connection.prepareStatement(DataBaseSqlQueries.INSERT_NOTIFICATION);
						java.util.Date utilDate = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(utilDate.getYear(), utilDate.getMonth(), utilDate.getDate());
						java.sql.Time sqlTime = new java.sql.Time(utilDate.getHours(), utilDate.getMinutes(), utilDate.getSeconds());
						preparedStatement.setDate(1, sqlDate);
						preparedStatement.setTime(2, sqlTime);
						preparedStatement.setInt(3, toUsernameCode);
						preparedStatement.setLong(4, code);
						preparedStatement.setString(5, ApplicationConstants.FRIEND_REQUEST_NOTIFICATION);
						preparedStatement.executeUpdate();
						preparedStatement.close();
					} else {
						resultSet.close();
						preparedStatement.close();
						JsonObject responseJsonObject = new JsonObject();
						responseJsonObject.addProperty(ApplicationConstants.SUCCESS, true);
						responseJson = responseJsonObject.toString();
						pw.print(responseJson);
						System.out.println(responseJson);
						return;
					}
				} else {
					resultSet.close();
					preparedStatement.close();
					JsonObject responseJsonObject = new JsonObject();
					responseJsonObject.addProperty(ApplicationConstants.SUCCESS, true);
					responseJsonObject.addProperty(ApplicationConstants.REMARK, ApplicationConstants.FRIENDS_ALREADY);
					responseJson = responseJsonObject.toString();
					pw.print(responseJson);
					System.out.println(responseJson);
					return;
				}
			}
			resultSet.close();
			preparedStatement.close();
			System.out.println("ypoooooo");
			connection.close();
			if (toUsernameCorrect) {
				responseJson = ApplicationConstants.ANS_SUCCESS_TRUE;
			} else {
				responseJson = ApplicationConstants.ANS_SUCCESS_FALSE;
				resultSet.close();
				preparedStatement.close();
				JsonObject responseJsonObject = new JsonObject();
				responseJsonObject.addProperty(ApplicationConstants.SUCCESS, false);
				responseJsonObject.addProperty(ApplicationConstants.EXCEPTION, ApplicationConstants.INVALID_FRIEND_REQUEST);
				responseJson = responseJsonObject.toString();
				pw.print(responseJson);
				System.out.println(responseJson);
				return;
			}
			System.out.println(responseJson);
			response.setContentType(ApplicationConstants.SET_CONTENT_TYPE_JSON);
			pw.print(responseJson);
		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
}