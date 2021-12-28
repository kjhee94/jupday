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

/**
 * Servlet implementation class CrewUpdateFeedServlet
 */
@WebServlet("/crew/crewUpdateFeed.do")
public class CrewUpdateFeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewUpdateFeedServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		String feedSubject = request.getParameter("feedSubject");
		String feedContent = request.getParameter("feedContent");
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		int currentFeedPage = Integer.parseInt(request.getParameter("currentFeedPage"));
		
		CrewBoard cb = new CrewBoard();
		cb.setCrewNo(crewNo);
		cb.setFeedNo(feedNo);
		cb.setFeedSubject(feedSubject);
		cb.setFeedContent(feedContent);
		
		CrewService cService = new CrewServiceimpl();
		
		int result = cService.updateCrewFeed(cb);
		
		
		if(result>0) {
			response.sendRedirect("/crew/crewOneFeed.do?crewNo="+crewNo+"&currentPage="+currentPage+"&feedNo="+feedNo+"&currentFeedPage="+currentFeedPage);
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
