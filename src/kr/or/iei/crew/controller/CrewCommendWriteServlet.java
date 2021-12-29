package kr.or.iei.crew.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.crew.model.service.CrewService;
import kr.or.iei.crew.model.service.CrewServiceimpl;
import kr.or.iei.crew.model.vo.CrewBoardComment;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class CrewCommendWriteServlet
 */
@WebServlet("/crew/crewCommendWrite.do")
public class CrewCommendWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewCommendWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String comment = request.getParameter("comment");
		int crewNo = Integer.parseInt(request.getParameter("crewNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		int feedNo = Integer.parseInt(request.getParameter("feedNo"));
		int currentFeedPage = Integer.parseInt(request.getParameter("currentFeedPage"));
		
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		CrewBoardComment cbc = new CrewBoardComment();
		
		cbc.setCrewNo(crewNo);
		cbc.setFeedNo(feedNo);
		cbc.setUserId(userId);
		cbc.setCommentContent(comment);
		
		CrewService cService = new CrewServiceimpl();
		
		int result = cService.insertFeedComment(cbc);
		
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
