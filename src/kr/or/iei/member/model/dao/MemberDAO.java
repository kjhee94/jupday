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
		String query= "INSERT INTO MEMBER VALUES('user',?,?,?,?,NULL,SYSDATE,'N')";
			 	//"INSERT INTO MEMBER VALUES(DEFAULT,?,?,?,?,NULL,SYSDATE,'N')";


		
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


	public boolean selectEmailChecking(String email, Connection conn) {
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
	
	
	
	public Member searchId(String email , Connection conn) {
		
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
	
	
	public Member searchPwd(String userId, String email , Connection conn) {
		
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
	
	public int searchUapatePwd(String userId, String userPwd, Connection conn) {
		PreparedStatement pstmt= null;
		int result = 0; 
		
		String query ="UPDATE MEMBER SET userPwd=? Where userId=?";
		
		//preparestatement 부터 만들겠다.
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userPwd);//변경할 비밀번호
			pstmt.setString(2, userId);//아이디

			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	
	}

		

	public int updatePwdMember(String userId, String pwd, String newPwd, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET userPwd=? WHERE userId=? AND userPwd=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newPwd);
			pstmt.setString(2, userId);
			pstmt.setString(3, pwd);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public int updateOneMember(Member m, Connection conn) {
		System.out.println("updateOneMember m : " + m.toString());
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MEMBER SET p_image=?, nick=?, email=? WHERE userId=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getP_Image());
			pstmt.setString(2, m.getNick());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	public Member refreshOneMember(String userId, Connection conn) {
		PreparedStatement pstmt = null;
		Member m = null;
		ResultSet rset = null;
		
		String query = "SELECT * FROM MEMBER WHERE USERID=? AND END_YN='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				m = new Member();
				m.setAuthority_Id(rset.getString("authority_Id"));
				m.setUserId(rset.getString("userId"));
				m.setUserPwd(rset.getString("userPwd"));
				m.setNick(rset.getString("nick"));
				m.setEmail(rset.getString("email"));
				m.setP_Image(rset.getString("p_Image"));
				m.setEnrollDate(rset.getDate("enrollDate"));
				m.setEnd_YN(rset.getString("end_YN").charAt(0));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int deleteOneMember(String userId, String userPwd, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET END_YN='Y' WHERE USERID=? AND USERPWD=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			result = pstmt.executeUpdate();
			
			if(result>0) {
				
			} else {
				result = -1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
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

	public int insertFileUpdate2(Member m, Connection conn) {
		System.out.println("m : " + m.toString());
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET P_IMAGE=? WHERE USERID=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getP_Image());
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			System.out.println("result : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}

	
	

}