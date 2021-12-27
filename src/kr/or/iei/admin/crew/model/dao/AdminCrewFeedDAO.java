package kr.or.iei.admin.crew.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.admin.crew.model.vo.AdminCrewFeed;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.vo.Crew;

public class AdminCrewFeedDAO<CrewNo> {
	public ArrayList<AdminCrewFeed> selectAllCrewFeedPageList(Connection conn, int currentPage, int recordCountPerPage, int crewNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<AdminCrewFeed> list = new ArrayList<AdminCrewFeed>();
				
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;		
		
		String query = " SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY C_F_NO ASC)AS NUM, " + 
				"		CF.C_F_NO, C_F_REGDATE, C_F_SUBJECT, C_F_CONTENT, C_F_DEL_YN, NICK " + 
				"		FROM CREW_FEED CF LEFT JOIN MEMBER M ON (CF.USERID=M.USERID) WHERE C_NO=?) " + 
				"		WHERE NUM BETWEEN ? AND ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, crewNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) 
			{
				AdminCrewFeed f = new AdminCrewFeed();
				f.setC_No(rset.getInt("c_No"));
				f.setC_f_No(rset.getInt("c_f_No"));
				f.setC_f_Subject(rset.getString("c_f_Subject"));
				f.setC_f_Content(rset.getString("c_f_Content"));
				f.setC_f_RegDate(rset.getDate("c_f_RegDate"));
				f.setnick(rset.getString("nick"));
				f.setC_f_Del_YN(rset.getString("c_f_Del_YN").charAt(0));
				
				int feedNo = f.getC_f_No();
				f.setLikeCount(selectFeedLikeCount(conn,feedNo));
				list.add(f);
			
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
	
    private int selectFeedLikeCount(Connection conn, int feedNo) {
        
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        int feedLikeCount = 0;
        
        String query = "SELECT C_F_NO, COUNT(*) AS LIKE_COUNT " + 
                       "FROM CREW_FEED_LIKE " + 
                       "WHERE C_F_NO=? " + 
                       "GROUP BY C_F_NO";
        
        try {
            pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, feedNo);
            
            rset = pstmt.executeQuery();
            
            if(rset.next()) {
                feedLikeCount = rset.getInt("like_count");
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCTemplate.close(rset);
            JDBCTemplate.close(pstmt);
        }
        
        return feedLikeCount;
    }


	public String getPageNavi(Connection conn, int naviCountPerPage, int recordCountPerPage, int currentPage) {
		
		//전체 피드수
		int recordTotalCount = totalCount(conn);
		
		//전체 페이지수
		int pageTotalCount = 0;
		
		if((recordTotalCount % recordCountPerPage)>0)
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage) + 1;
		}else
		{
			pageTotalCount = (recordTotalCount / recordCountPerPage);
		}
		
		int startNavi = (((currentPage-1) / naviCountPerPage) * naviCountPerPage) +1;
		int endNavi = startNavi + (naviCountPerPage-1);
		
		//endNavi가 총 page수보다 클 경우 총 page수로 셋팅
		if(endNavi > pageTotalCount)
		{
			endNavi = pageTotalCount;
		}
				
		//pageNavi 모양 만들기
		StringBuilder sb = new StringBuilder();
		
		if(startNavi!=1) {
			sb.append("<li><a href='/admin/crewFeedManageList.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/admin/crewFeedManageList.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/admin/crewFeedManageList.do?currentPage="+i+"'>"+i+"</a></li>");
			}
		}

		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/admin/crewFeedManageList.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
				
	}
	
	public int totalCount(Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "SELECT COUNT(*) as count FROM CREW_FEED WHERE C_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setInt(1, crewNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next())
			{
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


	public int updateCrewFeedDelYN(int feedNo, char delYN, Connection conn) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE CREW_FEED SET C_F_DEL_YN=? WHERE C_F_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, String.valueOf(delYN));
			pstmt.setInt(2, feedNo);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}


	
}
