package kr.or.iei.admin.crew.model.vo;

import java.sql.Date;

public class AdminCrewFeed {

	private int c_No;
	private String nick;
	private int c_f_No;
	private Date c_f_RegDate;
	private String c_f_Subject;
	private String c_f_Content;
	private char c_f_Del_YN;
	private char c_f_Like_YN;
	private int likeCount;
	
	
	public AdminCrewFeed() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminCrewFeed(int c_No, String nick, int c_f_No, Date c_f_RegDate, String c_f_Subject, String c_f_Content,
			char c_f_Del_YN, char c_f_Like_YN, int likeCount) {
		super();
		this.c_No = c_No;
		this.nick = nick;
		this.c_f_No = c_f_No;
		this.c_f_RegDate = c_f_RegDate;
		this.c_f_Subject = c_f_Subject;
		this.c_f_Content = c_f_Content;
		this.c_f_Del_YN = c_f_Del_YN;
		this.c_f_Like_YN = c_f_Like_YN;
		this.likeCount = likeCount;
	}
	public int getC_No() {
		return c_No;
	}
	public void setC_No(int c_No) {
		this.c_No = c_No;
	}
	public String getnick() {
		return nick;
	}
	public void setnick(String nick) {
		this.nick = nick;
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
	
	
}