package com.jaladhi.servlet;

import java.io.BufferedReader;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.jaladhi.constants.ApplicationConstants;
import com.jaladhi.entity.MemberDataStructure;
import com.jaladhi.services.ServiceForAllServlets;
import com.jaladhi.services.ServiceForAllServletsImp;


public class Authenticator extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType(ApplicationConstants.SET_CONTENT_TYPE_HTMl);
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
			String username = jsonObject.get(ApplicationConstants.USER_NAME).getAsString();
			String password = jsonObject.get(ApplicationConstants.PASSWORD).getAsString();
			ServiceForAllServlets serviceForAllServlets = new ServiceForAllServletsImp();			
			Boolean correct = serviceForAllServlets.checkUserNameInMember(username, password);
			MemberDataStructure memberDataStructure = null;
			if (correct) {
				memberDataStructure = serviceForAllServlets.getMemberByUserName(username, password);
				HttpSession session = request.getSession();
				session.setAttribute(ApplicationConstants.MEMBER, memberDataStructure);
			}

			String ANS;
			if (memberDataStructure.isCorrect()) {
				ANS = ApplicationConstants.ANS_SUCCESS_TRUE;
			} else {
				ANS = ApplicationConstants.ANS_SUCCESS_FALSE;
			}
			
			System.out.println(ANS);
			response.setContentType(ApplicationConstants.SET_CONTENT_TYPE_JSON);
			pw.print(ANS);

		} catch (Exception exception) {
			System.out.println(exception);
		}
	}
}