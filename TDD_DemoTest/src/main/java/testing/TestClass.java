package testing;

import org.junit.jupiter.api.Test;
import org.junit.Assert;

//import junit.framework.Assert;

public class TestClass {
	
	@Test
	public void testGame() {
		Player p1 = new Player();
		String expectedName = "Leon";
		p1.setPlayerName(expectedName);
		
		String actualName = p1.getPlayerName();
		
		Assert.assertEquals(expectedName,actualName);
	}
	
	@Test
	public void testGameList() {
		Player p1 = new Player();
		p1.setPlayerName("Leon");
		
		Game g1 = new Game();
		g1.add(p1);
		
		String expectedName = "Leon";
		
		// when
		String actualNameString = p1.getPlayerName();
		
		// then test the expected name
		Assert.assertEquals(expectedName, actualNameString);
	}

}
