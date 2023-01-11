package kr.co.kico.board.free;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kico.file.FileTestDTO3;

@Service
public class BoardFreeService {
	
	@Autowired
	private BoardFreeDAO dao;
	
	public int insBoardFree(FileTestDTO3 dto) {
		
		int successCount = 0;
	
		successCount = dao.insBoardFree(dto);
		
		return successCount;
	} // insBoardFree

	public List<FileTestDTO3> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	public FileTestDTO3 detail(String bno) {
		// TODO Auto-generated method stub
		return dao.detail(bno);
	}

	
}
