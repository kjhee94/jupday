<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자페이지 - 크루 피드 관리</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&family=Noto+Serif+KR:wght@400;500;600&display=swap" rel="stylesheet">    
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css" integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm" crossorigin="anonymous">
<link rel="stylesheet" href="/assets/commons/default.css">
<link rel="stylesheet" href="/assets/commons/adminNavigation.css">
<link rel="stylesheet" href="/assets/commons/adminCommon.css">
<link rel="stylesheet" href="/assets/css/adminBoard.css">
<script src="https://code.jquery.com/jquery-3.5.1.js" integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc=" crossorigin="anonymous"></script>
<script src="/assets/js/ui.js"></script>
</head>

<body>
    <div id="wrap">
    
        <!-- navigation -->
		<%@ include file="/views/commons/header/navigationAdmin.jsp"%>

        <div id="header">
            <div class="admin-path">
                <p>줍데이크루</p>
                <p>크루 삭제 관리</p>
                <p>크루 피드 관리</p>
            </div>

            <div class="box-user">
                <a href="/">admin님</a>
                <a href="/member/logout.do">로그아웃</a>
            </div>
        </div>

        <div id="content">
            <div class="container">
                <div class="container_top">
                    <div class="count-all">
                    	<p><span id="green">연신내 6번출구</span> > 전체 <span>7,777</span> 건</p>
                    </div>
                    
                    <div class="box-search">
						<form action="">
							<div class="select-search">
								<select>
									<option>검색필터</option>
									<option value="userId">아이디</option>
	                                <option value="nick">닉네임</option>
	                                <option value="title">제목</option>
	                                <option value="content">내용</option>
								</select>
								<i class="fas fa-chevron-down icon-arrow"></i>
							</div>
							<div class="input-search">
								<i class="fas fa-search icon-search"></i>
								<input type="text" name="search" placeholder="게시물을 검색하세요" />
							</div>
							<input type="submit" class="btn-rec" value="검색">
						</form>
					</div>
                </div>


                <div class="table_wrap">
                    <table>
                        <thead>
                            <tr>
                                <th width="200">게시번호</th>
                                <th width="300">게시글제목</th>
                                <th width="300">게시글내용</th>
                                <th width="300">작성자</th>
                                <th width="200">조회수</th>
                                <th width="200">좋아요</th>
                                <th width="200">작성일자</th>
                                <th width="150">삭제 / 복원</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="del_btn">삭제</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="re_btn">복원</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="del_btn">삭제</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="del_btn">삭제</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="re_btn">복원</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="re_btn">복원</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="re_btn">복원</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="del_btn">삭제</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="del_btn">삭제</button></td>
                            </tr>
                            <tr>
                                <td>10</td>
                                <td><div class="text-ellipsis subject">드디어 연신내로 넘어왔다</div></td>
                                <td><div class="text-ellipsis">은평구 살 때 행복했어요</div></td>
                                <td>gramnotebook</td>
                                <td>56</td>
                                <td>30</td>
                                <td>2021/11/11</td>
                                <td><button class="del_btn">삭제</button></td>
                            </tr>
                        </tbody>
                    </table>

                    <div id="page_wrap">
                        <ul class="page_ul">
					        <%=pageNavi %>
                        </ul>
                    </div>                    
                    
                </div>
            </div>
        </div>
        
        <footer id="footer">
            <p>2021 ⓒ JUP DAY</p>
        </footer>
    </div>
</body>
</html>
