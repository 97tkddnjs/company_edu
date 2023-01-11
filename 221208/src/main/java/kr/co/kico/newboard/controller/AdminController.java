package kr.co.kico.newboard.controller;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kico.newboard.NavBar;
import kr.co.kico.newboard.dto.BoardDTO;
import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MemberDTO;
import kr.co.kico.newboard.dto.MenuBoardDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;
import kr.co.kico.newboard.service.AdminService;
import kr.co.kico.newboard.service.NewBoardService;

@Controller
@RequestMapping("newboard/admin")
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private AdminService service;
	
	@Autowired
	private NewBoardService boardservice;
	
	@Autowired
	private NavBar nb;
	
	
	// 메뉴 추가
	@RequestMapping(value = "/menuadd" , method = RequestMethod.GET)
	public String menuAddpage(Model model, String menutype, PrintWriter out)
	{
		
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		
		List<MenuTypeDTO> menulist =  service.menulist();
		System.out.println("dddd");
		List<MenuBoardDTO> menu_board_list = service.menuBoardList();
		
		
		model.addAttribute("menulist", menulist);
		model.addAttribute("menu_board_list", menu_board_list);
		return "/newboard/menuadd";
	}
	
	
	// 메뉴 추가 post
	@RequestMapping(value = "/menuadd" , method = RequestMethod.POST)
	public String menuAdd(Model model, String menuname, PrintWriter out)
	{	
		logger.info("in the menu add post");
		
		int successCount;
		successCount =service.menuAdd(menuname);
	
		return "redirect:/newboard/admin/menuadd";
		
	}
	
	// 메뉴 삭제
	@RequestMapping(value = "/menudelete" , method = RequestMethod.POST)
	public void menuDeletepage( String menu_type_name,PrintWriter out)
	{
		
		System.out.println(menu_type_name);
		service.menuDelete(menu_type_name);
		
		out.print('1');
	}
	
	
	// 게시물 관리
	@RequestMapping(value = "/boardcontrol", method = RequestMethod.GET)
	public String boardAll(Model model) {
		
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		
		
		List<BoardDTO> allboardlist =  service.selectAllBoard();
		System.out.println(allboardlist);
		model.addAttribute("allboardlist", allboardlist );
		return "/newboard/boardcontrol";
	}
	
	
	// member들 관리
	@RequestMapping(value = "/membercontrol", method = RequestMethod.GET)
	public String memberAll(Model model) {
		
		
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		
		
		List<MemberDTO> memberlist =  service.selectAllMember();
		model.addAttribute("memberlist", memberlist);
		return "/newboard/membercontrol";
	}
	
	// member 관리
	@RequestMapping(value = "/memberspecific/{member_id}", method = RequestMethod.GET)
	public String memberspecific(
			@PathVariable int member_id,
			Model model) {
		
		
		// navbar 용
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		
		MemberDTO member=  service.selectMember(member_id);
		model.addAttribute("member", member);
		return "/newboard/memberdetail";
	}
	
	
	@PostMapping("boardadd")
	public String addBoard(int menu_type_id, String board_name, PrintWriter out)
	{
		System.out.println(menu_type_id);
		
		System.out.println(board_name);
		
		BoardTypeDTO dto = new BoardTypeDTO();
		dto.setBoard_name(board_name);
		dto.setMenu_type_id(menu_type_id);
		
		boardservice.inboard(dto);
		
		return "redirect:menuadd";
	}
	
	
	
}
