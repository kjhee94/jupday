package kr.or.iei.admin.notice.model.service;

import java.util.HashMap;

public interface AdminFAQService {
	
	HashMap<String, Object> selectAllFAQPageList(int currentPage);

	int updateFAQDelYN(int faqNo, char delYN);

}
