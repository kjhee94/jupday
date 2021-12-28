package kr.or.iei.crew.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.crew.model.service.CrewService;
import kr.or.iei.crew.model.service.CrewServiceimpl;
import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.crew.model.vo.CrewMember;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewFeedSearchServlet
 */
@WebServlet("/crew/crewFeedSearch.do")
public class CrewFeedSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewFeedSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		//pageNavi에서 현재페이지
		int currentFeedPage;
		
		//처음 게시판으로 이동시(null값일 때) 가장 첫페이지로 설정
		if(request.getParameter("currentFeedPage")==null) {
			currentFeedPage = 1;
		}else {
			currentFeedPage = Integer.parseInt(request.getParameter("currentFeedPage"));
		}
		
		CrewService cService = new CrewServiceimpl();
		
		//크루 정보 가져오기
		Crew c = cService.selectOneCrew(crewNo);
		
		//크루멤버정보 가져오기
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		CrewMember cm = cService.selectCrewMember(userId, crewNo);
		
		//페이징처리
		HashMap<String, Object> pageDataMap = cService.selectCrewFeedSearchList(currentFeedPage, keyword, type, crewNo, currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewOnePage.jsp");
		
		request.setAttribute("crew", c);
		request.setAttribute("crewMember", cm);
		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("currentFeedPage", currentFeedPage);
		request.setAttribute("keyword", keyword);
		request.setAttribute("type", type);
		
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
