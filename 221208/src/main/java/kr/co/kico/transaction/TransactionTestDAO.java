package kr.co.kico.transaction;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TransactionTestDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public int insOrderMain(TransactionTestDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("TranssactionTestMapper.insOrderMain",dto);
		return successCount;
	}//insOrderMain

	public int insOrderDetail1(TransactionTestDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("TranssactionTestMapper.insOrderDetail1",dto);
		return successCount;
	}//insOrderMain

	public int insOrderDetail12(TransactionTestDTO dto) {
		int successCount = 0;
		successCount = sqlSession.insert("TranssactionTestMapper.insOrderDetail12",dto);
		return successCount;
	}//insOrderMain

	
	
}//class
