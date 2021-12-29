package kr.or.iei.admin.notice.model.vo;

public class AdminFAQ {

	private int faq_No;
	private String faq_Title;
	private String faq_Content;
	private char faq_Del_YN;
	
	
	
	public AdminFAQ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminFAQ(int faq_No, String faq_Title, String faq_Content, char faq_Del_YN) {
		super();
		this.faq_No = faq_No;
		this.faq_Title = faq_Title;
		this.faq_Content = faq_Content;
		this.faq_Del_YN = faq_Del_YN;
	}
	public int getFaq_No() {
		return faq_No;
	}
	public void setFaq_No(int faq_No) {
		this.faq_No = faq_No;
	}
	public String getFaq_Title() {
		return faq_Title;
	}
	public void setFaq_Title(String faq_Title) {
		this.faq_Title = faq_Title;
	}
	public String getFaq_Content() {
		return faq_Content;
	}
	public void setFaq_Content(String faq_Content) {
		this.faq_Content = faq_Content;
	}
	public char getFaq_Del_YN() {
		return faq_Del_YN;
	}
	public void setFaq_Del_YN(char faq_Del_YN) {
		this.faq_Del_YN = faq_Del_YN;
	}
	
	
	
	
}