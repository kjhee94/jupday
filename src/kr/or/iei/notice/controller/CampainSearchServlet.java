package kr.or.iei.notice.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.service.NoticeServiceImpl;

/**
 * Servlet implementation class CampainSearchServlet
 */
@WebServlet("/notice/noticeCampaignSearch.do")
public class CampainSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CampainSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage;
		if(request.getParameter("currentPage")==null)
		{
			 currentPage=1;
		}else {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		
	
		//인코딩
		request.setCharacterEncoding("UTF-8");
		
		String keyword = request.getParameter("keyword");
		String type = request.getParameter("type");
		
		
		//해당 값을 가지고 ,비즈니스 로직처리를 해서 키워드에 해당하는 게시물을 검색하여 페이징 처리하여 리턴
		NoticeService nService = new NoticeServiceImpl();
		HashMap<String, Object> map =nService.selectSearchCampaignContent(currentPage,keyword,type); //페이징 처리와 검색을 할 메소드 호출
		
		RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeCampaign.jsp");
		
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
