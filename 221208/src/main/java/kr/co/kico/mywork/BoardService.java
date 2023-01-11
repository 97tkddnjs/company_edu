package kr.co.kico.mywork;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
	/*
	 * 2개의 매소드로 구성함
	 * 
	 * 중복 체크와 삽입 함수
	 * 
	 * */
	
	
	@Autowired
	private BoardDAO boardDAO;
	
	// false 면 중복이 없다는 것 true 면 안됨
	public boolean isDuplicationID(String id)
	{	
		// 0 값 반환되면 중복 없는 것임
		
		if(boardDAO.checkMember(id) == 0)
			return false;
		else
			return true;
	}
	
	public boolean insMember(BoardDTO dto) {
		
		// 중복이 아니란 의미
		if(!isDuplicationID(dto.getMid()))
		{
			boardDAO.insMember(dto);
			return true;
		}
		return false;
	}
	
	
	
}
