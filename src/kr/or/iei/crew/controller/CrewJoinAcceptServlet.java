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
 * Servlet implementation class CrewJoinAcceptServlet
 */
@WebServlet("/crew/crewJoinAccept.do")
public class CrewJoinAcceptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewJoinAcceptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		
		CrewService cService = new CrewServiceimpl();
		int result = cService.updateCrewJoinStateAccept(userId, crewNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewJoinApproveAccept.jsp");
		
		if(result>0) {
			request.setAttribute("updateResult", true);
		}else {
			request.setAttribute("updateResult", false);
		}
		
		request.setAttribute("crewNo", crewNo);
		
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
