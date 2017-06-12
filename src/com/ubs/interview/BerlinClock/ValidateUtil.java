package com.ubs.interview.BerlinClock;

import org.apache.commons.lang3.Validate;

public class ValidateUtil {

	private ValidateUtil(){}

	public static void validateRange(int maxRange, int minRange, int arg, String argName){
		
		Validate.isTrue(arg < maxRange, "Argument `" + argName + "` should be lower than " + maxRange);
		Validate.isTrue(arg >= minRange, "Argument `" + argName + "` should be greater than equal to " + minRange);
	}
	
	

	public static void validateLampRowLength(int maxLength, int actLength, String row){
		Validate.isTrue(maxLength+1 > actLength, "LampRow `" + row + " " + actLength + "` Length should not  be greater than " + maxLength);
	}

	public static boolean ValidateLampColor(String row, char firstcolor , char secondColor, char thirdColor)
	{
		boolean result = Boolean.TRUE;
		
		if(row != null && row.trim().length()> 0)
		{
			for (char c : row.toCharArray())
			{
				if (c != firstcolor && c != secondColor && c != thirdColor)
					result = Boolean.FALSE;
			}
		}
		
		return result ;
	}

	public static boolean ValidateLampColor(String row, char firstcolor , char secondColor)
	{
		boolean result = Boolean.TRUE;
		
		if(row != null && row.trim().length()> 0)
		{
			for (char c : row.toCharArray())
			{
				if (c != firstcolor && c != secondColor )
				{
					result = Boolean.FALSE;
				break;
				}
			}
		}
		
		return result ;
	}

	
	

}