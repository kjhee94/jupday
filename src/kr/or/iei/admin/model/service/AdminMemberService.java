package kr.or.iei.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.member.model.vo.Member;

public interface AdminMemberService {
	
	//요청한 페이지에 대한 목록 리턴
	public HashMap<String, Object> selectAllMemberList(int currentPage);
	
	public int updateMemberEndYN(String userId, char endYN);

}
