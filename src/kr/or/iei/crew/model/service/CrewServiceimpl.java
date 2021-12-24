package kr.or.iei.crew.model.service;

import java.sql.Connection;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.dao.CrewDAO;

public class CrewServiceimpl implements CrewService {
	
	private CrewDAO cDAO = new CrewDAO();

	@Override
	public HashMap<String, Object> selectAllCrewList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 8;
		
		cDAO.selectAllPostList(conn, currentPage, recordCountPerPage);
		
		return null;
	}

}
