<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 로그인</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberLogin.css">
</head>

<body>
	<div class="bg-color">
		<div class="box-white">
			<div class="logo-user"><a href="/"><img src="/assets/images/jupday_logo.png" alt="줍데이로고"></a></div>
			<form action="/member/login.do" method="post" ><%--서블릿을 호출한다. 로그인 값은 get방식이 아니라 포스트  --%>
				<input type="text" class="input-login" name="userId" placeholder="아이디를 입력하세요"><br>
				<input type="password" class="input-login" name="userPwd" placeholder="비밀번호를 입력하세요"><br>
				<input type="submit" class="btn-submit" value="로그인"><br>
				<button class="btn-join"><a href="/views/member/memberJoinus.jsp">회원가입</a></button><br>
				<div class="link-search">
					<a href="/views/member/memberSearchId.jsp">아이디를 잊어버리셨나요?</a><br>
					<a href="/views/member/memberSearchPwd.jsp">비밀번호를 잊어버리셨나요?</a>
				</div>
			</form>
		</div>
	</div>
	
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
	
</body>
</html>