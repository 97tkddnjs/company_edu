package kr.co.kico.mywork;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insMember(BoardDTO dto)
	{
		int successCount = 0;
		
		System.out.println("dfdfd"+dto);
		successCount = sqlSession.insert("BoardMemberMapper.insBoardMember",dto);
		System.out.println("yes");
		return successCount;
	}
	
	public int checkMember(String id) {
		
		int successCount = 0;
		
		//0 이면 중복 없고 ok 1이면 ~~
		successCount = sqlSession.selectOne("BoardMemberMapper.checkBoardMember",id);
		
		return successCount;
	}
	
}
