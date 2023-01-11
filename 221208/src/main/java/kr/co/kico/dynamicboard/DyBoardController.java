package kr.co.kico.dynamicboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value = "dynamicboard")
public class DyBoardController {
	
	@Autowired
	private DyBoardService service;
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String dboardhome(Model model) {
		
		List<DyBoardTypeDTO> list = service.selectAllBoardType();
		
		System.out.println(list.size());
		
		model.addAttribute("types", list);
		return "dynamicboard/home";
	}
	
	
	@RequestMapping(value = "/{dynamicboardnum}/{dynamicboardname}", method = RequestMethod.GET)
	public String dboarddetail(@PathVariable int dynamicboardnum, @PathVariable String dynamicboardname,
			Model model) {
		model.addAttribute("name", dynamicboardname);
		model.addAttribute("board_list",service.selectBoardByType(dynamicboardnum));
		return "dynamicboard/list";
	}
	
	
	//test ok
	@RequestMapping(value = "/typein", method = RequestMethod.POST)
	public String dboardTypeIns(String typename) {
		if(typename !=null)
			service.insBoardType(typename);
		return "redirect:./home";
	}
	
	//boardupload
	@RequestMapping(value = "/form/{name}", method = RequestMethod.GET)
	public String dboardIn(@PathVariable String name, Model model) {
		
		model.addAttribute("name", name);
		return "dynamicboard/form";
	}
	
	
	//boardupload
		@RequestMapping(value = "/boardupload", method = RequestMethod.POST)
		public void dboadupload(String hidname, BoardDTO dto, PrintWriter out) throws IOException  {
			System.out.println(dto);
			System.out.println(hidname);
			
			
			dto.setBoard_type_num(service.typenameTonum(hidname));
			
			MultipartFile uploadFile = dto.getAddFile();
	        if(uploadFile != null && !uploadFile.getOriginalFilename().equals("")) {
	            //파일이 있고, 기존에 없는 파일이라면
	            
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
	        }else { // mapper에서 아예 인식을 못해서 문제~
	        	dto.setAdd_file_name("");
	            dto.setAdd_file_path("");
	        }
	        System.out.println(dto);
	        int successCount = service.insdBoard(dto);
	        System.out.println("here   "+successCount);
	        out.print(successCount);
	        out.close();
	      
		}
	
	
}//class

