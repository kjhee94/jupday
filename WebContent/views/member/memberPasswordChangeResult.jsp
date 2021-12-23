<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	boolean pwdResult = (boolean)request.getAttribute("pwdResult");
	%>

	<script>
	<%if(pwdResult) { %>
		window.alert('비밀번호 변경에 성공하였습니다.');
		location.replace('/views/member/myPage.jsp');
	<% } else { %>
		window.alert('비밀번호 변경에 실패하였습니다. 다시 시도해주세요.');
		location.replace('/views/member/myPagePasswordChange.jsp');
	<% } %>
	</script>


</body>
</html>