package com.kh.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Servlet
 * - 웹 요청을 처리할 수 있는 자바 클래스
 * - 웹 요청 처리 기능이 있는 HttpServlet클래스를 상속해서 서블릿을 작성. (직접 작성할 수는 없다.)
 * - 요청방식에 따라 doGet, doPost를 오버라이드.
 * 
 */
public class TestPersonServlet1 extends HttpServlet {

	/*
	 * Get 방식으로 요청했을때 처리코드를 작성
	 * - HttpServletRequest 요청관련 정보를 가진 객체 
	 * - HttpServletResponse 응답처리관련 정보를 가진 객체
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 요청 인코딩 처리(GET방식은 생략가능)
		request.setCharacterEncoding("utf-8");
		
		//2. 사용자 입력값처리 (자바변수에 옮겨담기)
		//?name=홍길동&color=파랑&animal=강아지&food=짜장면&food=탕수육
		// 사용자 입력값은 모두 문자열이다. 
		String name = request.getParameter("name");	//string을 리턴, 대소문자 완벽 구분
		String color = request.getParameter("color");
		String animal = request.getParameter("animal");
		String[] foods = request.getParameterValues("food");	//복수개의 값처리
		
		System.out.println("name = " + name);
		System.out.println("color = " + color);
		System.out.println("animal = " + animal);
		System.out.println("food = " + (foods != null ? Arrays.toString(foods) : null));
		
				
		//3. 이번 요청의 업무로직 처리
		
		//4. 응답 메세지 작성
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
