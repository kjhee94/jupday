package kr.or.iei.admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import kr.or.iei.admin.model.dao.AdminMemberDAO;
import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class AdminMemberServiceImpl implements AdminMemberService{
	private AdminMemberDAO adDAO = new AdminMemberDAO();

	@Override
	public ArrayList<Member> selectAllMemberList(String authorityId) {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Member> list = adDAO.SelectAllMemberList(authorityId, conn);
		JDBCTemplate.close(conn);
				
		return list;
	}

}