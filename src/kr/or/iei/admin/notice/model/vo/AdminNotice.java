package kr.or.iei.admin.notice.model.vo;

import java.sql.Date;

public class AdminNotice {
	
	private int n_No;
	private String n_Title;
	private String n_Content;
	private Date n_regDate;
	private char n_Del_YN;
	
	public AdminNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminNotice(int n_No, String n_Title, String n_Content, Date n_regDate, char n_Del_YN) {
		super();
		this.n_No = n_No;
		this.n_Title = n_Title;
		this.n_Content = n_Content;
		this.n_regDate = n_regDate;
		this.n_Del_YN = n_Del_YN;
	}
	public int getN_No() {
		return n_No;
	}
	public void setN_No(int n_No) {
		this.n_No = n_No;
	}
	public String getN_Title() {
		return n_Title;
	}
	public void setN_Title(String n_Title) {
		this.n_Title = n_Title;
	}
	public String getN_Content() {
		return n_Content;
	}
	public void setN_Content(String n_Content) {
		this.n_Content = n_Content;
	}
	public Date getN_regDate() {
		return n_regDate;
	}
	public void setN_regDate(Date n_regDate) {
		this.n_regDate = n_regDate;
	}
	public char getN_Del_YN() {
		return n_Del_YN;
	}
	public void setN_Del_YN(char n_Del_YN) {
		this.n_Del_YN = n_Del_YN;
	}
	
}
	

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

/*
public class AdminFAQ {
	private int fq_No;
	private String fq_Content;
	private String fa_Content;
	private Date fq_regDate;
	private char fq_Del_YN;
	private char fa_Del_YN;
	
	public AdminFAQ() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminFAQ(int fq_No, String fq_Content, String fa_Content, Date fq_regDate, char fq_Del_YN, char fa_Del_YN) {
		super();
		this.fq_No = fq_No;
		this.fq_Content = fq_Content;
		this.fa_Content = fa_Content;
		this.fq_regDate = fq_regDate;
		this.fq_Del_YN = fq_Del_YN;
		this.fa_Del_YN = fa_Del_YN;
	}
	public int getFq_No() {
		return fq_No;
	}
	public void setFq_No(int fq_No) {
		this.fq_No = fq_No;
	}
	public String getFq_Content() {
		return fq_Content;
	}
	public void setFq_Content(String fq_Content) {
		this.fq_Content = fq_Content;
	}
	public String getFa_Content() {
		return fa_Content;
	}
	public void setFa_Content(String fa_Content) {
		this.fa_Content = fa_Content;
	}
	public Date getFq_regDate() {
		return fq_regDate;
	}
	public void setFq_regDate(Date fq_regDate) {
		this.fq_regDate = fq_regDate;
	}
	public char getFq_Del_YN() {
		return fq_Del_YN;
	}
	public void setFq_Del_YN(char fq_Del_YN) {
		this.fq_Del_YN = fq_Del_YN;
	}
	public char getFa_Del_YN() {
		return fa_Del_YN;
	}
	public void setFa_Del_YN(char fa_Del_YN) {
		this.fa_Del_YN = fa_Del_YN;
	}


	
}

*/