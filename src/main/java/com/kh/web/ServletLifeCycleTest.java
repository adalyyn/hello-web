package com.kh.web;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *  Servlet(상속구조)
 *  - GenericServlet 추상클래스 : Servlet 인터페이스를 구현
 *  	- HttpServlet 추상클래스
 *  		- ServletLifeCycle
 *  
 *  - 사용자 요청이 접수되면 HttpServlet의 service메소드가 먼저 호출되고, 
 *  	그 안에서 전송방식에 따라 doGet, doPost를 호출해준다.
 *  
 *  - Servlet은 tomcat(WAS/Web Container)에 의해서 Singletone패턴으로 관리된다.
 *  (Singletone : 프로그램 운영중에 단 하나의 서블릿 객체만 만들어서 운영한다는 의미,객체를 여러개 만들지 않는다. 메모리 효율성이 좋음)
 *  - 사용자 요청 당 하나의 스레드가 생성되어 처리.(톰캣은 멀티 스레드로 운영. 서블릿객체를 공유하게 된다. 응답성이 좋다.)
 *  
 *  - Servlet LifeCycle
 *  1. 생성자 호출
 *  2. init 호출
 *  
 *  3. service - doGet/doPost (여러번 일어남)
 *  
 *  4. destroy호출. 메모리반납
 */




/**
 * @WebServlet을 작성하는것은 web.xml에 url-pattern과 servlet 클래스 바인딩하는 것과 동일한 작업
 * 이거 이용하면 xml에 따로 등록안해도 된다.
 */
@WebServlet("/servlet/lifeCycle.do")
public class ServletLifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLifeCycleTest() {
        System.out.println("[ServletLifeCycleTest 생성자 호출]");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("[init 호출]");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("[desroy호출]");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("[GET / servlet/lifeCycle.do 호출!]");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
