package kr.co.kico.transaction;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.kico.file.FileController1;

@Controller
@RequestMapping(value="transaction")
public class TransactionTestController {

	private final static Logger logger = LoggerFactory.getLogger(TransactionTestController.class);
	
	@Autowired
	private TransactionTestService service;
	
	@RequestMapping(value="/sample" , produces="application/json;charset=UTF-8", method = RequestMethod.GET )
	@ResponseBody
	public String sample1(TransactionTestDTO dto) throws UnsupportedEncodingException{
		
		int successCount = 0;
		successCount = service.sample1(dto);
		//res.setContentType("text/html;charset=euc-kr");
		//res.setCharacterEncoding("UTF-8");
		//@ResponseBody를 사용하면 데이터 전송.
		// ajax 호출과 함께 사용 가능
		String message = "/transaction/sample의 수행 결과를 DB에서 확인하여야 한다."+successCount;
		return message;
	}//sample1
	
} // class

/*
 
 create sequence seq_order_main_no
 start with 1
 increment by 1
 maxvalue 99999
 nocycle;
 
 create sequence seq_order_detail_no
 start with 1
 increment by 1
 maxvalue 99999
 nocycle;
 
 create table order_main
 (
 	order_main_no number(5,0) primary key ,
 	order_date date  not null
 )
 
 create table order_detail
 (
 	order_detail_no  number(5,0) primary key,
 	order_main_no  number(5,0) not null,
 	product_name varchar2(60)  not null,
 	order_qty number(5,0)  not null
 )
 
 */