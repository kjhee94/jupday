<%@page import="kr.or.iei.notice.model.vo.NoticeCampaign"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JUP:DAY | 캠페인 안내</title>
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

<%
	//Servlet에서 보내온 데이터를 가져오도록 하겠습니다.
	NoticeCampaign noticeCampaign = (NoticeCampaign)request.getAttribute("noticeCampaign");//데이터를 가져왔다.
	//noticeCampaign 안에는 두가지 상황이 있다. 
	//1. noticeCampaign 객체가 담겨있는 상황 (정상적으로 해당 글의 정보를 가져왔을때)
	//2. null이 담겨 있는  상황 (정상적으로 해당 글의 정보를 읽어오지 못했을때)
	int currentPage =(int)request.getAttribute("currentPage");


%>


	<div id="wrap">
   
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
		
<%if(noticeCampaign!=null){%>
		<div id="content">
			<div class="box-title">
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big">캠페인 안내</p>
			</div>
         
         	<div class="box-notice">
	         	<div class="notice-top">
	         		<div class="box-subject">
	         			<p><%=noticeCampaign.getCampaignTitle() %></p>
	         		</div>
	         		<div class="box-notice-info">
	         			<div class="box-gray">조회수</div>
	         			<span><%=noticeCampaign.getCampaignHits()%></span>
	         		</div>
	         		<div class="box-notice-info">
	         			<div class="box-gray">작성일</div>
	         			<span><%=noticeCampaign.getCampaignRegDate() %></span>
	         		</div>
	         	</div>
	         	
	         	<div class="box-content">
	         		<div class="img-box">
	         			<img alt="" src="/assets/images/campaign01.jpg">
	         		</div>
	         		<p> <%=noticeCampaign.getCampaignContent() %></p>
	         	</div>
         	</div>
         	
         	<div class="box-button">
         		<button class="btn-m">
	         		<a href="/notice/noticeCampaignAllSelect.do?currentPage=<%=currentPage%>">목록</a>
	         	</button>
         	</div>
         		<%}else{%>
				<script>
				  alert("해당글이 존재 하지 않습니다. 다시 확인해주세요");
				  location.replace('/notice/noticeCampaignAllSelect.do');
				</script>		
				<%} %>
        	
		</div>
      
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
	
</body>
</html>