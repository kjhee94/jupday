package kr.or.iei.admin.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminCampaignService;
import kr.or.iei.admin.notice.model.service.AdminCampaignServiceImpl;
import kr.or.iei.admin.notice.model.service.AdminNoticeService;
import kr.or.iei.admin.notice.model.service.AdminNoticeServiceImpl;

/**
 * Servlet implementation class AdminCampaignDelYNChangeServlet
 */
@WebServlet("/admin/adminCampaignDelYNChange.do")
public class AdminCampaignDelYNChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCampaignDelYNChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		int ncNo = Integer.parseInt(request.getParameter("nc_No"));
		char delYN = request.getParameter("nc_Del_YN").charAt(0);
				
		if(delYN=='Y') delYN='N';
		else			delYN='Y';
		AdminCampaignService adnService = new AdminCampaignServiceImpl();
		int result = adnService.updateCampaignDelYN(ncNo,delYN);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/updateCampaignDelYN.jsp");
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
