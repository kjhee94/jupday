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
 * Servlet implementation class MemberSearchIdServlet
 */
@WebServlet("/member/memberSearchId.do")
public class MemberSearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//아이디 찾기를 처리하기위한 Servlet

        //회원의 email이 있는지 확인하고 그에따른 아이디를 받아와야한다. 
		String email = request.getParameter("email");
		
		//비즈니스 로직 처리(있는지 없는지)
		MemberService mService = new MemberServiceImpl();
		Member m = mService.SearchId(email);//이메일 값을 넘겨주면서 비즈니스로직을 시작한다.
		

		if(m!=null) {//이메일있다면
			HttpSession session = request.getSession(true);
			session.setAttribute("member", m);
			
			//아이디 찾기 성공시 페이지 이동
			response.sendRedirect("/views/member/memberSearchIdResult.jsp");
	
		}else {//아이디 찾기 실패할시
			
			
			RequestDispatcher view = request.getRequestDispatcher("/views/member/memberSearchIdFail.jsp");
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
