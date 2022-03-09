package kr.or.iei.crew.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.crew.model.service.CrewService;
import kr.or.iei.crew.model.service.CrewServiceimpl;

/**
 * Servlet implementation class CrewDeleteCommentServlet
 */
@WebServlet("/crew/crewCommentDelete.do")
public class CrewDeleteCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewDeleteCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		int currentFeedPage = Integer.parseInt(request.getParameter("currentFeedPage"));
		int commentNo = Integer.parseInt(request.getParameter("commentNo"));
		
		CrewService cService = new CrewServiceimpl();
		int result = cService.deleteOneComment(commentNo);
		
		//성공실패 페이지 보내기
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewDeleteCommentResult.jsp");
		
		if(result>0) {
			request.setAttribute("deleteResult", true);
		}else {
			request.setAttribute("deleteResult", false);
		}
		request.setAttribute("crewNo", crewNo);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("feedNo", feedNo);
		request.setAttribute("currentFeedPage", currentFeedPage);
		
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
