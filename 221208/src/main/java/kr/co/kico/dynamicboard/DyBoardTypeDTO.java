package kr.co.kico.dynamicboard;
//kr.co.kico.dynamicboard.DyBoardTypeDTO
public class DyBoardTypeDTO {
	
	private int board_type_num;
	
	private String board_type_name;

	public int getBoard_type_num() {
		return board_type_num;
	}

	public void setBoard_type_num(int board_type_num) {
		this.board_type_num = board_type_num;
	}

	public String getBoard_type_name() {
		return board_type_name;
	}

	public void setBoard_type_name(String board_type_name) {
		this.board_type_name = board_type_name;
	}

	@Override
	public String toString() {
		return "BoardTypeDTO [board_type_num=" + board_type_num + ", board_type_name=" + board_type_name + "]";
	}
	
	
	
}
