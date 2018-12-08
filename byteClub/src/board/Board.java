package board;

public class Board {
	
	public static int BOARD_SIZE=15;
	
	private byte matrix[][];
	//-1 Opponent
	// 0 Empty
	// 1 Mine
	private byte myColor;
	private byte myCapture,opponentCapture;
	
	public Board() {}
	
	public Board(byte matrix[][]) {
		this.matrix=matrix;
	}
	
	public Board(byte myColor) {
		matrix=new byte[BOARD_SIZE][BOARD_SIZE];
		this.myColor=myColor;
		myCapture=0;opponentCapture=0;
	}
	
	public boolean validMove(Move move) {
		int r=move.getR();int c=move.getC();
		if(r<0 || r>BOARD_SIZE-1 || c<0 || c>BOARD_SIZE-1) {
			return false;
		}
		if(matrix[r][c]!=0) {
			return false;
		}
		return true;
	}
	//Forse inutilizzata
	//Second move of the first player
	public boolean secondValidMove(Move move) {
		if(validMove(move)) {
			int r=move.getR();int c=move.getC();
			return (r<5 || r>9) && (c<5 || c>9);
		}
		return false;
	}
	//Forse inutilizzata
	//opponent move
	public void update(Move move) {
		int r=move.getR();int c=move.getC();
		byte color=move.getColor();
		matrix[r][c]=color;
	}
	//OSSERVAZIONE: RICORDARSI DI ELIMINARE IL PRIMO GIRO DI OGNI CICLO (NON SERVE)!!!
	public void capture(Move move) {
		byte moveColor=move.getColor();
		byte opponentColor=(byte)(moveColor*-1);
		int r=move.getR();int c=move.getC();
		//EAST
		for(int j=0;j<4 && c+j<BOARD_SIZE;j++) {
			if(j==0) {
				if(matrix[r][c+j]!=moveColor) {
					break;
				}
			}
			else if(j==1 || j==2) {
				if(matrix[r][c+j]!=opponentColor) {
					break;
				}
			}
			else if(j==4) {
				if(matrix[r][c+j]==moveColor) {
					matrix[r][c+1]=0;
					matrix[r][c+2]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//WEST
		for(int j=0;j<4 && c-j>=0;j++) {
			if(j==0) {
				if(matrix[r][c-j]!=moveColor) {
					break;
				}
			}
			else if(j==1 || j==2) {
				if(matrix[r][c-j]!=opponentColor) {
					break;
				}
			}
			else if(j==4) {
				if(matrix[r][c-j]==moveColor) {
					matrix[r][c-1]=0;
					matrix[r][c-2]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//SOUTH
		for(int i=0;i<4 && r+i<BOARD_SIZE;i++) {
			if(i==0) {
				if(matrix[r+i][c]!=moveColor) {
					break;
				}
			}
			else if(i==1 || i==2) {
				if(matrix[r+i][c]!=opponentColor) {
					break;
				}
			}
			else if(i==4) {
				if(matrix[r+i][c]==moveColor) {
					matrix[r+1][c]=0;
					matrix[r+2][c]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//NORD
		for(int i=0;i<4 && r-i>=0;i++) {
			if(i==0) {
				if(matrix[r-i][c]!=moveColor) {
					break;
				}
			}
			else if(i==1 || i==2) {
				if(matrix[r-i][c]!=opponentColor) {
					break;
				}
			}
			else if(i==4) {
				if(matrix[r-i][c]==moveColor) {
					matrix[r-1][c]=0;
					matrix[r-2][c]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//SOUTH-EAST
		for(int ij=0;ij<4 && r+ij<BOARD_SIZE && c+ij<BOARD_SIZE;ij++) {
			if(ij==0) {
				if(matrix[r+ij][c+ij]!=moveColor) {
					break;
				}
			}
			else if(ij==1 || ij==2) {
				if(matrix[r+ij][c+ij]!=opponentColor) {
					break;
				}
			}
			else if(ij==4) {
				if(matrix[r+ij][c+ij]==moveColor) {
					matrix[r+1][c+1]=0;
					matrix[r+2][c+2]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//NORTH-WEST
		for(int ij=0;ij<4 && r-ij>=0 && c-ij>=0;ij++) {
			if(ij==0) {
				if(matrix[r-ij][c-ij]!=moveColor) {
					break;
				}
			}
			else if(ij==1 || ij==2) {
				if(matrix[r-ij][c-ij]!=opponentColor) {
					break;
				}
			}
			else if(ij==4) {
				if(matrix[r-ij][c-ij]==moveColor) {
					matrix[r-1][c-1]=0;
					matrix[r-2][c-2]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//SOUTH-WEST
		for(int ij=0;ij<4 && r+ij<BOARD_SIZE && c-ij>=0;ij++) {
			if(ij==0) {
				if(matrix[r+ij][c-ij]!=moveColor) {
					break;
				}
			}
			else if(ij==1 || ij==2) {
				if(matrix[r+ij][c-ij]!=opponentColor) {
					break;
				}
			}
			else if(ij==4) {
				if(matrix[r+ij][c-ij]==moveColor) {
					matrix[r+1][c-1]=0;
					matrix[r+2][c-2]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
		//NORTH-EAST
		for(int ij=0;ij<4 && r-ij>=0 && c+ij<BOARD_SIZE;ij++) {
			if(ij==0) {
				if(matrix[r-ij][c+ij]!=moveColor) {
					break;
				}
			}
			else if(ij==1 || ij==2) {
				if(matrix[r-ij][c+ij]!=opponentColor) {
					break;
				}
			}
			else if(ij==4) {
				if(matrix[r-ij][c+ij]==moveColor) {
					matrix[r-1][c+1]=0;
					matrix[r-2][c+2]=0;
					if(moveColor==myColor) {
						myCapture+=1;
					}
					else {
						opponentCapture+=1;
					}
				}
				break;
			}
		}
	}
	
	public byte getMyColor() {
		return myColor;
	}
	
	public void setMyColor(byte color) {
		myColor=color;
	}
	
	public byte getMyCapture() {
		return myCapture;
	}
	
	public void setMyCapture(byte capture) {
		myCapture=capture;
	}
	
	public byte getOpponentCapture() {
		return opponentCapture;
	}
	
	public void setOpponentCapture(byte capture) {
		opponentCapture=capture;
	}
	
	public Board cloneBoard(Board board) {
		byte matrix[][]=new byte[BOARD_SIZE][BOARD_SIZE];
		for(int i=0;i<BOARD_SIZE;i++) {
			for(int j=0;j<BOARD_SIZE;j++) {
				matrix[i][j]=this.matrix[i][j];
			}
		}
		Board clone=new Board(matrix);
		clone.setMyColor(myColor);
		clone.setMyCapture(myCapture);
		clone.setOpponentCapture(opponentCapture);
		return clone;
	}

}
