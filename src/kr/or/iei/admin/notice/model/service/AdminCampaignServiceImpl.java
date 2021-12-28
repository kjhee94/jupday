package kr.or.iei.admin.notice.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.admin.notice.model.dao.AdminNoticeDAO;
import kr.or.iei.admin.notice.model.vo.AdminCampaign;
import kr.or.iei.admin.notice.model.vo.AdminFAQ;
import kr.or.iei.admin.notice.model.vo.AdminNotice;
import kr.or.iei.common.JDBCTemplate;

public class AdminCampaignServiceImpl implements AdminCampaignService {
	private AdminNoticeDAO adnDAO = new AdminNoticeDAO();
	
	@Override
	public HashMap<String, Object> selectAllCampaignPageList(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		//한 개의 page에서 몇 개의 목록으로 보여줄 것인지
		int recordCountPerPage = 10;
		
		ArrayList<AdminCampaign> list = adnDAO.selectAllCampaignPageList(conn, currentPage, recordCountPerPage);
		
		//한 개의 pageNavi에서 보여질 Navi 개수
		int naviCountPerPage = 5;
		
		String pageCamNavi = adnDAO.getpageCamNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("pageCamNavi", pageCamNavi);

		JDBCTemplate.close(conn);
		return hm;
	}

	@Override
	public int updateCampaignDelYN(int ncNo, char delYN) {
		Connection conn = JDBCTemplate.getConnection();
		int result = adnDAO.updateCampaignDelYN(ncNo,delYN,conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public AdminCampaign selectOneCampaignContent(int ncNo) {
		Connection conn = JDBCTemplate.getConnection();
		AdminCampaign adcam = adnDAO.selectOneCampaignContent(conn, ncNo);
		JDBCTemplate.close(conn);
		return adcam;
	}

}
