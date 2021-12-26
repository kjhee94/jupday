package kr.or.iei.admin.crew.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.crew.model.vo.Crew;

public interface AdminCrewService {

	//요청한 페이지에 대한 목록 리턴
	HashMap<String, Object> selectAllCrewPageList(int currentPage);

}
