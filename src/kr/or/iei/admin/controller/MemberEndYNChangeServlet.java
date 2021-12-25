package kr.or.iei.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.model.service.AdminMemberService;
import kr.or.iei.admin.model.service.AdminMemberServiceImpl;

/**
 * Servlet implementation class MemberEndYNChangeServlet
 */
@WebServlet("/admin/memberEndYNChange.do")
public class MemberEndYNChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEndYNChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		char endYN = request.getParameter("endYN").charAt(0);
		
		if(endYN=='Y') endYN='N';
		else			endYN='Y';
		AdminMemberService adService = new AdminMemberServiceImpl();
		int result = adService.updateMemberEndYN(userId,endYN);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/updateMemberEndYN.jsp");
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
