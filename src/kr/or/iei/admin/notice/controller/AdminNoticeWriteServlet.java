package kr.or.iei.admin.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.notice.model.service.AdminNoticeService;
import kr.or.iei.admin.notice.model.service.AdminNoticeServiceImpl;
import kr.or.iei.admin.notice.model.vo.AdminNotice;

/**
 * Servlet implementation class AdminNoticeWriteServlet
 */
@WebServlet("/admin/adminNoticeWrite.do")
public class AdminNoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticeWriteServlet() {
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
		
		AdminNotice adnwrite = new AdminNotice();
		adnwrite.setN_Title(title);
		adnwrite.setN_Content(content);
		
		AdminNoticeService adnService = new AdminNoticeServiceImpl();
		int result = adnService.insertNoticePostWrite(adnwrite);
		int nNo = adnService.searchNoticePostNo(adnwrite);
		
		if(result>0)
		{
			
			response.sendRedirect("/admin/adminNoticeSelectContent.do?n_No="+nNo+"&currentPage=1");
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
