package kr.co.kico.dynamicboard;

import org.springframework.web.multipart.MultipartFile;

// board dto

public class BoardDTO {
	
	private int bseq;
	
	private String bname;
	
	private String writer;
	
	private String cnts;
	
	private String add_file_name;
	
	private String add_file_path;
	
	private String bdate;
	
	private int board_type_num;

	private MultipartFile addFile;

	public int getBseq() {
		return bseq;
	}

	public void setBseq(int bseq) {
		this.bseq = bseq;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getCnts() {
		return cnts;
	}

	public void setCnts(String cnts) {
		this.cnts = cnts;
	}

	public String getAdd_file_name() {
		return add_file_name;
	}

	public void setAdd_file_name(String add_file_name) {
		this.add_file_name = add_file_name;
	}

	public String getAdd_file_path() {
		return add_file_path;
	}

	public void setAdd_file_path(String add_file_path) {
		this.add_file_path = add_file_path;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public int getBoard_type_num() {
		return board_type_num;
	}

	public void setBoard_type_num(int board_type_num) {
		this.board_type_num = board_type_num;
	}

	public MultipartFile getAddFile() {
		return addFile;
	}

	public void setAddFile(MultipartFile addFile) {
		this.addFile = addFile;
	}

	@Override
	public String toString() {
		return "BoardDTO [bseq=" + bseq + ", bname=" + bname + ", writer=" + writer + ", cnts=" + cnts
				+ ", add_file_name=" + add_file_name + ", add_file_path=" + add_file_path + ", bdate=" + bdate
				+ ", board_type_num=" + board_type_num + ", addFile=" + addFile + "]";
	}
	
	
	
	
	
	
}
