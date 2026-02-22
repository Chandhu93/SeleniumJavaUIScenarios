package Concepts;

import org.testng.annotations.Test;

import junit.framework.Assert;

public class HardAssertion {
	
	@Test
	public void assertEquals() {
		String act = "TYU";
		String exp = "TYU";
		Assert.assertEquals(act, exp);
		
	}
	

}
