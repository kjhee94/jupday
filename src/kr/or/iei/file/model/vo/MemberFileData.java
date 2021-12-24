package kr.or.iei.file.model.vo;

import java.sql.Timestamp;

public class MemberFileData {
	/* 
 	P_FILE_NO NUMBER PRIMARY KEY, -- 파일번호 고유번호 생성
    USERID NVARCHAR2(30), --유저아이디
    M_P_ORIGINAL NVARCHAR2(100), --원본 파일명
    M_P_CHANGE NVARCHAR2(100), --수정된 파일명
    M_P_FILEPAE NUMBER NOT NULL, --파일크기
    M_P_FILE_UPTH NVARCHAR2(300) NOT NULL, --저장경로
    M_P_FILESIZDATETIME TIMESTAMP, --업로드시점
    M_P_FILEDEL_YN CHAR(1) CHECK (M_P_FILEDEL_YN IN ('Y', 'N')) --삭제여부
    */
	
	private int P_File_No;
	private String userId;
	private String M_P_Original;
	private String M_P_Change;
	private long M_P_FilePae;
	private String M_P_File_Upth;
	private Timestamp M_P_File_UpdateTime;
	private char FileDel_YN;
	
	
	public MemberFileData(int p_File_No, String userId, String m_P_Original, String m_P_Change, long m_P_FilePae,
			String m_P_File_Upth, Timestamp m_P_File_UpdateTime, char fileDel_YN) {
		super();
		P_File_No = p_File_No;
		this.userId = userId;
		M_P_Original = m_P_Original;
		M_P_Change = m_P_Change;
		M_P_FilePae = m_P_FilePae;
		M_P_File_Upth = m_P_File_Upth;
		M_P_File_UpdateTime = m_P_File_UpdateTime;
		FileDel_YN = fileDel_YN;
	}


	public MemberFileData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getP_File_No() {
		return P_File_No;
	}
	public void setP_File_No(int p_File_No) {
		P_File_No = p_File_No;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getM_P_Original() {
		return M_P_Original;
	}
	public void setM_P_Original(String m_P_Original) {
		M_P_Original = m_P_Original;
	}
	public String getM_P_Change() {
		return M_P_Change;
	}
	public void setM_P_Change(String m_P_Change) {
		M_P_Change = m_P_Change;
	}
	public long getM_P_FilePae() {
		return M_P_FilePae;
	}
	public void setM_P_FilePae(long m_P_FilePae) {
		M_P_FilePae = m_P_FilePae;
	}
	public String getM_P_File_Upth() {
		return M_P_File_Upth;
	}
	public void setM_P_File_Upth(String m_P_File_Upth) {
		M_P_File_Upth = m_P_File_Upth;
	}
	public Timestamp getM_P_File_UpdateTime() {
		return M_P_File_UpdateTime;
	}
	public void setM_P_File_UpdateTime(Timestamp m_P_File_UpdateTime) {
		M_P_File_UpdateTime = m_P_File_UpdateTime;
	}
	public char getFileDel_YN() {
		return FileDel_YN;
	}
	public void setFileDel_YN(char fileDel_YN) {
		FileDel_YN = fileDel_YN;
	}
	
	
	
	
}
