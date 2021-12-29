package kr.or.iei.admin.notice.model.vo;

import java.sql.Date;

public class AdminNotice {
	
	private int n_No;
	private String n_Title;
	private String n_Content;
	private Date n_regDate;
	private char n_Del_YN;
	
	public AdminNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminNotice(int n_No, String n_Title, String n_Content, Date n_regDate, char n_Del_YN) {
		super();
		this.n_No = n_No;
		this.n_Title = n_Title;
		this.n_Content = n_Content;
		this.n_regDate = n_regDate;
		this.n_Del_YN = n_Del_YN;
	}
	public int getN_No() {
		return n_No;
	}
	public void setN_No(int n_No) {
		this.n_No = n_No;
	}
	public String getN_Title() {
		return n_Title;
	}
	public void setN_Title(String n_Title) {
		this.n_Title = n_Title;
	}
	public String getN_Content() {
		return n_Content;
	}
	public void setN_Content(String n_Content) {
		this.n_Content = n_Content;
	}
	public Date getN_regDate() {
		return n_regDate;
	}
	public void setN_regDate(Date n_regDate) {
		this.n_regDate = n_regDate;
	}
	public char getN_Del_YN() {
		return n_Del_YN;
	}
	public void setN_Del_YN(char n_Del_YN) {
		this.n_Del_YN = n_Del_YN;
	}
	
}
	
