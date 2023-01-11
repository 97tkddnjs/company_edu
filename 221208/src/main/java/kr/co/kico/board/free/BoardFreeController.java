package kr.co.kico.board.free;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kico.file.FileTestDTO3;

@Controller
@RequestMapping( value = "/board/free")
public class BoardFreeController {

	private static final Logger logger = LoggerFactory.getLogger(BoardFreeController.class);

	@Autowired
	private BoardFreeService service;

	
	@RequestMapping( value = "/detail", method = RequestMethod.GET )
	public String detail( String bno , Model model) {
		
		logger.info("detail method ~~~");
		FileTestDTO3 dto = service.detail(bno);
		model.addAttribute("detail_dto", dto);
		
		return "board/free/detail";
	}
	
	@RequestMapping( value = "/list", method = RequestMethod.GET )
	public String selectAllEmp( Model model ) {
		
		
		logger.info("select_all_emp start");
		
		//controller -> service -> dao -> mapper -> db -> mapper -> dao -> service -> controller -> model
		List<FileTestDTO3> list = null;
		list = service.selectAll();

		model.addAttribute("board_list", list);
		
		return "board/free/list";//jsp 파일 이름.
	}//selectAllEmp

}//class




