package board;

public class Move {

	private int r,c;//row,column
	private byte color;
	
	public Move() {	}
	
	public Move(int r,int c,byte color) {
		this.r=r;
		this.c=c;
		this.color=color;
	}
	
	public int getR() {
		return r;
	}
	
	public int getC() {
		return c;
	}
	
	public byte getColor() {
		return color;
	}
}
