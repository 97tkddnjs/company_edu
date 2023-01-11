package kr.co.kico.newboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;
import kr.co.kico.newboard.service.NavBarService;

@Component
public class NavBar {
	
	@Autowired
	private NavBarService service;
	
	public List<MenuTypeDTO> menuType(){
		
		return service.menuTypeList();
	}
	
	public List<BoardTypeDTO> boardType(){
		
		return service.boardTypeList();
	}
	
}
