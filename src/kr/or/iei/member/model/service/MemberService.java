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

	
	
	
	//회원의 비밀번호 변경
	/**
	 * 작성자 : 김서후
	 * @param userId, pwd, newPwd
	 * @return int
	 * 작성일:2021.12.21
	 */
	public int updatePwdMember(String userId, String pwd, String newPwd);

	//회원의 회원정보 변경
	/**
	 * 작성자 : 김서후
	 * @param m
	 * @return int
	 * 작성일:2021.12.21
	 */
	public int updateOneMember(Member m);
	
	//회원정보를 DB에서 갱신해올때 사용
	/**
	 * 작성자: 김서후
	 * @param userId
	 * @return Member
	 * 작성일 : 2021.12.21
	 */
	public Member refreshOneMember(String userId);
	
	//회원 정보를 탈퇴할때 사용 (userNo를 바탕으로 처리)
	/**
	 * 작성자: 김서후
	 * @param userId
	 * @return Member
	 * 작성일 : 2021.12.21
	 */
	public int deleteOneMember(String userId, String userPwd);

	//이메일 중복 확인
	//인증 로직 미구현시 사용
	/**
	 * 작성자: 김서후
	 * @param email
	 * @return boolean
	 * 작성일 : 2021.12.22
	 */
	public boolean selectEmailCheck(String email);
}
