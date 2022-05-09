package testing;

import java.util.ArrayList;

public class Game {
	
	private String player;
	ArrayList<Player> playerList = new ArrayList<>();
	
	public Game(String player, ArrayList<Player> playerList) {
		this.player = player;
		this.playerList = playerList;
	}
	
	public Game() {

	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public ArrayList<Player> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList = playerList;
	}
	
	public boolean add(Player player) {
		playerList.add(player);
		return true;
	}
	
	public void getWinner() {
		System.out.println("Winner");
	}

	@Override
	public String toString() {
		return "Game [player=" + player + ", playerList=" + playerList + "]";
	}
	
	
	
	
	

}
