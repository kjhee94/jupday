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
 * Servlet implementation class AdminNoticePostUpdateServlet
 */
@WebServlet("/admin/adminNoticePostUpdate.do")
public class AdminNoticePostUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminNoticePostUpdateServlet() {
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
		int nNo = Integer.parseInt(request.getParameter("noticeNo"));
		String subject = request.getParameter("subjectArea");
		String content = request.getParameter("contentArea");
		
		//데이터 한 번에 보낼 객체 생성
		AdminNotice adnoup = new AdminNotice();
		adnoup.setN_No(nNo);
		adnoup.setN_Title(subject);
		adnoup.setN_Content(content);
		
		//수정 비즈니스로직
		AdminNoticeService adnService = new AdminNoticeServiceImpl();
		int result = adnService.updateNoticePost(adnoup);
		
		//정상 및 오류 페이지
		if(result>0)
		{
			response.sendRedirect("/admin/adminNoticeSelectContent.do?n_No="+nNo);
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
