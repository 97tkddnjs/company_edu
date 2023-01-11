package kr.co.kico.newboard.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kico.newboard.dto.MemberDTO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public MemberDTO findById(String member_login_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("NewBoardMapper.findById", member_login_id);
	}

	public int memberSave(MemberDTO dto) {
		// TODO Auto-generated method stub
		int successCount;
		System.out.println("dao p "+dto);
		successCount =  sqlSession.insert("NewBoardMapper.memberSave", dto);
		System.out.println(successCount);
		return successCount;
		
	}

	

}
