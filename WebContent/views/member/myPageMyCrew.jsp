<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 크루</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/myPageMyCrew.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>

<!--
<c:choose>

<c:when test="">
	<c:forEach>
	</c:forEach>
</c:when>
<c:otherwise>

</c:otherwise>

</c:choose>
 -->
	
	
	<div id="wrap">
		<%@ include file="/views/commons/header/header.jsp"%>
		<% if(m!=null) {%>
		<div id="content">
			<div class="user-info">
				<div class=box-title>
					<p class="tit-small">J U P : D A Y</p>
					<p class="tit-big">크루 정보</p>
				</div>
				<div>
					<div class="info">
						<div class="manage-crew">
							<div class="tit-manage-crew">운영 크루</div>
							<table>
								<!-- 
								if(데이터 있을떄) {
									for() {
										<tr>
										
										</tr>
									}
								} else {
								<tr>
									<td colspan="3">
									크루가 업습니다.
									</td>
								</tr>
								}
								 -->
							 	<!-- jstl core library : c:forEach -->
								<tr>
									<td rowspan="2" class="manage-crew-img">image</td>
									<td class="manage-crew-name"> < % = % ></td>
									<td rowspan="2" class="manage-crew-set"><button class="btn-s"><a href="">크루 설정</a></button></td>
								</tr>
								<tr>
									<td class="manage-crew-sysdate"> < % = % ></td>
								</tr>
							</table>
						</div>
						
						<div class="join-crew">
								<div class="tit-join-crew">가입 크루</div>
								<table>
								<tr>
									<td rowspan="2" class="join-crew-img">image</td>
									<td class="join-crew-name"> < % = % ></td>
									<td rowspan="2" class="join-crew-set"><button class="btn-s"><a href="">크루 탈퇴</a></button></td>
								</tr>
								<tr>
									<td class="join-crew-sysdate"> < % = % ></td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
		<% } else { %>
			<script>
				location.replace("/views/member/memberLogin.jsp");
			</script>
		<%}  %>

</body>
</html>