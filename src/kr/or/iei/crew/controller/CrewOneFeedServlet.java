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
import kr.or.iei.crew.model.vo.CrewMember;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewOneFeedServlet
 */
@WebServlet("/crew/crewOneFeed.do")
public class CrewOneFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewOneFeedServlet() {
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
			int feedNo = Integer.parseInt(request.getParameter("feedNo"));
			int currentFeedPage = Integer.parseInt(request.getParameter("currentFeedPage"));
			
			CrewService cService = new CrewServiceimpl();
			
			String crewName = cService.selectCrewName(crewNo);
			
			//크루게시판 정보 가져오기
			CrewBoard cb = cService.selectOneCrewFeed(feedNo);
			
			RequestDispatcher view = request.getRequestDispatcher("/views/crew/crewOneFeed.jsp");
			
			request.setAttribute("crewBoard", cb);
			request.setAttribute("crewName", crewName);
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
