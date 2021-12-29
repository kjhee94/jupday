package kr.or.iei.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminCampaignService;
import kr.or.iei.admin.notice.model.service.AdminCampaignServiceImpl;
import kr.or.iei.admin.notice.model.vo.AdminCampaign;

/**
 * Servlet implementation class AdminCampaignWriteServlet
 */
@WebServlet("/admin/adminCampaignWrite.do")
public class AdminCampaignWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCampaignWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//검증코드
		//System.out.println(title);
		//System.out.println(content);
		
		AdminCampaign adcwrite = new AdminCampaign();
		adcwrite.setNc_Title(title);
		adcwrite.setNc_Content(content);
		
		AdminCampaignService adcService = new AdminCampaignServiceImpl();
		int result = adcService.insertCampaignPostWrite(adcwrite);
		
		if(result>0)
		{
			int ncNo = adcService.searchCampaignPostNo(adcwrite);
			response.sendRedirect("/admin/adminCampaignSelectContent.do?nc_No="+ncNo+"&currentPage=1");
		}else
		{
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
