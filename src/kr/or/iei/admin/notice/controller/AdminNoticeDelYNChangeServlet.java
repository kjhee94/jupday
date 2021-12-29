package kr.or.iei.admin.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminNoticeService;
import kr.or.iei.admin.notice.model.service.AdminNoticeServiceImpl;

/**
 * Servlet implementation class AdminNoticeDelYNChangeServlet
 */
@WebServlet("/admin/adminNoticeDelYNChange.do")
public class AdminNoticeDelYNChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeDelYNChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
				
		int nNo = Integer.parseInt(request.getParameter("n_No"));
		char delYN = request.getParameter("n_Del_YN").charAt(0);
				
		if(delYN=='Y') delYN='N';
		else			delYN='Y';
		AdminNoticeService adnService = new AdminNoticeServiceImpl();
		int result = adnService.updateNoticeDelYN(nNo,delYN);
				
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/updateNoticeDelYN.jsp");
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
