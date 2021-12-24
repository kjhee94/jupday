package kr.or.iei.crew.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.dao.CrewDAO;
import kr.or.iei.crew.model.vo.Crew;

public class CrewServiceimpl implements CrewService {
	
	private CrewDAO cDAO = new CrewDAO();

	@Override
	public HashMap<String, Object> selectCrewAllList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 8;
		
		ArrayList<Crew> list = cDAO.selectCrewAllList(conn, currentPage, recordCountPerPage);
		
//		for(Crew c : list) {
//			System.out.println("크루번호 : "+c.getCrewNo()+"<br>"+
//							   "크루명 : "+c.getCrewName()+"<br>"+
//							   "크루생성일 : "+c.getCrewCreateDate()+"<br>"+
//							   "크루설명 : "+c.getCrewInfo()+"<br>"+
//							   "크루이미지 : "+c.getCrewImg()+"<br>"+
//							   "크루삭제여부 : "+c.getCrewDelYN()+"<br>"+
//							   "크루원수 : "+c.getCrewCount());
//		}
		
		//pageNavi에서 보여질 Navi 개수를 설정
		int naviCountPerPage = 5;
		
		String pageNavi = cDAO.getPageNavi(conn, naviCountPerPage, recordCountPerPage, currentPage);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;
	}

	@Override
	public HashMap<String, Object> selectCrewSearchList(int currentPage, String keyword) {
		
		Connection conn =  JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 8;
		
		ArrayList<Crew> list = cDAO.selectCrewSearchList(conn, currentPage, recordCountPerPage, keyword);
		
//		for(Crew c : list) {
//		System.out.println("크루번호 : "+c.getCrewNo()+"<br>"+
//						   "크루명 : "+c.getCrewName()+"<br>"+
//						   "크루생성일 : "+c.getCrewCreateDate()+"<br>"+
//						   "크루설명 : "+c.getCrewInfo()+"<br>"+
//						   "크루이미지 : "+c.getCrewImg()+"<br>"+
//						   "크루삭제여부 : "+c.getCrewDelYN()+"<br>"+
//						   "크루원수 : "+c.getCrewCount());
//		}
		
		//pageNavi에서 보여질 Navi 개수를 설정
		int naviCountPerPage = 5;
		
		String pageNavi = cDAO.getSearchPageNavi(conn, naviCountPerPage, recordCountPerPage, currentPage, keyword);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;
	}
	
	
	
}
