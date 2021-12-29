package kr.or.iei.admin.notice.model.service;

import java.util.HashMap;

import kr.or.iei.admin.notice.model.vo.AdminNotice;

public interface AdminNoticeService {

	HashMap<String, Object> selectAllNoticePageList(int currentPage);

	int updateNoticeDelYN(int nNo, char delYN);

	AdminNotice selectOneNoticeContent(int nNo);

	int updateNoticePost(AdminNotice adnoup);

}
