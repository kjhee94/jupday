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
	boolean updateResult = (boolean)request.getAttribute("result");
	%>
	
	<script>
	<% if(updateResult) { %>
		alert('회원정보 변경을 성공했습니다.');
	<% } else { %>
		alert('회원정보 변경을 실패했습니다 \n지속적인 문제 발생시 관리자에게 문의해주세요.');
	<% } %>
	
	location.replace("/member/myPage.do");
	</script>

</body>
</html>