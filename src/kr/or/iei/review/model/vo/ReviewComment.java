package kr.or.iei.review.model.vo;

import java.sql.Date;

public class ReviewComment {

	private int r_c_no;
	private int postNum;
	private String userId;
	private String r_c_comment;
	private Date r_c_regDate;
	private char r_c_del_YN;
	private String nick;
	
	public ReviewComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewComment(int r_c_no, int postNum, String userId, String r_c_comment, Date r_c_regDate) {
		super();
		this.r_c_no = r_c_no;
		this.postNum = postNum;
		this.userId = userId;
		this.r_c_comment = r_c_comment;
		this.r_c_regDate = r_c_regDate;
	}

	public int getR_c_no() {
		return r_c_no;
	}

	public void setR_c_no(int r_c_no) {
		this.r_c_no = r_c_no;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getR_c_comment() {
		return r_c_comment;
	}

	public void setR_c_comment(String r_c_comment) {
		this.r_c_comment = r_c_comment;
	}

	public Date getR_c_regDate() {
		return r_c_regDate;
	}

	public void setR_c_regDate(Date r_c_regDate) {
		this.r_c_regDate = r_c_regDate;
	}

	public char getR_c_del_YN() {
		return r_c_del_YN;
	}

	public void setR_c_del_YN(char r_c_del_YN) {
		this.r_c_del_YN = r_c_del_YN;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "ReviewComment [r_c_no=" + r_c_no + ", postNum=" + postNum + ", userId=" + userId + ", r_c_comment="
				+ r_c_comment + ", r_c_regDate=" + r_c_regDate + ", r_c_del_YN=" + r_c_del_YN + ", nick=" + nick + "]";
	}

	
}
