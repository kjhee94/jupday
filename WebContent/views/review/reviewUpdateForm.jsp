<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 리뷰 수정</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/crewWriteFeed.css">
<link rel="stylesheet" href="/assets/css/reviewWriteForm.css">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=aa153422867c293a7226f0c302b5e6b3"></script>
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
</head>

<body>
	
	<div id="wrap">
	
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">리뷰 수정</p>
			</div>
			
			<div id="review_writing">
				<form action="">
					<div class="box-write">
						<div class="box-subject">
							<input type="text" placeholder="제목을 입력하세요" value="한달 플로깅 일지">
						</div>
						<div class="box-content">
							<textarea placeholder="내용을 입력하세요">
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
							</textarea>
						</div>
						<div class="box-upload">
							<label for="upload">
								<i class="far fa-image"></i>
								<span>사진첨부</span>
							</label>
							<input type="file" id="upload">
						</div>
						<div class="box-map">
							<div class="map-top">
								<i class="fas fa-map-marked-alt"></i>
								<span>위치추가</span>
								<i class="fas fa-chevron-down"></i>
							</div>
							<div class="map-content">
								<!-- 여기가 지도html부분 -->
							</div>
						</div>
					</div>
					<div class="box-button">
						<input type="submit" value="수정" class="btn-m">
						<button class="btn-m"><a href="./reviewSelectAllListPage.jsp">목록</a></button>
					</div>
				</form>
			</div>
			
		</div> 
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>	
	</div>
	
</body>
</html>