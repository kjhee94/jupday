package kr.or.iei.admin.member.vo;

import java.sql.Date;

public class Member {
	
    private String authority_Id;//1
    private String userId;//2
    private String userPwd;//3
    private String nick;//4
    private String email;//5
    private String p_Image;//6
    private Date enrollDate;//7
	private char end_YN;//8
    
    public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
    
	public Member(String authority_Id, String userId, String userPwd, String nick, String email, String p_Image,
			Date enrollDate, char end_YN) {
		super();
		this.authority_Id = authority_Id;
		this.userId = userId;
		this.userPwd = userPwd;
		this.nick = nick;
		this.email = email;
		this.p_Image = p_Image;
		this.enrollDate = enrollDate;
		this.end_YN = end_YN;
	}
	public String getAuthority_Id() {
		return authority_Id;
	}
	public void setAuthority_Id(String authority_Id) {
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
