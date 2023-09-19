<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>       
<%
  request.setCharacterEncoding("utf-8");
%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:set var="file1" value="${param.param1}"  />    
<c:set var="file2" value="${param.param2}"  />

<title>Insert title here</title>
</head>
<body>

파라미터 1 : ${file1}<br>
파라미터 2 : ${file2}<br>

<c:if test="${not empty file1}">
	<img src="${contextPath}/download.do?fileName=${file1}" /><br>
    <a href="${contextPath}/download.do?fileName=${file1}">파일 내려받기</a>
</c:if>
<c:if test="${not empty file2}">
	<img src="${contextPath}/download.do?fileName=${file2}" /><br>
    <a href="${contextPath}/download.do?fileName=${file2}">파일 내려받기</a>
</c:if>

</body>
</html>