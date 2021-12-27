package kr.or.iei.crew.model.vo;

import java.sql.Date;

public class CrewBoard {

	private int crewNo;
	private int feedNo;
	private String userId;
	private String nick;
	private Date feedRegdate;
	private String feedSubject;
	private String feedContent;
	private String feedImg;
	private int feedLikeCount;
	private int feedCommentCount;
	private char feedDelYN;
	
	
	//생성자
	public CrewBoard() {
		super();
	}

	public CrewBoard(int crewNo, int feedNo, String userId, String nick, Date feedRegdate, String feedSubject,
			String feedContent, String feedImg, int feedLikeCount, int feedCommentCount, char feedDelYN) {
		super();
		this.crewNo = crewNo;
		this.feedNo = feedNo;
		this.userId = userId;
		this.nick = nick;
		this.feedRegdate = feedRegdate;
		this.feedSubject = feedSubject;
		this.feedContent = feedContent;
		this.feedImg = feedImg;
		this.feedLikeCount = feedLikeCount;
		this.feedCommentCount = feedCommentCount;
		this.feedDelYN = feedDelYN;
	}

	
	//getter setter
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getFeedRegdate() {
		return feedRegdate;
	}

	public void setFeedRegdate(Date feedRegdate) {
		this.feedRegdate = feedRegdate;
	}

	public String getFeedSubject() {
		return feedSubject;
	}

	public void setFeedSubject(String feedSubject) {
		this.feedSubject = feedSubject;
	}

	public String getFeedContent() {
		return feedContent;
	}

	public void setFeedContent(String feedContent) {
		this.feedContent = feedContent;
	}

	public String getFeedImg() {
		return feedImg;
	}

	public void setFeedImg(String feedImg) {
		this.feedImg = feedImg;
	}

	public int getFeedLikeCount() {
		return feedLikeCount;
	}

	public void setFeedLikeCount(int feedLikeCount) {
		this.feedLikeCount = feedLikeCount;
	}

	public int getFeedCommentCount() {
		return feedCommentCount;
	}

	public void setFeedCommentCount(int feedCommentCount) {
		this.feedCommentCount = feedCommentCount;
	}

	public char getFeedDelYN() {
		return feedDelYN;
	}

	public void setFeedDelYN(char feedDelYN) {
		this.feedDelYN = feedDelYN;
	}
}
