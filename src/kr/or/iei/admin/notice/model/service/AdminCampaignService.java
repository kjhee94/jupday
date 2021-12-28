package kr.or.iei.admin.notice.model.service;

import java.util.HashMap;

import kr.or.iei.admin.notice.model.vo.AdminCampaign;

public interface AdminCampaignService {

	HashMap<String, Object> selectAllCampaignPageList(int currentPage);

	int updateCampaignDelYN(int ncNo, char delYN);

	AdminCampaign selectOneCampaignContent(int ncNo);
	
}
