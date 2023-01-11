package kr.co.kico.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/file11")
public class FileController3 {

	private final static Logger logger = LoggerFactory.getLogger(FileController3.class);
	
	@RequestMapping(value="/upload4", method = RequestMethod.POST)
	public String upload4return(FileTestDTO2 dto , Model model) throws IOException {
		
		Date now = new Date();
		DateFormat naljaFormat = new SimpleDateFormat("YYYYMMdd");
		DateFormat siganFormat = new SimpleDateFormat("HHmmss");
		String nalja = naljaFormat.format(now);
		String sigan = siganFormat.format(now);
		
		File destinationDirectory = new File("C:/up4spring/"+nalja);
		if(!destinationDirectory.exists()) {
			destinationDirectory.mkdir();
			
		}
		
		String [] splitName = dto.getFileFromJsp1().getOriginalFilename().split("\\.");
		String writeFileName = splitName[0]+"_"+sigan+splitName[1];
		
		InputStream in = dto.getFileFromJsp1().getInputStream();
		FileOutputStream out = new FileOutputStream(destinationDirectory+"/"
				+ writeFileName);
		
		FileCopyUtils.copy(in, out);
		in.close();
		out.close();
		
		model.addAttribute("file_type",dto.getFileFromJsp1().getContentType());
		model.addAttribute("file_origin_name",dto.getFileFromJsp1().getOriginalFilename());
		model.addAttribute("file_size",dto.getFileFromJsp1().getSize());
		logger.info(dto.getTestInput());
		
		
		return "file1/upload_result";
	}
	
	@RequestMapping(value = "/upload3", method = RequestMethod.POST)
	public String upload3return(MultipartFile fileFromJsp1 , Model model) throws IOException {
		
		Date now = new Date();
		
		logger.info(now.toString());
		
		DateFormat naljaFormat = new SimpleDateFormat("YYYYMMdd");
		DateFormat siganFormat = new SimpleDateFormat("HHmmss");
		String nalja = naljaFormat.format(now);
		String sigan = siganFormat.format(now);
		logger.info(nalja);
		logger.info(sigan);
		
		File destinationDirectory = new File("C:/up4spring/"+nalja);
		if(destinationDirectory.exists()==false) {
			destinationDirectory.mkdir();
		}
		
//		String originFileName = fileFromJsp1.getOriginalFilename();
//		String [] splitName = originFileName.split(".");
//		String writeFileName = splitName[0]+ splitName[1];
		String originFileName = fileFromJsp1.getOriginalFilename();
		String subString1 = originFileName.substring(0,originFileName.indexOf("."));
		String subString2 = originFileName.substring(originFileName.indexOf("."));
		String writeFileName = subString1 + "_"+sigan +"."+ subString2;
		
		logger.info(writeFileName);
		
		InputStream in = fileFromJsp1.getInputStream();
		FileOutputStream out = new FileOutputStream(destinationDirectory+"/"
				+ writeFileName);
		
		FileCopyUtils.copy(in, out);
		in.close();
		out.close();
		
		model.addAttribute("file_type",fileFromJsp1.getContentType());
		model.addAttribute("file_origin_name",fileFromJsp1.getOriginalFilename());
		model.addAttribute("file_size",fileFromJsp1.getSize());
		
		return "file1/upload_result"; // jsp file name
	}
	
	@RequestMapping(value="/upload1", method = RequestMethod.POST)
	public String upload1Return(MultipartFile fileFromJsp1 , Model model) {
		logger.info(fileFromJsp1.getContentType());
		logger.info(fileFromJsp1.getName());
		logger.info(fileFromJsp1.getOriginalFilename());
		logger.info(fileFromJsp1.getSize()+" ");
		
		model.addAttribute("file_type",fileFromJsp1.getContentType());
		model.addAttribute("file_origin_name",fileFromJsp1.getOriginalFilename());
		model.addAttribute("file_size",fileFromJsp1.getSize());
		
		return "file1/upload_result";
	}
	
	
	@RequestMapping(value="/upload2", method = RequestMethod.POST)
	public String upload2Return(MultipartFile fileFromJsp1 , Model model) throws IOException{
		
		//파일을 읽는다.
		InputStream fis = fileFromJsp1.getInputStream();
		
		// 파일을 서버에 쓴다. write
		FileOutputStream fos = new FileOutputStream("C:/up4spring");
		FileCopyUtils.copy(fis, fos);
		//close
		fis.close();
		fos.close();
		
		model.addAttribute("file_type",fileFromJsp1.getContentType());
		model.addAttribute("file_origin_name",fileFromJsp1.getOriginalFilename());
		model.addAttribute("file_size",fileFromJsp1.getSize());
		
		return "file1/upload_result";
	}
	
	
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String fileForm()
	{
		
		return "/file1/form3"; //jsp file name
	}
	
}// class
