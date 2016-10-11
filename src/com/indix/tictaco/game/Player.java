package com.indix.tictaco.game;

import java.util.List;

/**
 * 
 * @author akshay
 *
 */
public interface Player {
	
	public void play(Block block);
	
	public void notifyForMove(List<Block> avilableBlocks);


}
