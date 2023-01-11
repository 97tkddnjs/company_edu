package kr.co.kico.file;



import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


import kr.co.kico.board.free.BoardFreeService;



@Controller
@RequestMapping( value = "/file12" )
public class FileController4 {



   private final static Logger logger = LoggerFactory.getLogger(FileController4.class);
    
    @Autowired
    private BoardFreeService service;
    
    @RequestMapping( value = "/upload5", method = RequestMethod.POST )
    public void upload5Return(FileTestDTO3 dto, PrintWriter out ) throws IOException {
        
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
            
        }
        System.out.println(dto);
        int successCount = service.insBoardFree(dto);
        System.out.println(successCount);
        out.print(successCount);
        out.close();
    }
    
    @RequestMapping( value = "/form", method = RequestMethod.GET )
    public String callForm4() {
        return "file2/form4"; //jsp file name
    }
}
/*
*
*
*
create sequence seq_bno
start with 1
increment by 1
maxvalue 9999
nocycle;

create table board_free(
    bno number(5,0) primary key
    , title vharchar2(150)
    , writer vharchar2(60)
    , cnts vharchar2(1500)
    , add_file_name(150)
    , add_file_path(1500)
    , bdate date
);
*
* */
/*
-- 오라클은 외국어 하나에 3byte
create sequence seq_bno
start with 1
increment by 1
maxvalue 99999
nocycle;

create table board_free
(
	bno number(5,0) primary key
	, title varchar2(150) not null
	, writer varchar2(60) not null
	, cnts varchar2(1500) not null
	, add_file_name varchar2(150)
	, add_file_path varchar2(1500)
	, bdate date not null
);
  
  
 */
