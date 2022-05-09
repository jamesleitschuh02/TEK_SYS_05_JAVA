package testing;

import org.junit.Test;
import org.junit.Assert;

public class RollTest {
	// template-method definition
	private void test(Integer numberOfFaces) {
		// given
		Integer unexpected = null;
		Dice die = new Dice(numberOfFaces);
		
		// when
		die.roll();
		Integer actual = die.getCurrentFaceValue();
		
		// then
		Assert.assertNotEquals(unexpected, actual);
	}
	
	@Test
	public void test0() { test(2); }
	
	@Test
	public void test1() { test(3); }
	
	@Test(expected = NullPointerException.class)
	public void test2() { test(null); }

}
