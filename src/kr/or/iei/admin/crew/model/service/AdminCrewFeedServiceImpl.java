package kr.or.iei.admin.crew.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.admin.crew.model.dao.AdminCrewFeedDAO;
import kr.or.iei.admin.crew.model.vo.AdminCrewFeed;
import kr.or.iei.common.JDBCTemplate;

public class AdminCrewFeedServiceImpl implements AdminCrewFeedService{
	private AdminCrewFeedDAO adcfDAO = new AdminCrewFeedDAO();

	@Override
	public HashMap<String, Object> selectAllCrewFeedPageList(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		//한 개의 page에서 몇 개의 목록으로 보여줄 것인지
		int recordCountPerPage = 10;
		
		int crewNo = 0;
		
		ArrayList<AdminCrewFeed> list = adcfDAO.selectAllCrewFeedPageList(conn, currentPage, recordCountPerPage, crewNo);
		
		//한 개의 pageNavi에서 보여질 Navi 개수
		int naviCountPerPage = 5;
		
		String pageNavi = adcfDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		return hm;
	}

	@Override
	public int updateCrewFeedDelYN(int feedNo, char delYN) {
		Connection conn = JDBCTemplate.getConnection();
		int result = adcfDAO.updateCrewFeedDelYN(feedNo,delYN,conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}
}
