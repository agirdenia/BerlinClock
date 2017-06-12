package com.ubs.interview.BerlinClock;

import org.junit.Assert;
import org.junit.Test;


public class ValidateUtilTest {
	
	 @Test
	 public void testValidateLampColor()
	{
		 Assert.assertTrue(ValidateUtil.ValidateLampColor("RROO", 'R', 'O'));
		 Assert.assertFalse(ValidateUtil.ValidateLampColor("RROY", 'R', 'O'));
		 Assert.assertTrue(ValidateUtil.ValidateLampColor("RROYRRRO", 'R', 'O','Y'));
		 
	}

}
