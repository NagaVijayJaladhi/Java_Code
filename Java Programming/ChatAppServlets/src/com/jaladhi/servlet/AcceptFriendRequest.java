package com.jaladhi.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jaladhi.constants.ApplicationConstants;
import com.jaladhi.db.DataBaseSqlQueries;

public class AcceptFriendRequest extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType(ApplicationConstants.SET_CONTENT_TYPE_JSON);
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
			String responseJson;
			JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			HttpSession Session = request.getSession();
			System.out.println("HNNN");
			String requestSenderUsername = jsonObject.get(ApplicationConstants.REQUEST_SENDER_USERNAME).getAsString();
			String requestAccepterUsername = jsonObject.get(ApplicationConstants.REQUEST_ACCEPTER_USERNAME).getAsString();
			System.out.println("43");
			PreparedStatement preparedStatement;
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/tmchatdb");
			preparedStatement = connection.prepareStatement(DataBaseSqlQueries.GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME);
			preparedStatement.setString(1, requestSenderUsername);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
			boolean requestSenderUsernameCorrect = resultSet.next();
			PreparedStatement preparedStatement1 = connection.prepareStatement(DataBaseSqlQueries.GET_CODE_FROM_MEMBER_TABLE_BY_USERNAME);
			preparedStatement1.setString(1, requestAccepterUsername);
			ResultSet resultSet1;
			resultSet1 = preparedStatement1.executeQuery();
			boolean requestAccepterUsernameCorrect = resultSet1.next();
			System.out.println("1");
			if (requestSenderUsernameCorrect) {
				int code = resultSet1.getInt("code");
				int requestSenderUsernameCode = resultSet.getInt(ApplicationConstants.CODE);
				System.out.println(code + "," + requestSenderUsernameCode);
				preparedStatement.close();
				resultSet.close();
				preparedStatement1.close();
				resultSet1.close();
				System.out.println("43");
				preparedStatement = connection.prepareStatement(DataBaseSqlQueries.SELECT_FROM_FRIEND_OR_AND);
				preparedStatement.setInt(1, requestSenderUsernameCode);
				preparedStatement.setInt(2, code);
				preparedStatement.setInt(3, code);
				preparedStatement.setInt(4, requestSenderUsernameCode);
				resultSet = preparedStatement.executeQuery();
				boolean correct = resultSet.next();
				System.out.println("3434");
				if (!(correct)) {
					System.out.println("hyyyyyyy");
					preparedStatement.close();
					resultSet.close();
					preparedStatement1.close();
					resultSet1.close();
					preparedStatement = connection.prepareStatement(DataBaseSqlQueries.SELECT_FROM_FRIEND_REQUEST);
					preparedStatement.setInt(1, requestSenderUsernameCode);
					preparedStatement.setInt(2, code);
					resultSet = preparedStatement.executeQuery();
					boolean correct1 = resultSet.next();
					System.out.println("kya hua");
					preparedStatement1 = connection.prepareStatement(DataBaseSqlQueries.SELECT_FROM_FRIEND_REQUEST);
					preparedStatement1.setInt(1, requestSenderUsernameCode);
					preparedStatement1.setInt(2, code);
					resultSet1 = preparedStatement1.executeQuery();
					System.out.println("kyaaaaa");
					if (resultSet1.next()) {
						System.out.println("chala ");
						preparedStatement.close();
						resultSet.close();
						preparedStatement1.close();
						resultSet1.close();
						preparedStatement = connection.prepareStatement(DataBaseSqlQueries.INSERT_FRIEND);
						preparedStatement.setInt(1, requestSenderUsernameCode);
						preparedStatement.setInt(2, code);
						preparedStatement1 = connection.prepareStatement(DataBaseSqlQueries.DELETE_FROM_FRIEND_REQUEST_BY_AND_TO);
						preparedStatement1.setInt(1, requestSenderUsernameCode);
						preparedStatement1.setInt(2, code);
						preparedStatement1.executeUpdate();
						preparedStatement.executeUpdate();
						System.out.println("35fdg42");
						preparedStatement = connection.prepareStatement(DataBaseSqlQueries.INSERT_NOTIFICATION);
						java.util.Date utilDate = new java.util.Date();
						java.sql.Date sqlDate = new java.sql.Date(utilDate.getYear(), utilDate.getMonth(), utilDate.getDate());
						java.sql.Time sqlTime = new java.sql.Time(utilDate.getHours(), utilDate.getMinutes(), utilDate.getSeconds());
						preparedStatement.setDate(1, sqlDate);
						preparedStatement.setTime(2, sqlTime);
						preparedStatement.setInt(3, requestSenderUsernameCode);
						preparedStatement.setLong(4, code);
						preparedStatement.setString(5, ApplicationConstants.FRIEND_REQUEST_ACCEPTED_NOTIFICATION);
						preparedStatement.executeUpdate();
						preparedStatement.close();
						System.out.println("35wqer42");
					} else {
						resultSet.close();
						preparedStatement.close();
						JsonObject responseJsonObject = new JsonObject();
						responseJsonObject.addProperty(ApplicationConstants.SUCCESS, false);
						responseJsonObject.addProperty(ApplicationConstants.REMARK, ApplicationConstants.NO_REQUEST_FROM_USER);
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
					responseJsonObject.addProperty(ApplicationConstants.EXCEPTION, ApplicationConstants.FRIENDS_ALREADY);
					responseJson = responseJsonObject.toString();
					pw.print(responseJson);
					System.out.println(responseJson);
					return;
				}
			}
			resultSet.close();
			preparedStatement.close();
			connection.close();
			if (requestSenderUsernameCorrect) {
				responseJson = ApplicationConstants.ANS_SUCCESS_TRUE;
				System.out.println(responseJson);
			} else {
				responseJson = ApplicationConstants.ANS_SUCCESS_FALSE;
				resultSet.close();
				preparedStatement.close();
				JsonObject responseJsonObject = new JsonObject();
				responseJsonObject.addProperty(ApplicationConstants.SUCCESS, false);
				responseJsonObject.addProperty(ApplicationConstants.EXCEPTION, "Invalid USER");
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