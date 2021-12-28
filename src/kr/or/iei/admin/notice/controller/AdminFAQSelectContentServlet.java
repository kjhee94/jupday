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
import kr.or.iei.admin.notice.model.vo.AdminFAQ;
import kr.or.iei.common.MemberAuthorityCheck;

/**
 * Servlet implementation class AdminFAQSelectContentServlet
 */
@WebServlet("/admin/adminFAQSelectContent.do")
public class AdminFAQSelectContentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFAQSelectContentServlet() {
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
		
		//페이지에서 보낸 데이터 가져오기
		int faqNo = Integer.parseInt(request.getParameter("faqNo"));
		System.out.println(faqNo);
		
		//비즈니스 로직
		AdminFAQService afaqService = new AdminFAQServiceImpl();
		AdminFAQ adfaq = afaqService.selectOneFAQContent(faqNo);
		
		if(adfaq != null)
		{
			RequestDispatcher view = request.getRequestDispatcher("/views/admin/noticeFAQWrite.jsp");
			request.setAttribute("adfaq", adfaq);
			view.forward(request, response);
			
		}else
		{
			
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
