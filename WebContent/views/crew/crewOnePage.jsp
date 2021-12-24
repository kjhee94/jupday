	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 게시판</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewOnePage.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class="img-crew-profile">
					<img alt="크루이미지" src="/assets/images/crew.png">
			</div>
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">오늘도 내가 해냄</p>
				<p class="txt-crew-exp">
					오늘도 해버렸지 밤샘<br>
					끝내버렸찌 코딩 함께해요..^^(광기)
				</p>
				<button>크루 가입하기</button>
			</div>
			
			<div class="box-write-search">
				<button class="btn-rec">
					<a href="./crewWriteFeed.jsp">글쓰기</a>
				</button>
				
				<div class="box-search">
					<form action="">
						<div class="select-search">
							<select>
								<option>검색필터</option>
								<option>글제목</option>
								<option>작성자</option>
							</select>
							<i class="fas fa-chevron-down icon-arrow"></i>
						</div>
						<div class="input-search">
							<i class="fas fa-search icon-search"></i>
							<input type="text" name="keyword" placeholder="검색어을 검색하세요">
						</div>
						<input type="submit" class="btn-rec" value="검색">
					</form>
				</div>
			</div>
			
			<div class="box-feed">
				<div class="list-crew-feed">
					<a href="./crewOneFeed.jsp">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>연신내 독감자</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>11</span>
							<i class="far fa-comment"></i><span>3</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
				</div>
				
				<div class="list-crew-feed">
					<a href="">
						<div class="box-writer">
							<div class="user-img">
								<img alt="" src="/assets/images/profile.png">
							</div>
							<div class="user-name">
								<p>최강주희</p>
								<span>2021.11.23</span>
							</div>
						</div>
						<div class="feed-content">
							<p>오늘 신한은행 앞에 타코야끼 트럭 있나요? </p>
						</div>
						<div class="feed-bottom">
							<i class="far fa-heart"></i><span>1,202</span>
							<i class="far fa-comment"></i><span>657</span>
						</div>
					</a>
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