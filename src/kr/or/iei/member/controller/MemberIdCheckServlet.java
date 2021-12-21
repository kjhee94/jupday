package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberIdCheckServlet
 */
@WebServlet("/member/idCheck.do")
public class MemberIdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberIdCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//중복 체크를 확인할 userId 값을 받아와야한다.
		String userId= request.getParameter("userId");
		
		MemberService mService = new MemberServiceImpl();
		boolean result= mService.selectIdCheck(userId);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/member/idCheck.jsp");
		
		request.setAttribute("idCheck", result);// true 또는 false 값을 담아준다.
		request.setAttribute("userId", userId);// JSP 페이지에서 id 값을 사용 할 수 있도록 보내줌
		
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
