package kr.or.iei.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.member.model.vo.Member;

public interface AdminMemberService {
	
	//요청한 페이지에 대한 목록 리턴
	HashMap<String, Object> selectAllMemberPageList(int currentPage);
	
	public int updateMemberEndYN(String userId, char endYN);

	
	
	/**
	 * 남진구
	 * @param currentPage
	 * @param keyword
	 * @param type
	 * @return
	 * 
	 * 실패하면 이 메소드를 삭제할것.
	 */
	HashMap<String, Object> adminMemberSearch(int currentPage, String keyword, String type);

}
