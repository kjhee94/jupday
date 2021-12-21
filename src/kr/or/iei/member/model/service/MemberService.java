package kr.or.iei.member.model.service;

import kr.or.iei.member.model.vo.Member;

public interface MemberService {
	
	
	/**
	 * 작성자 : 남진구
	 * @param userId
	 * @param userPwd
	 * @return Member
	 * 작성일 : 2021. 12.6.
	 *
	 * Description : 회원 ID 와 회원 PW를 바탕으로 회원정보 조회(로그인시 사용)
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
	
	//회원 정보 수정
	public int udateOneMember(Member m);
	
	//회원 정보를 탈퇴할때 사용 (userNo를 바탕으로 처리)
	public int deleteOneMember(int userNo);
	
	//회원정보를 DB에서 갱신해올때 사용
	public Member refreshOneMember(int userNo);
	
	//아이디 중복 체크
	/**
	 * 작성자: 남진구
	 * @param userId
	 * @return boolean
	 * 작성일 : 2021.12.13
	 */
	public boolean selectIdCheck(String userId);
	
	//닉네임 중복 체크
	/**
	 * 작성자 : 남진구
	 * @param nick
	 * @return boolean
	 * 작성일:2021.12.13
	 */
	public boolean selectNickCheck(String nick);

}
