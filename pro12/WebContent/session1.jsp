<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name =(String) request.getAttribute("name");
	request.setAttribute("address", "서울시 강남구");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름은 <%=name %>입니다.<br>
	<!-- <a href="session2.jsp">두번째 페이지로 이동</a> -->
	<%
	   RequestDispatcher dispatch = request.getRequestDispatcher("session2.jsp");
	   dispatch.forward(request, response);
	%>
	
</body>
</html>