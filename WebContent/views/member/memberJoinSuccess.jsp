<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>환영합니다!</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberJoinSuccess.css">
</head>

<body>
	<%
		Object result = request.getAttribute("userId");
	%>
	
	<%String userId = (String)request.getAttribute("userId"); %>
	<div class="bg-color">
		<div class="box-white">
			<div class="logo-user"><a href="/"><img src="/assets/images/jupday_logo.png" alt="줍데이로고"></a></div>
			<p class="txt-welcome"><span><%=userId%></span>님<br>회원가입을 환영합니다.</p>
			<p class="txt-welcomeInfo">지금 바로 로그인하여<br>JUP:DAY만의 해택을 즐겨보세요.</p>
			
			<button class="btn-goHome"><a href="/">홈으로 이동</a></button>
		</div>
	</div>
	
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
</body>
</html>