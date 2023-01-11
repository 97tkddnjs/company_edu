package kr.co.kico.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionTestService {

	@Autowired
	private TransactionTestDAO dao;
	
	@Transactional
	public int sample1(TransactionTestDTO dto) {
		int successCount = 0;
		successCount = dao.insOrderMain(dto);
		
		int successCount2 = 0;
		successCount2 = dao.insOrderDetail1(dto);
		
		int successCount3 = 0;
		successCount3 = dao.insOrderDetail12(dto);
		
		return successCount + successCount2 + successCount3;
	}//sample

}// class
