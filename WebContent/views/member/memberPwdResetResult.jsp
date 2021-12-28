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
		boolean pwdResult =(boolean)request.getAttribute("pwdResult");
	%>
	
	<script>
	<%if(pwdResult){%>
		alert('비밀번호 변경 성공하였습니다. 로그인 페이지로 이동합니다.');
		location.replace('/views/member/memberLogin.jsp');		
		<%}else{%>
			alert('비밀번호 변경 실패 \n 비밀번호를 재확인 해주세요');
			location.replace('/views/member/memberSearchId.jsp');
		<%}%>
		</script>

</body>
</html>