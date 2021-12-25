<%@page import="kr.or.iei.review.model.vo.Review"%>
<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 줍데이리뷰</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewOneFeed.css">
<link rel="stylesheet" href="/assets/css/reviewWriteForm.css">
<link rel="stylesheet" href="/assets/css/reviewSelectContent.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>

<style>
	.dot {overflow:hidden;float:left;width:12px;height:12px;background: url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/mini_circle.png');}    
	.dotOverlay {position:relative;bottom:10px;border-radius:6px;border: 1px solid #ccc;border-bottom:2px solid #ddd;float:left;font-size:12px;padding:5px;background:#fff;}
	.dotOverlay:nth-of-type(n) {border:0; box-shadow:0px 1px 2px #888;}    
	.number {font-weight:bold;color:#ee6152;}
	.dotOverlay:after {content:'';position:absolute;margin-left:-6px;left:50%;bottom:-8px;width:11px;height:8px;background:url('https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/vertex_white_small.png')}
	.distanceInfo {position:relative;top:5px;left:5px;list-style:none;margin:0;}
	.distanceInfo .label {display:inline-block;width:50px;}
	.distanceInfo:after {content:none;}
</style>
<!-- 위의 지도 부분은 카카오 지도 API에 필요한 CSS, 지도를 불러오지 못했지만 스타일은 남겨둠 -->
</head>

<body>
	
	<div id="wrap">
	
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">줍데이리뷰</p>
			</div>
		
			
		
			<%
				Review review = (Review)request.getAttribute("review");
				int currentPage = (int)request.getAttribute("currentPage");	
			%>
			
			<%if(m!=null){ %>
		
			<div id="review_writing">
				<div class="write-top">
					<div class="box-subject">
						<p><%=review.getPostTitle() %></p>
					</div>
					<div class="box-writer">
						<div class="user-img">
							<img alt="" src="/assets/images/profile.png">
						</div>
						<div class="user-name">
							<p><%=review.getNick() %></p>
							<span><%=review.getRegDate() %></span>
						</div>
					</div>
				</div>
				
				<div class="write-content">
					<div class="box-content">
						<div class="box-content-img">
							<img alt="" src="/assets/images/플로깅리뷰7.jpg">
						</div>
						<p>
						<%=review.getPostContent() %>
						<input type="hidden" name="reviewNo" value="<%=review.getPostNum() %>"/>
						<input type="hidden" name="currentPage" value="<%=currentPage%>"/>
						</p>
					</div>
					
					<div class="box-map">
						<div class="map-top">
							<i class="fas fa-map-marked-alt"></i>
							<span>지도 보기</span>
							<i class="fas fa-chevron-down"></i>
						</div>
						<div class="map-content">
							<!-- 여기가 지도html부분 -->
						</div>
					</div>
					
					<div class="box-icon">
						<i class="far fa-heart"></i><span><%=review.getGood()%></span>
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
								<p>우와 너무 멋져요 자극받고갑니다!</p>
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
								<p>한강이 플로깅하기 좋군요 참고하겠습니다 고마워요!</p>
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
								<p>와ㅠㅠ대단하세요ㅠㅠㅠㅠㅠ</p>
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
					<button class="btn-m btn-update"><a href="./reviewUpdateForm.jsp">수정</a></button>
					<button class="btn-m btn-golist"><a href="./reviewSelectAllListPage.jsp">목록</a></button>
				</div>
			</div>
			
			<%}else{%>
				<script>
					alert('해당 글이 존재하지 않습니다');
					location.replace('/review/reviewAllselect.do'); //여기 주의! 서블릿 주소 바꿔야 할 수도 있음
				</script>
			<%} %>
			
		</div> 
	
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
	
	
</body>
</html>