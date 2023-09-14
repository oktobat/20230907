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
	<%
		String _name = request.getParameter("name");
		MemberBean vo = new MemberBean(_name);
		MemberDAO dao = new MemberDAO();
		List<MemberBean> list = dao.oklistMembers(vo);
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
				String id = mvo.getId();
				String pwd = mvo.getPwd();
				String name = mvo.getName();
				String email = mvo.getEmail();
				Date joinDate = mvo.getJoinDate();
				String hobby = mvo.getHobby();
		%>
			<tr align="center">
	       		<td><%= id %></td>
		        <td><%= pwd %></td>
		        <td><%= name %></td>
		        <td><%= email %></td>
		        <td><%= joinDate  %></td>
		        <td><%= hobby  %></td>
     		</tr>
		<%
		 }
		%>
		
	</table>

</body>
</html>