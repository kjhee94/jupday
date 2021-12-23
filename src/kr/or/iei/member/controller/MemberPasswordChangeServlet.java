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
 * Servlet implementation class MemberPasswordChangeServlet
 */
@WebServlet("/member/memberPasswordChange.do")
public class MemberPasswordChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberPasswordChangeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
				
		String pwd = request.getParameter("pwd");
		String newPwd = request.getParameter("new_pwd");
				
		String userId = ((Member)request.getSession().getAttribute("member")).getUserId();
		
		MemberService mService = new MemberServiceImpl();
		int result = mService.updatePwdMember(userId,pwd,newPwd);
				
		RequestDispatcher view = request.getRequestDispatcher("/views/member/memberPasswordChangeResult.jsp");
		if(result>0) {
			request.setAttribute("pwdResult", true);
		} else {
			request.setAttribute("pwdResult", false);
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
