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
import com.jaladhi.entity.UserBean;
import com.jaladhi.util.EncryptionUtility;

public class UserCreator extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			BufferedReader br = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				sb.append(line);
			}
			String requestJSON = sb.toString();
			Gson gson = new Gson();
			UserBean userBean = gson.fromJson(requestJSON, UserBean.class);
			String username = userBean.getUsername();
			String password = userBean.getPassword();
			String name = userBean.getName();
			String responseJSON;
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();

			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/tmchatdb");
			PreparedStatement preparedStatement;
			preparedStatement = connection.prepareStatement("select code from member where upper(username)=?");
			preparedStatement.setString(1, username.toUpperCase());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				resultSet.close();
				preparedStatement.close();
				connection.close();
				JsonObject responseJSONObject = new JsonObject();
				responseJSONObject.addProperty("success", false);
				responseJSONObject.addProperty("exception", "Username not available");
				responseJSON = responseJSONObject.toString();
				pw.print(responseJSON);
				return;
			}
			resultSet.close();
			preparedStatement.close();
			String passwordKey = java.util.UUID.randomUUID().toString();
			passwordKey = passwordKey.replaceAll("-", "a");
			if (passwordKey.length() > 100)
				passwordKey = passwordKey.substring(0, 100);
			String encryptedPassword;
			encryptedPassword = EncryptionUtility.encrypt(password, passwordKey);
			preparedStatement = connection.prepareStatement("insert into member (name,username,e_password,k_password) values (?,?,?,?)");
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, username);
			preparedStatement.setString(3, encryptedPassword);
			preparedStatement.setString(4, passwordKey);
			preparedStatement.executeUpdate();
			preparedStatement.close();
			connection.close();
			JsonObject responseJSONObject = new JsonObject();
			responseJSONObject.addProperty("success", true);
			responseJSON = responseJSONObject.toString();
			pw.print(responseJSON);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}