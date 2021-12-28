package kr.or.iei.admin.notice.model.service;

import java.util.HashMap;

public interface AdminCampaignService {

	HashMap<String, Object> selectAllCampaignPageList(int currentPage);

	int updateCampaignDelYN(int ncNo, char delYN);
	


}
