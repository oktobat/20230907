<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "이순신");
%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>세션에 이름을 바인딩합니다.</h1>
	<!--  <a href='session1.jsp'>첫번째 페이지로 이동하기 </a> -->
	<%
	   RequestDispatcher dispatch = request.getRequestDispatcher("session1.jsp");
	   dispatch.forward(request, response);
	%>
	
</body>
</html>