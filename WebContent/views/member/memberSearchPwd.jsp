<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 찾기</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberSearchPwd.css">
</head>

<body>
	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/views/member/memberSearchId.jsp">아이디 찾기</a>
				<a href="/views/member/memberSearchPwd.jsp">비밀번호 찾기</a>
			</div>
			<form action="">
				<input type="text" class="input-data" name="userId" placeholder="아이디 입력"> <br>
				<input type="email" class="input-data" name="email" placeholder="이메일 입력"> <br>
				<input type="submit" class="btn-searchPwd" value="비밀번호 찾기">
			</form>
			<a href="/">메인으로 가기</a>
		</div>
	</div>
	
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
</body>
</html>