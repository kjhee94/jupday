package kr.or.iei.notice.model.vo;

import java.sql.Date;

public class QuestionFAQ { 
	
	
	private int questionFAQNo;//1
	private String questionFAQWriter;// 2 
	private String questionFAQContent;// 3 
	private Date questionFAQRegDate;// 4
	private char delYN;//5 
	
	
	public QuestionFAQ() {
		super();
		// TODO Auto-generated constructor stub
	}


	public QuestionFAQ(int questionFAQNo, String questionFAQWriter, String questionFAQContent, Date questionFAQRegDate,
			char delYN) {
		super();
		this.questionFAQNo = questionFAQNo;
		this.questionFAQWriter = questionFAQWriter;
		this.questionFAQContent = questionFAQContent;
		this.questionFAQRegDate = questionFAQRegDate;
		this.delYN = delYN;
	}


	public int getQuestionFAQNo() {
		return questionFAQNo;
	}


	public void setQuestionFAQNo(int questionFAQNo) {
		this.questionFAQNo = questionFAQNo;
	}


	public String getQuestionFAQWriter() {
		return questionFAQWriter;
	}


	public void setQuestionFAQWriter(String questionFAQWriter) {
		this.questionFAQWriter = questionFAQWriter;
	}


	public String getQuestionFAQContent() {
		return questionFAQContent;
	}


	public void setQuestionFAQContent(String questionFAQContent) {
		this.questionFAQContent = questionFAQContent;
	}


	public Date getQuestionFAQRegDate() {
		return questionFAQRegDate;
	}


	public void setQuestionFAQRegDate(Date questionFAQRegDate) {
		this.questionFAQRegDate = questionFAQRegDate;
	}


	public char getDelYN() {
		return delYN;
	}


	public void setDelYN(char delYN) {
		this.delYN = delYN;
	}


	@Override
	public String toString() {
		return "QuestionFAQ [questionFAQNo=" + questionFAQNo + ", questionFAQWriter=" + questionFAQWriter
				+ ", questionFAQContent=" + questionFAQContent + ", questionFAQRegDate=" + questionFAQRegDate
				+ ", delYN=" + delYN + "]";
	}

	

    		
    		

}
