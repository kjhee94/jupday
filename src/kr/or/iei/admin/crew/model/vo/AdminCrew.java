package kr.or.iei.admin.crew.model.vo;

import java.sql.Date;

public class AdminCrew {
	
		private int c_No;
		private String c_Name;
		private Date c_CreateDate;
		private String c_Info;
		private char c_Del_YN;
		private int c_Count;
		
		
		public AdminCrew() {
			super();
			// TODO Auto-generated constructor stub
		}

		public AdminCrew(int c_No, String c_Name, Date c_CreateDate, String c_Info, char c_Del_YN, int c_Count) {
			super();
			this.c_No = c_No;
			this.c_Name = c_Name;
			this.c_CreateDate = c_CreateDate;
			this.c_Info = c_Info;
			this.c_Del_YN = c_Del_YN;
			this.c_Count = c_Count;
		}
		
		public int getC_No() {
			return c_No;
		}
		public void setC_No(int c_No) {
			this.c_No = c_No;
		}
		public String getC_Name() {
			return c_Name;
		}
		public void setC_Name(String c_Name) {
			this.c_Name = c_Name;
		}
		public Date getC_CreateDate() {
			return c_CreateDate;
		}
		public void setC_CreateDate(Date c_CreateDate) {
			this.c_CreateDate = c_CreateDate;
		}
		public String getC_Info() {
			return c_Info;
		}
		public void setC_Info(String c_Info) {
			this.c_Info = c_Info;
		}
		public char getC_Del_YN() {
			return c_Del_YN;
		}
		public void setC_Del_YN(char c_Del_YN) {
			this.c_Del_YN = c_Del_YN;
		}
		public int getC_Count() {
			return c_Count;
		}
		public void setC_Count(int c_Count) {
			this.c_Count = c_Count;
		}
}

