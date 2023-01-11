package kr.co.kico.login;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kico.dto.MemberDTO;

@Repository
public class InOutDAO {

	@Autowired
	private SqlSession sqlSession;
	
	
	public MemberDTO login(MemberDTO dto) {
		
		dto = sqlSession.selectOne("LoginMapper.Login", dto);
		return dto;
	}
	
}
