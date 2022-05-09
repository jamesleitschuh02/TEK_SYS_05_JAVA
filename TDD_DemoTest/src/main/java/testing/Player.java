package testing;

public class Player {
	
	private String playerName;

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	public Player() {
		super();
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public String toString() {
		return "Player [playerName=" + playerName + "]";
	}

}
