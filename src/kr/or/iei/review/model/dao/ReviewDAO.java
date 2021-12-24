package kr.or.iei.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.review.model.vo.Review;

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
		
		if(startNavi!=1) {sb.append("<a href='/review/reviewAllSelect.do?currentPage="+(startNavi-1)+"'>◀</a> ");}
		
		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<a href='/review/reviewAllSelect.do?currentPage="+i+"'>"+i+"</a> ");
			}else {
				sb.append("<a href='/review/reviewAllSelect.do?currentPage="+i+"'>"+i+"</a> ");
			}
			
		}
		
		if(endNavi!=pageTotalCount) {sb.append("<a href='/review/reviewAllSelect.do?currentPage="+(endNavi+1)+"'>▶</a> ");}
		
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
	

}
