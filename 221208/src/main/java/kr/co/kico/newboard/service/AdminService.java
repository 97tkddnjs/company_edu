package kr.co.kico.newboard.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kico.newboard.dao.AdminDAO;
import kr.co.kico.newboard.dto.BoardDTO;
import kr.co.kico.newboard.dto.MemberDTO;
import kr.co.kico.newboard.dto.MenuBoardDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;

@Service
public class AdminService {
	
	@Autowired
	private AdminDAO dao;

	public int menuAdd(String menutype) {
		
		int successConunt;
		
		successConunt= dao.menuAdd(menutype);
		
		return successConunt;
	}

	public List<MenuTypeDTO> menulist() {
		// TODO Auto-generated method stub
		
		return dao.menuList();
	}

	public List<MenuBoardDTO> menuBoardList() {
		// TODO Auto-generated method stub
		return dao.menuBoardList();
	}

	public List<MemberDTO> selectAllMember() {
		// TODO Auto-generated method stub
		return dao.selectAllMember();
	}

	public List<BoardDTO> selectAllBoard() {
		// TODO Auto-generated method stub
		return  dao.selectAllBoard();
	}

	public void menuDelete(String menu_type_name) {
		// TODO Auto-generated method stub
		dao.menuDelete(menu_type_name);
	}

	public MemberDTO selectMember(int member_id) {
		// TODO Auto-generated method stub
		return dao.selectMember(member_id);
	}

}
