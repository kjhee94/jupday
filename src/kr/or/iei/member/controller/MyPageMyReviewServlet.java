package kr.or.iei.member.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.review.model.service.ReviewService;
import kr.or.iei.review.model.service.ReviewServiceImpl;
import kr.or.iei.review.model.vo.Review;

/**
 * Servlet implementation class MyPageMyReviewServlet
 */
@WebServlet("/member/myPageMyReview.do")
public class MyPageMyReviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPageMyReviewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Member m = (Member)session.getAttribute("member");
		
		if(m!=null) {
		
		//main 페이지에서 가므로 일단은 null값을 가지고 감, 그래서 currentPage는 일단 1로 잡음
		int currentPage;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//요청한 페이지값을 가지고 service로 감
		// 이게 오른쪽에 있는 애들 불러오는 로직
		String userId = ((Member)session.getAttribute("member")).getUserId();
		
		ReviewService rService = new ReviewServiceImpl();
		HashMap<String, Object> pageDataMap = rService.selectSearchPost(currentPage, userId);

		/*Review review = rService.memberReview(userId);*/
		
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		
		

		if("13".equals(month)) {
			month = "01";
		}
		
		if("0".equals(month)) {
			month = "12";
		}
		
		Date date = new Date();
		if(year == null) {
			year = Integer.toString(date.getYear() + 1900);
		}
		if(month == null) {
			month = Integer.toString(date.getMonth()+1);
		}
		
		System.out.println(" year : " + year);
		System.out.println(" month : " + month);
		
		// month가 한자리일 때 [ 1월, 2월 ... ]
		if(month.length() == 1) {
			month = "0" + month;
		}

		String startDate = year + month;
		String endDate = "";
		
		// 12월에 대한 cal 가져올 때
		
		if("12".equals(month)) {
			year = Integer.toString(Integer.parseInt(year) + 1); 
			month = "01";
			endDate = year + month;
		} else {
			if(month.length() == 1) {
				month = "0" + Integer.toString(Integer.parseInt(month) + 1);
			}
			endDate = year + month;
		}
		
		/*switch(month) {
			case "12":
				System.out.println("12월");
				break;
			case "11":
			case "10":
			case "9":
			case "8":
			case "7":
			case "6":
			case "5":
			case "4":
			case "3":
			case "2":
			case "1":
		}*/
		
		
		
		System.out.println("start Date : " + startDate);
		System.out.println("end Date : " + endDate);
		
		// 원하는 달의 리뷰 전체
		ArrayList<Review> list = rService.selectMonthStamp(userId, startDate, endDate);
		
		String[] dayArr = new String[list.size()];

		
		Date from = new Date();
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

		for(int i = 0 ; i < dayArr.length; i++) {
			// strDate에 담기는 애들이 날짜에 따라 담기게 됨 ex) 2021-12-01 / 2021-12-31
			String strDate = transFormat.format(list.get(i).getRegDate());
			// split으로 짜르고 맨 마지막 애들 담아주면, 위의 데이터에서 01, 31이 strDate에 담기게 됨.
			strDate = strDate.split("-")[2];
			// strDate에서 '01', '31'이 있는데, 앞자리가 0인애를 찾음
			// 그럼 '01'이라는 데이터를 가진 strDate가 if문에 들어감
			if(strDate.charAt(0) == '0') {
				// '01'이라는 데이터 중에서 1만 뽑기 위해서 charAt(1)
				// 그럼 strDate에 1이 Character 타입으로 들어가는데, 이거 String으로 변환해서 strDate에 넣어줌
				// 그럼 01 => 1로 변경된 데이터가 strDate에 담김.
				strDate = Character.toString(strDate.charAt(1));
			}
			// 그리고 얘를 dayArr이라는 String Array에 담아줌.
			dayArr[i] = strDate;
		}
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/myPageMyReview.jsp");
				
		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("userId", userId);
		request.setAttribute("dayArr", dayArr);
		
		view.forward(request, response);									
	} else {
		response.sendRedirect("/views/member/memberLogin.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
