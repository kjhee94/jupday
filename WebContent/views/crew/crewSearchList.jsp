<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 검색</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewSearchList.css">
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
				<p class="tit-big">크루 검색</p>
			</div>
			
			<div class="search-bar">
				<form action="">
					<div class="box-input">
						<i class="fas fa-search"></i>
						<input type="text" name="keyword" placeholder="크루명을 검색하세요">
						<input type="submit" value="검색하기">
					</div>
				</form>
			</div>
			
			<div class="list-crew-all">
				<div class="box-crew">
					<div class="area-img">
						<a href="">
							<img alt="크루이미지" src="/assets/images/crew.png">
						</a>
					</div>
					<div class="area-bottom">
						<div class="area-txt">
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
							</div>
						</div>
					</div>
				</div>
				
				<div class="box-crew">
					<div class="area-img">
						<a href="">
							<img alt="크루이미지" src="/assets/images/crew2.png">
						</a>
					</div>
					<div class="area-bottom">
						<div class="area-txt">
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
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
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
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
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
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
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
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
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
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
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
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
							<p class="crew-name">오늘도 내가 해냄</p>
							<div class="crew-m-number">
								<i class="far fa-user"></i>
								<span>37명</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			
			<div id="page_wrap">
		        <ul class="page_ul">
		            <li><a href=""><i class="fas fa-chevron-left"></i></a></li>
		            <li><a href="" class="page_active">1</a></li>
		            <li><a href="">2</a></li>
		            <li><a href="">3</a></li>
		            <li><a href="">4</a></li>
		            <li><a href="">5</a></li>
		            <li><a href=""><i class="fas fa-chevron-right"></i></a></li>
		        </ul>
		    </div>
		</div>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
</body>
</html>