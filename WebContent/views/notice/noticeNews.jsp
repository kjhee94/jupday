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
<link rel="stylesheet" href="/assets/css/noticeNews.css">
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
				<button class="btn-notice on">공지사항</button>
				<button class="btn-campaine">캠페인 안내</button>
			 </div>
			
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
			 
			 <div class="container">
                <table>
                    <thead>
                        <tr>
                            <th width="100">번호</th>
                            <th width="400">제목</th>
                            <th width="100">조회수</th>
                            <th width="100">작성자</th>
                            <th width="150">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>12</td>
                            <td><div class="text-ellipsis subject">세미 프로젝트 종료 및 발표 안내</div></td>
                            <td>568</td>
                            <td>관리자</td>
                            <td>2021/12/28</td>
                        </tr>
                        <tr>
                            <td>11</td>
                            <td><div class="text-ellipsis subject">크리스마스입니다 코딩하세요</div></td>
                            <td>134</td>
                            <td>관리자</td>
                            <td>2021/12/25</td>
                        </tr>
                        <tr>
                            <td>10</td>
                            <td><div class="text-ellipsis subject">크리스마스 이브입니다 코딩하세요</div></td>
                            <td>356</td>
                            <td>관리자</td>
                            <td>2021/12/24</td>
                        </tr>
                        <tr>
                            <td>9</td>
                            <td><div class="text-ellipsis subject">깃허브 업로드 완료했습니다</div></td>
                            <td>986</td>
                            <td>관리자</td>
                            <td>2021/12/22</td>
                        </tr>
                        <tr>
                            <td>8</td>
                            <td><div class="text-ellipsis subject">여러분 라이브러리 꼭 추가하세요</div></td>
                            <td>1240</td>
                            <td>관리자</td>
                            <td>2021/12/16</td>
                        </tr>
                        <tr>
                            <td>7</td>
                            <td><div class="text-ellipsis subject">12월 줍게이 공지</div></td>
                            <td>124</td>
                            <td>관리자</td>
                            <td>2021/12/07</td>
                        </tr>
                        <tr>
                            <td>6</td>
                            <td><div class="text-ellipsis subject">점검 완료 했습니다</div></td>
                            <td>534</td>
                            <td>관리자</td>
                            <td>2021/12/04</td>
                        </tr>
                        <tr>
                            <td>5</td>
                            <td><div class="text-ellipsis subject">12월 4일 오전 4시 점검이 있을 예정입니다</div></td>
                            <td>211</td>
                            <td>관리자</td>
                            <td>2021/12/01</td>
                        </tr>
                        <tr>
                            <td>4</td>
                            <td><div class="text-ellipsis subject">11월 오늘의 리뷰 당첨자 목록</div></td>
                            <td>231</td>
                            <td>관리자</td>
                            <td>2021/11/28</td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td><div class="text-ellipsis subject">11월 줍데이 공지(+수정)</div></td>
                            <td>124</td>
                            <td>관리자</td>
                            <td>2021/11/02</td>
                        </tr>
                    </tbody>
                </table>

                <div id="page_wrap">
                    <ul class="page_ul">
                        <li><a href="javascript:"><i class="fas fa-chevron-left"></i></a></li>
                        <li><a href="javascript:" class="page_active">1</a></li>
                        <li><a href="javascript:">2</a></li>
                        <li><a href="javascript:">3</a></li>
                        <li><a href="javascript:">4</a></li>
                        <li><a href="javascript:">5</a></li>
                        <li><a href="javascript:"><i class="fas fa-chevron-right"></i></a></li>
                    </ul>
                </div>
            </div>
			 
         </div>
      </div>
      
      <!-- footer -->
      <%@ include file="/views/commons/footer/footer.jsp"%>
   </div>

</body>
</html>