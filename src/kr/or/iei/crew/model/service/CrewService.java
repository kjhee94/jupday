package kr.or.iei.crew.model.service;

import java.util.HashMap;

public interface CrewService {

	/**
	 * 작성자 : 강주희
	 * @param currentPage
	 * @return HashMap<String,Object>
	 * 작성일 : 2021. 12. 24.
	 *
	 * Description : 요청한 페이지에 대한 목록을 리턴해 주는 메소드
	 */
	HashMap<String, Object> selectAllCrewList(int currentPage);

}