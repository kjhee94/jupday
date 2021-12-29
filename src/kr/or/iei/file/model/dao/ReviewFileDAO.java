package kr.or.iei.file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.file.model.vo.ReviewFileData;

public class ReviewFileDAO {

	public int insertFileUpload(Connection conn, ReviewFileData rfd) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		/*
		 R_F_FILE_NO NUMBER PRIMARY KEY, -- 파일번호 고유번호 생성
	    USERID NVARCHAR2(12), -- 유저아이디 외래키
	    R_F_ORIGINAL NVARCHAR2(100), --원본 파일명
	    R_F_CHANGE NVARCHAR2(100), --수정된 파일명
	    R_F_FILEPATH NVARCHAR2(300) NOT NULL, --저장경로
	    R_F_FILESIZE NUMBER NOT NULL, --파일크기
	    R_F_FILE_UPDATETIME TIMESTAMP, --업로드시점
	    R_F_FILEDEL_YN CHAR(1) CHECK (R_F_FILEDEL_YN IN ('Y', 'N')) --삭제여부
		 */
		
		String query = "insert into REVIEW_FILE values(R_F_FILE_SEQ.nextval,?,?,?,?,?,?,'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, rfd.getUserId());
			pstmt.setString(2, rfd.getR_F_Original());
			pstmt.setString(3, rfd.getR_F_Change());
			pstmt.setString(4, rfd.getR_F_Filepath());
			pstmt.setLong(5, rfd.getR_F_Filesize());
			pstmt.setTimestamp(6, rfd.getR_F_File_Updatetime());
			
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
