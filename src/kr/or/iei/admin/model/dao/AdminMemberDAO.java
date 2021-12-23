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
				Member m = new Member();
				m.setAuthority_Id(rset.getString("authority_Id")); //1
				m.setUserId(rset.getString("userId")); //2
				m.setUserPwd(rset.getString("userPwd")); //3
				m.setNick(rset.getString("nick")); //4
				m.setEmail(rset.getString("email")); //5
				m.setP_Image(rset.getString("p_Image")); //6
				m.setEnrollDate(rset.getDate("enrollDate")); //7
				m.setEnd_YN(rset.getString("end_yn").charAt(0)); //8
				list.add(m);
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

}
