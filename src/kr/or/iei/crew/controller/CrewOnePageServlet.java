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
 * Servlet implementation class CrewOnePageServlet
 */
@WebServlet("/crew/crewOnePage.do")
public class CrewOnePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewOnePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Member m = (Member)request.getSession().getAttribute("member");
		
		if(m==null) {
			response.sendRedirect("/views/member/memberLogin.jsp");
		}else {
			
			int crewNo = Integer.parseInt(request.getParameter("crewNo"));
			int currentPage = Integer.parseInt(request.getParameter("currentPage"));
			
			//현재 피드게시판 
			int currentFeedPage;
			
			if(request.getParameter("currentFeedPage")==null) {
				//게시판으로 처음 이동하는 경우에는 가장 첫페이지인 1page로 세팅
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
			HashMap<String, Object> pageDataMap = cService.selectAllCrewFeed(currentFeedPage ,crewNo, currentPage);
			
			RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewOnePage.jsp");
			
			request.setAttribute("crew", c);
			request.setAttribute("crewMember", cm);
			request.setAttribute("pageDataMap", pageDataMap);
			request.setAttribute("currentPage", currentPage);
			request.setAttribute("currentFeedPage", currentFeedPage);
			
			view.forward(request, response);	
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
