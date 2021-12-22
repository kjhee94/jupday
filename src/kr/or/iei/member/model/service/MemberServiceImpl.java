package kr.or.iei.member.model.service;

import java.sql.Connection;

import kr.or.iei.common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDAO;
import kr.or.iei.member.model.vo.Member;

public class MemberServiceImpl implements MemberService {

	
	private MemberDAO mDAO= new MemberDAO();

	@Override
	public Member selectOneMember(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.selectOneMember(userId,userPwd,conn);
		JDBCTemplate.close(conn);

		return m;
	}

	@Override
	public int insertOneMember(Member m) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result=mDAO.insertOneMember(m,conn);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public int udateOneMember(Member m) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOneMember(int userNo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member refreshOneMember(int userNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean selectIdCheck(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result=mDAO.selectIdCheck(userId,conn);
		JDBCTemplate.close(conn);
		
		return result;
	}

	@Override
	public boolean selectNickCheck(String nick) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result=mDAO.selectNickCheck(nick,conn);
		JDBCTemplate.close(conn);	
		
		return result;
	}
}
