package com.jaladhi.servlet;

import java.io.PrintWriter;
import com.google.gson.Gson;
import java.io.BufferedReader;
import com.google.gson.JsonObject;
import com.google.gson.JsonElement;
import javax.servlet.http.HttpServlet;
import com.jaladhi.services.ServiceForAllServlets;
import com.jaladhi.services.ServiceForAllServletsImp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jaladhi.constants.ApplicationConstants;

public class AddMessage extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		String responseJSON;
		try {
			response.setContentType(ApplicationConstants.SET_CONTENT_TYPE_JSON);
			PrintWriter pw = response.getWriter();
			BufferedReader br = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line;
			while (true) {
				line = br.readLine();
				if (line == null)
					break;
				sb.append(line);
			}
			String jsonString = sb.toString();
			Gson gson = new Gson();
			JsonElement jsonElement = gson.fromJson(jsonString, JsonElement.class);
			JsonObject jsonObject = jsonElement.getAsJsonObject();
			String toUsername = jsonObject.get(ApplicationConstants.TO_USER_NAME).getAsString();
			String fromUsername = jsonObject.get(ApplicationConstants.FROM_USER_NAME).getAsString();
			String message = jsonObject.get(ApplicationConstants.MESSAGE).getAsString();
			ServiceForAllServlets serviceForAllServlets = new ServiceForAllServletsImp();			
			boolean toUsernameCorrect = serviceForAllServlets.checkUserNameInMember(toUsername, fromUsername);			
			if (toUsernameCorrect == false) {
				JsonObject responseJSONObject = new JsonObject();
				responseJSONObject.addProperty(ApplicationConstants.SUCCESS, false);
				responseJSONObject.addProperty(ApplicationConstants.EXCEPTION, ApplicationConstants.INVALID_REQUEST);
				responseJSON = responseJSONObject.toString();
				pw.print(responseJSON);
			} else {
				serviceForAllServlets.insertMessage(toUsername, fromUsername, message);
				JsonObject responseJSONObject = new JsonObject();
				responseJSONObject.addProperty(ApplicationConstants.SUCCESS, true);
				responseJSON = responseJSONObject.toString();
				pw.print(responseJSON);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}