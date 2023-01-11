package kr.co.kico.newboard.dto;

public class BoardTypeDTO {

	private int board_id;
	
	private String board_name;
	
	private int menu_type_id;
	
	private int board_deleted;

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

	public int getMenu_type_id() {
		return menu_type_id;
	}

	public void setMenu_type_id(int menu_type_id) {
		this.menu_type_id = menu_type_id;
	}

	public int getBoard_deleted() {
		return board_deleted;
	}

	public void setBoard_deleted(int board_deleted) {
		this.board_deleted = board_deleted;
	}

	@Override
	public String toString() {
		return "BoardTypeDTO [board_id=" + board_id + ", board_name=" + board_name + ", menu_type_id=" + menu_type_id
				+ ", board_deleted=" + board_deleted + "]";
	}
	
	
	
}
