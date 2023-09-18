<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec02.ex01.*, java.util.*"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 출력창</title>
</head>
<body>

	<h1>회원 정보</h1>
	<% 
	    request.setCharacterEncoding( "utf-8" );
	%>
	<jsp:useBean id="m1" class="sec02.ex01.MemberBean" scope="page" />
	<jsp:setProperty name="m1" property="*" />
	<jsp:useBean id="memberList" class="java.util.ArrayList" />
		
	<%-- 
	    MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com", "등산, 피아노, 독서");
		memberList.add(m1);
		memberList.add(m2);
	--%>
	
	<c:set var="mem" value="<%=memberList %>" />
	
	<table border="1" width="800" align="center">
		<tr align="center" bgcolor="ffff66">
		   <th>아이디</th>
		   <th>비밀번호</th>
		   <th>이름</th>
		   <th>이메일</th>
		   <th>취미</th>
		</tr>
		<c:forEach var="member" items="${mem}">
			<tr align="center">
	       		<td>${member.id }</td>
		        <td>${member.pwd }</td>
		        <td>${member.name }</td>
		        <td>${member.email }</td>
		        <td>${member.hobby }</td>
	    	</tr>
    	</c:forEach>
	</table>

</body>
</html>