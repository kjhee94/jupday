<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 찾기</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/css/memberSearchIdResult.css">
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
				<p>입력하신 정보와 일치하는 아이디입니다.</p>
				<div class="box-userInfo">
					<span id="userId"><%=m.getUserId()%> 님</span> 
					<span id="enrollDate"><%=m.getEnrollDate()%> 가입</span>
				</div>
			</div>
			<button class="btn-login"><a href="/views/member/memberLogin.jsp">로그인하기</a></button>
		</div>
	</div>
<%}%>
	<!-- footer -->
	<%@ include file="/views/commons/footer/footer.jsp"%>
</body>
</html>