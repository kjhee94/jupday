package kr.or.iei.crew.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.crew.model.service.CrewService;
import kr.or.iei.crew.model.service.CrewServiceimpl;
import kr.or.iei.crew.model.vo.CrewBoard;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewWriteFeedServlet
 */
@WebServlet("/crew/crewWriteFeed.do")
public class CrewWriteFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewWriteFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		String feedSubject = request.getParameter("feedSubject");
		String feedContent = request.getParameter("feedContent");
		
		if(request.getSession().getAttribute("member")==null) {
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		CrewBoard cb = new CrewBoard();
		cb.setCrewNo(crewNo);
		cb.setUserId(userId);
		cb.setFeedSubject(feedSubject);
		cb.setFeedContent(feedContent);
		
		CrewService cService = new CrewServiceimpl();
		int result = cService.insertCrewFeed(cb);
		
		if(result>0) {
			
			int feedNo = cService.searchFeedNo(cb);
			
			response.sendRedirect("/crew/crewOneFeed.do?crewNo="+crewNo+"&currentPage="+currentPage+"&feedNo="+feedNo+"&currentFeedPage=1");
		}else {
			response.sendRedirect("/views/commons/error.jsp");
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
