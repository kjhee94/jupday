package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class MemberWithdrawServlet
 */
@WebServlet("/member/memberWithdraw.do")
public class MemberWithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberWithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");*/
		
		String userPwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		Member m = (Member) session.getAttribute("member");
		String userId = m.getUserId();

		MemberService mService = new MemberServiceImpl();
		int result = mService.deleteOneMember(userId, userPwd);
		
		RequestDispatcher view = null;
		/*PrintWriter out = response.getWriter();*/
		
		if (result > 0) {
			view = request.getRequestDispatcher("/views/member/myPageWithdrawSuccess.jsp");
			request.setAttribute("result", true);
			session.invalidate();
		} else {
			request.setAttribute("result", false);
			//request.setAttribute("msg", "탈퇴 실패");
			/*out.print("<script>");
			out.print("alert('회원 탈퇴를 실패했습니다.');");
			out.print("</script>");*/
			
			
			view = request.getRequestDispatcher("/views/member/myPageWithdrawFail.jsp");
		}
		request.setAttribute("userId", m.getUserId());

		view.forward(request, response);
		/*out.close();*/
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
