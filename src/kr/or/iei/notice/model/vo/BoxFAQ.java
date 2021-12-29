package kr.or.iei.notice.model.vo;

import java.sql.Date;

public class BoxFAQ {
	
	
	private int boxFAQNo;//1
	private String  boxAnswerFAQTitle;// 2 
	private String  boxFAQContent;// 3 
	private char delYN;//4
	
	public BoxFAQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoxFAQ(int boxFAQNo, String boxAnswerFAQTitle, String boxFAQContent, char delYN) {
		super();
		this.boxFAQNo = boxFAQNo;
		this.boxAnswerFAQTitle = boxAnswerFAQTitle;
		this.boxFAQContent = boxFAQContent;
		this.delYN = delYN;
	}

	public int getBoxFAQNo() {
		return boxFAQNo;
	}

	public void setBoxFAQNo(int boxFAQNo) {
		this.boxFAQNo = boxFAQNo;
	}

	public String getBoxAnswerFAQTitle() {
		return boxAnswerFAQTitle;
	}

	public void setBoxAnswerFAQTitle(String boxAnswerFAQTitle) {
		this.boxAnswerFAQTitle = boxAnswerFAQTitle;
	}

	public String getBoxFAQContent() {
		return boxFAQContent;
	}

	public void setBoxFAQContent(String boxFAQContent) {
		this.boxFAQContent = boxFAQContent;
	}

	public char getDelYN() {
		return delYN;
	}

	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}

	@Override
	public String toString() {
		return "BoxFAQ [boxFAQNo=" + boxFAQNo + ", boxAnswerFAQTitle=" + boxAnswerFAQTitle + ", boxFAQContent="
				+ boxFAQContent + ", delYN=" + delYN + "]";
	}
	
	

}
