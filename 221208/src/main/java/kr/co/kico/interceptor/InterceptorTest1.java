package kr.co.kico.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.kico.board.free.BoardFreeController;
import kr.co.kico.dto.MemberDTO;

public class InterceptorTest1 extends HandlerInterceptorAdapter{
	
	private static final Logger logger = LoggerFactory.getLogger(InterceptorTest1.class);
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		System.out.println("RequestMapping method 실행 전");
//		logger.info("Request uri "+request.getRequestURI());
//		
//		HttpSession session =request.getSession();
//		MemberDTO dto = (MemberDTO)session.getAttribute("login_info");
//		if(dto == null || dto.getMname() ==null || dto.getMname().equals("")) {
//			response.sendRedirect("/kico/inout/loginf");
//			return false;
//		}
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("RequestMapping 메소드 실행 후 실행");
		logger.info("modelAndView name "+modelAndView.getViewName());
		super.postHandle(request, response, handler, modelAndView);
	}
	
	
} //class
