<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="sec02.ex01.*, java.util.*"
    import="java.sql.Timestamp"
%>
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
	<jsp:useBean id="m" class="sec02.ex01.MemberBean" scope="page" />
	<jsp:setProperty name="m" property="*" />
	
	<% 
	    MemberDAO dao = new MemberDAO();
		dao.addMember(m);
		List<MemberBean> list = dao.listMembers();
	%>
	
	<table border="1" width="800" align="center">
		<tr align="center" bgcolor="ffff66">
		   <th>아이디</th>
		   <th>비밀번호</th>
		   <th>이름</th>
		   <th>이메일</th>
		   <th>가입일자</th>
		   <th>취미</th>
		</tr>
		<%
			for (int i=0; i<list.size(); i++){
				MemberBean mvo = (MemberBean) list.get(i);
		%>
			<tr align="center">
	       		<td><%= mvo.getId() %></td>
		        <td><%= mvo.getPwd() %></td>
		        <td><%= mvo.getName() %></td>
		        <td><%= mvo.getEmail() %></td>
		        <td><%= mvo.getJoinDate() %></td>
		        <td><%= mvo.getHobby() %></td>
     		</tr>
		<%
		 }
		%>
		
	</table>

</body>
</html>