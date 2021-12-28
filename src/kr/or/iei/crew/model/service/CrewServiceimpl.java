package kr.or.iei.crew.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.dao.CrewDAO;
import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.crew.model.vo.CrewBoard;
import kr.or.iei.crew.model.vo.CrewMember;
import kr.or.iei.review.model.vo.Review;

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

	@Override
	public boolean crewCreate(Crew c, String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//크루 생성
		int result = cDAO.insertOneCrew(conn, c);
		
		//크루에 크루장 등록
		int result2 = cDAO.insertCrewMaster(conn, c, userId);
		
		if(result>0 && result2>0) {
			JDBCTemplate.commit(conn);
			JDBCTemplate.close(conn);
			return true;
		}else {
			JDBCTemplate.rollback(conn);
			JDBCTemplate.close(conn);
			return false;
		}
	}

	@Override
	public ArrayList<Crew> selectManageCrew(String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Crew> list = cDAO.selectManageCrew(conn, userId);
		JDBCTemplate.close(conn);
		return list;
	}

	@Override
	public ArrayList<Crew> selectJoinedCrew(String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Crew> list = cDAO.selectJoinedCrew(conn, userId);
		JDBCTemplate.close(conn);
		return list;
	}

	@Override
	public Crew selectOneCrew(int crewNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		Crew c = cDAO.selectOneCrew(conn, crewNo);
		JDBCTemplate.close(conn);
		return c;
	}

	@Override
	public int UpdateOneCrew(Crew c) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.updateOneCrew(conn, c);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public ArrayList<CrewMember> selectApproveList(int crewNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<CrewMember> list = cDAO.selectApproveList(conn, crewNo);
		JDBCTemplate.close(conn);
		return list;
	}

	@Override
	public int updateCrewJoinStateAccept(String userId, int crewNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.updateCrewJoinStateAccept(conn, userId, crewNo);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int updateCrewJoinStateRefusal(String userId, int crewNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.updateCrewJoinStateRefusal(conn, userId, crewNo);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public String selectCrewName(int crewNo) {
		Connection conn = JDBCTemplate.getConnection();
		String crewName = cDAO.selectCrewName(conn, crewNo);
		JDBCTemplate.close(conn);
		return crewName;
	}

	@Override
	public int deleteOneCrew(int crewNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.deleteOneCrew(conn, crewNo);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public HashMap<String, Object> selectAllCrewFeed(int currentFeedPage, int crewNo) {

		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 10;
		
		ArrayList<CrewBoard> list = cDAO.selectAllPostList(conn, currentFeedPage, recordCountPerPage, crewNo);
		
		
		return null;
	}

	/*@Override
	public HashMap<String, Object> myCrewList(int currentPage, String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		int recordCountPerPage = 5;
		
		ArrayList<Review> list = cDAO.myPageMyCrewList(userId, conn, currentPage, recordCountPerPage); 
		
		int naviCountPerPage = 5;
		
		String pageNavi = cDAO.getSearchPageNavi(conn, naviCountPerPage, recordCountPerPage, currentPage, userId);
		
		JDBCTemplate.close(conn);
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}*/
	
	
	
}
