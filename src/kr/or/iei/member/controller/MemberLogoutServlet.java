package kr.or.iei.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberLogoutServlet
 */
@WebServlet("/member/logout.do")
public class MemberLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//로그 아웃을 처리하기 위한 Servlet doget 메소드
		//세션부터 가져와야함 
		HttpSession session=request.getSession();
		
		//일반적인 로그아웃은 session을 찾아서 파기만 하면된다.
		//그런데 만약에 혹시라도 로그 아웃에 대한 시점 저장 하고 싶다면? =>그때에는 session에서 데이터(ID값)값을 찾아서 DB에 기록 해야한다.
		
		session.invalidate();//세션 파기
		/*
		  sendRedirect?
		  RequestDispatcher?
		 */
		
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
