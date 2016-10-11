package com.indix.tictaco.game;

import java.util.List;

/**
 * 
 * @author akshay
 *
 */
public class TicTakPlayer implements Player {

	// Data structure to for where he placed.
	
	TicTacBorad board;
	
	public TicTakPlayer(int i) {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void play(Block block) {
		board.placeCoin(block.getI(),block.getJ());

	}
	
	
	public void notifyForMove(List<Block> avilableBlocks){
		Block bestMove = getBestPossibleMove(avilableBlocks);
		play(bestMove);
	}


	private Block getBestPossibleMove(List<Block> blocks) {
		// TODO Auto-generated method stub
		return null;
	}

}
