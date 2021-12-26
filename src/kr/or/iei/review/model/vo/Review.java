package kr.or.iei.review.model.vo;

import java.sql.Date;
import java.util.ArrayList;

public class Review {

	private int postNum;
	private String userId;
	private Date regDate;
	private String postTitle;
	private String postContent;
	private int hits;
	private int good;
	private char best_YN;
	private char del_YN;
	private String nick;
	private ArrayList<ReviewComment> comments;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Review(int postNum, String userId, Date regDate, String postTitle, String postContent, int hits, int good,
			char best_YN, char del_YN, String nick) {
		super();
		this.postNum = postNum;
		this.userId = userId;
		this.regDate = regDate;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.hits = hits;
		this.good = good;
		this.best_YN = best_YN;
		this.del_YN = del_YN;
		this.nick = nick;
	}

	public ArrayList<ReviewComment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<ReviewComment> comments) {
		this.comments = comments;
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

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
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

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@Override
	public String toString() {
		return "Review [postNum=" + postNum + ", userId=" + userId + ", regDate=" + regDate + ", postTitle=" + postTitle
				+ ", postContent=" + postContent + ", hits=" + hits + ", good=" + good + ", best_YN=" + best_YN
				+ ", del_YN=" + del_YN + ", nick=" + nick + "]";
	}

	
	
}
