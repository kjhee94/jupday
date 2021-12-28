package kr.or.iei.crew.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.crew.model.vo.CrewBoard;
import kr.or.iei.crew.model.vo.CrewFileData;
import kr.or.iei.crew.model.vo.CrewMember;

/**
 * @author ipsak
 *
 */
public interface CrewService {

	/**
	 * 작성자 : 강주희
	 * @param currentPage
	 * @return HashMap<String,Object>
	 * 작성일 : 2021. 12. 24.
	 *
	 * Description : 요청한 페이지에 대한 목록을 리턴해 주는 메소드
	 */
	HashMap<String, Object> selectCrewAllList(int currentPage);

	/**
	 * 작성자 : 강주희
	 * @param currentPage
	 * @param keyword
	 * @return HashMap<String,Object>
	 * 작성일 : 2021. 12. 25.
	 *
	 * Description : 게시물을 검색하는 메소드
	 */
	HashMap<String, Object> selectCrewSearchList(int currentPage, String keyword);
	
	/**
	 * 작성자 : 강주희
	 * @param c
	 * @param crewMaster
	 * @return boolean
	 * 작성일 : 2021. 12. 25.
	 *
	 * Description : 새로운 크루를 생성하는 메소드
	 */
	boolean crewCreate(Crew c, String userId);

	/**
	 * 작성자 : 강주희
	 * @param cfd
	 * @return int
	 * 작성일 : 2021. 12. 27.
	 *
	 * Description : 크루생성시 크루대표 이미지를 저장하는 메소드
	 */
	int insertFileCreate(CrewFileData cfd);
	
	/**
	 * 작성자 : 강주희
	 * @param userId
	 * @return ArrayList<Crew>
	 * 작성일 : 2021. 12. 25.
	 *
	 * Description : 로그인한 아이디로 크루장인 크루를 조회하는 메소드
	 */
	ArrayList<Crew> selectManageCrew(String userId);

	/**
	 * 작성자 : 강주희
	 * @param userId
	 * @return ArrayList<Crew>
	 * 작성일 : 2021. 12. 25.
	 *
	 * Description : 로그인한 아이디로 크루원인 크루를 조회하는 메소드
	 */
	ArrayList<Crew> selectJoinedCrew(String userId);

	/**
	 * 작성자 : 강주희
	 * @param crewNo
	 * @return Crew
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : crewNo값으로 크루 한개의 정보를 조회하는 메소드
	 */
	Crew selectOneCrew(int crewNo);

	
	/**
	 * 작성자 : 강주희
	 * @param c
	 * @return int
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : 크루의 정보를 수정하는 메소드
	 */
	int UpdateOneCrew(Crew c);

	/**
	 * 작성자 : 강주희
	 * @param cfd
	 * @return int
	 * 작성일 : 2021. 12. 28.
	 *
	 * Description : 크루 수정시 크루 대표이미지를 저장하는 메소드
	 */
	int insertFileUpdate(CrewFileData cfd);
	
	/**
	 * 작성자 : 강주희
	 * @param crewNo void
	 * @return ArrayList<CrewMember>
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : 승인대기중인 크루원의 정보를 조회하는 메소드
	 */
	ArrayList<CrewMember> selectApproveList(int crewNo);

	/**
	 * 작성자 : 강주희
	 * @param userId
	 * @param crewNo 
	 * @return int
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : 승인대기중인 크루원을 승인 완료하는 메소드
	 */
	int updateCrewJoinStateAccept(String userId, int crewNo);

	/**
	 * 작성자 : 강주희
	 * @param userId
	 * @param crewNo
	 * @return int
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : 승인대기중인 크루원을 승인 거절하는 메소드
	 */
	int updateCrewJoinStateRefusal(String userId, int crewNo);

	/**
	 * 작성자 : 강주희
	 * @param crewNo
	 * @return String
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : 크루 이름을 반환하는 메소드
	 */
	String selectCrewName(int crewNo);

	/**
	 * 작성자 : 강주희
	 * @param crewNo
	 * @return int
	 * 작성일 : 2021. 12. 26.
	 *
	 * Description : 크루를 삭제하는 메소드
	 */
	int deleteOneCrew(int crewNo);

	/**
	 * 작성자 : 강주희
	 * @param currentFeedPage
	 * @param crewNo
	 * @param currentPage
	 * @return HashMap<String,Object>
	 * 작성일 : 2021. 12. 27.
	 *
	 * Description : 크루개별 페이지의 정보를 가져오는 메소드
	 */
	HashMap<String, Object> selectAllCrewFeed(int currentFeedPage, int crewNo, int currentPage);

	/**
	 * 작성자 : 강주희
	 * @param feedNo
	 * @return CrewBoard
	 * 작성일 : 2021. 12. 27.
	 *
	 * Description : 크루 피드의 정보를 가져오는 메소드
	 */
	CrewBoard selectOneCrewFeed(int feedNo);

	/**
	 * 작성자 : 강주희
	 * @param cb
	 * @return int
	 * 작성일 : 2021. 12. 28.
	 *
	 * Description : 크루피드를 작성하는 메소드
	 */
	int insertCrewFeed(CrewBoard cb);

	/**
	 * 작성자 : 강주희
	 * @param cb
	 * @return int
	 * 작성일 : 2021. 12. 28.
	 *
	 * Description : 피드번호를 조회하는 메소드
	 */
	int searchFeedNo(CrewBoard cb);

	/**
	 * 작성자 : 강주희
	 * @param userId
	 * @param crewNo
	 * @return CrewMember
	 * 작성일 : 2021. 12. 28.
	 *
	 * Description : 로그인한 아이디로 크루멤버를 조회하는 메소드
	 */
	CrewMember selectCrewMember(String userId, int crewNo);

	/**
	 * 작성자 : 강주희
	 * @param cb
	 * @return int
	 * 작성일 : 2021. 12. 28.
	 *
	 * Description : 크루피드를 수정하는 메소드
	 */
	int updateCrewFeed(CrewBoard cb);

	

	
	


	

}
