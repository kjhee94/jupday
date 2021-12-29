package kr.or.iei.notice.model.vo;

import java.sql.Date;

public class NoticeCampaign {
	
	/*CREATE TABLE NOTICE_CAMPAIGN(
		    NC_NO NUMBER PRIMARY KEY,
		    NC_WRITER NVARCHAR2(10),
			NC_TITLE NVARCHAR2(200),
		    NC_CONTENT NVARCHAR2(2000),
		    NC_REGDATE DATE,
		    NC_HITS number*/
	
	
	
	//MemberField
	private int campaignNo;//1
	private String campaignWriter;//2
	private String campaignTitle;//3
	private String campaignContent;//4
	private Date campaignRegDate;//5
	private int campaignHits;
	
	
	public NoticeCampaign() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//메인페이지에서 공지사항 캠페인 리스트에 사용하는 생성자
	public NoticeCampaign(int campaignNo, String campaignTitle, String campaignContent, Date campaignRegDate) {
		super();
		this.campaignNo = campaignNo;
		this.campaignTitle = campaignTitle;
		this.campaignContent = campaignContent;
		this.campaignRegDate = campaignRegDate;
	}


	public NoticeCampaign(int campaignNo, String campaignWriter, String campaignTitle, String campaignContent,
			Date campaignRegDate, int campaignHits) {
		super();
		this.campaignNo = campaignNo;
		this.campaignWriter = campaignWriter;
		this.campaignTitle = campaignTitle;
		this.campaignContent = campaignContent;
		this.campaignRegDate = campaignRegDate;
		this.campaignHits = campaignHits;
	}


	public int getCampaignNo() {
		return campaignNo;
	}


	public void setCampaignNo(int campaignNo) {
		this.campaignNo = campaignNo;
	}


	public String getCampaignWriter() {
		return campaignWriter;
	}


	public void setCampaignWriter(String campaignWriter) {
		this.campaignWriter = campaignWriter;
	}


	public String getCampaignTitle() {
		return campaignTitle;
	}


	public void setCampaignTitle(String campaignTitle) {
		this.campaignTitle = campaignTitle;
	}


	public String getCampaignContent() {
		return campaignContent;
	}


	public void setCampaignContent(String campaignContent) {
		this.campaignContent = campaignContent;
	}


	public Date getCampaignRegDate() {
		return campaignRegDate;
	}


	public void setCampaignRegDate(Date campaignRegDate) {
		this.campaignRegDate = campaignRegDate;
	}


	public int getCampaignHits() {
		return campaignHits;
	}


	public void setCampaignHits(int campaignHits) {
		this.campaignHits = campaignHits;
	}


	@Override
	public String toString() {
		return "NoticeCampaign [campaignNo=" + campaignNo + ", campaignWriter=" + campaignWriter + ", campaignTitle="
				+ campaignTitle + ", campaignContent=" + campaignContent + ", campaignRegDate=" + campaignRegDate
				+ ", campaignHits=" + campaignHits + "]";
	}
	
	
	
}
	