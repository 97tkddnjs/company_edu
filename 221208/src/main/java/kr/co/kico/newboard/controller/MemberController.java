package kr.co.kico.newboard.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jdk.internal.org.jline.utils.Log;
import kr.co.kico.newboard.NavBar;
import kr.co.kico.newboard.SessionConst;
import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MemberDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;
import kr.co.kico.newboard.service.MemberService;

@Controller
@RequestMapping(value = "newboard")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService service;
	
	@Autowired
	private NavBar nb;
	
	// 로그인 페이지로 연결
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginForm(Model model) {
		
		List<MenuTypeDTO> list = nb.menuType();
		System.out.println(list);
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		
		System.out.println(boardlist);
		model.addAttribute("boardlist",boardlist);
		
		return "newboard/login";
	}
	
	
	// 로그인 데이터 post로  값 넘기는 경우
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginCheck(MemberDTO dto ,PrintWriter out, HttpServletRequest request) {
		
		System.out.println(dto);
		
		MemberDTO login = service.login(dto.getMember_login_id(), dto.getMember_pwd());
		
		
		System.out.println("log in " +login);
		if(login == null){
			out.print(0);
			return "newboard/login";
		}
		
		// 세션에다가 해당 정보들 넣기
		HttpSession session = request.getSession(true);
		session.setAttribute(SessionConst.LOGIN_MEMBER, login);
		
		
		Object attribute = session.getAttribute(SessionConst.LOGIN_MEMBER);
		System.out.println((MemberDTO)attribute);
		
		
		// 등급이 admin인지 아닌지에 따라서 다르게 페이지 보여줌
		if(login.getMember_grade_id()==2)
			return "redirect:/newboard/home";
		else
			return "redirect:/newboard/admin/home";
	}
	
	@RequestMapping(value = "/logout" )
	public String logout(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false); 
		//HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 생성하지 않고 그냥 null을 반환
        if (session != null) { 	  // session 이 존재한다는 의미
            session.invalidate(); // 세션 없애기~
        }
		return "redirect:/newboard/home";
	}
	
	
	// 회원 가입 페이지로 
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(){
		
		return "newboard/signup";
	}
	
	
	// 회원 가입 post
	@RequestMapping(value="/signup", method = RequestMethod.POST)
	public void signcheck( MemberDTO dto, PrintWriter out){
		
		System.out.println("sign up "+ dto);
		int succes=  service.save(dto);
		System.out.println("success "+succes);
		out.print(succes);

	}
	
}
