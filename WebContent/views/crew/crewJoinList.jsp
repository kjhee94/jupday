<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 목록</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewJoinList.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">크루 목록</p>
			</div>
			
			<div class="box-button">
				<button class="btn-created-crew on">운영크루</button>
				<button class="btn-joined-crew">가입크루</button>
			</div>
			
			<div class="area-created-crew">
			
				<div class="box-crew">
					<div class="area-img">
						<a href="./crewOnePage.jsp">
							<img alt="크루이미지" src="/assets/images/crew.png">
						</a>
					</div>
					<div class="area-bottom">
						<div class="area-txt">
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-count">
								<i class="far fa-user"></i>
								<span>37명</span>
							</div>
						</div>
						<button class="crew-setting">
							<a href="./crewSetting.jsp">설정</a>
						</button>
					</div>
				</div>
				
				<div class="box-crew">
					<button class="crew-create">
						<a href="./crewCreate.jsp">
							<i class="fas fa-plus"></i>
						</a>
					</button>
				</div>
			</div>
			
			<div class="area-joined-crew">
				<div class="box-crew">
					<div class="area-img">
						<a href="">
							<img alt="크루이미지" src="/assets/images/crew.png">
						</a>
					</div>
					<div class="area-bottom">
						<div class="area-txt">
							<p class="crew-name">연신내 줍데이</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>227명</span>
							</div>
						</div>
					</div>
				</div>
				<div class="box-crew">
					<div class="area-img">
						<a href="">
							<img alt="크루이미지" src="/assets/images/crew.png">
						</a>
					</div>
					<div class="area-bottom">
						<div class="area-txt">
							<p class="crew-name">내가 제일 잘주워</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>374명</span>
							</div>
						</div>
					</div>
				</div>
					
				<div class="box-crew">
					<button class="crew-create">
						<a href="./crewSearchList.jsp">
							<i class="fas fa-plus"></i>
						</a>
					</button>
				</div>
			</div>
		</div>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
</body>
</html>