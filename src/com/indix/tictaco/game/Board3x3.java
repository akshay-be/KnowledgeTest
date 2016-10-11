package com.indix.tictaco.game;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author akshay
 *
 */
public class Board3x3 implements TicTacBorad {

	static Board3x3 myInstance = new Board3x3();

	public static Board3x3 getInstance() {
		return myInstance;
	}
	// int[][] board = new int[3][3];

	Block[][] board = new Block[3][3];

	Player p1;
	Player p2;

	String lastPlayed = ""; // possible values "" , p1, p2

	private Board3x3() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = new Block(i, j);
			}
		}
	}

	@Override
	public boolean placeCoin(int i, int j) {
		if (isValidMove()) {
			board[i][j] = new Block(i, j);
			board[i][j].setState(true);
			board[i][j].setName("");

			return true;
		}

		return false;
	}

	private boolean isValidMove() {
		// TODO Auto-generated method stub

		return true;

	}

	public void setPlayers(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}

	public void startPlaying() {
		// notify 1st player.
		p1.notifyForMove(getAvilableBlocks());
	}

	boolean isCompleted() {

		return true;
	}

	public void notifyOtherPlayerToPlay() {

		if (lastPlayed.equals("p1")) {
			p2.notifyForMove(getAvilableBlocks());
		} else {
			p1.notifyForMove(getAvilableBlocks());
		}
	}

	public List<Block> getAvilableBlocks() {
		List<Block> avilableBlock = new ArrayList<Block>();

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j].isState()) {
					avilableBlock.add(board[i][j]);
				}
			}
		}

		return avilableBlock;
	}

	public String playerWOnName() {
		return null;
	}
}
