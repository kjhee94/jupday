package kr.or.iei.admin.notice.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminNoticeService;
import kr.or.iei.admin.notice.model.service.AdminNoticeServiceImpl;
import kr.or.iei.common.MemberAuthorityCheck;

/**
 * Servlet implementation class AdminCampaignManageListServlet
 */
@WebServlet("/admin/adminCampaignManageList.do")
public class AdminCampaignManageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCampaignManageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩 처리
		
		request.setCharacterEncoding("UTF-8");

		String authorityId = MemberAuthorityCheck.authorityCheck(request, response);
		
		if(authorityId==null) {
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		//페이징처리
		int currentPage;
		if(request.getParameter("currentPage")==null)
		{
				currentPage = 1;
		}else 
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//요청한 page(currentPage)를 가지고 비즈니스 로직 처리
		AdminNoticeService adnService = new AdminNoticeServiceImpl();
		HashMap<String,Object> pageDataMap = adnService.selectAllCampaignPageList(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/noticeCampaignManageList.jsp");
		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage", currentPage);
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
