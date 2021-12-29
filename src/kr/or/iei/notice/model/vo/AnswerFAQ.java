package kr.or.iei.notice.model.vo;

import java.sql.Date;

public class AnswerFAQ {
	
	private int answerFAQNo;//1
	private String  answerFAQWriter;// 2 
	private String  answerFAQContent;// 3 
	private Date  answerFAQRegDate;// 4
	private char delYN;//5 
	
	public AnswerFAQ() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnswerFAQ(int answerFAQNo, String answerFAQWriter, String answerFAQContent, Date answerFAQRegDate,
			char delYN) {
		super();
		this.answerFAQNo = answerFAQNo;
		this.answerFAQWriter = answerFAQWriter;
		this.answerFAQContent = answerFAQContent;
		this.answerFAQRegDate = answerFAQRegDate;
		this.delYN = delYN;
	}

	public int getAnswerFAQNo() {
		return answerFAQNo;
	}

	public void setAnswerFAQNo(int answerFAQNo) {
		this.answerFAQNo = answerFAQNo;
	}

	public String getAnswerFAQWriter() {
		return answerFAQWriter;
	}

	public void setAnswerFAQWriter(String answerFAQWriter) {
		this.answerFAQWriter = answerFAQWriter;
	}

	public String getAnswerFAQContent() {
		return answerFAQContent;
	}

	public void setAnswerFAQContent(String answerFAQContent) {
		this.answerFAQContent = answerFAQContent;
	}

	public Date getAnswerFAQRegDate() {
		return answerFAQRegDate;
	}

	public void setAnswerFAQRegDate(Date answerFAQRegDate) {
		this.answerFAQRegDate = answerFAQRegDate;
	}

	public char getDelYN() {
		return delYN;
	}

	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}

	@Override
	public String toString() {
		return "AnswerFAQ [answerFAQNo=" + answerFAQNo + ", answerFAQWriter=" + answerFAQWriter + ", answerFAQContent="
				+ answerFAQContent + ", answerFAQRegDate=" + answerFAQRegDate + ", delYN=" + delYN + "]";
	}
	
	
	
	

}
