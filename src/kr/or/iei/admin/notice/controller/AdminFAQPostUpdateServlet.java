package kr.or.iei.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminFAQService;
import kr.or.iei.admin.notice.model.service.AdminFAQServiceImpl;
import kr.or.iei.admin.notice.model.vo.AdminFAQ;

/**
 * Servlet implementation class AdminFAQPostUpdateServlet
 */
@WebServlet("/admin/adminFAQPostUpdate.do")
public class AdminFAQPostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFAQPostUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		int faqNo = Integer.parseInt(request.getParameter("faqNo"));
		String title = request.getParameter("subjectArea");
		String content = request.getParameter("contentArea");
		
		AdminFAQ adfaq = new AdminFAQ();
		adfaq.setFaq_No(faqNo);
		adfaq.setFaq_Title(title);
		adfaq.setFaq_Content(content);
		
		AdminFAQService adfService = new AdminFAQServiceImpl();
		int result = adfService.updateFAQPost(adfaq);
		
		//정상 및 오류 페이지
		if(result>0)
		{
			response.sendRedirect("/admin/adminFAQSelectContent.do?faqNo="+faqNo);
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
