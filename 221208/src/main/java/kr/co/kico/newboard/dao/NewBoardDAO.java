package kr.co.kico.newboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kico.newboard.dto.BoardDTO;
import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MenuBoardDetailDTO;

@Repository
public class NewBoardDAO {
	
	@Autowired
	SqlSession sqlSession;

	public List<BoardDTO> menuTypeBoardDetail(MenuBoardDetailDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("NewBoardMapper.menuTypeBoardDetail", dto);
	}

	public BoardDTO boardDetail(int board_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("NewBoardMapper.boardDetail", board_id);
	}

	public int insdBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.insert("NewBoardMapper.boardDetailIn", dto);
	}

	public List<BoardDTO> allboard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("NewBoardMapper.allboard");
	}

	public void inboard(BoardTypeDTO dto) {
		// TODO Auto-generated method stub
		sqlSession.insert("NewBoardMapper.inboard",dto);
	}

	public int updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return sqlSession.update("NewBoardMapper.updateBoard", dto);
	}

	public int boardDelete(int bseq) {
		// TODO Auto-generated method stub
		return sqlSession.delete("NewBoardMapper.boardDelete", bseq);
	}

	
}
