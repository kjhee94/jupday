<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 생성</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewUpdateInfo.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>

<body>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
		
		<% if(m!=null) {%>
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">크루 생성</p>
			</div>
			
			<form id="crewInfo" action="/crew/crewCreate.do" method="post">
				<div class="box-name">
					<span>크루명</span>
					<input type="text" id="crewName" class="input-style" name="crewName" placeholder="크루명을 입력하세요(10자 이내)" maxlength="10">
				</div>
				<div class="box-explan">
					<p>크루설명</p>
					<textarea class="input-style" name="crewInfo" placeholder="크루 설명을 입력하세요"></textarea>
				</div>
				<div class="box-upload">
					<span>크루 대표 사진</span>
					<span class="file-name"></span>
					<label for="crewImg" class="btn-s">사진등록</label>
					<input type="file" id="crewImg" name="crewImg"><br>
				</div>
				<div class="box-button">
					<input type="submit" value="완료" class="btn-m">
				</div>
			</form>
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