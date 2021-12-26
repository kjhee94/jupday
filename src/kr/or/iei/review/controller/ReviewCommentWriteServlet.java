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
 * Servlet implementation class ReviewCommentWriteServlet
 */
@WebServlet("/review/reviewCommentWrite.do")
public class ReviewCommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewCommentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String r_c_comment = request.getParameter("r_c_comment");
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		ReviewComment co = new ReviewComment();
		
		co.setPostNum(postNum);
		co.setR_c_comment(r_c_comment);
		co.setUserId(userId);
		
		ReviewService rService = new ReviewServiceImpl();
		int result = rService.insertBoardComment(co);
		
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
