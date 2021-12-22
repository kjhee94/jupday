<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<%
		   Member m = (Member)session.getAttribute("member");
		%>
		
		<header id="header">
		    <div class="logo">
		        <a href="/"><img src="/assets/images/jupday_logo.png" alt="줍데이로고"></a>
		    </div>
		    <nav>
		        <ul class="gnb-list">
		            <li><a href="/views/crew/crewJoinList.jsp">줍데이크루</a>
		                <ul class="lnb-list">
		                    <li><a href="/views/crew/crewJoinList.jsp">크루 목록</a></li>
		                    <li><a href="/views/crew/crewSearchList.jsp">크루 검색</a></li>
		                    <li><a href="/views/crew/crewCreate.jsp">크루 생성</a></li>
		                </ul>
		            </li>
		            <li><a href="/views/review/reviewSelectAllListPage.jsp">줍데이리뷰</a>
		                <ul class="lnb-list">
		                    <li><a href="/views/review/reviewSelectAllListPage.jsp">리뷰 목록</a></li>
		                    <li><a href="/views/review/reviewWriteForm.jsp">리뷰 작성</a></li>
		                </ul>
		            </li>
		            <li><a href="/views/notice/noticeNews.jsp">줍데이공지</a>
		                <ul class="lnb-list">
		                    <li><a href="/views/notice/noticeNews.jsp">줍데이 소식</a></li>
		                    <li><a href="/views/notice/noticeFAQ.jsp">자주묻는 질문</a></li>
		                </ul>
		            </li>
		            <li><a href="/views/member/myPage.jsp">마이줍데이</a>
		                <ul class="lnb-list">
		                    <li><a href="/views/member/myPage.jsp">회원 정보</a></li>
		                    <li><a href="/views/member/myPageMyCrew.jsp">크루 목록</a></li>
		                    <li><a href="/views/member/myPageMyReview.jsp">리뷰 목록</a></li>
		                </ul>
		            </li>
		        </ul>
		    </nav>
		    <div class="link-user">
		    
		    	<%if(m!=null){%>
		    	
		    	<div class="box-user">
	     			<a href="/views/member/myPage.jsp"><%=m.getNick()%>님 </a>
	     			<a href="/member/logout.do">로그아웃</a><br>
				</div>
				
		    	<%}else{%>
		    	
	    		<div class="box-user">
		    		<a href="/views/member/memberLogin.jsp">로그인</a>
		        	<a href="/views/member/memberJoinus.jsp">회원가입</a>
	    		</div>
	    		
		    	<%}%>
		    </div>
		</header>