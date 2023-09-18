<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding( "utf-8" );
%>    
<%--
	String id = request.getParameter("id");
    String pwd = request.getParameter("pwd");
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${param.id }</h1>
	<h1>${param.pwd }</h1>
	<h1>${requestScope.address}</h1>
	
</body>
</html>