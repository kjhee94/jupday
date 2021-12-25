package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.service.MemberServiceImpl;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class MemberSearchPwdServlet
 */
@WebServlet("/member/memberSearchPwd.do")
public class MemberSearchPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	          	//비밀번호를 찾기위해 ID와 email를 일단 받아와야 한다
				String userId = request.getParameter("userId");
				String email = request.getParameter("email");
				
				//비즈니스 로직 처리(있는지 없는지)
				MemberService mService = new MemberServiceImpl();
				Member m = mService.SearchPwd(userId,email);//ID값과 이메일 값을 넘겨주면서 비즈니스로직을 시작한다.
				

				if(m!=null) {//아이디와 이메일값이 존재한다면
					HttpSession session = request.getSession(true);
					session.setAttribute("member", m);
					
					//로그인 성공시 페이지 이동
					response.sendRedirect("/views/member/memberSearchPwdResult.jsp");
					//로그인을 성공하게 되면, sendRedirect를 통하여 메인페이지로 이동 시켜주어라
					//이때 sendRedirect는 사용자의 URL을 변경시켜주는 response 객체의 메소드
				
				}else {//아이디와 이메일 값이 존재하지 않을시
					
					//RequestDispatcher를 이용하면 URL을 변경하지 않고 이동할 수 있다.
					//이때 pageContext.forward처럼 request와 response 객체를 가지고 이동할 수 있다.
					
					RequestDispatcher view = request.getRequestDispatcher("/views/member/memberSearchPwdFail.jsp");
					view.forward(request, response);
				}

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
