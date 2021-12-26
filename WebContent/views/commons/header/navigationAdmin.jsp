<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

		<div id="navigation">
            <div id="logo">
                <img src="/assets/images/jupday_admin_logo.png" alt="줍데이로고">
            </div>
            
            <nav class="gnb-list">
            	<ul class="top_nav">
                    <li>
                        <span>MEMBER</span>
                    </li>
                    <li>
                        <ul class="mdl_nav">
                            <li>
								회원 정보 <i class="fas fa-chevron-down"></i>
                            </li>
                            <ul class="sub_nav">
                                <li>
                                	<a href="/admin/MemberManageList.do">· 회원 정보 관리</a>
                               	</li>
                            </ul>
                        </ul>
                    </li>
                </ul>

                
                <ul class="top_nav">
                    <li>
                        <span>BOARD</span>
                    </li>
                    <li>
                        <ul class="mdl_nav">
                            <li>
								줍데이크루 <i class="fas fa-chevron-down"></i>
                            </li>
                            <ul class="sub_nav">
                                <li>
                                    <a href="/admin/crewManageList.do">· 크루 삭제 관리</a>
                                </li>
                            </ul>
                        </ul>
                    </li>
                    
                    <li>
                        <ul class="mdl_nav">
                            <li>
                               	 줍데이리뷰 <i class="fas fa-chevron-down"></i>
                            </li>
                            <ul class="sub_nav">
                                <li>
                                    <a href="/views/admin/reviewManageList.jsp">· 리뷰게시판 관리</a>
                                </li>
                            </ul>
                        </ul>
                    </li>

                    <li>
                        <ul class="mdl_nav">
                            <li>
								줍데이공지 <i class="fas fa-chevron-down"></i>
                            </li>
                            <ul class="sub_nav">
                                <li>
                                    <a href="/views/admin/noticeManageList.jsp">· 공지사항 관리</a>
                                </li>
                                <li>
                                    <a href="/views/admin/noticeCampaignManageList.jsp">· 캠페인 안내 관리</a>
                                </li>
                                <li>
                                    <a href="/views/admin/noticeFAQManageList.jsp">· 자주 묻는 질문 관리</a>
                                </li>
                            </ul>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>