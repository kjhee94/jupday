package kr.or.iei.admin.crew.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.crew.model.service.AdminCrewService;
import kr.or.iei.admin.crew.model.service.AdminCrewServiceImpl;

/**
 * Servlet implementation class CrewFeedDelYNChangeServlet
 */
@WebServlet("/admin/crewFeedDelYNChange.do")
public class CrewFeedDelYNChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrewFeedDelYNChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
			
		int feedNo = Integer.parseInt(request.getParameter("c_No"));
		char delYN = request.getParameter("c_Del_YN").charAt(0);
				
		if(delYN=='Y') delYN='N';
		else			delYN='Y';
		AdminCrewService adcService = new AdminCrewServiceImpl();
		int result = adcService.updateCrewDelYN(feedNo,delYN);
				
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/updateCrewDelYN.jsp");
		if(result>0) request.setAttribute("result", true);
		else request.setAttribute("result", false);
				
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
