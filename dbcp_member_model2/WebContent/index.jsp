<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%
 	MemberVO vo=(MemberVO)session.getAttribute("vo");
 	String msg=request.getParameter("msg"); 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="js/jquery-3.3.1.slim.min.js"></script>
<script>
	$(function(){
		$("document").ready(function() {
			var msg='<%=msg%>';
			if(msg=='fail')
				alert('로그인 정보를 확인해 주세요');
			//$("#id").focus();
		});
		$("#logout").click(function(){
			//logout.do로 이동 후 세션 해제
			location.href='logout.do';
			//다시 index.jsp로 돌아오기
		});
		$("#pwdcheck").click(function(){
			//pwdcheck.jsp로 이동
			location.href='view/pwdcheck.jsp?cmd=check';
			//다시 index.jsp로 돌아오기
		});
		$("#leave").click(function(){
			//pwdcheck.jsp로 이동
			location.href='view/pwdcheck.jsp?cmd=leave';
			//다시 index.jsp로 돌아오기
		});
	});
</script>
</head>
<body>
<%-- <% if(vo==null){ %> --%>
<c:if test ="${empty vo}">
	<form method="post" action="login.do">
		<p><label for="id">아이디</label>
		<input type="text" name="id" id="id" required autofocus>
		</p>
		<p><label for="current_pass">비밀번호</label>
		<input type="password" name="current_pass" 
				id="current_pass" required>
		</p>
		<p><input type="submit" value="로그인"></p>
	</form>
	<a href="view/register.jsp">회원가입</a>
</c:if>
<c:if test ="${!empty vo}">
<%-- <%}else{ %> --%>
	${vo.name}님 반갑습니다.
	<button type="button" id="logout">로그아웃</button>
	<button type="button" id="pwdcheck">정보수정</button>
	<button type="button" id="leave">회원탈퇴</button>
	<button type="button" id="moobin">무빈</button>
<%-- <%} %> --%>
	<a href ="http://www.naver.com">네이버</a>
</c:if>
</body>
</html>
















