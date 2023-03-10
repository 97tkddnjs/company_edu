package kr.co.kico.newboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import kr.co.kico.newboard.NavBar;
import kr.co.kico.newboard.SessionConst;
import kr.co.kico.newboard.dto.BoardDTO;
import kr.co.kico.newboard.dto.BoardTypeDTO;
import kr.co.kico.newboard.dto.MemberDTO;
import kr.co.kico.newboard.dto.MenuTypeDTO;
import kr.co.kico.newboard.service.NewBoardService;



@Controller
@RequestMapping(value = "newboard")
public class NewBoardController {
	private static final Logger logger = LoggerFactory.getLogger(NewBoardController.class);
	
	@Autowired
	private NavBar nb;
	
	@Autowired
	private NewBoardService boardservice;
	
	// main page
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String newBoardHome(Model model) {
		
		logger.info("hello newboard");
		
		
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		List<BoardDTO> all = boardservice.allboard();
		model.addAttribute("allboard",all);
		return "newboard/home";
	}
	
	
	//admin home
	@RequestMapping(value = "admin/home", method = RequestMethod.GET)
	public String adminHome(Model model,HttpServletRequest request) {
		
		logger.info("hello admin");
		
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		HttpSession session = request.getSession(false); 
		//HttpSession??? ???????????? ?????? HttpSession??? ???????????? ???????????? ????????? ????????? ???????????? ?????? ?????? null??? ??????
        
		if (session != null) { 	  // session ??? ??????????????? ??????
            
			Object attribute = session.getAttribute(SessionConst.LOGIN_MEMBER);
			MemberDTO dto = (MemberDTO)attribute;
			
				return "/newboard/admin"; //*** ?????? ???????????? redirect -> ??? ???????????????...? -> ???????????? ????????? ?????????
			
        }else {	//session ??? ?????? ?????? ?????? X??????
        	
        	
        	return "newboard/home";
        }
		
	}
	
	
	// ????????? ????????? ???????????? ???????????? 
	@GetMapping(value = "/{menu_type_name}/{board_name}/{board_id}")
	public String boardHome(@PathVariable String menu_type_name, 
							@PathVariable String board_name
							,@PathVariable int board_id
							, Model model)
	{
		model.addAttribute("menutype", menu_type_name);
		model.addAttribute("boardname", board_name);
		model.addAttribute("board_id", board_id);
		
		//navbar ???
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
		
		List<BoardDTO> menuBoard = boardservice.menuTypeBoardDetail(menu_type_name,board_name);
		System.out.println(menuBoard);
		model.addAttribute("detailboard", menuBoard);
		return "newboard/showboard";
	}
	
	
	// ????????? ????????? ????????? ???????????? 
	@GetMapping(value = "/{menu_type_name}/{board_name}/{bseq}/detail")
	public String boardHomeDetail(
			@PathVariable String menu_type_name, 
			@PathVariable String board_name,
			@PathVariable int bseq , 
			Model model)
	{
		model.addAttribute("menutype", menu_type_name);
		model.addAttribute("boardname", board_name);
		
		//navbar ???
		List<MenuTypeDTO> list = nb.menuType();
		model.addAttribute("list",list);
		List<BoardTypeDTO> boardlist =  nb.boardType();
		model.addAttribute("boardlist",boardlist);
				
		
		
		System.out.println("hhererew "+menu_type_name+"   "+board_name+"   "+ bseq );
		BoardDTO board_detail =  boardservice.boardDetail(bseq);
		
		board_detail.setMenu_type_name(menu_type_name);
		board_detail.setBoard_name(board_name);
		
		model.addAttribute("board_detail", board_detail);
		
		return "newboard/boarddetail";
	}

	@RequestMapping(value = "/{menu_type_name}/{board_name}/{board_id}/boardupload", method = RequestMethod.GET)
	public String newoaduploadhome(
			@PathVariable String menu_type_name , 
			@PathVariable String board_name,
			@PathVariable int board_id,
			HttpServletRequest request,
			PrintWriter out,
			Model model
	) 
	{
		System.out.println("in comming");
		
		HttpSession session = request.getSession(false); 
		//HttpSession??? ???????????? ?????? HttpSession??? ???????????? ???????????? ????????? ????????? ???????????? ?????? ?????? null??? ??????
		MemberDTO dto = null;
		if (session != null) { 	  // session ??? ??????????????? ??????
            
			Object attribute = session.getAttribute(SessionConst.LOGIN_MEMBER);
			dto = (MemberDTO)attribute;
		}
		
		model.addAttribute("user", dto.getMember_login_id());
		model.addAttribute("menu_type_name", menu_type_name);
		model.addAttribute("board_name", board_name);
		model.addAttribute("board_id", board_id);	
		
		return "newboard/form";
	}
	
	@RequestMapping(value = "/{menu_type_name}/{board_name}/{bseq}/boarddelete", method = RequestMethod.POST)
	public void newoaddeletehome(
			@PathVariable String menu_type_name , 
			@PathVariable String board_name,
			@PathVariable int bseq,
			HttpServletRequest request,
			PrintWriter out
	) 
	{
		
		int successCnt=1;
		
		successCnt = boardservice.boardDelete(bseq);
		
		out.print(successCnt);
	}
	
	
	
	
	
	
	
