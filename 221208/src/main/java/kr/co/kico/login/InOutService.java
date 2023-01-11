package kr.co.kico.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.kico.dto.MemberDTO;

@Service
public class InOutService {

	@Autowired
	private InOutDAO dao;
	
	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
		// TODO Auto-generated method stub
		
	}

}
