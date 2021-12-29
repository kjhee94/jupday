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
import kr.or.iei.admin.notice.model.vo.AdminCampaign;

/**
 * Servlet implementation class AdminCampaignSelectContentServlet
 */
@WebServlet("/admin/adminCampaignSelectContent.do")
public class AdminCampaignSelectContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCampaignSelectContentServlet() {
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
		int ncNo = Integer.parseInt(request.getParameter("nc_No"));
		
		//비즈니스 로직
		AdminCampaignService acService = new AdminCampaignServiceImpl();
		AdminCampaign adcam = acService.selectOneCampaignContent(ncNo);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/noticeCampaignContent.jsp");
		request.setAttribute("adcam", adcam);
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
