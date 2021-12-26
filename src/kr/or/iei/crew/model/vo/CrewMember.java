package kr.or.iei.crew.model.vo;

import java.sql.Date;

public class CrewMember {

	private String userId;
	private int crewNo;
	private String crewAuthorityId;
	private Date crewEnrollDate;
	private String crewJoinState;
	private char crewEndYN;
	private String nick;
	private String memberImg;
	
	
	//생성자
	public CrewMember() {
		super();
	}

	public CrewMember(String userId, int crewNo, String crewAuthorityId, Date crewEnrollDate, String crewJoinState,
			char crewEndYN, String nick, String memberImg) {
		super();
		this.userId = userId;
		this.crewNo = crewNo;
		this.crewAuthorityId = crewAuthorityId;
		this.crewEnrollDate = crewEnrollDate;
		this.crewJoinState = crewJoinState;
		this.crewEndYN = crewEndYN;
		this.nick = nick;
		this.memberImg = memberImg;
	}


	//getter setter
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

	public String getCrewAuthorityId() {
		return crewAuthorityId;
	}

	public void setCrewAuthorityId(String crewAuthorityId) {
		this.crewAuthorityId = crewAuthorityId;
	}

	public Date getCrewEnrollDate() {
		return crewEnrollDate;
	}

	public void setCrewEnrollDate(Date crewEnrollDate) {
		this.crewEnrollDate = crewEnrollDate;
	}

	public String getCrewJoinState() {
		return crewJoinState;
	}

	public void setCrewJoinState(String crewJoinState) {
		this.crewJoinState = crewJoinState;
	}

	public char getCrewEndYN() {
		return crewEndYN;
	}

	public void setCrewEndYN(char crewEndYN) {
		this.crewEndYN = crewEndYN;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getMemberImg() {
		return memberImg;
	}

	public void setMemberImg(String memberImg) {
		this.memberImg = memberImg;
	}

	@Override
	public String toString() {
		return "CrewMember [userId=" + userId + ", crewNo=" + crewNo + ", crewAuthorityId=" + crewAuthorityId
				+ ", crewEnrollDate=" + crewEnrollDate + ", crewJoinState=" + crewJoinState + ", crewEndYN=" + crewEndYN
				+ ", nick=" + nick + ", memberImg=" + memberImg + "]";
	}
	
}
