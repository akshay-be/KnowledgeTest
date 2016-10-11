package com.indix.tictaco.game;


/**
 * 
 * @author akshay
 *
 */
public interface TicTacBorad {

	public void setPlayers(Player p1, Player p2);
	
	boolean placeCoin(int i , int j);
	
	public void  startPlaying();
	
	public String playerWOnName();
	
}
