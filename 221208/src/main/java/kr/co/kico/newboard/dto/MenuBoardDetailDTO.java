package kr.co.kico.newboard.dto;

public class MenuBoardDetailDTO {
	
	String menu_type_name;
	
	String board_name;
	
	String board_id;

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getMenu_type_name() {
		return menu_type_name;
	}

	public void setMenu_type_name(String menu_type_name) {
		this.menu_type_name = menu_type_name;
	}

	public String getBoard_name() {
		return board_name;
	}

	public void setBoard_name(String board_name) {
		this.board_name = board_name;
	}

	@Override
	public String toString() {
		return "MenuBoardDetailDTO [menu_type_name=" + menu_type_name + ", board_name=" + board_name + ", board_id="
				+ board_id + "]";
	}

	
	
	
	
}
