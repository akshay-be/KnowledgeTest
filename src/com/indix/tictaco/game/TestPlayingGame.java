package com.indix.tictaco.game;

public class TestPlayingGame {

	public static void main(String[] args) {

		TicTakPlayer p1 = new TicTakPlayer(0);
		TicTakPlayer p2 = new TicTakPlayer(1);

		TicTacBorad tb = Board3x3.getInstance();
		tb.setPlayers(p1, p2);

		tb.startPlaying();

		String name = tb.playerWOnName();

		System.out.println("Player won : "+name);
	}

}
