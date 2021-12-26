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

/**
 * Servlet implementation class ReviewCommentDeleteServlet
 */
@WebServlet("/review/deletePostComment.do")
public class ReviewCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int r_c_no = Integer.parseInt(request.getParameter("r_c_no"));
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		ReviewService bService = new ReviewServiceImpl();
		int result = bService.deleteReviewComment(r_c_no,userId);
		
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
