package kr.or.iei.admin.crew.model.vo;

import java.sql.Date;

public class AdminCrew {
	
	private int crewNo;
	private String crewName;
	private Date crewCreateDate;
	private int crewCount;
	private String crewInfo;
	private char crewDelYN;
	
	
	public AdminCrew() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminCrew(int crewNo, String crewName, Date crewCreateDate, int crewCount, String crewInfo, char crewDelYN) {
		super();
		this.crewNo = crewNo;
		this.crewName = crewName;
		this.crewCreateDate = crewCreateDate;
		this.crewCount = crewCount;
		this.crewInfo = crewInfo;
		this.crewDelYN = crewDelYN;
	}
	public int getCrewNo() {
		return crewNo;
	}
	public void setCrewNo(int crewNo) {
		this.crewNo = crewNo;
	}
	public String getCrewName() {
		return crewName;
	}
	public void setCrewName(String crewName) {
		this.crewName = crewName;
	}
	public Date getCrewCreateDate() {
		return crewCreateDate;
	}
	public void setCrewCreateDate(Date crewCreateDate) {
		this.crewCreateDate = crewCreateDate;
	}
	public int getCrewCount() {
		return crewCount;
	}
	public void setCrewCount(int crewCount) {
		this.crewCount = crewCount;
	}
	public String getCrewInfo() {
		return crewInfo;
	}
	public void setCrewInfo(String crewInfo) {
		this.crewInfo = crewInfo;
	}
	public char getCrewDelYN() {
		return crewDelYN;
	}
	public void setCrewDelYN(char crewDelYN) {
		this.crewDelYN = crewDelYN;
	}
	
}