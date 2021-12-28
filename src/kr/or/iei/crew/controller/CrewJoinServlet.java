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
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewJoinServlet
 */
@WebServlet("/crew/crewJoin.do")
public class CrewJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		CrewService cService = new CrewServiceimpl();
		int joinResult = cService.joinCrew(crewNo, userId);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewJoinResult.jsp");
		
		if(joinResult>0) {
			request.setAttribute("joinResult", true);
		}else {
			request.setAttribute("joinResult", false);
		}
		request.setAttribute("crewNo", crewNo);
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
