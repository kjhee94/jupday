package kr.or.iei.admin.notice.model.vo;

import java.sql.Date;

public class AdminCampaign {
	private int nc_No;
	private String nc_Title;
	private String nc_Content;
	private Date nc_regDate;
	private char nc_Del_YN;
	
	public AdminCampaign() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AdminCampaign(char nc_Del_YN) {
		super();
		this.nc_Del_YN = nc_Del_YN;
	}
	public char getNc_Del_YN() {
		return nc_Del_YN;
	}
	public void setNc_Del_YN(char nc_Del_YN) {
		this.nc_Del_YN = nc_Del_YN;
	}
	
	public AdminCampaign(int nc_No, String nc_Title, String nc_Content, Date nc_regDate) {
		super();
		this.nc_No = nc_No;
		this.nc_Title = nc_Title;
		this.nc_Content = nc_Content;
		this.nc_regDate = nc_regDate;
	}
	public int getNc_No() {
		return nc_No;
	}
	public void setNc_No(int nc_No) {
		this.nc_No = nc_No;
	}
	public String getNc_Title() {
		return nc_Title;
	}
	public void setNc_Title(String nc_Title) {
		this.nc_Title = nc_Title;
	}
	public String getNc_Content() {
		return nc_Content;
	}
	public void setNc_Content(String nc_Content) {
		this.nc_Content = nc_Content;
	}
	public Date getNc_regDate() {
		return nc_regDate;
	}
	public void setNc_regDate(Date nc_regDate) {
		this.nc_regDate = nc_regDate;
	}
}


