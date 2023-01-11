package kr.co.kico.newboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kico.newboard.dao.NewBoardDAO;
import kr.co.kico.newboard.dto.BoardDTO;
import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MenuBoardDetailDTO;

@Service
public class NewBoardService {
	
	@Autowired
	private NewBoardDAO dao;

	public List<BoardDTO> menuTypeBoardDetail(String menu_type_name, String board_name) {
		MenuBoardDetailDTO dto = new MenuBoardDetailDTO();
		dto.setMenu_type_name(menu_type_name);
		dto.setBoard_name(board_name);
		
		return dao.menuTypeBoardDetail(dto);
	}

	public BoardDTO boardDetail(int board_id) {
		// TODO Auto-generated method stub
		return dao.boardDetail(board_id);
	}

	public int insdBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return dao.insdBoard(dto);
	}

	public List<BoardDTO> allboard() {
		// TODO Auto-generated method stub
		return dao.allboard();
	}

	public void inboard(BoardTypeDTO dto) {
		// TODO Auto-generated method stub
		dao.inboard(dto);
	}

	public int updateBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return dao.updateBoard(dto);
	}

	public int boardDelete(int bseq) {
		// TODO Auto-generated method stub
		return dao.boardDelete(bseq);
	}

	
}
