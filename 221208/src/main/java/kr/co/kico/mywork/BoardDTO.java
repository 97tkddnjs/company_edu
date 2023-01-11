package kr.co.kico.mywork;

public class BoardDTO {
	private int mno;
	private String mid;
	private String mpwd;
	private String mname;
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
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
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	@Override
	public String toString() {
		return "BoardDTO [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mname=" + mname + "]";
	}
	
	
	
}
