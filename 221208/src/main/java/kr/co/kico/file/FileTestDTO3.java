package kr.co.kico.file;

import org.springframework.web.multipart.MultipartFile;

public class FileTestDTO3 {

	private String bno;
	private String title;
	private String writer;
	private String cnts;
	private MultipartFile addFile;
	private String add_file_name;
	private String add_file_path;
	private String bdate;
	
	
	public String getBno() {
		return bno;
	}
	public void setBno(String bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public MultipartFile getAddFile() {
		return addFile;
	}
	public void setAddFile(MultipartFile addFile) {
		this.addFile = addFile;
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
	
	@Override
	public String toString() {
		return "FileTestDTO3 [bno=" + bno + ", title=" + title + ", writer=" + writer + ", cnts=" + cnts + ", addFile="
				+ addFile + ", add_file_name=" + add_file_name + ", add_file_path=" + add_file_path + ", bdate=" + bdate
				+ "]";
	}
	
}
