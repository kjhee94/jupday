package kr.or.iei.crew.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.vo.Crew;

public class CrewDAO {

	public ArrayList<Crew> selectCrewAllList(Connection conn, int currentPage, int recordCountPerPage) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Crew> list = new ArrayList<Crew>();
		
		int start = currentPage*recordCountPerPage-(recordCountPerPage-1);
		int end = currentPage*recordCountPerPage;
		
		String query = "SELECT * FROM(" + 
					   "SELECT ROW_NUMBER() OVER(ORDER BY C.C_NO DESC)AS NUM," + 
					   "C.C_NO,C_NAME,C_CREATEDATE,C_INFO,C_P_IMAGE,C_DEL_YN," + 
					   "COUNT(*)AS c_count " + 
					   "FROM CREW C " + 
					   "LEFT JOIN CREW_MEMBER CM ON (C.C_NO=CM.C_NO) " + 
					   "WHERE C_DEL_YN='N' " + 
					   "GROUP BY C.C_NO,C_NAME,C_CREATEDATE,C_INFO,C_P_IMAGE,C_DEL_YN) " + 
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
				c.setCrewCreateDate(rset.getDate("c_createdate"));
				c.setCrewInfo(rset.getString("c_info"));
				c.setCrewImg(rset.getString("c_p_image"));
				c.setCrewDelYN(rset.getString("c_del_YN").charAt(0));
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
					   "C.C_NO,C_NAME,C_CREATEDATE,C_INFO,C_P_IMAGE,C_DEL_YN," + 
					   "COUNT(*)AS c_count " + 
					   "FROM CREW C " + 
					   "LEFT JOIN CREW_MEMBER CM ON (C.C_NO=CM.C_NO) " + 
					   "WHERE C_DEL_YN='N' AND C_NAME LIKE ? " + 
					   "GROUP BY C.C_NO,C_NAME,C_CREATEDATE,C_INFO,C_P_IMAGE,C_DEL_YN) " + 
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
			c.setCrewCreateDate(rset.getDate("c_createdate"));
			c.setCrewInfo(rset.getString("c_info"));
			c.setCrewImg(rset.getString("c_p_image"));
			c.setCrewDelYN(rset.getString("c_del_YN").charAt(0));
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
	
	
	

}
