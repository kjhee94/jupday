package kr.or.iei.admin.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminFAQService;
import kr.or.iei.admin.notice.model.service.AdminFAQServiceImpl;

/**
 * Servlet implementation class AdminFAQDelYNChangeServlet
 */
@WebServlet("/admin/noticeFAQDelYNChange.do")
public class AdminFAQDelYNChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFAQDelYNChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		int faqNo = Integer.parseInt(request.getParameter("faq_No"));
		char delYN = request.getParameter("faq_Del_YN").charAt(0);
		
		if(delYN=='Y') delYN='N';
		else			delYN='Y';
		AdminFAQService adnService = new AdminFAQServiceImpl();
		int result = adnService.updateFAQDelYN(faqNo,delYN);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/updateFAQDelYN.jsp");
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
