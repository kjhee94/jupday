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
import kr.or.iei.crew.model.vo.CrewBoard;

/**
 * Servlet implementation class CrewFeedValueServlet
 */
@WebServlet("/crew/crewFeedValue.do")
public class CrewFeedValueServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewFeedValueServlet() {
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
		
		CrewService cService = new CrewServiceimpl();
		
		String crewName = cService.selectCrewName(crewNo);
		
		CrewBoard cb = cService.selectOneCrewFeed(feedNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewUpdateFeed.jsp");
		
		request.setAttribute("crewName", crewName);
		request.setAttribute("crewBoard", cb);
		request.setAttribute("currentPage", currentPage);
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
