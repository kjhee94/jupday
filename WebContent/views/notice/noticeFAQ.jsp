<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>자주 묻는 질문</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<!-- <link rel="stylesheet" href="/assets/commons/notice.css"> -->
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/header.js"></script>
<script src="/assets/js/notice2.js"></script>

<style>
	#content {
	
	}
	.faq-all-box {
	   width: 100%;
	   height: auto;
	   overflow: hidden;
	   padding-bottom: 80px;
	}
	.faq-box {
		width: 100%;
		height: auto;
		overflow: hidden;
		border-bottom: 1px solid #c8c8c8;
	}
	
	.question-box {
	   width: 100%;
	   height: 90px;
	   margin: 0px auto;
	   font-size: 18px;
	   padding: 30px;
	   box-sizing: border-box;
	   cursor : pointer;
	}
	
	.question-box>i {
	   font-size: 18px;
	   margin-right: 30px;
	   
	}
	.question-box>p {
		margin-top: 5px;
		display: inline-block;
	}
	
	.answer-box {
	   width: 100%;
	   height: 150px;
	   margin-left: 70px;
	   display: none;
	}

</style>
</head>
<body>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class="box-title">
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">자주 묻는 질문</p>
			</div>
			
			   <div class="faq-all-box">
      
	         <div class="faq-box">
	         	<div class="question-box" id="que-1">
	            	<i class="fas fa-chevron-down" id="que-1-toggle"></i> 
	               <p>크루 가입시 어떻게 해야 하나요?</p>
	            </div>
	            <div class="answer-box" id="ans-1">
	            	<p>원하는 크루를 검색해서 가입하기 버튼을 누른 뒤<br>
	            	크루장의 승인을 받으면 크루에 가입할 수 있습니다.</p>
	            </div>
	         </div>
	         
	      <div class="faq-box">
	         <div class="question-box" id="que-2">
	            <i class="fas fa-chevron-down" id="que-2-toggle"></i> 
	               <p>크루 생성은 어떻게 하나요?</p>
	         </div>
	         <div class="answer-box" id="ans-2">
	            	<p>[줍데이크루]에 들어가신 후 <br>
	            	원하시는 크루를 생성해주시면 됩니다. :)</p>
	            </div>
	      </div>
	         
	      <div class="faq-box">  
	         <div class="question-box" id="que-3">
	            <i class="fas fa-chevron-down" id="que-3-toggle"></i> 
	               <p>비밀번호를 변경하려면 어떻게 해야 하나요?</p>
	            <div class="answer-box" id="ans-3">
	            	<p>[마이페이지]에 들어가시면 비밀번호를 변경할 수 있습니다.</p>
	            </div>
	         </div>
	      </div>     

	      <div class="faq-box">  	      
	         <div class="question-box" id="que-4">
	            <i class="fas fa-chevron-down" id="que-4-toggle"></i> 
	               <p>크루 생성시 어떻게 해야 하나요?</p>
	            <div class="answer-box" id="ans-4">
	            	<p>[줍데이크루]에 들어가신 후 원하시는 크루를 생성해주시면 됩니다. :)</p>
	            </div>
	         </div>
	      </div>
	      
	      <div class="faq-box">  	      
	         <div class="question-box" id="que-5">
	            <i class="fas fa-chevron-down" id="que-5-toggle"></i> 
	               <p>크루장은 회원탈퇴를 어떻게 하나요?</p>
	            <div class="answer-box" id="ans-5">
	            	<p>탈퇴시 [크루장]이 아닌 상태여야하기에 [크루탈퇴]를 하시거나 [크루삭제] 후 탈퇴가 가능합니다.</p>
	            </div>
	         </div>
	      </div>
	       
	      <div class="faq-box">  	         
	         <div class="question-box" id="que-6">
	            <i class="fas fa-chevron-down" id="que-6-toggle"></i> 
	               <p>캠페인을 직접 열 수 있나요?</p>
	            <div class="answer-box" id="ans-6">
	            	<p>원하신다면 직접 주최가 가능합니다.</p>
	            </div>
	         </div>
	      </div>
	      
	     <div class="faq-box">   
	         <div class="question-box" id="que-7">
	            <i class="fas fa-chevron-down" id="que-7-toggle"></i>
	                <p>크루 가입시 어떻게 해야 하나요?</p>
	            </div>
	            <div class="answer-box" id="ans-7">
	            	<p>원하는 크루를 검색해서 가입하기 버튼을 누른 뒤 크루장의 승인을 받으면 크루에 가입할 수 있습니다.</p>
	            </div>
		 </div>	         

	      <div class="faq-box">  
	         <div class="question-box" id="que-8">
	          <i class="fas fa-chevron-down" id="que-8-toggle"></i> 
	               <p>질문8</p>
	            <div class="answer-box" id="ans-8">
	            	<p>[줍데이크루]에 들어가신 후 원하시는 크루를 생성해주시면 됩니다. :)</p>
	            </div>
	         </div>
  		  </div>	         
  		  
	      <div class="faq-box">  
	         <div class="question-box" id="que-9">
	         <i class="fas fa-chevron-down" id="que-9-toggle"></i> 
	               <p>9번 질문</p>
	            <div class="answer-box" id="ans-9">
	            	<p>[줍데이크루]에 들어가신 후 원하시는 크루를 생성해주시면 됩니다. :)</p>
	            </div>
	         </div>
	   	  </div>
	   	  
	   	  <div class="faq-box">      
	         <div class="question-box" id="que-10">
	        <i class="fas fa-chevron-down" id="que-10-toggle"></i> 
	               <p>10번 질문</p>
	            <div class="answer-box" id="ans-10">
	            	<p>[줍데이크루]에 들어가신 후 원하시는 크루를 생성해주시면 됩니다. :)</p>
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