package kr.co.kico.newboard.dto;

import org.springframework.web.multipart.MultipartFile;

public class BoardDTO {
	
	private int bseq;
	
	private int board_id;
	
	private String board_name;
	
	private String member_login_id;
	
	private String bname;
	
	private String add_file_name;
	
	private String add_file_path;
	
	private String cnts;
	
	private String bdate;
	
	private String menu_type_name;
	
	private int board_detail_deleted;

	private MultipartFile addFile;
	
	
	
	public MultipartFile getAddFile() {
		return addFile;
	}




	public void setAddFile(MultipartFile addFile) {
		this.addFile = addFile;
	}




	public String getCnts() {
		return cnts;
	}




	public void setCnts(String cnts) {
		this.cnts = cnts;
	}

	

	public int getBseq() {
		return bseq;
	}




	public void setBseq(int bseq) {
		this.bseq = bseq;
	}




	public int getBoard_id() {
		return board_id;
	}




	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}




	public String getBoard_name() {
		return board_name;
	}




	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}




	public String getMember_login_id() {
		return member_login_id;
	}




	public void setMember_login_id(String member_login_id) {
		this.member_login_id = member_login_id;
	}




	public String getBname() {
		return bname;
	}




	public void setBname(String bname) {
		this.bname = bname;
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




	public String getMenu_type_name() {
		return menu_type_name;
	}




	public void setMenu_type_name(String menu_type_name) {
		this.menu_type_name = menu_type_name;
	}




	public int getBoard_detail_deleted() {
		return board_detail_deleted;
	}




	public void setBoard_detail_deleted(int board_detail_deleted) {
		this.board_detail_deleted = board_detail_deleted;
	}




	@Override
	public String toString() {
		return "BoardDTO [bseq=" + bseq + ", board_id=" + board_id + ", board_name=" + board_name + ", member_login_id="
				+ member_login_id + ", bname=" + bname + ", add_file_name=" + add_file_name + ", add_file_path="
				+ add_file_path + ", cnts=" + cnts + ", bdate=" + bdate + ", menu_type_name=" + menu_type_name
				+ ", board_detail_deleted=" + board_detail_deleted + "]";
	}

}
