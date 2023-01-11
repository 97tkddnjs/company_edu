package kr.co.kico.dynamicboard;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DyBoardService {
	
	@Autowired
	private DyBoardDAO boardDAO;
	
	// BoardType 모두 호출
	public List<DyBoardTypeDTO> selectAllBoardType(){
		return boardDAO.selectAllBoardTypee();
	}
	
	// BoardType insert
	public int  insBoardType(String typename) {
		int successCount =0;	
		successCount = boardDAO.insBoardType(typename);
		return successCount;
	}
	
	//BoardDTO
	@Transactional
	public List<BoardDTO> selectBoardByType(int num){
		
		return boardDAO.selectBoardByType(num);
	}

	public int insdBoard(BoardDTO dto) {
		// TODO Auto-generated method stub
		return boardDAO.insdBoard(dto);
	}
	public int typenameTonum(String name) {
		return boardDAO.typenameTonum(name);
	}
	
}
