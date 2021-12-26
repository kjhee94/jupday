package kr.or.iei.admin.crew.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.crew.model.vo.Crew;

public class AdminCrewDAO {
	public ArrayList<Crew> selectAllCrewPageList(Connection conn, int currentPage, int recordCountPerPage) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Crew> list = new ArrayList<Crew>();
		
		int start = currentPage * recordCountPerPage - (recordCountPerPage-1);
		int end = currentPage * recordCountPerPage;
		
		String query = "SELECT * FROM "
				+ "	(SELECT ROW_NUMBER() OVER (ORDER BY C_NO ASC) AS NUM, "
				+ "	CREW.* FROM CREW) WHERE NUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) 
			{
				Crew cr = new Crew();
				cr.setCrewNo(rset.getInt("c_No"));
				cr.setCrewName(rset.getString("c_Name"));
				cr.setCrewInfo(rset.getString("c_Info"));
				cr.setCrewCount(rset.getInt("c_count"));
				cr.setCrewCreateDate(rset.getDate("c_CreateDate"));
				cr.setCrewDelYN(rset.getString("crewDel_YN").charAt(0));
				list.add(cr);
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
		
		//전체 크루수
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
			sb.append("<li><a href='/admin/CrewrManageList.do?currentPage="+(startNavi-1)+"'><i class='fas fa-chevron-left'></i></a></li>");
		}

		for(int i=startNavi; i<=endNavi; i++) {
			
			if(i==currentPage) {
				sb.append("<li><a href='/admin/CrewManageList.do?currentPage="+i+"' class='page_active'>"+i+"</a></li>");
			}else {
				sb.append("<li><a href='/admin/CrewManageList.do?currentPage="+i+"'>"+i+"</a></li>");
			}
		}

		if(endNavi!=pageTotalCount) {
			sb.append("<li><a href='/admin/CrewManageList.do?currentPage="+(endNavi+1)+"'><i class='fas fa-chevron-right'></i></a></li>");
		}
		
		return sb.toString();
				
	}
	
	public int totalCount(Connection conn)
	{
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		int count = 0;
		
		String query = "SELECT COUNT(*) as count FROM CREW";
		
		try {
			pstmt = conn.prepareStatement(query);
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
}

