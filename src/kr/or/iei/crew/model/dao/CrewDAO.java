package kr.or.iei.crew.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.vo.Crew;
import kr.or.iei.crew.model.vo.CrewBoard;
import kr.or.iei.crew.model.vo.CrewMember;
import kr.or.iei.review.model.vo.Review;
import oracle.net.aso.p;

public class CrewDAO {

	public ArrayList<Crew> selectCrewAllList(Connection conn, int currentPage, int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Crew> list = new ArrayList<Crew>();
		
		int start = currentPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "SELECT * FROM(" + 
					   "SELECT ROW_NUMBER() OVER(ORDER BY C.C_NO DESC)AS NUM," + 
					   "C.C_NO,C_NAME,C_P_IMAGE," + 
					   "COUNT(*)AS c_count " + 
					   "FROM CREW C " + 
					   "LEFT JOIN CREW_MEMBER CM ON (C.C_NO=CM.C_NO) " + 
					   "WHERE C_DEL_YN='N' AND C_JOIN_STATE='SUCCESS' " + 
					   "GROUP BY C.C_NO,C_NAME,C_P_IMAGE) " + 
					   "WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Crew c = new Crew();
				
				c.setCrewNo(rset.getInt("c_no"));
				c.setCrewName(rset.getString("c_name"));
				c.setCrewImg(rset.getString("c_p_image"));
				c.setCrewCount(rset.getInt("c_count"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
	
		//전체 글 개수
		int recordTotalCount = totalCount(conn);
		
		//전체 페이지 개수
		int pageTotalCount = 0;
		
		if((recordTotalCount%recordCountPerPage)>0) {
			pageTotalCount = (recordTotalCount/recordCountPerPage)+1;
		}else {
			pageTotalCount = (recordTotalCount/recordCountPerPage);
		}
		
		//네비 시작번호, 끝 번호
		int startNavi = (((currentPage-1)/naviCountPerPage)*naviCountPerPage)+1;
		int endNavi = startNavi+(naviCountPerPage-1);
		
		//공식으로 구한 endNavi가 총페이지 수 보다 크다면 총 페이지 수로 세팅
		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		//pageNavi 모양 만들기
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1) {
			sb.append("<li><a href='/crew/crewAllList.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");
		}
		
		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/crew/crewAllList.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/crew/crewAllList.do?currentPage="+i+"'>"+i+"</a></li>");
			}
		}
		
		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/crew/crewAllList.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
	}

	private int totalCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String query = "SELECT COUNT(*)AS COUNT FROM CREW WHERE C_DEL_YN='N'";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	
	
	public ArrayList<Crew> selectCrewSearchList(Connection conn, int currentPage, int recordCountPerPage,
			String keyword) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Crew> list =  new ArrayList<Crew>();
		
		int start = currentPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "SELECT * FROM(" + 
					   "SELECT ROW_NUMBER() OVER(ORDER BY C.C_NO DESC)AS NUM," + 
					   "C.C_NO,C_NAME,C_P_IMAGE," + 
					   "COUNT(*)AS c_count " + 
					   "FROM CREW C " + 
					   "LEFT JOIN CREW_MEMBER CM ON (C.C_NO=CM.C_NO) " + 
					   "WHERE C_DEL_YN='N' AND C_JOIN_STATE='SUCCESS' AND C_NAME LIKE ? " + 
					   "GROUP BY C.C_NO,C_NAME,C_P_IMAGE) " + 
					   "WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Crew c = new Crew();
				
				c.setCrewNo(rset.getInt("c_no"));
				c.setCrewName(rset.getString("c_name"));
				c.setCrewImg(rset.getString("c_p_image"));
				c.setCrewCount(rset.getInt("c_count"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public String getSearchPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage,
			String keyword) {
		
		//전체 글 개수
		int recordTotalCount = totalSearchCount(conn, keyword);
		
		//전체 페이지 개수
		int pageTotalCount = 0;
		
		if((recordTotalCount%recordCountPerPage)>0) {
			pageTotalCount = (recordTotalCount/recordCountPerPage)+1;
		}else {
			pageTotalCount = (recordTotalCount/recordCountPerPage);
		}
		
		//네비 시작번호, 끝 번호
		int startNavi = (((currentPage-1)/naviCountPerPage)*naviCountPerPage)+1;
		int endNavi = startNavi+(naviCountPerPage-1);
		
		//공식으로 구한 endNavi가 총페이지 수 보다 크다면 총 페이지 수로 세팅
		if(endNavi>pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		//pageNavi 모양 만들기
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1) {
			sb.append("<li><a href='/crew/crewSearchList.do?currentPage="+(startNavi-1)+"&keyword="+keyword+"'><i class='fas fa-chevron-left'></i></a></li>");
		}
		
		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/crew/crewSearchList.do?currentPage="+i+"&keyword="+keyword+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/crew/crewSearchList.do?currentPage="+i+"&keyword="+keyword+"'>"+i+"</a></li>");
			}
		}
		
		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/crew/crewSearchList.do?currentPage="+(endNavi+1)+"&keyword="+keyword+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
	}

	private int totalSearchCount(Connection conn, String keyword) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int count = 0;
		
		String query = "SELECT COUNT(*)AS COUNT FROM CREW WHERE C_DEL_YN='N' AND C_NAME LIKE ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+keyword+"%");
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				count = rset.getInt("count");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	public int insertOneCrew(Connection conn, Crew c) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO CREW VALUES(CREW_SEQ.NEXTVAL, ?, SYSDATE, ?, ?, 'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getCrewName());
			pstmt.setString(2, c.getCrewInfo());
			pstmt.setString(3, c.getCrewImg());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertCrewMaster(Connection conn, Crew c, String userId) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		//입력한 크루명을 사용하여 c_no 검색 후 가져오기
		int crewNo = selectCrewNo(conn,c);
		
		String query = "INSERT INTO CREW_MEMBER VALUES(?, ?, '크루장', SYSDATE, 'SUCCESS', 'N')";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, crewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	private int selectCrewNo(Connection conn, Crew c) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int crewNo = 0;
		
		String query = "SELECT C_NO FROM CREW WHERE C_NAME=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getCrewName());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				crewNo = rset.getInt("c_no");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return crewNo;
	}

	public ArrayList<Crew> selectManageCrew(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Crew> list = new ArrayList<Crew>();
		
		String query = "SELECT C.C_NO,C_NAME,C_P_IMAGE,C_CREATEDATE,COUNT(*)AS C_COUNT " + 
					   "FROM CREW C " + 
					   "LEFT JOIN CREW_MEMBER CM ON (C.C_NO=CM.C_NO) " + 
					   "WHERE C_DEL_YN='N' AND C_JOIN_STATE='SUCCESS' " +
					   "AND C.C_NO IN (SELECT C_NO FROM CREW_MEMBER WHERE USERID=? AND C_AUTHORITY_ID = '크루장') " + 
					   "GROUP BY C.C_NO,C_NAME,C_P_IMAGE,C.C_CREATEDATE " +
					   "ORDER BY C.C_NO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Crew c = new Crew();
				
				c.setCrewNo(rset.getInt("c_no"));
				c.setCrewName(rset.getString("c_name"));
				c.setCrewImg(rset.getString("c_p_image"));
				c.setCrewCount(rset.getInt("c_count"));
				c.setCrewCreateDate(rset.getDate("c_createDate"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public ArrayList<Crew> selectJoinedCrew(Connection conn, String userId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Crew> list = new ArrayList<Crew>();
		
		String query = "SELECT C.C_NO,C_NAME,C_P_IMAGE,C_CREATEDATE,COUNT(*)AS C_COUNT " + 
					   "FROM CREW C " + 
					   "LEFT JOIN CREW_MEMBER CM ON (C.C_NO=CM.C_NO) " + 
					   "WHERE C_DEL_YN='N' AND C_JOIN_STATE='SUCCESS' " +
					   "AND C.C_NO IN (SELECT C_NO FROM CREW_MEMBER WHERE USERID=? AND C_AUTHORITY_ID = '크루원') " + 
					   "GROUP BY C.C_NO,C_NAME,C_P_IMAGE,C_CREATEDATE " +
					   "ORDER BY C.C_NO DESC";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				Crew c = new Crew();
				
				c.setCrewNo(rset.getInt("c_no"));
				c.setCrewName(rset.getString("c_name"));
				c.setCrewImg(rset.getString("c_p_image"));
				c.setCrewCount(rset.getInt("c_count"));
				c.setCrewCreateDate(rset.getDate("c_createDate"));
				
				list.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public Crew selectOneCrew(Connection conn, int crewNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Crew c = null;
		
		String query = "SELECT * FROM CREW WHERE C_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, crewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				c = new Crew();
				c.setCrewNo(rset.getInt("c_no"));
				c.setCrewName(rset.getString("c_name"));
				c.setCrewCreateDate(rset.getDate("c_createdate"));
				c.setCrewInfo(rset.getString("c_info"));
				c.setCrewImg(rset.getString("c_p_image"));
				c.setCrewDelYN(rset.getString("c_del_YN").charAt(0));				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return c;
	}

	public int updateOneCrew(Connection conn, Crew c) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE CREW SET C_NAME=?,C_INFO=?,C_P_IMAGE=? WHERE C_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getCrewName());
			pstmt.setString(2, c.getCrewInfo());
			pstmt.setString(3, c.getCrewImg());
			pstmt.setInt(4, c.getCrewNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<CrewMember> selectApproveList(Connection conn, int crewNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CrewMember> list = new ArrayList<CrewMember>();
		
		String query = "SELECT NICK,P_IMAGE,CM.* " +
					   "FROM CREW_MEMBER CM " + 
					   "LEFT JOIN MEMBER M ON (CM.USERID=M.USERID) " + 
					   "WHERE CM.C_NO=? AND C_JOIN_STATE='WAIT'";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, crewNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				
				CrewMember cm = new CrewMember();
				
				cm.setUserId(rset.getString("userId"));
				cm.setCrewNo(rset.getInt("c_no"));
				cm.setCrewAuthorityId(rset.getString("c_Authority_Id"));
				cm.setCrewEnrollDate(rset.getDate("c_EnrollDate"));
				cm.setCrewJoinState(rset.getString("c_Join_State"));
				cm.setCrewEndYN(rset.getString("c_End_YN").charAt(0));
				cm.setNick(rset.getString("nick"));
				cm.setMemberImg(rset.getString("p_image"));
				
				list.add(cm);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int updateCrewJoinStateAccept(Connection conn, String userId, int crewNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE CREW_MEMBER SET C_JOIN_STATE='SUCCESS' " + 
					   "WHERE USERID=? AND C_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, crewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateCrewJoinStateRefusal(Connection conn, String userId, int crewNo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "DELETE FROM CREW_MEMBER " + 
					   "WHERE USERID=? AND C_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, crewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public String selectCrewName(Connection conn, int crewNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String crewName = "";
		
		String qurey = "SELECT C_NAME FROM CREW WHERE C_NO=?";
		
		try {
			pstmt = conn.prepareStatement(qurey);
			pstmt.setInt(1, crewNo);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				crewName = rset.getString("c_name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return crewName;
	}

	public int deleteOneCrew(Connection conn, int crewNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE CREW SET C_DEL_YN='Y' WHERE C_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, crewNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<CrewBoard> selectAllPostList(Connection conn, int currentFeedPage, int recordCountPerPage, int crewNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CrewBoard> list = new ArrayList<CrewBoard>();
		
		int start = currentFeedPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentFeedPage*recordCountPerPage;
		
		int feedLikeCount = selectFeedLikeCount(crewNo);
		int feedCommentCount = selectFeedCommentCount(crewNo);
		
		String query = "SELECT * FROM ( " + 
					   "SELECT ROW_NUMBER() OVER(ORDER BY C_F_NO DESC)AS NUM, CF.*,NICK " + 
					   "FROM CREW_FEED CF " + 
					   "LEFT JOIN MEMBER M ON (CF.USERID=M.USERID) " + 
					   "WHERE C_NO=?) " + 
					   "WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, crewNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	private int selectFeedCommentCount(int crewNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int feedLikeCount = 0;
		
		String query = "";
		
		return 0;
	}

	private int selectFeedLikeCount(int crewNo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
