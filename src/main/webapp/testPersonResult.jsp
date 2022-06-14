<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Arrays"%>
<%
	//jsp의 script - java영역
	// reqeust, response 객체에 선언없이 접근 가능 (forword할때 넘겨줬기 떄문에 바로 사용할 수 있다.)
	String name = request.getParameter("name");
	String color = request.getParameter("color");
	String animal = request.getParameter("animal");
	String[] foods = request.getParameterValues("food");
	
	System.out.println("name@jsp = " + name);
	System.out.println("color@jsp = " + color);
	System.out.println("animal@jsp = " + animal);
	System.out.println("food@jsp = " + (foods != null ? Arrays.toString(foods) : null));	//import문 직접 작성
%>

<!Doctype html>
<html>
<head>
<meta charset='utf-8'>
<title>개인취향검사결과</title>
</head>
<body>
<%-- 출력식 --%>
<h1>개인취향검사결과 <%= request.getMethod() %></h1>
<p>이름 : <%= name %></p>
<p>선호색상 : <%= color %></p>
<p>선호동물 : <%= animal %></p>
<p>선호음식 : <%= foods != null ? Arrays.toString(foods) : "없음" %></p>
</body>
</html>