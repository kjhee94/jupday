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
import kr.or.iei.review.model.vo.ReviewComment;

/**
 * Servlet implementation class ReviewCommentUpdateServlet
 */
@WebServlet("/review/reviewCommentUpdate.do")
public class ReviewCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String comment = request.getParameter("comment"); //jsp에서 parameter 태그의 name을 r_c_comment로 줄 것
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		int postNum = Integer.parseInt(request.getParameter("postNum")); //여기까지 모두 parameter name을 파란색 글자명으로 줄 것
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		ReviewComment co = new ReviewComment();
		
		co.setR_c_no(commentNo);
		co.setR_c_comment(comment);
		co.setUserId(userId);
		
		ReviewService bService = new ReviewServiceImpl();
		int result = bService.updateReviewComment(co);
		
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
