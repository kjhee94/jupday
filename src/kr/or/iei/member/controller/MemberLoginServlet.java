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
 * Servlet implementation class MemberLoginServlet
 */
@WebServlet("/member/login.do")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//로그인을 처리하기위한 Servlet
		
		//2개의 값을 가져와야 한다 (userId, userPwd)
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		//System.out.println("보내온 id : "+userId); 확인
		//System.out.println("보내온 Pwd : "+userPwd); 확인
		
		//비즈니스 로직 처리
		MemberService mService = new MemberServiceImpl();
		Member m = mService.selectOneMember(userId, userPwd);//로그인에대한 정보가 있는 없는지 담겨있는곳
		
        //리턴값은 Member 객체 이거나 혹은 null

		if(m!=null) {//로그인이 성공했다면
			HttpSession session = request.getSession(true);
			session.setAttribute("member", m);
			
			//로그인 성공시 페이지 이동
			response.sendRedirect("/");
			//로그인을 성공하게 되면, sendRedirect를 통하여 메인페이지로 이동 시켜주어라
			//이때 sendRedirect는 사용자의 URL을 변경시켜주는 response 객체의 메소드
		
		}else {//로그인이 실패할시
			//response.sendRedirect("/views/member/memberLoginFail.jsp");
			
			//RequestDispatcher를 이용하면 URL을 변경하지 않고 이동할 수 있다.
			//이때 pageContext.forward처럼 request와 response 객체를 가지고 이동할 수 있다.
			
			RequestDispatcher view = request.getRequestDispatcher("/views/member/memberLoginFail.jsp");
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
