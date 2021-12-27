package kr.or.iei.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.admin.model.dao.AdminMemberDAO;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class AdminMemberServiceImpl implements AdminMemberService{
	
	private AdminMemberDAO adDAO = new AdminMemberDAO();
	
	@Override
	public HashMap<String, Object> selectAllMemberList(int currentPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		//한 개의 page에서 몇 개의 목록으로 보여줄 것인지
		int recordCountPerPage = 10;
		
		ArrayList<Member> list = adDAO.selectAllMemberList(conn, currentPage, recordCountPerPage);
		
		//한 개의 pageNavi에서 보여질 Navi 개수
		int naviCountPerPage = 5;
		
		String pageNavi = adDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		JDBCTemplate.close(conn);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);
		
		return hm;
	}

	@Override
	public int updateMemberEndYN(String userId, char endYN) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = adDAO.updateMemberEndYN(userId,endYN,conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	


		
}
