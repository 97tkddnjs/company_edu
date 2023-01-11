package kr.co.kico.newboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.kico.newboard.dao.MemberDAO;
import kr.co.kico.newboard.dto.MemberDTO;

@Service
public class MemberService {
	
	@Autowired
	private MemberDAO dao;
	
	public MemberDTO login(String member_login_id, String member_pwd) {
		// TODO Auto-generated method stub
		
		// 조회 후에 비밀번호와 같다면
		MemberDTO dto =  dao.findById(member_login_id);
		if(dto.getMember_pwd().equals(member_pwd)) {
			return dto;
		}
		return null;
	}

	//@Transactional
	public int save(MemberDTO dto) {
		// TODO Auto-generated method stub
		// 조회한 값이 null 이라면 -> 가입할 값을 넣어야지~
		
		MemberDTO data = dao.findById(dto.getMember_login_id());
		System.out.println("here "+ data);
		if(data == null) {
			System.out.println("ok here");
			dto.setMember_grade_id(2);
			dto.setMember_group_id(1);
			
			return dao.memberSave(dto);
		}else {
			System.out.println("?????");
		}
		return 0;
	}

	

	
	
}
