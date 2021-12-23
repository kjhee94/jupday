package kr.or.iei.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.iei.member.model.vo.Member;

/**
 * @author ${김이서}
 * Description : 회원권한 체크 Class (관리자/비관리자)
 * 2021. 12. 23.
 */

public abstract class MemberAuthorityCheck {
	
	public static String authorityCheck(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
		{
			HttpSession session = req.getSession(false);
			
			Object obj = session.getAttribute("member");
			
			//로그인을 하지 않은 사용자일 경우
			if(obj==null) {
				
				return null;				
			}
		
			Member m = (Member) obj;
			
			if(!m.getAuthority_Id().equals("root"))  //관리자가 아니라면
			
			{
				return null;
			}else //관리자라면
			{
				return m.getAuthority_Id();
			}
		}

}
