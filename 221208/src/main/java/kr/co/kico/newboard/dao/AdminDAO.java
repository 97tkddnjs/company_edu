package kr.co.kico.newboard.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.kico.newboard.dto.BoardDTO;
import kr.co.kico.newboard.dto.MemberDTO;
import kr.co.kico.newboard.dto.MenuBoardDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;

@Repository
public class AdminDAO {

	
	@Autowired
	private SqlSession sqlSession;
	
	public int menuAdd(String menutype) {
		// TODO Auto-generated method stub
		
		sqlSession.insert("NewBoardMapper.menusave", menutype);
		return 0;
	}

	public List<MenuTypeDTO> menuList() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("NewBoardMapper.menulist");
	}
	
	// 메뉴가 가진 게시판 개수
	public  List<MenuBoardDTO> menuBoardList() {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("NewBoardMapper.menuboardlist");
	}

	public List<MemberDTO> selectAllMember() {
		
		return sqlSession.selectList("NewBoardMapper.selectAllMember");
	}

	public List<BoardDTO> selectAllBoard() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("NewBoardMapper.selectAllBoard");
	}

	public void menuDelete(String menu_type_name) {
		// TODO Auto-generated method stub
		sqlSession.delete("NewBoardMapper.menuTypeDelete", menu_type_name);
	}

	public MemberDTO selectMember(int member_id) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("NewBoardMapper.selectMember", member_id);
	}

}
