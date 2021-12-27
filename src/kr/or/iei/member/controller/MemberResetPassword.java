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
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class MemberResetPassword
 */
@WebServlet("/member/resetSearchPassword.do")
public class MemberResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberResetPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		         
		
		//인코딩 
		request.setCharacterEncoding("UTF-8");
		
	    //유저가 입력한 변경할 패스워드를 받는다.
		String userPwd = request.getParameter("userPwd");
		
		//세션에서 해당유저를 구분할 수 있는 정보르 추출(userId 추출)
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		//패스워드 변경을 위한 비즈니스 로직 처리
		MemberService mService = new MemberServiceImpl();
		int result= mService.searchUapatePwd(userId, userPwd);
		
		RequestDispatcher view =request.getRequestDispatcher("/views/member/memberPwdResetResult.jsp");
		
		if(result>0)
		{
			request.setAttribute("pwdResult", true);
		}else
		{
			request.setAttribute("pwdResult",false);
		}
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
