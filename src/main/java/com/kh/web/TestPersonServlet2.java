package com.kh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPersonServlet2 extends HttpServlet {

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
		
		// 4. 응답메세지 작성
		// 헤더(설정정보)
		response.setContentType("text/html; charset=utf-8");	//html보낼거고, 인코딩까지설정
		
		// 바디(html을 포함해야 한다.) html을 출력하는 자바코드
		PrintWriter out = response.getWriter();	//응답메세지를 대상으로하는 문자기반 출력스트림(이미 만들어져 있음)
		out.println("<!Doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>개인취향검사결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>개인취향검사결과" + request.getMethod() + " </h1>");
		out.println("<p>이름 : " + name + "</p>");
		out.println("<p>선호색상 : " + color + "</p>");
		out.println("<p>선호동물 : " + animal + "</p>");
		out.println("<p>선호음식 : " + (foods != null ? Arrays.toString(foods) : "없음") + "</p>");
		out.println("</body>");
		out.println("</html>");
	}
	
}
