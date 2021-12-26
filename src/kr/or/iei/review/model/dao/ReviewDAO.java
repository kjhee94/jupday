package kr.or.iei.review.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;
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
	/*
	public String getPageNavi2(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		
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
		
		if(startNavi!=1) {sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");}
		
		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+i+"'class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+i+"'>"+i+"</a></li>");
			}
			
		}
		
		if(endNavi!=pageTotalCount) {sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");}
		
		return sb.toString();
	}*/
	
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

	/*public Review memberReview(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Review review = null;
		
		String query = "select * from review where userId=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) 
			{
				review = new Review();
				review.setUserId(rset.getString("userId"));
			}
			 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
	
	return review; 
	
	}*/

	public ArrayList<Review> selectAllpostList2(String userId, Connection conn, int currentPage, int recordCountPerPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Review> list = new ArrayList<Review>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query = "select *" + 
				"		from (select row_number() over(order by postnum desc)as num, review.* ,nick" + 
				"		from review " + 
				"		left join member on (review.userid=member.userid)" + 
				"		where review.del_YN='N' " + 
				"       and review.userId=?)" +
				"		where num between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
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

	public String getSearchPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage,
			String userId) {
		int recordTotalCount = totalSearchCount(conn, userId); //전체 게시글 갯수
		
		int pageTotalCount = 0; //전체 페이지 갯수
		
		if(recordTotalCount % recordCountPerPage > 0 ) { //나머지가 있으면 +1
			pageTotalCount = (recordTotalCount / recordCountPerPage) + 1;
		} else { //나머지가 없으면 그냥
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		
		/* startNavi 공식
		startNavi = (((현재페이지 - 1)) / (navi 당 보여질 갯수) * navi 당 보여질 갯수) + 1
		코드로 표현
		StartNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) + 1
		
		endNavi 공식
		endNavi = 시작navi값 + (Navi당 보여질 갯수 -1)
		코드로 표현
		endNavi = startNavi + (naviCountPerPage -1)
		*/
		
		int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) + 1;
		int endNavi = startNavi + (naviCountPerPage -1);
		
		//단 위의 공식은 문제가 없지만, 하나의 상황에서는 예외가 있다.
		//만약 현재 페이지가 21페이지일 경우 < 21 22
		
		//만약 공식으로 구한 endNavi가 총  page수보다 크다면 총 page 수로 세팅하라는 코드
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		// PageNavi 모양 만들기
		
				StringBuilder sb = new StringBuilder();
				
				if(startNavi!=1)
				{
					sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+(startNavi-1)+"&userId="+userId+"'><i class='fas fa-chevron-left'></i></a></li>");
				}
				
				for(int i=startNavi; i<=endNavi;i++)
				{
					if(i==currentPage)
					{
						sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+i+"&userId="+userId+"' class='page_active'>"+i+"</a></li>");
					}else
					{
						sb.append("<li><a href='/member/myPageMyReview.do?currentPage="+i+"&userId="+userId+"'>"+i+"</a></li>");
					}
					
				}
				
				if(endNavi!=pageTotalCount)
				{
					sb.append("<li><a class='next' href='/member/myPageMyReview.do?currentPage="+(endNavi+1)+"&userId="+userId+"'><i class='fas fa-chevron-right'></i></a></li>");
				}
		
		return sb.toString();
	}

	private int totalSearchCount(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = 
		
		
		"SELECT COUNT(*) as count FROM REVIEW " + 
		"    LEFT JOIN MEMBER ON (REVIEW.USERID = MEMBER.USERID) " + 
		"WHERE REVIEW.DEL_YN='N' AND REVIEW.USERID like ?";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
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
}
