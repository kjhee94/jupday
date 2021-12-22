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
 * Servlet implementation class MemberJoinServlet
 */
@WebServlet("/member/memberJoin.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				
		//데이터를 꺼내기전에 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		//view Page에서 보내온 값을 처리 		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String nick = request.getParameter("nick");
		String email = request.getParameter("email");
		
		
		Member m = new Member(userId, userPwd, nick, email);
		
		//비즈니스 로직 처리
		
		MemberService mService = new MemberServiceImpl();
		int result= mService.insertOneMember(m);
		
		//회원가입 성공 또는 실패
		//1.회원가입을 성공하면 성공페이지로 이동,회원가입을 실패하면 실패 페이지로 이동
		//2.성공/실패 여부와 상관없이 하나의 페이지로 이동한다 (해당 페이지에서 성공/실패를 처리한다)
		
		//첫번째 방법
		
		if(result>0)//성공했다면
		{
			//response.sendRedirect("/views/member/memberJoinSuccess.jsp");
			RequestDispatcher view = request.getRequestDispatcher("/views/member/memberJoinSuccess.jsp");
			request.setAttribute("userId", userId);// JSP 페이지에서 id 값을 사용 할 수 있도록 보내줌
			view.forward(request,response);
		}else//실패했다면
		{
			response.sendRedirect("/views/member/memberJoinFail.jsp");
		}
		
		//System.out.println(userId); 이상무
		//System.out.println(userPwd); 이상무
		//System.out.println(nick);  이상무
		//System.out.println(email); 이상무

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
