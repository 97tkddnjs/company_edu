package kr.co.kico.mywork;

import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/boardhome", method  = RequestMethod.GET)
	public String boardhome()
	{
		return "mywork/boardhome";
	}
	
	@RequestMapping(value = "/signup", method  = RequestMethod.GET)
	public String signup(){
		return "mywork/signup";
	}
	
	
	@RequestMapping(value = "/idCheck", method  = RequestMethod.POST)
	public void idCheck(String id, PrintWriter out) {
		
		boolean check = boardService.isDuplicationID(id);
		out.print(check);
		out.close();
	}
	
	
	@RequestMapping(value = "/signupIn", method  = RequestMethod.POST)
	public void signupIn(String id, String pwd, String name ,
			PrintWriter out)
	{
		BoardDTO dto = new BoardDTO();
		
		dto.setMid(id);
		dto.setMname(name);
		dto.setMpwd(pwd);
		
		System.out.println(dto);
		
		if(boardService.insMember(dto)){
			out.print(true);
		}else {
			out.print(false);
		}out.close();
		
		//return "mywork/signup";
	}
	
}
