<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 가입 승인</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewJoinApprove.css">
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
				<p class="tit-big">크루 가입 승인</p>
			</div>
			
			<div class="applicants">
				<div class="box-applicant">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="user-name">
						<p>최강주희</p>
						<span>가입신청 : 2021.11.23</span>
					</div>
					<div class="box-approval">
						<button>수락</button>
						<button>거절</button>
					</div>
				</div>
				
				<div class="box-applicant">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="user-name">
						<p>최강주희</p>
						<span>가입신청 : 2021.11.23</span>
					</div>
					<div class="box-approval">
						<button>수락</button>
						<button>거절</button>
					</div>
				</div>
				
				<div class="box-applicant">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="user-name">
						<p>최강주희</p>
						<span>가입신청 : 2021.11.23</span>
					</div>
					<div class="box-approval">
						<button>수락</button>
						<button>거절</button>
					</div>
				</div>
				
				<div class="box-applicant">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="user-name">
						<p>최강주희</p>
						<span>가입신청 : 2021.11.23</span>
					</div>
					<div class="box-approval">
						<button>수락</button>
						<button>거절</button>
					</div>
				</div>
			</div>
			
			<div class="box-btn">
				<button class="btn-m">
					<a href="./crewSetting.jsp">완료</a>
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