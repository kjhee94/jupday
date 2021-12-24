<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 줍데이 소식</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/noticeCampaign.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>

<body>

   <div id="wrap">
   
      <!-- header -->
      <%@ include file="/views/commons/header/header.jsp"%>

      <div id="content">
         <div class="box-title">
            <p class="tit-small">J U P : D A Y</p>
            <p class="tit-big">줍데이소식</p>
         </div>
         
         <div class="notice-top">
         	 <div class="box-button">
				<button class="btn-notice">
					<a href="./noticeNews.jsp">공지사항</a>
				</button>
				<button class="btn-campaign">
					<a href="./noticeCampaign.jsp">캠페인 안내</a>
				</button>
			 </div>
		 </div>
		
        <div class="area-campaign">
        	<div class="box-search">
				<form action="">
					<div class="select-search">
						<select>
							<option>검색필터</option>
							<option>글제목</option>
							<option>글내용</option>
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
			 
			 <div class="box-campaign-list">
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign01.jpg">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>온라인싹쓰리 챌린지 1탄 싹줍깅</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign02.png">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>우리의 미래숲을 위한 '쓰담달리기'</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign03.jpg">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>싹줍깅 봉사활동</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign04.jpg">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>우리동네 쓰담쓰담</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign05.jpg">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>생활 속 지구 지킴 줍깅 챌린지</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign06.jpg">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>어스 앤 런</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign07.png">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>지구를 살리는 플로깅하세요</p>
				 			<p>2021.11.05</p>
				 		</div>
			 		</a>
			 	</div>
			 	
			 	<div class="box-campaign">
			 		<a href="noticeCampaineContent.jsp">
			 			<div class="img-campaign">
				 			<img alt="" src="/assets/images/campaign08.png">
				 		</div>
				 		<div class="txt-campaign">
				 			<p>옹기종기 축제 플로깅 챌린지</p>
				 			<p>2021.11.05</p>
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
         
         
      </div>
      
      <!-- footer -->
      <%@ include file="/views/commons/footer/footer.jsp"%>
   </div>

</body>
</html>