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
	public int deleteOneMember(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.deleteOneMember(userId, userPwd, conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public Member refreshOneMember(String userId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.refreshOneMember(userId, conn);
		JDBCTemplate.close(conn); 
		return m;
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

	@Override

	public boolean selectEmailChecking(String email) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result=mDAO.selectEmailCheck(email,conn);
		JDBCTemplate.close(conn);	
		
		return result;
	}
	
	@Override
	public Member searchId(String email) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.searchId(email,conn);
		JDBCTemplate.close(conn);

		return m;
		
		
	}
	
	@Override
	public Member searchPwd(String userId,String email) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = mDAO.searchPwd(userId,email,conn);
		JDBCTemplate.close(conn);

		return m;
		

		
	}
	
	
	@Override
	public int searchUapatePwd(String userId, String userPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result= mDAO.searchUapatePwd(userId,userPwd,conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;

		
	}
	
	




	public int updatePwdMember(String userId, String pwd, String newPwd) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updatePwdMember(userId, pwd, newPwd, conn);
		if(result>0) JDBCTemplate.commit(conn);
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public int updateOneMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.updateOneMember(m, conn);
		if(result>0) JDBCTemplate.getConnection();
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}

	@Override
	public boolean selectEmailCheck(String email) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result=mDAO.selectEmailCheck(email,conn);
		JDBCTemplate.close(conn);	
		return result;
	}

	//미사용
	@Override
	public int insertFileUpdate2(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = mDAO.insertFileUpdate2(m, conn);
		if(result>0) JDBCTemplate.getConnection();
		else JDBCTemplate.rollback(conn);
		JDBCTemplate.close(conn);
		return result;
	}
	}
	


