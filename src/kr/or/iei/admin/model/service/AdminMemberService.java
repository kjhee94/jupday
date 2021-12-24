package kr.or.iei.admin.model.service;

import java.util.ArrayList;

import kr.or.iei.member.model.vo.Member;

public interface AdminMemberService {
	
	public ArrayList<Member> selectAllMemberList(String authorityId);

}
