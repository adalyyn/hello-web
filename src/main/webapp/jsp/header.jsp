<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String name = "홍길동";	//알아서 이클립스가 처리해줌
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 재사용- include</title>
<script src="/web/js/jquery-3.6.0.js"></script>
<script>
	const num = 123;	/*브라우저에서 처리될 JS 하나의 HTML로 묶여서 날라가기 떄문에*/
</script>
</head>
<body>
	<header>
		<h1>Hello Web</h1>
		<nav>
			<ul>
				<li><a href="/web/jsp/main1.jsp">main1</a></li>
				<li><a href="/web/jsp/main2.jsp">main2</a></li>
				<li><a href="http://naver.com">네이버</a></li>
			</ul>
		</nav>
	</header>
	<main>