<%@page import="kr.or.iei.member.model.vo.Member"%>
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
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberSearchPwdResult.css">
</head>

<body>

<%
   Member m = (Member)session.getAttribute("member");
%>

<%if(m!=null){%>
	<div class="bg-color">
		<div class="box-white">
			<div class="tab-search">
				<a href="/views/member/memberSearchId.jsp">아이디 찾기</a>
				<a href="/views/member/memberSearchPwd.jsp">비밀번호 찾기</a>
			</div>
			<div class="box-result">
				<p>비밀번호 재설정</p>
				<form action="">
					<input type="password" class="input-style" name="userPwd" placeholder="비밀번호 입력"> <br>
					<input type="password" class="input-style" name="userPwdRe" placeholder="비밀번호 확인"> <br>
					<input type="submit" class="btn-login" value="재설정">
				</form>
				
			</div>
			
		</div>
	</div>
	<%}%>
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
</body>
</html>