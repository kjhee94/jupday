package kr.or.iei.crew.model.vo;

import java.sql.Date;

public class CrewBoardComment {

	private int crewNo;
	private int feedNo;
	private int commentNo;
	private String userId;
	private String commentContent;
	private Date commentRegdate;
	private char commentDelYN;
	private String nick;
	private String userImg;
	
	//생성자
	public CrewBoardComment() {
		super();
	}

	public CrewBoardComment(int crewNo, int feedNo, int commentNo, String userId, String commentContent,
			Date commentRegdate, char commentDelYN, String nick, String userImg) {
		super();
		this.crewNo = crewNo;
		this.feedNo = feedNo;
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.commentRegdate = commentRegdate;
		this.commentDelYN = commentDelYN;
		this.nick = nick;
		this.userImg = userImg;
	}

	public int getCrewNo() {
		return crewNo;
	}

	public void setCrewNo(int crewNo) {
		this.crewNo = crewNo;
	}

	public int getFeedNo() {
		return feedNo;
	}

	public void setFeedNo(int feedNo) {
		this.feedNo = feedNo;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentRegdate() {
		return commentRegdate;
	}

	public void setCommentRegdate(Date commentRegdate) {
		this.commentRegdate = commentRegdate;
	}

	public char getCommentDelYN() {
		return commentDelYN;
	}

	public void setCommentDelYN(char commentDelYN) {
		this.commentDelYN = commentDelYN;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getUserImg() {
		return userImg;
	}

	public void setUserImg(String userImg) {
		this.userImg = userImg;
	}

	
	
}