	//updateboard/${board_detail.bseq}
	@GetMapping("/updateboard/{bseq}")
	public String updateBoard(@PathVariable int bseq, Model model) {
		
		BoardDTO dto = boardservice.boardDetail(bseq);
		model.addAttribute("board_detail_dto", dto);		
		return "newboard/reform";
	}
	
	
	
	@PostMapping("/updateboard/{bseq}/{board_id}")
	public void updateBoardPost(@PathVariable int bseq, 
			@PathVariable int board_id, 
			BoardDTO dto
			,Model model, PrintWriter out)  throws IOException {
		
		dto.setBoard_id(board_id);

		MultipartFile uploadFile = dto.getAddFile();
        if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
            //????????? ??????, ????????? ?????? ???????????????
            
            Date now = new Date();
            DateFormat dayFormat = new SimpleDateFormat("YYYYMMdd");
            DateFormat timeFormat = new SimpleDateFormat("HHmmss");
            String dayStr = dayFormat.format(now);
            String timeStr = timeFormat.format(now);
            
            File destFolder = new File("C:/up4spring/" + dayStr);
            
            System.out.println(destFolder);
            
            if(!destFolder.exists())
                destFolder.mkdir();
            
            String originFileName = uploadFile.getOriginalFilename();
            String [] splitFileName = originFileName.split("\\.");
            String upFileName = splitFileName[0] + "_" + timeStr + "." + splitFileName[1];
            InputStream in = uploadFile.getInputStream();
            OutputStream fileOut = new FileOutputStream(destFolder + "/" + upFileName);
            FileCopyUtils.copy(in, fileOut);
            in.close();
            //out.close();
            
            dto.setAdd_file_name(upFileName);
            dto.setAdd_file_path("/up4spring/" + dayStr + "/" + upFileName);
        }else { // mapper?????? ?????? ????????? ????????? ??????~
        	dto.setAdd_file_name("");
            dto.setAdd_file_path("");
        }
		
		
		System.out.println(dto);
		int successCount = boardservice.updateBoard(dto);
		
		 out.print(successCount);
	     out.close();
		//model.addAttribute("board_detail_dto", dto);		
		//return "newboard/reform";
	}
	
	
	
	//boardupload post 
	@RequestMapping(value = "/{menu_type_name}/{board_name}/{board_id}/boardupload", method = RequestMethod.POST)
	public void newoadupload(
			@PathVariable String menu_type_name , 
			@PathVariable String board_name ,
			@PathVariable int board_id ,
			BoardDTO dto, PrintWriter out) throws IOException  {
			
			dto.setBoard_id(board_id);
			//System.out.println(dto);
		
		
		
		
		MultipartFile uploadFile = dto.getAddFile();
        if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
            //????????? ??????, ????????? ?????? ???????????????
            
            Date now = new Date();
            DateFormat dayFormat = new SimpleDateFormat("YYYYMMdd");
            DateFormat timeFormat = new SimpleDateFormat("HHmmss");
            String dayStr = dayFormat.format(now);
            String timeStr = timeFormat.format(now);
            
            File destFolder = new File("C:/up4spring/" + dayStr);
            
            System.out.println(destFolder);
            
            if(!destFolder.exists())
                destFolder.mkdir();
            
            String originFileName = uploadFile.getOriginalFilename();
            String [] splitFileName = originFileName.split("\\.");
            String upFileName = splitFileName[0] + "_" + timeStr + "." + splitFileName[1];
            InputStream in = uploadFile.getInputStream();
            OutputStream fileOut = new FileOutputStream(destFolder + "/" + upFileName);
            FileCopyUtils.copy(in, fileOut);
            in.close();
            //out.close();
            
            dto.setAdd_file_name(upFileName);
            dto.setAdd_file_path("/up4spring/" + dayStr + "/" + upFileName);
        }else { // mapper?????? ?????? ????????? ????????? ??????~
        	dto.setAdd_file_name("");
            dto.setAdd_file_path("");
        }
        System.out.println(dto);
        int successCount = boardservice.insdBoard(dto);
        System.out.println("here   "+successCount);
        out.print(successCount);
        out.close();
      
	}
	
	@RequestMapping( value = "/download", method = RequestMethod.GET )
	public void fileDownload( String path, HttpServletResponse response ) throws IOException {
		System.out.println(path);
		String name = path.substring( path.lastIndexOf("/") + 1 ); // ??????????????? ????????? ??????
		name = new String( name.getBytes(), "ISO8859_1" );
		System.out.println(name);
		response.setHeader("Content-Disposition", "attachment;filename=" + name );
		//response : client??? ???????????? data ??????.
		//header : http??? ?????? ???????????? data packet??? ???????????? ??????.
		//setHeader : header??? ????????? ???????????? ?????????.
		//ISO8859_1 : character set( data ?????? ?????? )??? ??????

		FileInputStream fis = new FileInputStream( "C:" + path );
		ServletOutputStream sos = response.getOutputStream();

		byte [] buffer = new byte[1024];//1024 byte ????????? ????????? ?????? ?????? ??????.
		int readData = fis.read( buffer );
		while( readData != -1 ) {//-1 : EOF : end of file : ??? ?????? ?????? ???????????? ????????? ??????.
			sos.write( buffer );
			readData = fis.read( buffer );
		}//while

		sos.flush();//?????? data ????????????.
		fis.close();
		sos.close();

	}//fileDownload
	
	
}
