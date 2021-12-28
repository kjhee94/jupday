package kr.or.iei.admin.review.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.review.model.service.AdminReviewService;
import kr.or.iei.admin.review.model.service.AdminReviewServiceImpl;
import kr.or.iei.common.MemberAuthorityCheck;

/**
 * Servlet implementation class AdminReviewManageListServlet
 */
@WebServlet("/admin/reviewManageList.do")
public class AdminReviewManageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminReviewManageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String authorityId = MemberAuthorityCheck.authorityCheck(request, response);
		
		if(authorityId==null) {
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
		int currentPage;
		if(request.getParameter("currentPage")==null)
		{
				currentPage = 1;
		}else 
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//요청한 page(currentPage)를 가지고 비즈니스 로직 처리
		AdminReviewService adrService = new AdminReviewServiceImpl();
		HashMap<String,Object> pageDataMap = adrService.selectAllReviewPageList(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/reviewManageList.jsp");
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
