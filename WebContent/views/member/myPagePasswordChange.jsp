<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 보안 정보 수정</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/myPagePasswordChange.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>


<body>

	<div id="wrap">
		<%@ include file="/views/commons/header/header.jsp"%>
		<div id="content">
			<div class="user-info">
				<div class=box-title>
					<p class="tit-small">J U P : D A Y</p>
					<p class="tit-big">보안 정보 수정</p>
				</div>
				<form action="/member/memberPasswordChange.do" method="post">
					<table class="info">
						<tr>
							<td>현재 비밀번호</td>
							<td><input type="password" class="input-style" name="pwd" placeholder="현재 비밀번호 입력"></td>
						</tr>
						<tr>
							<td>신규 비밀번호</td>
							<td><input type="password" class="input-style" name="new_pwd" placeholder="신규 비밀번호 입력"></td>
						</tr>
						<tr>
							<td>신규 비밀번호 재입력</td>
							<td><input type="password" class="input-style" name="new_pwd_re" placeholder="신규 비밀번호 재입력"></td>
						</tr>
						<tr>
							<td colspan="2">
								<input type="submit" class="btn-m" onclick="passwordChange();" value="변경완료">
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
	
</body>
</html>
