package kr.co.kico.rest;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import kr.co.kico.board.free.BoardFreeController;
import kr.co.kico.board.free.BoardFreeDTO;
import kr.co.kico.board.free.BoardFreeService;
import kr.co.kico.file.FileTestDTO3;

@RestController // RestController 에서 method 는 일반적으로 json data를 return , 약점은 화면 호출이 어렵다는 점이다~
@RequestMapping(value = "/rest2")
public class RestController1 {

	private static final Logger logger = LoggerFactory.getLogger(RestController1.class);
	
	@RequestMapping(value = "/general", method = RequestMethod.GET)
	public String generalRestControllerMethod() {
		return "file12/form"; //data return 
	}
	
	@Autowired
	private BoardFreeService service;
	
	@RequestMapping(value="/general2", method = RequestMethod.GET, produces="application/json;charset=UTF-8")
	public String generalRestControllerJsonMethod() {
		
		List<FileTestDTO3> list =  service.selectAll();
		
		return new Gson().toJson(list); // repsonsebody json 리턴
	}//generalControllerMethod
	
	
	@RequestMapping(value = "/boardfree/{bno}", method = RequestMethod.GET)
	public String pathTest(@PathVariable String bno) {
		
		FileTestDTO3 dto = service.detail(bno);
		
		return new Gson().toJson(dto); // json data rerturn
	}
	
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String boardFreeWrite(@RequestBody FileTestDTO3 dto) {
		
		logger.info(dto.getTitle());
		logger.info(dto.getWriter());
		logger.info(dto.getCnts());
		
		
		return "success";
	}
	
	@RequestMapping(value="/{bno}", method = RequestMethod.DELETE)
	public String boardDelete(@PathVariable String bno) {
		
		logger.info(bno);
		return "success";
		
	}
	
}//class
