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
		
			<div id="review_writing">
				<div class="write-top">
					<div class="box-subject">
						<p>한달 플로깅 일지</p>
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
				
				<div class="write-content">
					<div class="box-content">
						<div class="box-content-img">
							<img alt="" src="/assets/images/플로깅리뷰7.jpg">
						</div>
						<p>
						먼저, 텍스트 밑줄 기능이 개선됐다. 
						영어 알파벳 p, q, j, y 와 같이 글자의 일부 획이 눈에 보이지는 않지만 실제로는 존재하는 가로 기준선 아래로 내려가는 디센더(Descender) 글자라도 텍스트 아래에 일정한 공간을 두고 밑줄이 그어질 수 있도록 했다. 
						기존에는 텍스트 밑줄이 기준선에 맞춰 그어져, 디센더 글자는 밑줄 아래로 일부 획이 넘어가 디자인 상 세련되지 못했다. 
						지금은 속성창의 텍스트 세션에서 기능을 바로 선택하거나, 단축기(CMD+U와 CTRL+U)를 사용하면, 텍스트에 밑줄을 넣을 수 있다.
						또, 오브젝트 종류와 관계없이 획(스트로크, Stoke)의 위치와 정렬도 조정할 수 있다. 
						과거에는 직사각형과 타원의 경우에는 인사이드 획만 수정했고, 경로(path), 선(lines), 불리언(Boolean) 등은 센터 획을 수정할 수 있었다. 
						이번 업데이트로 아웃사이드, 인사이드, 센터 획 등을 모두 조절할 수 있다. 
						이를 통해, 디자이너는 오브젝트의 테두리를 더욱 정교하게 다듬을 수 있다.
						디자인 사양(베타) 기능도 강화됐다. 
						디자인 사양(베타)는 디자이너와 개발자가 어도비 XD에서 링크공유를 통해 실시간 커뮤니케이션할 수 있는 프로토 타입이다. 
						이번 업데이트를 통해, 개발자는 아트 보드의 순서, 흐름, 색상, 글자 스타일 등 각 디자인을 개발하는데 필요한 정보를 바로 얻을 수 있다. 
						또, 디자인 사양(베타)은 한국어, 일본어, 프랑스어, 독일어 등 어도비 XD CC가 지원하는 모든 언어로 제공된다. 
						디자이너는 이제 디자인 사양 웹 링크에서 해당 언어를 설정하면 되며, 개발자는 자신이 브라우저에서 설정한 언어로 공유 받은 사양을 확인할 수 있다.
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
			
		</div> 
	
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
	
	
</body>
</html>