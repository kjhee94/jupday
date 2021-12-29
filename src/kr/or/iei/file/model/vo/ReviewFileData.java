package kr.or.iei.file.model.vo;

import java.sql.Timestamp;

public class ReviewFileData {

	private int R_F_File_No;
	private int postNum;
	private String userId;
	private String R_F_Original;
	private String R_F_Change;
	private String R_F_Filepath;
	private long R_F_Filesize;
	private Timestamp R_F_File_Updatetime;
	private char R_F_Filedel_YN;
	
	public ReviewFileData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewFileData(int r_F_File_No, int postNum, String userId, String r_F_Original, String r_F_Change,
			String r_F_Filepath, long r_F_Filesize, Timestamp r_F_File_Updatetime, char r_F_Filedel_YN) {
		super();
		R_F_File_No = r_F_File_No;
		this.postNum = postNum;
		this.userId = userId;
		R_F_Original = r_F_Original;
		R_F_Change = r_F_Change;
		R_F_Filepath = r_F_Filepath;
		R_F_Filesize = r_F_Filesize;
		R_F_File_Updatetime = r_F_File_Updatetime;
		R_F_Filedel_YN = r_F_Filedel_YN;
	}



	public int getR_F_File_No() {
		return R_F_File_No;
	}

	public void setR_F_File_No(int r_F_File_No) {
		R_F_File_No = r_F_File_No;
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

	public String getR_F_Original() {
		return R_F_Original;
	}

	public void setR_F_Original(String r_F_Original) {
		R_F_Original = r_F_Original;
	}

	public String getR_F_Change() {
		return R_F_Change;
	}

	public void setR_F_Change(String r_F_Change) {
		R_F_Change = r_F_Change;
	}

	public String getR_F_Filepath() {
		return R_F_Filepath;
	}

	public void setR_F_Filepath(String r_F_Filepath) {
		R_F_Filepath = r_F_Filepath;
	}

	public long getR_F_Filesize() {
		return R_F_Filesize;
	}

	public void setR_F_Filesize(long r_F_Filesize) {
		R_F_Filesize = r_F_Filesize;
	}

	public Timestamp getR_F_File_Updatetime() {
		return R_F_File_Updatetime;
	}

	public void setR_F_File_Updatetime(Timestamp r_F_File_Updatetime) {
		R_F_File_Updatetime = r_F_File_Updatetime;
	}

	public char getR_F_Filedel_YN() {
		return R_F_Filedel_YN;
	}

	public void setR_F_Filedel_YN(char r_F_Filedel_YN) {
		R_F_Filedel_YN = r_F_Filedel_YN;
	}
	
	
	
	
	
	
}
