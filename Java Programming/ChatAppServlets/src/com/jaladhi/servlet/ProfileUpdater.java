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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jaladhi.entity.MemberDataStructure;
import com.jaladhi.util.EncryptionUtility;

public class ProfileUpdater extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			String responseJson;
			MemberDataStructure mds = (MemberDataStructure) request.getSession().getAttribute("member");
			System.out.println(mds);
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
			String username = jsonObject.get("username").getAsString();
			String password = jsonObject.get("password").getAsString();
			String name = jsonObject.get("name").getAsString();
			System.out.println("10");
			String newPassword = jsonObject.get("newPassword").getAsString();
			System.out.println("1");
			PreparedStatement preparedStatement;
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/tmchatdb");
			preparedStatement = connection.prepareStatement("select * from member where username=?");
			preparedStatement.setString(1, username);
			ResultSet resultSet;
			resultSet = preparedStatement.executeQuery();
			Boolean correct;
			System.out.println("2");
			correct = resultSet.next();
			if (correct) {
				int code = resultSet.getInt("code");
				String pp = resultSet.getString("e_password").trim();
				String pk = resultSet.getString("k_password").trim();
				System.out.println(pp);
				System.out.println(pk);
				String decryptedPassword = EncryptionUtility.decrypt(pp, pk);

				System.out.println(decryptedPassword);
				correct = decryptedPassword.equals(password);

				System.out.println(correct);
				System.out.println(newPassword);
				if (correct) {
					String passwordKey = java.util.UUID.randomUUID().toString();
					String encryptedPassword = EncryptionUtility.encrypt(newPassword, passwordKey);
					preparedStatement = connection
							.prepareStatement("update member set name=?,e_password=?,k_password=? where code=?");
					preparedStatement.setString(1, name);
					preparedStatement.setString(2, encryptedPassword);
					preparedStatement.setString(3, passwordKey);
					preparedStatement.setInt(4, code);
					preparedStatement.executeUpdate();
					resultSet.close();
					preparedStatement.close();
					connection.close();
					System.out.println("4");
					JsonObject responseJsonObject = new JsonObject();
					responseJsonObject.addProperty("success", true);

					responseJson = responseJsonObject.toString();
					System.out.println("1");
					pw.print(responseJson);
					System.out.println(responseJson);
					return;
				} else {
					resultSet.close();
					preparedStatement.close();
					connection.close();
					JsonObject responseJsonObject = new JsonObject();
					responseJsonObject.addProperty("success", false);
					responseJsonObject.addProperty("Exception", "Wrong Password");
					responseJson = responseJsonObject.toString();
					System.out.println("1");
					pw.print(responseJson);
					System.out.println(responseJson);
					return;
				}
			}

			resultSet.close();
			preparedStatement.close();
			connection.close();

			JsonObject responseJsonObject = new JsonObject();
			responseJsonObject.addProperty("success", false);
			responseJsonObject.addProperty("Exception", "Username not available");
			responseJson = responseJsonObject.toString();
			System.out.println("1");
			pw.print(responseJson);

			System.out.println(responseJson);
			response.setContentType("application/json");

		} catch (Exception exception) {
			System.out.println(exception); // remove after testing
		}
	}
}