package kr.or.iei.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.review.model.vo.Review;
import kr.or.iei.review.model.vo.ReviewComment;

public class ReviewDAO {

	public ArrayList<Review> selectAllpostList(Connection conn, int currentPage, int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = new ArrayList<Review>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query = "select *" + 
				"		from (select row_number() over(order by postnum desc)as num, review.* ,nick" + 
				"		from review " + 
				"		left join member on (review.userid=member.userid)" + 
				"		where review.del_YN='N') " + 
				"		where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Review review = new Review();
				
				review.setPostNum(rset.getInt("postNum"));
				review.setUserId(rset.getString("userId"));
				review.setRegDate(rset.getDate("regDate"));
				review.setPostTitle(rset.getString("postTitle"));
				review.setPostContent(rset.getString("postContent"));
				review.setHits(rset.getInt("hits"));
				review.setGood(rset.getInt("good"));
				review.setBest_YN(rset.getString("best_YN").charAt(0));
				review.setDel_YN(rset.getString("del_YN").charAt(0));
				review.setNick(rset.getString("nick"));
				
				list.add(review);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
		
	}

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		
		int recordTotalCount = totalCount(conn);
		
		int pageTotalCount = 0;
		
		if((recordTotalCount % recordCountPerPage) > 0) {
			pageTotalCount = (recordTotalCount / recordCountPerPage) +1;
		}else {
			pageTotalCount = (recordTotalCount / recordCountPerPage);
		};
		
		int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) + 1;
		int endNavi = startNavi + (naviCountPerPage-1);
		
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1) {sb.append("<li><a href='/review/reviewAllSelect.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");}
		
		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/review/reviewAllSelect.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/review/reviewAllSelect.do?currentPage="+i+"'>"+i+"</a></li>");			
			}
			
		}
		
		if(endNavi!=pageTotalCount) {sb.append("<li><a href='/review/reviewAllSelect.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li> ");}
		
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "select count(*) as count from review where del_YN='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
		
	}

	public Review selectOneContent(Connection conn, int postNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		Review review = null;
		
		String query = "select review.*,nick from review " + 
				"left join member on (review.userid = member.userid) " + 
				"where postnum = ? and review.del_YN='N'" ;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNum);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				review = new Review();
				
				review.setPostNum(rset.getInt("postNum"));
				review.setUserId(rset.getString("userId"));
				review.setRegDate(rset.getDate("regDate"));
				review.setPostTitle(rset.getString("postTitle"));
				review.setPostContent(rset.getString("postContent"));
				review.setHits(rset.getInt("hits"));
				review.setGood(rset.getInt("good"));
				review.setBest_YN(rset.getString("best_YN").charAt(0));
				review.setDel_YN(rset.getString("del_YN").charAt(0));
				review.setNick(rset.getString("nick"));
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return review;
	}

	public ArrayList<ReviewComment> selectPostAllComment(Connection conn, int postNum) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		ArrayList<ReviewComment> commentslist = new ArrayList<ReviewComment>();
		
		String query = "select REVIEW_COMMENT.*,Member.nick from REVIEW_COMMENT " + 
				"left join member on (REVIEW_COMMENT.userid = member.userid) " + 
				"where R_C_DEL_YN='N' and postnum=? " + 
				"order by R_C_NO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, postNum);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ReviewComment co = new ReviewComment();
				
				co.setR_c_no(rset.getInt("r_c_no"));
				co.setPostNum(rset.getInt("postNum"));
				co.setUserId(rset.getString("userId"));
				co.setR_c_comment(rset.getString("r_c_comment"));
				co.setR_c_regDate(rset.getDate("r_c_regDate"));
				co.setR_c_del_YN(rset.getString("r_c_del_YN").charAt(0));
				co.setNick(rset.getString("nick"));
				
				commentslist.add(co);
			}	

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return commentslist;
	}

	public int insertBoardComment(Connection conn, ReviewComment co) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO REVIEW_COMMENT VALUES(REV_COMMENT_SEQ.nextval,?,?,?,sysdate,'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, co.getPostNum());
			pstmt.setString(2, co.getUserId());
			pstmt.setString(3, co.getR_c_comment());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateReviewComment(Connection conn, ReviewComment co) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = "update REVIEW_COMMENT set R_C_COMMENT=? where R_C_NO=? and userid=?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, co.getR_c_comment());
			pstmt.setInt(2, co.getR_c_no());
			pstmt.setString(3, co.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteReviewComment(Connection conn, int r_c_no, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "update REVIEW_COMMENT set R_C_DEL_YN='Y' where R_C_NO=? and userid=?"; 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, r_c_no);
			pstmt.setString(2, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int insertPostWrite(Connection conn, Review review) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO review VALUES(REVIEW_Seq.NEXTVAL,?,SYSDATE,?,?,'0','0','N','N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getUserId());
			pstmt.setString(2, review.getPostTitle());
			pstmt.setString(3, review.getPostContent());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int searchBoardNo(Connection conn, Review review) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int postNum = 0;
		
		String query = "SELECT postnum FROM " + 
				"(SELECT ROW_NUMBER() OVER(order BY postnum DESC) AS NUM,review.*  FROM review " + 
				"WHERE userid=? AND posttitle=? AND postCONTENT=?) " + 
				"WHERE NUM = 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getUserId());
			pstmt.setString(2, review.getPostTitle());
			pstmt.setString(3, review.getPostContent());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				postNum = rset.getInt("postNum");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return postNum;
	}
	

}
