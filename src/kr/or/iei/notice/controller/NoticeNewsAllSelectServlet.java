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
 * Servlet implementation class noticeNewsAllSelectServlet
 */
@WebServlet("/views/notice/noticeNewsAllSelect.do")
public class NoticeNewsAllSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeNewsAllSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        	
		        //해당 Servlet을 요청하게 되면, 페이지 값을 받아와서 동작하는 형태로 구현 할 것입니다.
				
				int currentPage;
				if(request.getParameter("currentPage")==null)
				{
				//header.jsp 에서 게시판으로 이동하는 경우에는 가장 첫 페이지인 1page로 셋팅
					 currentPage=1;
				}else {
					currentPage=Integer.parseInt(request.getParameter("currentPage"));
				}
				
				//우리는 요청한 page값 (currentPage) 을 가지고  페이지에 따른 데이터 목록화를 비즈니스 로직으로 처리
				NoticeService NService = new NoticeServiceImpl();
			    HashMap <String,Object> pageDataMap = NService.selectAllPostList(currentPage);
				
				
				//보내준다. 뿌려주는 페이지로
				RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeNews.jsp");
				
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
