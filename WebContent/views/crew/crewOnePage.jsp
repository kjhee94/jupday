	<%@page import="kr.or.iei.crew.model.vo.CrewMember"%>
<%@page import="kr.or.iei.crew.model.vo.CrewBoard"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.iei.crew.model.vo.Crew"%>
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

	<%
		Crew c = (Crew)request.getAttribute("crew");
		CrewMember cm = (CrewMember)request.getAttribute("crewMember");
		HashMap<String,Object> pageDataMap = (HashMap<String,Object>)request.getAttribute("pageDataMap");	

		int currentPage = (int)request.getAttribute("currentPage");
		int currentFeedPage = (int)request.getAttribute("currentFeedPage");
		
		ArrayList<CrewBoard> list = (ArrayList<CrewBoard>)pageDataMap.get("list");
		String pageNavi = (String)pageDataMap.get("pageNavi");
		
		String keyword = (String)request.getAttribute("keyword");
		String type = (String)request.getAttribute("type");
	%>

	<div id="wrap">
		<!-- header -->
		<%@ include file="/views/commons/header/header.jsp"%>
			
		<div id="content">
			<div class="img-crew-profile">
				<%if(c.getCrewImg()!=null) { %>
				<img alt="크루이미지" src="/upload/<%=c.getCrewImg()%>.png">
				<%}else { %>
				<img alt="크루이미지" src="/assets/images/crew.png">
				<%} %>
			</div>
			<div class=box-title>
				<p class="tit-small">J U P : D A Y</p>
				<p class="tit-big"><%=c.getCrewName() %></p>
				<p class="txt-crew-exp">
					<%=c.getCrewInfo() %>
				</p>
				<%if(cm!=null && cm.getCrewAuthorityId().equals("크루장")) {%>
					<button><a href="/views/crew/crewSetting.jsp?crewNo=<%=c.getCrewNo()%>">크루 설정</a></button>
				<%}else { %>
					<%if(cm!=null && cm.getCrewJoinState().equals("SUCCESS") && cm.getCrewEndYN()=='N') { %>
						<button><a href="/crew/crewWithdraw.do?crewNo=<%=c.getCrewNo()%>&currentPage=<%=currentPage%>">크루 탈퇴하기</a></button>
					<%}else if(cm!=null && cm.getCrewJoinState().equals("WAIT") && cm.getCrewEndYN()=='N') { %>
						<button class="btn-click-non">가입 승인 중</button>
					<%}else { %>
						<button><a href="/crew/crewJoin.do?crewNo=<%=c.getCrewNo()%>&currentPage=<%=currentPage%>">크루 가입하기</a></button>
					<%} %>
				<%} %>
				
			</div>
			
			<div class="box-write-search">
			
				<%if(cm!=null && cm.getCrewJoinState().equals("SUCCESS") && cm.getCrewEndYN()=='N') { %>
					<button class="btn-rec">
						<a href="/views/crew/crewWriteFeed.jsp?crewNo=<%=c.getCrewNo()%>&currentPage=<%=currentPage %>&crewName=<%=c.getCrewName()%>">글쓰기</a>
					</button>
				<%}else { %>
					<button class="btn-rec alertJoin">글쓰기</button>
				<%} %>
				
				<div class="box-search">
					<form action="/crew/crewFeedSearch.do" method="get">
						<div class="select-search">
							<select name="type">
								<option>검색필터</option>
								<option value="subject">제목</option>
								<option value="writer">작성자</option>
								<option value="all">제목+작성자</option>
							</select>
							<i class="fas fa-chevron-down icon-arrow"></i>
						</div>
						<div class="input-search">
							<i class="fas fa-search icon-search"></i>
							<input type="text" name="keyword" placeholder="검색어를 입력하세요">
						</div>
						<input type="hidden" name="crewNo" value="<%=c.getCrewNo() %>">
						<input type="hidden" name="currentPage" value="<%=currentPage %>">
						<input type="submit" class="btn-rec" value="검색">
					</form>
				</div>
			</div>
			
			<div class="box-feed">
				
				<%for(CrewBoard cb : list) {%>
					<%if(cm!=null && cm.getCrewJoinState().equals("SUCCESS") && cm.getCrewEndYN()=='N') { %>
						<div class="list-crew-feed">
							<a href="/crew/crewOneFeed.do?crewNo=<%=cb.getCrewNo()%>&currentPage=<%=currentPage %>&feedNo=<%=cb.getFeedNo()%>&currentFeedPage=<%=currentFeedPage%>">
								<div class="box-writer">
									<div class="user-img">
										<%if(cb.getWriterImg()!=null) { %>
										<img alt="프로필사진" src="/upload/<%=cb.getWriterImg()%>.png">
										<%}else { %>
										<img alt="프로필사진" src="/assets/images/profile.png">
										<%} %>
										
									</div>
									<div class="user-name">
										<p><%=cb.getWriter() %></p>
										<span><%=cb.getFeedRegdate() %></span>
									</div>
								</div>
								<div class="feed-content">
									<p><%=cb.getFeedSubject() %></p>
								</div>
								<div class="feed-bottom">
									<i class="far fa-heart"></i><span><%=cb.getFeedLikeCount() %></span>
									<i class="far fa-comment"></i><span><%=cb.getFeedCommentCount() %></span>
								</div>
							</a>
						</div>
					<%}else {%>
						<div class="list-crew-feed alertJoin">
							<div class="box-writer">
								<div class="user-img">
									<%if(cb.getWriterImg()!=null) { %>
									<img alt="프로필사진" src="/upload/<%=cb.getWriterImg()%>.png">
									<%}else { %>
									<img alt="프로필사진" src="/assets/images/profile.png">
									<%} %>
									
								</div>
								<div class="user-name">
									<p><%=cb.getWriter() %></p>
									<span><%=cb.getFeedRegdate() %></span>
								</div>
							</div>
							<div class="feed-content">
								<p><%=cb.getFeedSubject() %></p>
							</div>
							<div class="feed-bottom">
								<i class="far fa-heart"></i><span><%=cb.getFeedLikeCount() %></span>
								<i class="far fa-comment"></i><span><%=cb.getFeedCommentCount() %></span>
							</div>
						</div>
					<%} %>
				<%} %>
				
			</div>
			
			<div id="page_wrap">
		        <ul class="page_ul">
		            <%=pageNavi %>
		        </ul>
		    </div>
		</div>
		
		
		<!-- footer -->
		<%@ include file="/views/commons/footer/footer.jsp"%>
	</div>
		
</body>
</html>