package kr.or.iei.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.notice.model.service.NoticeService;
import kr.or.iei.notice.model.service.NoticeServiceImpl;
import kr.or.iei.notice.model.vo.NoticeCampaign;

/**
 * Servlet implementation class CampaignOneSelectServlet
 */
@WebServlet("/notice/CampaignContent.do")
public class CampaignOneSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CampaignOneSelectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//게시물 번호가 넘어온다.	campaignNo
		int campaignNo = Integer.parseInt(request.getParameter("campaignNo"));
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		NoticeService nService = new NoticeServiceImpl();
		NoticeCampaign noticeCampaign=nService.selectOneCampaignPost(campaignNo); //데이터를 읽어올 수 있도록 하고 게시물 번호를 넘겨준다.

		
		//처리된 결과 데이터를  view page로 전달
		RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeCampaineContent.jsp");
		request.setAttribute("noticeCampaign", noticeCampaign);//데이터를 담아서 보내준다.
		request.setAttribute("currentPage", currentPage);//데이터를 담아서 보내준다.
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
