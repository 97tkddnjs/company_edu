package kr.co.kico.newboard.dto;

public class MenuTypeDTO {
	
	private int menu_type_id;
	
	private String menu_type_name ;
	
	private int menu_type_deleted ;

	public int getMenu_type_id() {
		return menu_type_id;
	}

	public void setMenu_type_id(int menu_type_id) {
		this.menu_type_id = menu_type_id;
	}

	public String getMenu_type_name() {
		return menu_type_name;
	}

	public void setMenu_type_name(String menu_type_name) {
		this.menu_type_name = menu_type_name;
	}

	public int getMenu_type_deleted() {
		return menu_type_deleted;
	}

	public void setMenu_type_deleted(int menu_type_deleted) {
		this.menu_type_deleted = menu_type_deleted;
	}

	@Override
	public String toString() {
		return "MenuTypeDTO [menu_type_id=" + menu_type_id + ", menu_type_name=" + menu_type_name
				+ ", menu_type_deleted=" + menu_type_deleted + "]";
	}

	
}
