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
import kr.or.iei.crew.model.vo.Crew;

/**
 * Servlet implementation class CrewUpdateServlet
 */
@WebServlet("/crew/crewUpdate.do")
public class CrewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		//보내주는 값 받아주기
		String crewName = request.getParameter("crewName");
		String crewInfo = request.getParameter("crewInfo");
		String crewImg = request.getParameter("crewImg");
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		
		Crew c = new Crew(crewNo, crewName,crewInfo,crewImg);
		
		CrewService cService = new CrewServiceimpl();
		int result = cService.UpdateOneCrew(c);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewUpdateResult.jsp");
		
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
