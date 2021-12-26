package kr.or.iei.crew.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.crew.model.service.CrewService;
import kr.or.iei.crew.model.service.CrewServiceimpl;
import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewJoinListServlet
 */
@WebServlet("/crew/crewJoinList.do")
public class CrewJoinListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewJoinListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("member");
		
		if(m!=null) {
			String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
			
			CrewService cService = new CrewServiceimpl();
			ArrayList<Crew> manageList = cService.selectManageCrew(userId);
			ArrayList<Crew> joinList = cService.selectJoinedCrew(userId);
			
			RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewJoinList.jsp");
			
			request.setAttribute("manageList", manageList);
			request.setAttribute("joinList", joinList);
			
			view.forward(request, response);
		}else {
			response.sendRedirect("/views/member/memberLogin.jsp");
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
