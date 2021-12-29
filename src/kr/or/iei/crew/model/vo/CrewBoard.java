package kr.or.iei.crew.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class CrewBoard {

	private int crewNo;
	private int feedNo;
	private String userId;
	private String writer;
	private String writerImg;	
	private Date feedRegdate;
	private String feedSubject;
	private String feedContent;
	private int feedLikeCount;
	private int feedCommentCount;
	private char feedDelYN;
	private ArrayList<CrewBoardComment> coList;
	
	
	//생성자
	public CrewBoard() {
		super();
	}
	
	public CrewBoard(int crewNo, int feedNo, String userId, String writer, String writerImg, Date feedRegdate,
			String feedSubject, String feedContent, int feedLikeCount, int feedCommentCount, char feedDelYN) {
		super();
		this.crewNo = crewNo;
		this.feedNo = feedNo;
		this.userId = userId;
		this.writer = writer;
		this.writerImg = writerImg;
		this.feedRegdate = feedRegdate;
		this.feedSubject = feedSubject;
		this.feedContent = feedContent;
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
	
	public String getWriter() {
		return writer;
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public String getWriterImg() {
		return writerImg;
	}
	
	public void setWriterImg(String writerImg) {
		this.writerImg = writerImg;
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
	
	public char getFeedDelYN() {
		return feedDelYN;
	}
	
	public void setFeedDelYN(char feedDelYN) {
		this.feedDelYN = feedDelYN;
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

	public ArrayList<CrewBoardComment> getCoList() {
		return coList;
	}

	public void setCoList(ArrayList<CrewBoardComment> coList) {
		this.coList = coList;
	}

	@Override
	public String toString() {
		return "CrewBoard [crewNo=" + crewNo + ", feedNo=" + feedNo + ", userId=" + userId + ", writer=" + writer
				+ ", writerImg=" + writerImg + ", feedRegdate=" + feedRegdate + ", feedSubject=" + feedSubject
				+ ", feedContent=" + feedContent + ", feedLikeCount=" + feedLikeCount + ", feedCommentCount="
				+ feedCommentCount + ", feedDelYN=" + feedDelYN + "]";
	}

	
}
