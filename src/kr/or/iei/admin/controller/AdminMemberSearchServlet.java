package kr.or.iei.admin.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.admin.model.service.AdminMemberService;
import kr.or.iei.admin.model.service.AdminMemberServiceImpl;
import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.service.NoticeServiceImpl;

/**
 * Servlet implementation class adminMemberSearchServlet
 */
@WebServlet("/admin/adminMemberSearch.do")
public class AdminMemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//필요 값들을 받아준다. 검색을 하더라도 검색된 결과는 페이징 처리 되어야 하기 때문에 페이징 처리했던 Servlet과 동일
	    //단 , 검색 키워드가 있느냐 없는갸 차이이다.

		int currentPage;
		if(request.getParameter("currentPage")==null)
		{
			 currentPage=1;
		}else {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
		//키워드를 가져와야한다.
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		
		
		//해당 값을 가지고 ,비즈니스 로직처리를 해서 키워드에 해당하는 게시물을 검색하여 페이징 처리하여 리턴
		AdminMemberService adDAO = new AdminMemberServiceImpl();
		HashMap<String, Object> map =adDAO.adminMemberSearch(currentPage,keyword,type); //페이징 처리와 검색을 할 메소드 호출
		
		RequestDispatcher view = request.getRequestDispatcher("/views/admin/memberManageList.jsp");
		
		request.setAttribute("pageDataMap", map);
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
