<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 크루 피드 수정</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewWriteFeed.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/header.js"></script>
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
			
			<form action="">
				<div class="box-write">
					<div class="box-subject">
						<input type="text" placeholder="제목을 입력하세요" value="오늘 신한은행 앞에 타코야끼 트럭 있나요? ">
					</div>
					<div class="box-content">
						<textarea placeholder="내용을 입력하세요">붕어빵은 있는거 같은데 타코야끼가 안보이네요.. 혹시 사장님이 자리 옮기셨나요.. 아시는 분들은 댓글 달아주세요ㅠㅠㅠㅠㅠㅠ</textarea>
					</div>
					<div class="box-upload">
						<label for="upload">
							<i class="far fa-image"></i>
							<span>사진첨부</span>
						</label>
						<input type="file" id="upload">
					</div>
				</div>
				<div class="box-button">
					<input type="submit" value="수정" class="btn-m">
					<button class="btn-m"><a href="./crewOneFeed.jsp">취소</a></button>
				</div>
			</form>
			
		</div>
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>

</body>
</html>