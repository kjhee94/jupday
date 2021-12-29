package kr.or.iei.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import kr.or.iei.admin.model.dao.AdminMemberDAO;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;
import kr.or.iei.notice.model.vo.NoticeCampaign;

public class AdminMemberServiceImpl implements AdminMemberService{
	
	private AdminMemberDAO adDAO = new AdminMemberDAO(); 

	@Override
	public int updateMemberEndYN(String userId, char endYN) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = adDAO.updateMemberEndYN(userId,endYN,conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}


	@Override
	public HashMap<String, Object> selectAllMemberPageList(int currentPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		//한 개의 page에서 몇 개의 목록으로 보여줄 것인지
		int recordCountPerPage = 10;
		
		ArrayList<Member> list = adDAO.selectAllMemberPageList(conn, currentPage, recordCountPerPage);
		
		//한 개의 pageNavi에서 보여질 Navi 개수
		int naviCountPerPage = 5;
		
		String pageNavi = adDAO.getPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage);
		
		HashMap<String,Object> hm = new HashMap<String,Object>();
		
		hm.put("list", list);
		hm.put("pageNavi", pageNavi);

		JDBCTemplate.close(conn);
		return hm;
		
		
		
	}


	@Override//삭제시 이 메소드를 삭제
	public HashMap<String, Object> adminMemberSearch(int currentPage, String keyword, String type) {

		Connection conn = JDBCTemplate.getConnection();
		
		//하나의 Page에서 몇개의 목록으로 보여줄 것인지에 대한 값이 필요
		int recordCountPerPage= 10; 
		
		ArrayList<Member> list =adDAO.selectSearchAdminMemberList(conn,currentPage,recordCountPerPage,keyword,type);
		
		//2.하나의 pageNavi Bar에 보여질 Navi 개수를 설정
		int naviCountPerPage=5;


		String pageNavi=adDAO.getSearchAdminMemberPageNavi(conn,naviCountPerPage,recordCountPerPage,currentPage,keyword,type);
		
		//DB 연결 해제 
		JDBCTemplate.close(conn);
		
		// 리턴을 하기 위하여 HashMap 객체를 만들어서 리턴
		
		HashMap<String,Object> map = new HashMap<String,Object>();
		
		map.put("list", list);
		map.put("pageNavi", pageNavi);
		
		return map;
	}


	}

