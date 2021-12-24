package kr.or.iei.file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.file.model.vo.MemberFileData;

public class MemberFileDAO {

	public static int insertFileUpload(Connection conn, MemberFileData mfd) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO MEMBER_PROFILE VALUES(M_PROFILE_SEQ.NEXTVAL,?,?,?,?,?,?,'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mfd.getUserId());
			pstmt.setString(2, mfd.getM_P_Original());
			pstmt.setString(3, mfd.getM_P_Change());
			pstmt.setString(4, mfd.getM_P_File_Upth());
			pstmt.setLong(5, mfd.getM_P_FilePae());
			pstmt.setTimestamp(6, mfd.getM_P_File_UpdateTime());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	
}
