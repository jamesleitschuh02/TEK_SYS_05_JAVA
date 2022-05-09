package com.example.TDD_DemoTest;

import testing.Game;
import testing.Player;

public class TddDemoTestApplication {

	public static void main(String[] args) {
		
		// player to set the name
		Player p1 = new Player();
		p1.setPlayerName("James");
		
		// game to add name to the list
		Game g1 = new Game();
		g1.add(p1);
		
		System.out.println(g1.getPlayerList());
		g1.getWinner();
	}

}
