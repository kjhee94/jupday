<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css"/>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/main.css">
<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
<script src="/assets/js/swiper.js"></script>
</head>

<body>
	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
		
		<!-- content -->
		<div id="content">
			<div class="main">
				<div class="main-img">
					<img alt="" src="/assets/images/main_image.jpg">
				</div>
				<div class="main-txt">
					<p class="main-txt-s">달리면서 실천하는 지구 살리기</p>
					<p class="main-txt-b">오늘도 줍:데이</p>
					<button class="main-btn">
						<a href="/views/review/reviewWriteForm.jsp">일지 작성하기</a>
					</button>
				</div>
			</div>
			
			<div class="box-review-best">
				<p class="tit">이달의 리뷰</p>
				
				<!-- Swiper -->
			    <div class="swiper mySwiper">
					<div class="swiper-wrapper">
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">첫 플로깅 후기입니다:)</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰1.jpeg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">아이와 함께 줍데이 했어요</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰2.png">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">플로깅 꿀팁 공유합니다!</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰3.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">동해바다 플로깅 진행했습니다</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰4.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">연신내줍데이 크루 오프만남 진행했어요!</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰5.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">계곡에서도 줍데이하기^^~</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰6.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">한강 플로깅 한달 일지</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰7.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">한강에서 줍데이하며 10kg 감량</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰8.jpg">
							</a>
						</div>
						<div class="swiper-slide">
							<a href="">
								<div class="box-review-hover">
									<p class="tit-review">플로깅 명소 추천합니다!</p>
									<i class="far fa-heart"></i><span>1,202</span>
									<i class="far fa-comment"></i><span>657</span>
									<!--<i class="far fa-comment-dots"></i>-->
								</div>
								<img alt="베스트리뷰사진" src="/assets/images/플로깅리뷰9.jpg">
							</a>
						</div>
					</div>
					<div class="swiper-button-next"></div>
					<div class="swiper-button-prev"></div>
			    </div>
			</div>
			
			<div class="box-notice">
				<p class="tit">줍데이소식</p>
				<div class="bg-grey">
				
					<div class="box-notice-button">
						<button id="notice" class="check">공지사항</button>
						<button id="campaign">캠페인안내</button>
					</div>
					
					<div class="box-notice-list">
						<div class="box-notice-one">
							<p class="tit-notice">사이트 정기점검 안내</p>
							<p class="con-notice">
								11월 서버 정기 점검일은 다음과 같이 진행될 예정입니다. 
								11월 7일(일) 새벽 2시 ~ 새벽 5시 회원님들의 많은 양해와 참고 부탁드리며 
								어쩌구어쩌구어쩌구어쩌구어쩌구어쩌구
							</p>
							<p class="date-notice">2021-11-30</p>
						</div>
						<div class="box-notice-one">
							<p class="tit-notice">사이트 정기점검 안내</p>
							<p class="con-notice">
								11월 서버 정기 점검일은 다음과 같이 진행될 예정입니다. 
								11월 7일(일) 새벽 2시 ~ 새벽 5시 회원님들의 많은 양해와 참고 부탁드리며 
								어쩌구어쩌구어쩌구어쩌구어쩌구어쩌구
							</p>
							<p class="date-notice">2021-11-30</p>
						</div>
						<div class="box-notice-one">
							<p class="tit-notice">사이트 정기점검 안내</p>
							<p class="con-notice">
								11월 서버 정기 점검일은 다음과 같이 진행될 예정입니다. 
								11월 7일(일) 새벽 2시 ~ 새벽 5시 회원님들의 많은 양해와 참고 부탁드리며 
								어쩌구어쩌구어쩌구어쩌구어쩌구어쩌구
							</p>
							<p class="date-notice">2021-11-30</p>
						</div>
					</div>
					
					<div class="box-campaign-list">
						<div class="box-notice-one">
							<p class="tit-notice">캠페인입니다</p>
							<p class="con-notice">
								이부분은 캠페인 내용이 나오는걸로
								어쩌구어쩌구어쩌구어쩌구어쩌구어쩌구
							</p>
							<p class="date-notice">2021-11-30</p>
						</div>
						<div class="box-notice-one">
							<p class="tit-notice">캠페인입니다</p>
							<p class="con-notice">
								이부분은 캠페인 내용이 나오는걸로
								어쩌구어쩌구어쩌구어쩌구어쩌구어쩌구
							</p>
							<p class="date-notice">2021-11-30</p>
						</div>
						<div class="box-notice-one">
							<p class="tit-notice">캠페인입니다</p>
							<p class="con-notice">
								이부분은 캠페인 내용이 나오는걸로
								어쩌구어쩌구어쩌구어쩌구어쩌구어쩌구
							</p>
							<p class="date-notice">2021-11-30</p>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
</body>
</html>