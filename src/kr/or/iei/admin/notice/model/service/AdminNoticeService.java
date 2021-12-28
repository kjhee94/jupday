package kr.or.iei.admin.notice.model.service;

import java.util.HashMap;

public interface AdminNoticeService {

	HashMap<String, Object> selectAllNoticePageList(int currentPage);

	int updateNoticeDelYN(int nNo, char delYN);

}
