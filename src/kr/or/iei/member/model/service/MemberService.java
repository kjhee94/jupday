package kr.or.iei.member.model.service;

import java.sql.Connection;

import kr.or.iei.member.model.vo.Member;

public interface MemberService {
	
	
	/**
	 * 작성자 : 남진구
	 * @param userId
	 * @param userPwd
	 * @return Member
	 * 작성일 : 2021. 12.6.
	 * Description : 회원 ID와 PW를 바탕으로 회원정보 조회
	 */
	public Member selectOneMember(String userId, String userPwd);
	

	/**
	 * 작성자: 남진구
	 * @param m
	 * @return Member
	 * 작성일: 2021.12.13
	 */
	//신규 회원가입시
	public int insertOneMember(Member m);
	
	
	/**
	 * 작성자: 남진구
	 * @param userId
	 * @return boolean
	 * 작성일 : 2021.12.13
	 */
	//아이디 중복 체크
	public boolean selectIdCheck(String userId);
	
	/**
	 * 작성자 : 남진구
	 * @param nick
	 * @return boolean
	 * 작성일:2021.12.13
	 */
	//닉네임 중복 체크
	public boolean selectNickCheck(String nick);
	
	
	
	
	/**
	 * 작성자 : 남진구
	 * @param email
	 * @return boolean
	 * 작성일:2021.12.24
	 */
	//email 중복 체크
	public boolean selectEmailCheck(String email);
	
	
	/**
	 * 작성자 : 남진구
	 * @param email
	 * @return Member
	 * 작성일:2021.12.24
	 */
	//아이디 찾기
	public Member SearchId(String email);

	/**
	 * 작성자 : 남진구
	 * @param userId,
	 * @param email
	 * @return Member
	 * 작성일:2021.12.24
	 */
	//비밀번호 찾기
	public Member SearchPwd(String userId,String email);

}
