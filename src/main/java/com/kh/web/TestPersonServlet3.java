package com.kh.web;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testPerson3.do")
public class TestPersonServlet3 extends HttpServlet {

	/*
	 * POST 요청 처리시 doPost 오버라이드
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 인코딩 처리(POST요청시 필수 body부분의 한글이 꺠질 수 있음)
		request.setCharacterEncoding("utf-8");
		
		// 2. 사용자 입력값 옮겨 담기(폼 태그 하위에 중요한건 id값이 아님. 전송되는 name값이 중요)
		String name = request.getParameter("name");		//name값을 가져오는 것임.
		String color =request.getParameter("color");	//name값을 가져오는 것임.
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");

		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("food = " + (foods != null ? Arrays.toString(foods) : null));
		
		
		// 3. 업무로직 처리
		
		// 4. 응답메세지 작성 -> jsp에 위임(html은 jsp가 만들거야~)
		RequestDispatcher reqDispatcher = request.getRequestDispatcher("/testPersonResult.jsp");
		reqDispatcher.forward(request, response);
	}
	
}
