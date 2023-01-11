package kr.co.kico.dynamicboard;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DyBoardDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<DyBoardTypeDTO> selectAllBoardTypee() {
		return sqlSession.selectList("DyBoardMapper.selectAllBoardType");
	}//typename
	
	public int insBoardType(String typename) {
		int successCount =0;
		
		successCount = sqlSession.insert("DyBoardMapper.insBoardType",typename);
		return successCount;
	}
	
	public List<BoardDTO> selectBoardByType(int board_type_num) {
		return sqlSession.selectList("DyBoardMapper.selectAllByBoardType",board_type_num);
	}//typename

	public int typenameTonum(String name) {
		return sqlSession.selectOne("DyBoardMapper.typenameTonum",name);
	}

	public int insdBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert("DyBoardMapper.insBoard",dto);
	}

	
}
