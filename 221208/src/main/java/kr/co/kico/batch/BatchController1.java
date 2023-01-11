package kr.co.kico.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import kr.co.kico.start.FirstTestDTO;
import kr.co.kico.start.FirstTestService;

//@Controller
public class BatchController1 {

	private final static Logger logger = LoggerFactory.getLogger(BatchController1.class);

	//초 분 시 일 월 요일
	//5 * * * * * : 매분 5초
	//5 2 * * * * : 매시간 2분 5초
	//5 2 10 * * * : 매일 10시 2분 5초
	//5 2 10 7 * * : 매월 7일 10시 2분 5초
	//5 2 10 7 12 * : 매년 11월 7일 10시 2분 5초
	//5 2 10 * * 2 : 매주 화요일 10시 2분 5초//(프로그램마다 일요일이 0 이거나 1이다.)
	//@Scheduled( cron = "5 * * * * *" )
	public void testScheduler() {
		logger.info("======= testScheduler =======");
	}//testScheduler
	
	@Autowired
	private FirstTestService service;
	
	//@Scheduled( cron = "5 * * * * *" )
	public void testScheduler2() {
		//@Scheduled 를 통해서 특정 DB crud 업무 자동으로 실행 시킬 수 있다.
		List<FirstTestDTO> list = service.selectAllEmp();
		logger.info(list.toString());
	}// testScheduler2

}//class
