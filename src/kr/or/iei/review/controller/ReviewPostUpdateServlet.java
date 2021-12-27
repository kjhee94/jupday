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
 * Servlet implementation class ReviewPostUpdateServlet
 */
@WebServlet("/review/reviewPostUpdate.do")
public class ReviewPostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewPostUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String postContent = request.getParameter("postContent");
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		Review review = new Review();
		review.setPostNum(postNum);
		review.setPostContent(postContent);
		review.setUserId(userId);
		
		ReviewService rService = new ReviewServiceImpl();
		int result = rService.updatePost(review);
		
		if(result>0) {
			response.sendRedirect("/review/reviewSelectContent.do?postNum="+postNum+"&currentPage="+currentPage);
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
