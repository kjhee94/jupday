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
	
	
}
