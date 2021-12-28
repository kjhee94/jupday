package kr.or.iei.crew.model.vo;

import java.sql.Timestamp;

public class CrewFileData {

//	  C_P_FILE_NO NUMBER PRIMARY KEY, -- 파일번호 고유번호 생성
//    USERID NVARCHAR2(20), -- 유저아이디 외래키
//    C_NO NUMBER, -- 크루테이블에서 가져온 크루번호 외래키
//    C_P_ORIGINAL NVARCHAR2(100), --원본 파일명
//    C_P_CHANGE NVARCHAR2(100), --수정된 파일명
//    C_P_FILEPATH NVARCHAR2(300) NOT NULL, --저장경로
//    C_P_FILESIZE NUMBER NOT NULL, --파일크기
//    C_P_FILE_UPDATETIME TIMESTAMP, --업로드시점
//    C_P_FILEDEL_YN CHAR(1) CHECK (C_P_FILEDEL_YN IN ('Y', 'N')) --삭제여부
	
	private int crewProfileNo;
	private String userId;
	private int crewNo;
	private String crewProfileOriginal;
	private String crewProfileChange;
	private String crewProfilePath;
	private long crewProfileSize;
	private Timestamp crewProfileUpdateTime;
	private char crewProfileDelYN;
	
	
	//생성자
	public CrewFileData() {
		super();
	}

	public CrewFileData(int crewProfileNo, String userId, int crewNo, String crewProfileOriginal,
			String crewProfileChange, String crewProfilePath, long crewProfileSize, Timestamp crewProfileUpdateTime,
			char crewProfileDelYN) {
		super();
		this.crewProfileNo = crewProfileNo;
		this.userId = userId;
		this.crewNo = crewNo;
		this.crewProfileOriginal = crewProfileOriginal;
		this.crewProfileChange = crewProfileChange;
		this.crewProfilePath = crewProfilePath;
		this.crewProfileSize = crewProfileSize;
		this.crewProfileUpdateTime = crewProfileUpdateTime;
		this.crewProfileDelYN = crewProfileDelYN;
	}

	
	//getter setter
	public int getCrewProfileNo() {
		return crewProfileNo;
	}

	public void setCrewProfileNo(int crewProfileNo) {
		this.crewProfileNo = crewProfileNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getCrewNo() {
		return crewNo;
	}

	public void setCrewNo(int crewNo) {
		this.crewNo = crewNo;
	}

	public String getCrewProfileOriginal() {
		return crewProfileOriginal;
	}

	public void setCrewProfileOriginal(String crewProfileOriginal) {
		this.crewProfileOriginal = crewProfileOriginal;
	}

	public String getCrewProfileChange() {
		return crewProfileChange;
	}

	public void setCrewProfileChange(String crewProfileChange) {
		this.crewProfileChange = crewProfileChange;
	}

	public String getCrewProfilePath() {
		return crewProfilePath;
	}

	public void setCrewProfilePath(String crewProfilePath) {
		this.crewProfilePath = crewProfilePath;
	}

	public long getCrewProfileSize() {
		return crewProfileSize;
	}

	public void setCrewProfileSize(long crewProfileSize) {
		this.crewProfileSize = crewProfileSize;
	}

	public Timestamp getCrewProfileUpdateTime() {
		return crewProfileUpdateTime;
	}

	public void setCrewProfileUpdateTime(Timestamp crewProfileUpdateTime) {
		this.crewProfileUpdateTime = crewProfileUpdateTime;
	}

	public char getCrewProfileDelYN() {
		return crewProfileDelYN;
	}

	public void setCrewProfileDelYN(char crewProfileDelYN) {
		this.crewProfileDelYN = crewProfileDelYN;
	}

	@Override
	public String toString() {
		return "CrewFileData [crewProfileNo=" + crewProfileNo + ", userId=" + userId + ", crewNo=" + crewNo
				+ ", crewProfileOriginal=" + crewProfileOriginal + ", crewProfileChange=" + crewProfileChange
				+ ", crewProfilePath=" + crewProfilePath + ", crewProfileSize=" + crewProfileSize
				+ ", crewProfileUpdateTime=" + crewProfileUpdateTime + ", crewProfileDelYN=" + crewProfileDelYN + "]";
	}
	
	
}
