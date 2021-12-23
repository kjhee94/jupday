package kr.or.iei.member.model.vo;

import java.sql.Date;

public class Member {
	
	//총 8개 MEMBER FIELD
	private int authority_Id;//2
	private String userId;//3
	private String userPwd;//4
	private String nick;//5
	private String email;//6
	private String p_Image;//7
	private Date enrollDate;//8
	private char end_YN;//9
	
	
	//회원정보수정시 필요한 항목
	public Member(String nick, String email, String p_Image) {
		super();
		this.nick = nick;
		this.email = email;
		this.p_Image = p_Image;
	}

	//DEFAULT CONSTRUCTOR
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}

	//CONSTRUCTOR
	public Member(int authority_Id, String userId, String userPwd, String nick, String email,
			String p_Image, Date enrollDate, char end_YN) {
		super();
		this.authority_Id = authority_Id;//2
		this.userId = userId;//3
		this.userPwd = userPwd;//4
		this.nick = nick;//5
		this.email = email;//6
		this.p_Image = p_Image;//7
		this.enrollDate = enrollDate;//8
		this.end_YN = end_YN;//9
	}

	//INSERT될 COSTRUCTOR
	public Member(String userId, String userPwd, String nick, String email) {
		super();
		this.userId = userId;//1
		this.userPwd = userPwd;//2
		this.nick = nick;//3
		this.email = email;//4
	}

	//TOSTRING
	@Override
	public String toString() {
		return "Member [authority_Id=" + authority_Id + ", userId=" + userId + ", userPwd="
				+ userPwd + ", nick=" + nick + ", email=" + email + ", p_Image=" + p_Image + ", enrollDate="
				+ enrollDate + ", end_YN=" + end_YN + "]";
	}
	
	//SETTER GETTER
	public int getAuthority_Id() {
		return authority_Id;
	}
	public void setAuthority_Id(int authority_Id) {
		this.authority_Id = authority_Id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getP_Image() {
		return p_Image;
	}
	public void setP_Image(String p_Image) {
		this.p_Image = p_Image;
	}
	public Date getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}
	public char getEnd_YN() {
		return end_YN;
	}
	public void setEnd_YN(char end_YN) {
		this.end_YN = end_YN;
	}
	
	
	

}