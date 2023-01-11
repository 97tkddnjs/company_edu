package kr.co.kico.newboard.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;

@Repository
public class NavBarDAO {
	
	@Autowired
	private SqlSession sqlSession;

	public List<MenuTypeDTO> menuTypeList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("NewBoardMapper.menuTypeList");
	}

	public List<BoardTypeDTO> boardTypeList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("NewBoardMapper.boardTypeList");
	}
	
	
	
}
