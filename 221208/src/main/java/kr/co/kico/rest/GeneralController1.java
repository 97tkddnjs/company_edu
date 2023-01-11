package kr.co.kico.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import kr.co.kico.board.free.BoardFreeService;
import kr.co.kico.file.FileTestDTO3;

@Controller	// Controller 에서 method 는 일반적으로 jsp 파일 이름을 return
public class GeneralController1 {
	
	
	
	@RequestMapping(value="/rest/general1", method = RequestMethod.GET)
	public String generalControllerMethod() {
		return "file2/form"; // jsp 파일이름을 리턴
	}//generalControllerMethod
	
	
	@RequestMapping(value="/rest/general2", method = RequestMethod.GET)
	@ResponseBody
	public String generalControllerResponsBodyMethod() {
		return "file12/form"; // repsonsebody json 리턴
	}//generalControllerMethod
	
	@Autowired
	private BoardFreeService service;
	
	@RequestMapping(value="/rest/general3", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	@ResponseBody
	public String generalControllerResponsBodyJsonMethod() {
		
		List<FileTestDTO3> list =  service.selectAll();
		
		return new Gson().toJson(list); // repsonsebody json 리턴
	}//generalControllerMethod
	
	
}
