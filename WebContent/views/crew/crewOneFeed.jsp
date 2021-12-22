	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 피드</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewOneFeed.css">
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
				<p class="tit-big">오늘도 내가 해냄</p>
			</div>
			
			<div class="feed-top">
				<div class="box-subject">
					<p>오늘 신한은행 앞에 타코야끼 트럭 있나요?</p>
				</div>
				<div class="box-writer">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="user-name">
						<p>연신내독감자</p>
						<span>2021.11.23</span>
					</div>
				</div>
			</div>
			
			<div class="feed-content">
				<div class="box-content">
					<p>붕어빵은 있는거 같은데 타코야끼가 안보이네요.. 혹시 사장님이 자리 옮기셨나요.. 아시는 분들은 댓글 달아주세요ㅠㅠㅠㅠㅠㅠ</p>
				</div>
				<div class="box-icon">
					<i class="far fa-heart"></i><span>좋아요 11</span>
					<i class="far fa-comment"></i><span>댓글 3</span>
				</div>
			</div>
			
			<div class="box-comment">
			
				<div class="box-one-comment">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="right-comment">
						<div class="user-comment">
							<p>최강주희<span>2021-12-06</span></p>
						</div>
						<div class="txt-comment">
							<p>사장님 자리 옮기셨대요! 어디인지는 저도 잘ㅠ</p>
						</div>
					</div>
				</div>
				
				<div class="box-one-comment">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="right-comment">
						<div class="user-comment">
							<p>연신내핵주먹<span>2021-12-06</span></p>
						</div>
						<div class="txt-comment">
							<p>국민은행 앞 쪽에서 봤습니다! </p>
						</div>
					</div>
				</div>
				
				<div class="box-one-comment">
					<div class="user-img">
						<img alt="" src="/assets/images/profile.png">
					</div>
					<div class="right-comment">
						<div class="user-comment">
							<p>난폭한오렌지<span>2021-12-06</span></p>
						</div>
						<div class="txt-comment">
							<p>붕어빵 어디서 파나요ㅠㅠㅠㅠㅠ</p>
						</div>
					</div>
				</div>
				
				<div class="box-write-comment">
					<div class="user-nick">
						<p>연신내 독감자</p>
					</div>
					<textarea placeholder="댓글을 입력하세요"></textarea>
					<button>등록</button>
				</div>
			</div>
			
			<div class="list-btn">
				<button class="btn-m btn-update"><a href="./crewUpdateFeed.jsp">수정</a></button>
				<button class="btn-m btn-golist"><a href="./crewOnePage.jsp">목록</a></button>
			</div>
			
		</div>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
		
</body>
</html>