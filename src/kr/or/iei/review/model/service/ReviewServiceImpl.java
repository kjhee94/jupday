package kr.or.iei.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;
import kr.or.iei.review.model.dao.ReviewDAO;
import kr.or.iei.review.model.vo.Review;


public class ReviewServiceImpl implements ReviewService{
	
	private ReviewDAO rDAO = new ReviewDAO();
	



	@Override
	public HashMap<String, Object> selectAllPostList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 8;
		
		ArrayList<Review> list = rDAO.selectAllpostList(conn,currentPage,recordCountPerPage);
		
		int naviCountPerPage = 8;
		
		String pageNavi = rDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;
	}
	/*
	@Override
	public HashMap<String, Object> selectMemberAllPostList(String userId, int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 9;
		
		ArrayList<Review> list = rDAO.selectAllpostList2(userId,conn,currentPage,recordCountPerPage);
		
		int naviCountPerPage = 5;
		
		String pageNavi = rDAO.getPageNavi2(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list",list);
		hm.put("pageNavi", pageNavi);
		
		JDBCTemplate.close(conn);
		
		return hm;		
	}*/
	
	

	@Override
	public Review selectOnePost(int postNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		Review review = rDAO.selectOneContent(conn, postNum);
		JDBCTemplate.close(conn);
		return review;

	}
	
	
	/*@Override
	public Review memberReview(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Review review = rDAO.memberReview(conn, userId);
		JDBCTemplate.close(conn); 
		return review;
		
	}*/

	@Override
	public HashMap<String, Object> selectSearchPost(int currentPage, String userId) {
		//코드를 selectAllPostList 에서 가져왔음
		Connection conn = JDBCTemplate.getConnection();
				
		//하나의 PAGE에서 몇개의 목록을 보여줄 것인지에 대한 값이 필요
		int recordCountPerPage = 9;
				
		//list 안에는 우리가 넘겨준 키워드를 바탕으로 검색 된 값이 있을 것이다
		ArrayList<Review> list = rDAO.selectAllpostList2(userId, conn, currentPage, recordCountPerPage); 
				
		//하나의 pagenavi bar에 보여질 navi 개수를 설정
		int naviCountPerPage = 5;
				
		String pageNavi = rDAO.getSearchPageNavi(conn, naviCountPerPage, recordCountPerPage, currentPage, userId);
				
		//DB연결 해제코드
		JDBCTemplate.close(conn);
				
		//2가지 데이터의 리턴을 위해서 HashMap 객체를 만들어서 리턴
		HashMap<String, Object> map = new HashMap<String,Object>();
				
		map.put("list", list);
		map.put("pageNavi", pageNavi);
				
		return map;
	}

	
	
}
