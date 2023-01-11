package kr.co.kico.login;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.kico.dto.MemberDTO;
import kr.co.kico.interceptor.InterceptorTest1;

@Controller
@RequestMapping(value = "/inout")
public class InOutController {
	
	private static final Logger logger = LoggerFactory.getLogger(InOutController.class);
	
	@Autowired
	private InOutService service;
	
	
	@RequestMapping(value = "/loginf" , method = RequestMethod.GET)
	public String loginform() {
		
		
		return "login/login";
	}//loginform 
	
	@RequestMapping(value = "/login" , method = RequestMethod.GET)
	public String login(MemberDTO dto, HttpSession session, Model model) {
		//service -> dao -> mapper ->db에 id와 pwd 존재 여부 확인.
		
		System.out.println(dto);
		dto = service.login(dto);
		
		if(dto != null && dto.getMno() !=null && dto.getMno().contentEquals("")) {
			// 로그인 성공
			session.setAttribute("login_info", dto);
			model.addAttribute("messageFromServer", "로그인 성공");
		}else { // 로그인 실패
			model.addAttribute("messageFromServer", "로그인 실패");
		}
		
		return "start/home";
	}//loginform 
	
	
	@RequestMapping(value = "/logout" , method = RequestMethod.GET)
	public String logout(HttpSession session, Model model) {
		session.invalidate();
		model.addAttribute("messageFromServer", "로그아웃 성공");
		return "start/home";
	}//loginform 
	
}
