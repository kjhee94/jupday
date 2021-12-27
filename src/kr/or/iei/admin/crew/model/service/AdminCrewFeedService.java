package kr.or.iei.admin.crew.model.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface AdminCrewFeedService {

	HashMap<String, Object> selectAllCrewFeedPageList(int currentPage);

	int updateCrewFeedDelYN(int feedNo, char delYN);

}
