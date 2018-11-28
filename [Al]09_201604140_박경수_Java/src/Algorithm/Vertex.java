package Algorithm;

public class Vertex {
	final int WHITE = 0;
	final int GRAY = 1;
	final int BLACK = 2;
	int Color;
	int d;
	Vertex p;
	
	public int getColor() {
		return Color;
	}
	public void setColor(int color) {
		Color = color;
	}
	public int getD() {
		return d;
	}
	public void setD(int d) {
		this.d = d;
	}
	public Vertex getP() {
		return p;
	}
	public void setP(Vertex p) {
		this.p = p;
	}
}
