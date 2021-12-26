package kr.or.iei.review.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.vo.Member;
import kr.or.iei.review.model.service.ReviewService;
import kr.or.iei.review.model.service.ReviewServiceImpl;
import kr.or.iei.review.model.vo.Review;

/**
 * Servlet implementation class ReviewWriteSetvlet
 */
@WebServlet("/review/reviewWrite.do")
public class ReviewWriteSetvlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewWriteSetvlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		
		if(request.getSession().getAttribute("member")==null)
		{
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		Review review = new Review();
		review.setUserId(userId);
		review.setPostTitle(postTitle);
		review.setPostContent(postContent);
		
		
		ReviewService rService = new ReviewServiceImpl();
		int result = rService.insertPostWrite(review);
		
		if(result>0) {//작성이 완료되면
			int postNum = rService.searchReviewNo(review); //그 글의 BoardNo를 가져옴
			response.sendRedirect("/review/reviewSelectContent.do?postNum="+postNum+"&currentPage=1");
		}else {
			response.sendRedirect("/views/commons/error.jsp");
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
