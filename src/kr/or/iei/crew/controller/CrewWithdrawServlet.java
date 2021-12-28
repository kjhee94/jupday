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
 * Servlet implementation class CrewWithdrawServlet
 */
@WebServlet("/crew/crewWithdraw.do")
public class CrewWithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewWithdrawServlet() {
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
		int withDrawResult = cService.withdrawCrew(crewNo, userId);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewWithDrawResult.jsp");
		
		if(withDrawResult>0) {
			request.setAttribute("withDrawResult", true);
		}else {
			request.setAttribute("withDrawResult", false);
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
