package kr.or.iei.admin.review.model.vo;

import java.sql.Date;

public class AdminReview {
	
	private int postnum;
	private String nick;
	private Date regDate;
	private String postTitle;
	private String postContent;
	private int good;
	private char best_YN;
	private char del_YN;
	
	public AdminReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminReview(int postnum, String nick, Date regDate, String postTitle, String postContent, int good,
			char best_YN, char del_YN) {
		super();
		this.postnum = postnum;
		this.nick = nick;
		this.regDate = regDate;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.good = good;
		this.best_YN = best_YN;
		this.del_YN = del_YN;
	}
	public int getPostnum() {
		return postnum;
	}
	public void setPostnum(int postnum) {
		this.postnum = postnum;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public char getBest_YN() {
		return best_YN;
	}
	public void setBest_YN(char best_YN) {
		this.best_YN = best_YN;
	}
	public char getDel_YN() {
		return del_YN;
	}
	public void setDel_YN(char del_YN) {
		this.del_YN = del_YN;
	}
	
}