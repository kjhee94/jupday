package kr.or.iei.review.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.review.model.service.ReviewService;
import kr.or.iei.review.model.service.ReviewServiceImpl;
import kr.or.iei.review.model.vo.Review;
import kr.or.iei.review.model.vo.ReviewComment;

/**
 * Servlet implementation class ReviewSelectContentServlet
 */
@WebServlet("/review/reviewSelectContent.do")
public class ReviewSelectContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewSelectContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		ReviewService rService = new ReviewServiceImpl();
		Review review = rService.selectOnePost(postNum);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/review/reviewSelectContent.jsp");
		
		request.setAttribute("review", review);
		request.setAttribute("currentPage", currentPage);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
