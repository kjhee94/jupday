package kr.or.iei.review.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.review.model.dao.ReviewDAO;
import kr.or.iei.review.model.vo.Review;
import kr.or.iei.review.model.vo.ReviewComment;


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

	@Override
	public Review selectOnePost(int postNum) {
		Connection conn = JDBCTemplate.getConnection();
		
		Review review = rDAO.selectOneContent(conn, postNum);
		
		ArrayList<ReviewComment> commentslist = rDAO.selectPostAllComment(conn,postNum);
		
		review.setComments(commentslist);
		
		JDBCTemplate.close(conn);
		return review;

	}

	@Override
	public int insertBoardComment(ReviewComment co) {
		Connection conn = JDBCTemplate.getConnection();
		int result = rDAO.insertBoardComment(conn,co);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public int updateReviewComment(ReviewComment co) {
		Connection conn = JDBCTemplate.getConnection();
		int result = rDAO.updateReviewComment(conn,co);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
		
	}

	@Override
	public int deleteReviewComment(int r_c_no, String userId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = rDAO.deleteReviewComment(conn,r_c_no,userId);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public int insertPostWrite(Review review) {
		Connection conn = JDBCTemplate.getConnection();
		int result = rDAO.insertPostWrite(conn,review);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public int searchReviewNo(Review review) {
		Connection conn = JDBCTemplate.getConnection();
		int postNum = rDAO.searchBoardNo(conn,review);
		JDBCTemplate.close(conn);
		return postNum;
	}

	@Override
	public int updatePost(Review review) {
		Connection conn = JDBCTemplate.getConnection();
		int result = rDAO.updatePost(conn,review);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public HashMap<String, Object> selectSearchPost(int currentPage, String keyword, String type) {
		
		Connection conn = JDBCTemplate.getConnection();
		int recordCountPerPage = 8;
		ArrayList<Review> list = rDAO.selectSearchPostList(conn,currentPage,recordCountPerPage,keyword,type);
		
		int naviCountPerPage = 5;
		String pageNavi = rDAO.getSearchPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,keyword,type);
		
		JDBCTemplate.close(conn);
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}

	@Override
	public int deletePost(int postNum, String userId) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = rDAO.deletePost(conn,postNum,userId);
		if(result>0)JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public ArrayList<Review> selectAllBestReview() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Review> list2 = rDAO.selectAllBestReview(conn);
		JDBCTemplate.close(conn);
		return list2;
	}
	
	
}
