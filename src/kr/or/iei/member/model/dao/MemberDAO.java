package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class MemberDAO {

	public Member selectOneMember(String userId, String userPwd, Connection conn) {

		PreparedStatement pstmt = null;
		Member m=null;
		ResultSet rset= null;
		
		String query ="SELECT*FROM MEMBER WHERE USERID=? AND USERPWD=? AND END_YN='N'";
	
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset =pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();

				m.setAuthority_Id(rset.getString("authority_Id"));//1
				m.setUserId(rset.getString("userId"));//2
				m.setUserPwd(rset.getString("userPwd"));//3
				m.setNick(rset.getString("nick"));//4
				m.setEmail(rset.getString("email"));//5
				m.setP_Image(rset.getString("p_Image"));//6
				m.setEnrollDate(rset.getDate("enrollDate"));//7
			}
			
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
		
	}

	public int insertOneMember(Member m, Connection conn) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		//MEMBER_SEQ.NEXTVAL,SYSDATE,'N'는 고정값이라 위치 홀더를 쓰지 않는다.
		String query= "INSERT INTO MEMBER VALUES(DEFAULT,?,?,?,?,NULL,SYSDATE,'N')";

		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getNick());
			pstmt.setString(4, m.getEmail());
			
			result=pstmt.executeUpdate();//테이블에 영향을 줬다.
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public boolean selectIdCheck(String userId, Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		boolean result = false;
		
		String query= "select userId from Member WHERE userId=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				result= true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public boolean selectNickCheck(String nick, Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		boolean result = false;
		
		String query= "select nick from Member WHERE nick=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nick);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				result= true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public boolean selectEmailCheck(String email, Connection conn) {
		PreparedStatement pstmt= null;
		ResultSet rset= null;
		boolean result = false;
		
		String query= "select email from Member WHERE email=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				result= true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	public Member SearchId(String email , Connection conn) {
		
		PreparedStatement pstmt = null;
		Member m=null;
		ResultSet rset= null;
		
		String query ="SELECT*FROM MEMBER WHERE EMAIL=? AND END_YN='N'";
	
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, email);
			rset= pstmt.executeQuery();
						
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("userId"));//1
				m.setEmail(rset.getString("email"));//2
				m.setEnrollDate(rset.getDate("enrollDate"));//3
			}
			
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
		
	}
	
	
	public Member SearchPwd(String userId, String email , Connection conn) {
		
		PreparedStatement pstmt = null;
		Member m=null;
		ResultSet rset= null;
		
		String query ="SELECT*FROM MEMBER WHERE userID=? AND EMAIL=? AND END_YN='N'";
	
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			pstmt.setString(2, email);
			rset= pstmt.executeQuery();
						
			if(rset.next()) {
				m = new Member();
				m.setUserId(rset.getString("userId"));//1
				m.setUserPwd(rset.getString("userPwd"));//2
				m.setEmail(rset.getString("email"));//3
			}
			
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return m;
		
	}



	
	

}