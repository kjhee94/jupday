package kr.or.iei.admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class AdminMemberDAO {
	
	public ArrayList<Member> SelectAllMemberList(String authorityId, Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();

		String query = selectAllMemberQuery(authorityId);
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			//여러명이므로 while
			while(rset.next()) 
			{
				//Member m은 MemberDAO와 겹쳐서 mem으로 대체
				Member mem = new Member();
				mem.setAuthority_Id(rset.getString("authority_Id")); //1
				mem.setUserId(rset.getString("userId")); //2
				mem.setUserPwd(rset.getString("userPwd")); //3
				mem.setNick(rset.getString("nick")); //4
				mem.setEmail(rset.getString("email")); //5
				mem.setP_Image(rset.getString("p_Image")); //6
				mem.setEnrollDate(rset.getDate("enrollDate")); //7
				mem.setEnd_YN(rset.getString("end_yn").charAt(0)); //8
				list.add(mem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}

	public String selectAllMemberQuery(String authorityId)
	{
		String query = "SELECT * FROM MEMBER"; 
		return query;
	}

	public int updateMemberEndYN(String userId, char endYN, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MEMBER SET end_YN=? WHERE userId=? AND authority_id!='root'";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, String.valueOf(endYN));
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
}
