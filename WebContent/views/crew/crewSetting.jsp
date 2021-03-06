<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 설정</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewSetting.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>
	
	<%
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
	%>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<% if(m!=null) {%>
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">크루 설정</p>
			</div>
			
			<div class="list-setting">
				<p><a href="/crew/crewValue.do?crewNo=<%=crewNo%>">크루 정보 수정</a></p>
				<p><a href="/crew/crewJoinApprove.do?crewNo=<%=crewNo%>">크루 가입 승인</a></p>
				<p><a href="/crew/crewDeleteName.do?crewNo=<%=crewNo%>">크루 삭제</a></p>
			</div>
			
			<div class="box-btn">
				<button class="btn-m">
					<a href="/crew/crewJoinList.do">완료</a>
				</button>
			</div>
		</div>
		
		<% } else { %>
			<script>
				location.replace("/views/member/memberLogin.jsp");
			</script>
		<%}  %>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
	
</body>
</html>