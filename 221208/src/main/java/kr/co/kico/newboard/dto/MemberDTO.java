package kr.co.kico.newboard.dto;

public class MemberDTO {
	
	private int member_id;
	
	private  String member_login_id;
	
	private String member_pwd;
	
	private int member_group_id;
	
	private int member_grade_id;
	
	private int member_deleted;

	public int getMember_id() {
		return member_id;
	}

	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}

	public String getMember_login_id() {
		return member_login_id;
	}

	public void setMember_login_id(String member_login_id) {
		this.member_login_id = member_login_id;
	}

	public String getMember_pwd() {
		return member_pwd;
	}

	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}

	public int getMember_group_id() {
		return member_group_id;
	}

	public void setMember_group_id(int member_group_id) {
		this.member_group_id = member_group_id;
	}

	public int getMember_grade_id() {
		return member_grade_id;
	}

	public void setMember_grade_id(int member_grade_id) {
		this.member_grade_id = member_grade_id;
	}

	public int getMember_deleted() {
		return member_deleted;
	}

	public void setMember_deleted(int member_deleted) {
		this.member_deleted = member_deleted;
	}

	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", member_login_id=" + member_login_id + ", member_pwd="
				+ member_pwd + ", member_group_id=" + member_group_id + ", member_grade_id=" + member_grade_id
				+ ", member_deleted=" + member_deleted + "]";
	}
	
	
	
}
