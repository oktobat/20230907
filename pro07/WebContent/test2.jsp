<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="dan" value="${param.dan}" />
<h2> <c:out value="${dan}" />단 출력</h2>
<h2> ${dan}단 출력</h2>
<table border="1">
<c:forEach var="i" begin="1" end="9" step="1">
	<c:if test="${ i%2 == 0 }">
    	<tr bgcolor="#ccff66">
    </c:if>
	<c:if test="${ i%2 == 1 }">
	    <tr bgcolor="#ccccff">
	</c:if>
		<td><c:out value="${dan}" />*<c:out value="${i}" /></td>
		<td><c:out value="${c}" default="결과" /></td>
	</tr>
</c:forEach>	
</table>


</body>
</html>