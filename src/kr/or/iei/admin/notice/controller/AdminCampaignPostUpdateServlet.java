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
 * Servlet implementation class AdminCampaignPostUpdateServlet
 */
@WebServlet("/admin/adminCampaignPostUpdate.do")
public class AdminCampaignPostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCampaignPostUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		//데이터 가져오기
		int ncNo = Integer.parseInt(request.getParameter("campaignNo"));
		String title = request.getParameter("subjectArea");
		String content = request.getParameter("contentArea");
		
		//데이터 한 번에 보낼 객체 생성
		AdminCampaign adc = new AdminCampaign();
		adc.setNc_No(ncNo);
		adc.setNc_Title(title); 
		adc.setNc_Content(content);
		
		//출력
		System.out.println(ncNo);
		System.out.println(title);
		System.out.println(content);
		
		//수정 비즈니스로직
		AdminCampaignService adcService = new AdminCampaignServiceImpl();
		int result = adcService.updateCampaignPost(adc);
		
		//정상 및 오류 페이지
		if(result>0)
		{
			response.sendRedirect("/admin/adminCampaignSelectContent.do?nc_No="+ncNo);
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
