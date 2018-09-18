<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//정보를 가져와야 하는지 탈퇴를 위한 비밀번호 확인을 해야하는지 결정
	//cmd = check면 정보가져오기
	//cmd = leave면 탈퇴
	String cmd = request.getParameter("cmd");

	String id = null;
	//세션 정보 가져오기 id만 추출
	MemberVO vo=(MemberVO)session.getAttribute("vo");
	if(vo != null)
	id = vo.getUserid();
	else{
		
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action = "../pwdcheck.do">
		<label for ="userid">아이디</label>
		<input type = "text" name = "userid" value="<%=id%>" readonly><br> <!-- readonly : 수정 금지 -->
		<label for ="userid">비밀번호 확인</label>
		<input type = "password" name = "password" id="password" required ="required" autofocus><br>
		<input type = "hidden" name = "cmd" value="<%=cmd%>">
		<input type = "submit" value= "확인">
	</form>
</body>
</html>