<%@page import="kr.or.iei.review.model.dao.ReviewDAO"%>
<%@page import="kr.or.iei.review.model.vo.Review"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 리뷰</title>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/header.css">
<link rel="stylesheet" href="/assets/commons/footer.css">
<link rel="stylesheet" href="/assets/commons/common.css">
<link rel="stylesheet" href="/assets/css/myPageMyReview.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>
<body>
	
	<div id="wrap">
		<%@ include file="/views/commons/header/header.jsp"%>
		<% if(m!=null) {%>
		<div id="content">
			<div class="user-info">
				<div class=box-title>
					<p class="tit-small">J U P : D A Y</p>
					<p class="tit-big">나의 리뷰</p>
				</div>
				<div class="basic">
					<div class="calendar">
						<%@ include file="/views/member/myPageCalendar.jsp"%>
					</div>
					
					
				<%
				HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");
				
				ArrayList<Review> list = (ArrayList<Review>)pageDataMap.get("list");
				String pageNavi = (String)pageDataMap.get("pageNavi");
				int currentPage = (int)request.getAttribute("currentPage");
				String keyword = (String)request.getAttribute("keyword"); //getParameter로도 넘기기 가능
				
				%>
			
					
					
					<div class="board">
							<%for(Review review : list) { %>
								<%-- <% if(session.getAttribute("member").equals(r.getUserId())) { %> --%>
								
								<div class="box-one-review">
									<div class="box-img">
										
										<a href="/review/reviewSelectContent.do?postNum=<%=review.getPostNum()%>&currentPage=<%=currentPage%>">
											<img alt="" src="">
										</a>
									</div>
								</div>
									
								<%--  <%} %>	 --%>
							<%} %>
							
							<div id="page_wrap">
			                   <ul class="page_ul">
			                       <li><a href=""><i class="fas fa-chevron-left"></i></a></li>
			                       <%=pageNavi %>
			                       
			                      <%-- 기존 코드는 일단 주석처리
			                       <li><a href="" class="page_active">1</a></li>
			                       <li><a href="">2</a></li>
			                       <li><a href="">3</a></li>
			                       <li><a href="">4</a></li>
			                       <li><a href="">5</a></li>
			                      --%>
			                       <li><a href=""><i class="fas fa-chevron-right"></i></a></li>
			                   	</ul>
			               	</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
		<% } else { %>
			<script>
				location.replace("/views/member/memberLogin.jsp");
			</script>
		<%}  %>

</body>
</html>