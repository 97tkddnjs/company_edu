package kr.co.kico.newboard.dto;

public class MenuBoardDTO {
	
	private String menu_type_name;
	
	private int cnt;

	public String getMenu_type_name() {
		return menu_type_name;
	}

	public void setMenu_type_name(String menu_type_name) {
		this.menu_type_name = menu_type_name;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	@Override
	public String toString() {
		return "MenuBoardDTO [menu_type_name=" + menu_type_name + ", cnt=" + cnt + "]";
	}
	
	
	
}
