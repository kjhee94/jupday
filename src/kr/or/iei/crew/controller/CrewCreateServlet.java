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
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewCreateServlet
 */
@WebServlet("/crew/crewCreate.do")
public class CrewCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String crewName = request.getParameter("crewName");
		String crewInfo = request.getParameter("crewInfo");
		String crewImg = null;
		
		Crew c = new Crew(crewName, crewInfo, crewImg);
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		CrewService cService = new CrewServiceimpl();
		boolean result = cService.crewCreate(c, userId);
		
		//성공실패 페이지 보내기
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewCreateResult.jsp");
		
		if(result) {
			request.setAttribute("result", true);
		}else {
			request.setAttribute("result", false);
		}
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
