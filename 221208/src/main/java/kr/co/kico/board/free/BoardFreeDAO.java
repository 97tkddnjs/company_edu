package kr.co.kico.board.free;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kico.file.FileTestDTO3;

@Repository
public class BoardFreeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public int insBoardFree(FileTestDTO3 dto)
	{
		int successCount = 0;
		
		successCount = sqlSession.insert("BoardFreeMapper.insBoardFree",dto);
		
		return successCount;
	}

	public List<FileTestDTO3> selectAll() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("BoardFreeMapper.selectList");
	}

	public FileTestDTO3 detail(String bno) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectOne("BoardFreeMapper.selectOne", bno);
	}
	
	
}
