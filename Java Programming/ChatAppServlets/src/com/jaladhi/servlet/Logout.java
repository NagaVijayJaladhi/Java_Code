package com.jaladhi.servlet;

import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;

public class Logout extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		try {
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			String responseJson;
			HttpSession session = request.getSession();
			request.getSession().removeAttribute("member");
			JsonObject responseJSONObject = new JsonObject();
			responseJSONObject.addProperty("success", true);
			responseJson = responseJSONObject.toString();
			pw.print(responseJson);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}