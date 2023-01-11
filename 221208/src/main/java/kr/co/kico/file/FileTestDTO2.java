package kr.co.kico.file;

import org.springframework.web.multipart.MultipartFile;

public class FileTestDTO2 {
	
	private MultipartFile fileFromJsp1;
	
	public MultipartFile getFileFromJsp1() {
		return fileFromJsp1;
	}

	public void setFileFromJsp1(MultipartFile fileFromJsp1) {
		this.fileFromJsp1 = fileFromJsp1;
	}

	public String getTestInput() {
		return testInput;
	}

	public void setTestInput(String testInput) {
		this.testInput = testInput;
	}

	private String testInput;
	
}
