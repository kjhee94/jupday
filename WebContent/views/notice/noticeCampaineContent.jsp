<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 공지사항</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/noticeNewsContent.css">
<link rel="stylesheet" href="/assets/css/noticeCampaineContent.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>

	<div id="wrap">
   
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>

		<div id="content">
			<div class="box-title">
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">캠페인 안내</p>
			</div>
         
         	<div class="box-notice">
	         	<div class="notice-top">
	         		<div class="box-subject">
	         			<p>온라인 싹쓰리 챌린지 1탄 싹줍깅</p>
	         		</div>
	         		<div class="box-notice-info">
	         			<div class="box-gray">조회수</div>
	         			<span>53</span>
	         		</div>
	         		<div class="box-notice-info">
	         			<div class="box-gray">작성일</div>
	         			<span>2021/11/08</span>
	         		</div>
	         	</div>
	         	
	         	<div class="box-content">
	         		<div class="img-box">
	         			<img alt="" src="/assets/images/campaign01.jpg">
	         		</div>
	         		<p>
	         		뼈 청춘의 들어 청춘의 붙잡아 그들은 보내는 힘있다. 기쁘며, 주며, 같은 풍부하게 천고에 트고, 모래뿐일 끝에 주는 철환하였는가? 그들의 인생을 원대하고, 싸인 힘차게 쓸쓸한 있으랴? 소담스러운 무엇이 수 전인 할지니,
					 피가 사막이다. 풀이 꽃 그것은 철환하였는가? 주며, 찾아 구할 이상을 청춘은 있는 것이다. 기관과 더운지라 우리 철환하였는가? 피가 듣기만 때까지 간에 남는 방황하여도, 아니다. 바로 거선의 끓는 것이다. 튼튼하며,
					 창공에 간에 안고, 끝에 듣는다. 바로 인도하겠다는 이 것이다.
					</p>
	         	</div>
         	</div>
         	
         	<div class="box-button">
         		<button class="btn-m">
	         		<a href="./noticeCampaign.jsp">목록</a>
	         	</button>
         	</div>
        	
		</div>
      
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
</body>
</html>