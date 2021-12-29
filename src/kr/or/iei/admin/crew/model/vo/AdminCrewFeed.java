package kr.or.iei.admin.crew.model.vo;

import java.sql.Date;

public class AdminCrewFeed {

	private int c_No;
	private String c_Name;
	private String c_Nick;
	private int c_f_No;
	private Date c_f_RegDate;
	private String c_f_Subject;
	private String c_f_Content;
	private char c_f_Del_YN;
	private char c_f_Like_YN;
	private int likeCount;
	private int allNum; //페이징처리할 정렬순서
	
	
	public AdminCrewFeed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminCrewFeed(int c_No, String c_Name, String c_Nick, int c_f_No, Date c_f_RegDate, String c_f_Subject,
			String c_f_Content, char c_f_Del_YN, char c_f_Like_YN, int likeCount, int allNum) {
		super();
		this.c_No = c_No;
		this.c_Name = c_Name;
		this.c_Nick = c_Nick;
		this.c_f_No = c_f_No;
		this.c_f_RegDate = c_f_RegDate;
		this.c_f_Subject = c_f_Subject;
		this.c_f_Content = c_f_Content;
		this.c_f_Del_YN = c_f_Del_YN;
		this.c_f_Like_YN = c_f_Like_YN;
		this.likeCount = likeCount;
		this.allNum = allNum;
	}
	
	public int getC_No() {
		return c_No;
	}
	public void setC_No(int c_No) {
		this.c_No = c_No;
	}
	public String getC_Name() {
		return c_Name;
	}
	public void setC_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	public String getC_Nick() {
		return c_Nick;
	}
	public void setC_Nick(String c_Nick) {
		this.c_Nick = c_Nick;
	}
	public int getC_f_No() {
		return c_f_No;
	}
	public void setC_f_No(int c_f_No) {
		this.c_f_No = c_f_No;
	}
	public Date getC_f_RegDate() {
		return c_f_RegDate;
	}
	public void setC_f_RegDate(Date c_f_RegDate) {
		this.c_f_RegDate = c_f_RegDate;
	}
	public String getC_f_Subject() {
		return c_f_Subject;
	}
	public void setC_f_Subject(String c_f_Subject) {
		this.c_f_Subject = c_f_Subject;
	}
	public String getC_f_Content() {
		return c_f_Content;
	}
	public void setC_f_Content(String c_f_Content) {
		this.c_f_Content = c_f_Content;
	}
	public char getC_f_Del_YN() {
		return c_f_Del_YN;
	}
	public void setC_f_Del_YN(char c_f_Del_YN) {
		this.c_f_Del_YN = c_f_Del_YN;
	}
	public char getC_f_Like_YN() {
		return c_f_Like_YN;
	}
	public void setC_f_Like_YN(char c_f_Like_YN) {
		this.c_f_Like_YN = c_f_Like_YN;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getAllNum() {
		return allNum;
	}
	public void setAllNum(int allNum) {
		this.allNum = allNum;
	}
	
	
}