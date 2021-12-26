package kr.or.iei.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.member.model.vo.Member;

public interface AdminMemberService {
	
<<<<<<< HEAD
=======
	//요청한 페이지에 대한 목록 리턴
	public HashMap<String, Object> selectAllMemberList(int currentPage);
	
>>>>>>> f93397b939848e98cbef78726858accdef6ad98d
	public int updateMemberEndYN(String userId, char endYN);

	//요청한 페이지에 대한 목록 리턴
	HashMap<String, Object> selectAllMemberPageList(int currentPage);

}
