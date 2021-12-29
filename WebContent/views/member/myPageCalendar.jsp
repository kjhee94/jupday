<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.member.controller.MyPageCalendarServlet"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>달력</title>

<link rel="stylesheet" href="/assets/css/myPageCalendar.css">

</head>
<body>
	<%
		String[] dayArr = (String[])request.getAttribute("dayArr");
	
		// 컴퓨터 시스템의 년, 월 받아오기
		Date date = new Date();
		int year = date.getYear() + 1900;
		int month = date.getMonth() + 1;

		//	오류사항 걸러주기	
		try {
			year = Integer.parseInt(request.getParameter("year"));
			month = Integer.parseInt(request.getParameter("month"));

			if (month >= 13) {
				year++;
				month = 1;
			} else if (month <= 0) {
				year--;
				month = 12;
			}
		} catch (Exception e) {

		}
	%>
	<div>
		<!-- 달력 만들기 -->
		<table>
			<tr>
				<!-- 이전달 버튼 -->
				<th>
	 				<input type="image" class="button" src="/assets/images/navi_pre.png" onclick="location.href='/member/myPageMyReview.do?year=<%=year%>&month=<%=month - 1%>'">
				</th>
				<!-- 제목 -->
				<th id="title" colspan="5"><%=month %>월의 줍데이</th>
	
				<!-- 다음달 버튼 -->
				<th>
					<input type="image" class="button" src="/assets/images/navi_next.png" onclick="location.href='/member/myPageMyReview.do?year=<%=year%>&month=<%=month + 1%>'">
				</th>
			</tr>
			
			<tr>
				<td colspan="7" class="total-data">오늘도 JUB:DAY와 함께해주셔서 감사합니다.</td>
			</tr>
			
			<!-- 요일 표시칸 -->
			<tr>
				<td class="etcday">일</td>
				<td class="etcday">월</td>
				<td class="etcday">화</td>
				<td class="etcday">수</td>
				<td class="etcday">목</td>
				<td class="etcday">금</td>
				<td class="etcday">토</td>
			</tr>
	
			<!-- 날짜 집어 넣기 -->
			<tr>
				<%
					//	1일의 요일을 계산 (자주 쓰이기 때문에 변수로 선언)
					int first = MyPageCalendarServlet.weekDay(year, month, 1);
			
					//	1일이 출력될 위치 전에 전 달의 마지막 날짜들을 넣어주기위해 전 달 날짜의 시작일을 계산.
					int start = 0;
					start = month == 1 ? MyPageCalendarServlet.lastDay(year - 1, 12) - first : MyPageCalendarServlet.lastDay(year, month - 1) - first;
			
					//	1일이 출력될 위치를 맞추기 위해 1일의 요일만큼 반복하여 전 달의 날짜를 출력.
					for (int i = 1; i <= first; i++) {
						out.println("<td class = 'before'>" + ++start + "</td>");
					}
					
					
					int stampDay = 0;
					/* 1일부터 달력을 출력한 달의 마지막 날짜까지 반복하며 날짜를 출력 */
					for (int i = 1; i <= MyPageCalendarServlet.lastDay(year, month); i++) {
						for(int j = 0; j < dayArr.length; j++) {
							if(dayArr[j].equals(Integer.toString(i))) {
								stampDay = Integer.parseInt(dayArr[j]);
								// Stamp icon
								out.println("<td class ='etc'> <img src='/assets/images/stamp.png' style='width:50px;'> </td>");
							}
						}
						// 요일 출력
						if(stampDay != i) {
							out.println("<td class ='etc'>" + i + "</td>");
						}
							
						// 출력한 날짜(i)가 토요일이고 그달의 마지막 날짜이면 줄을 바꿔주기
						if (MyPageCalendarServlet.weekDay(year, month, i) == 6 && i != MyPageCalendarServlet.lastDay(year, month)) {
							out.println("</tr><tr>");
						}
					}
					if (MyPageCalendarServlet.weekDay(year, month, MyPageCalendarServlet.lastDay(year, month)) != 6) {
						for (int i = MyPageCalendarServlet.weekDay(year, month, MyPageCalendarServlet.lastDay(year, month)) + 1; i < 7; i++) {
							out.println("<td></td>");
						}
					}
				%>
			</tr>
		</table>
	</div>
	
</body>
</html>