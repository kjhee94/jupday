package kr.or.iei.crew.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.dao.CrewDAO;
import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.crew.model.vo.CrewBoard;
import kr.or.iei.crew.model.vo.CrewBoardComment;
import kr.or.iei.crew.model.vo.CrewFileData;
import kr.or.iei.crew.model.vo.CrewMember;
import kr.or.iei.file.model.dao.MemberFileDAO;

public class CrewServiceimpl implements CrewService {
	
	private CrewDAO cDAO = new CrewDAO();

	@Override
	public HashMap<String, Object> selectCrewAllList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 8;
		
		ArrayList<Crew> list = cDAO.selectCrewAllList(conn, currentPage, recordCountPerPage);
		
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
	public int insertFileCreate(CrewFileData cfd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.insertFileCreate(conn, cfd);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		return result;
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
	public int insertFileUpdate(CrewFileData cfd) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.insertFileUpdate(conn, cfd);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
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
	public HashMap<String, Object> selectAllCrewFeed(int currentFeedPage, int crewNo, int currentPage) {

		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 10;
		
		ArrayList<CrewBoard> list = cDAO.selectAllPostList(conn, currentFeedPage, recordCountPerPage, crewNo);
		
		//pageNavi에서 보여질 Navi 개수를 설정
		int naviCountPerPage = 5;
		
		String pageNavi = cDAO.getFeedPageNavi(conn, naviCountPerPage, recordCountPerPage, currentFeedPage, crewNo, currentPage);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
	
		JDBCTemplate.close(conn);
		
		return hm;
	}

	@Override
	public CrewBoard selectOneCrewFeed(int crewNo, int feedNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//한개의 게시물 가져오기
		CrewBoard cb = cDAO.selectOneCrewFeed(conn, feedNo);
		
		//해당게시물에 대한 댓글 가져오기
		ArrayList<CrewBoardComment> coList = cDAO.selectCrewFeedAllComment(conn, crewNo, feedNo);
		
		//해당 게시물 객체에 대한 댓글까지 저장
		cb.setCoList(coList);
		
		JDBCTemplate.close(conn);
		return cb;
	}

	@Override
	public int insertCrewFeed(CrewBoard cb) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.insertCrewFeed(conn, cb);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int searchFeedNo(CrewBoard cb) {
		
		Connection conn = JDBCTemplate.getConnection();
		int feedNo = cDAO.searchFeedNo(conn, cb);
		JDBCTemplate.close(conn);
		return feedNo;
	}

	@Override
	public CrewMember selectCrewMember(String userId, int crewNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		CrewMember cm = cDAO.selectCrewMember(conn, userId, crewNo);
		JDBCTemplate.close(conn);
		return cm;
	}

	@Override
	public int updateCrewFeed(CrewBoard cb) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.updateCrewFeed(conn, cb);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int deleteCrewFeed(int feedNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.updateCrewFeed(conn, feedNo);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public HashMap<String, Object> selectCrewFeedSearchList(int currentFeedPage, String keyword, String type, int crewNo, int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 페이지에서 보여줄 목록의 갯수
		int recordCountPerPage = 10;
		
		ArrayList<CrewBoard> list = cDAO.selectCrewFeedSearchList(conn, currentFeedPage, recordCountPerPage, keyword, type, crewNo);
		
		//pageNavi에서 보여질 Navi 개수를 설정
		int naviCountPerPage = 5;
		
		String pageNavi = cDAO.getFeedSearchPageNavi(conn, naviCountPerPage, recordCountPerPage, currentFeedPage, keyword, type, crewNo, currentPage);
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;
	}

	@Override
	public int withdrawCrew(int crewNo, String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.withdrawCrew(conn, crewNo, userId);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int joinCrew(int crewNo, String userId) {

		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.joinCrew(conn, crewNo, userId);
		
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

	@Override
	public int insertFeedComment(CrewBoardComment cbc) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = cDAO.insertFeedComment(conn, cbc);
		
		if(result>0) JDBCTemplate.commit(conn);
		else		 JDBCTemplate.rollback(conn);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	
}
