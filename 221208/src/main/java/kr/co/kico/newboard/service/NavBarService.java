package kr.co.kico.newboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kico.newboard.dao.NavBarDAO;
import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;

@Service
public class NavBarService {

	@Autowired
	private NavBarDAO dao;
	
	public List<MenuTypeDTO> menuTypeList() {
		// TODO Auto-generated method stub
		return dao.menuTypeList();
	}

	public List<BoardTypeDTO> boardTypeList() {
		// TODO Auto-generated method stub
		return dao.boardTypeList();
	}

}
