package kr.co.kico.dto;

public class MemberDTO {

	private String mid; 
	
	private String mpwd;
	
	private String mno;
	
	private String mname;

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMno() {
		return mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpwd=" + mpwd + ", mno=" + mno + ", mname=" + mname + "]";
	}
	
	
	
} // class
