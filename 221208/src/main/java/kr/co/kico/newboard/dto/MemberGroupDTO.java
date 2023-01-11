package kr.co.kico.newboard.dto;

public class MemberGroupDTO {
	private int member_group_id;
	
	private String member_group_name;
	
	private int member_group_deleted;

	public int getMember_group_id() {
		return member_group_id;
	}

	public void setMember_group_id(int member_group_id) {
		this.member_group_id = member_group_id;
	}

	public String getMember_group_name() {
		return member_group_name;
	}

	public void setMember_group_name(String member_group_name) {
		this.member_group_name = member_group_name;
	}

	public int getMember_group_deleted() {
		return member_group_deleted;
	}

	public void setMember_group_deleted(int member_group_deleted) {
		this.member_group_deleted = member_group_deleted;
	}

	@Override
	public String toString() {
		return "MemberGroupDTO [member_group_id=" + member_group_id + ", member_group_name=" + member_group_name
				+ ", member_group_deleted=" + member_group_deleted + "]";
	}
	
	
}
