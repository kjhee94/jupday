package kr.or.iei.admin.controller;

import java.io.IOException;
<<<<<<< HEAD
=======
import java.util.ArrayList;
>>>>>>> f93397b939848e98cbef78726858accdef6ad98d
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.model.service.AdminMemberService;
import kr.or.iei.admin.model.service.AdminMemberServiceImpl;
import kr.or.iei.common.MemberAuthorityCheck;

/**
 * Servlet implementation class MemberManageListServlet
 */
@WebServlet("/admin/MemberManageList.do")
public class MemberManageListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManageListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String authorityId = MemberAuthorityCheck.authorityCheck(request, response);
		
		//System.out.println(authorityId); 검증코드
		
		if(authorityId==null) {
			response.sendRedirect("/views/commons/error.jsp");
			return;
		}
		
<<<<<<< HEAD
		/*
=======
		
		//페이징처리
		int currentPage;
		
		if(request.getParameter("currentPage")==null)
		{
			currentPage = 1;
		}else 
		{
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		
>>>>>>> f93397b939848e98cbef78726858accdef6ad98d
		//비즈니스 로직
		AdminMemberService adService = new AdminMemberServiceImpl();
		
		HashMap<String,Object> pageDataMap = adService.selectAllMemberList(currentPage);
		
		//view페이지 이동
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/memberManageList.jsp");
		
		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage", currentPage);
		
		view.forward(request, response);
<<<<<<< HEAD
		*/
		
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
		AdminMemberService adService = new AdminMemberServiceImpl();
		HashMap<String,Object> pageDataMap = adService.selectAllMemberPageList(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/memberManageList.jsp");
		request.setAttribute("pageDataMap", pageDataMap);
		request.setAttribute("currentPage", currentPage);
		view.forward(request, response);
		
		
	
=======
		
>>>>>>> f93397b939848e98cbef78726858accdef6ad98d
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
