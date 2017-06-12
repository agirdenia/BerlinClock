package com.ubs.interview.BerlinClock;

import org.apache.commons.lang3.Validate;

public class ValidateTimeUtil {

	private ValidateTimeUtil(){}

	public static void validateRange(int maxRange, int minRange, int arg, String argName){
		
		Validate.isTrue(arg < maxRange, "Argument `" + argName + "` should be lower than " + maxRange);
		Validate.isTrue(arg >= minRange, "Argument `" + argName + "` should be greater than equal to " + minRange);
	}


}