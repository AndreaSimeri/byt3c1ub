package gameTree;

import java.util.List;

import board.Board;
import board.Move;
//Forse pu� essere comodo implements Comparable<Node>
public class Node {
	
	private Board board;
	private Move move;
	private Node parent;
	private List<Board> childList;
	private int value;

}
