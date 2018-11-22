package Algorithm;

public class Struct {
	private final int LEFTUP = 0; // ↖
	private final int LEFT = 1; // ←
	private final int UP = 2; // ↑
	private int number; // 숫자
	private int arrow; // 화살표
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getArrow() {
		return arrow;
	}
	public void setArrow(int arrow) {
		this.arrow = arrow;
	}
}
