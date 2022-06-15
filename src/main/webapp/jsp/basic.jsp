<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*,java.util.GregorianCalendar" %>

<%-- 
	jsp작성내용을 servlet으로 변환되어 서비스 된다.
	jsp를 수정한 경우, tomcat을 재시동할 필요가 없다.
	클라이언트 호출시 변경된 내용이 자동변환 -> 컴파일 처리된다.
 --%>
<%
	//scriptlet 자바영역
	System.out.println("Hello JSP");
	System.out.println("12345");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Basic</title>
<script>
window.onload = () => {
	let sum = 0;
	for(let i = 1; i <= 100 ; i++){
		sum += i;
	}
	document.querySelector("#client-sum").innerHTML = sum;
	
	/* document.querySelector("#client-millis").innerHTML = Date.now(); 강사님의 한줄풀이....*/
}
/* 온로드 이벤트에 같이 써도 된다. */
window.onload = () => {
	const now = new Date();
	const millis = now.getTime();
	document.querySelector("#client-millis").innerHTML = millis;	
}
</script>
<style>
	table{
		border: 1px solid black;
		border-collapse: collapse;
		margin: auto 0;
	}
	td,th{
		padding:3px;
		border: 1px solid black;
	}
</style>
</head>
<body>
<%
	int sum = 0;
	for(int i = 1; i <= 100; i++)
		sum += i;
%>
	<h1>JSP Basic</h1>
	<%-- jsp주석 : servlet변환시 처리되지 않는다. --%>
	<!-- html주석 : client까지 전달된다. 보안상 주의해야 한다. -->
	
	
	<h2>1부터 100까지의 합은?</h2>
	<ul>
		<li>Server : <span class="sum"><%= sum %></span></li>
		<li>Client : <span class="sum" id="client-sum"></span></li>		
	</ul>

<%
	Calendar cal = new GregorianCalendar();
	long millis = cal.getTimeInMillis();
%>	
	<h2>Server | client 시각출력</h2>
	<ul>
		<li>Server : <span class="millis"><%= millis %></span></li><%-- 내가 푼 코드...복잡하게 풀었네 --%>
		
		<li>Server : <span class="millis"><% out.print(System.currentTimeMillis()); %></span></li>
		
		<%-- <li>Server : <span class="millis"><%= System.currentTimeMillis() %></span></li> --%>
	
		<%-- 출력식 안에서 ; 찍지 않는다. 메소드 안에 전달될 부분이기 때문에. --%>
		
		<li>Client : <span class="millis" id="client-millis"></span></li>
	</ul>
	
	<h2>분기처리</h2>
<%
	String lang = request.getParameter("lang");
	System.out.println("lang = " + lang);
	if("en".equals(lang)){
%>
	<p>Hello</p>
<% 
	}
	else if("ko".equals(lang)){
%>
	<p>안녕하세요~</p>
<%	
	}
%>


<!-- 스위치문 다시 -->


	<h2>반복처리</h2>
	<ul>
<%
	List<String> names = Arrays.asList("홍길동", "신사임당", "이순신");
	for(String name : names){
%>
		<li><%= name %></li>
<% 
	}
%>
	</ul>
	
	
	<h2>@실습문제 - 주문</h2>
	<!-- 
		table
			tbody
				tr
					th 주문번호
					td ??
				tr
					th 상품명
					td ??
				tr
					th 옵션1
					td ??
	 -->
	 
<%
	String no = request.getParameter("no");		//정수필요하면 문자열로 가져오고 형변환해야한다.
	String prod = request.getParameter("prod");
	String[] options = request.getParameterValues("option");
	
%>
	<table>
		<tbody>
			<tr>
				<th>주문번호</th>
				<td><%= no %></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><%= prod %></td>
			</tr>
<%
	if(options != null){
		for(int i = 0; i < options.length; i++){
%>
			<tr>
				<th>옵션<%= i + 1 %></th>
				<td><%= options[i]%></td>
			</tr>
<%
		}
%>
		</tbody>
	</table>
<%
	}
%>


	
	

	
</body>
</html>








