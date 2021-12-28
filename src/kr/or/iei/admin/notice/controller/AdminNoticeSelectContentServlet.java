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
import kr.or.iei.admin.notice.model.vo.AdminCampaign;
import kr.or.iei.admin.notice.model.vo.AdminNotice;
import kr.or.iei.common.MemberAuthorityCheck;


/**
 * Servlet implementation class AdminNoticeSelectContentServlet
 */
@WebServlet("/admin/adminNoticeSelectContent.do")
public class AdminNoticeSelectContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeSelectContentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		//페이지에서 보낸 데이터 가져오기
		int nNo = Integer.parseInt(request.getParameter("n_No"));
		
		//비즈니스 로직
		AdminNoticeService adnService = new AdminNoticeServiceImpl();
		AdminNotice adnotice = adnService.selectOneNoticeContent(nNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/noticeSelectContent.jsp");
		request.setAttribute("adnotice", adnotice);
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
