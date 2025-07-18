package com.jst.controller;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jst.utlity.OnlineConstant;

import com.jst.db.DatabaseConnection;
import com.jst.model.Questions;

@WebServlet(OnlineConstant.ADD_QUESTION)
public class AddQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
  	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String question = request.getParameter(OnlineConstant.QUESTION);
		String option1 = request.getParameter(OnlineConstant.OPTION1);
		String option2 = request.getParameter(OnlineConstant.OPTION2);
		String option3 = request.getParameter(OnlineConstant.OPTION3);
		String option4 = request.getParameter(OnlineConstant.OPTION4);
		String correctAnswer = request.getParameter(OnlineConstant.CORRECT_ANSWER);
		String selectTopic = request.getParameter(OnlineConstant.SELECT_TOPIC);
		
		Questions questions = new Questions(question, option1, option2, option3, option4, correctAnswer, selectTopic);
		
		
		
		try {
			
			if(addQuestion > 0){
				response.sendRedirect(OnlineConstant.ADD_QUESTION_JSP);
			}else{
				response.sendRedirect(OnlineConstant.ADD_QUESTION_JSP);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
