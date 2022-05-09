package testing;

import org.junit.Test;
import org.junit.Assert;

public class DiceTest {
	
	@Test
	public void testConstructor() {
		Integer expectedFaceValue = null;
		Integer expectedNumberOfFaces = null;
		
		// when
		Dice die = new Dice(expectedNumberOfFaces);
		Integer actualFaceValue = die.getCurrentFaceValue();
		Integer actualNumberOfFaces = die.getNumberOfFaces();
		
		// then
		Assert.assertEquals(expectedFaceValue,actualFaceValue);
		Assert.assertEquals(expectedNumberOfFaces, actualNumberOfFaces);
	}
	

}
