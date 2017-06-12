package com.ubs.interview.BerlinClock;

public class BerlinToStandardTimeConvertor {
	
	public Time convertBerlineTimeToTime(String[] berlinTime) {
		int second = this.convertSecondLampRow(berlinTime[0]);
		int firstHour = this.convertFirstHourLampRow(berlinTime[1]);
		int secondHour = this.convertSecondHourLampRow(berlinTime[2]);
		int firstHourMinute = this.convertFirstMinuteLampRow(berlinTime[3]);
		int secondHourMinute = this.convertSecondMinuteLampRow(berlinTime[4]);
	    return new Time(firstHour+secondHour,firstHourMinute+secondHourMinute,second);
	}

	
	public int convertFirstHourLampRow(String firstHourLampRow)
	{
	  int firstHourLampRowCount = 0;
	  ValidateUtil.validateLampRowLength(Contant.LampInFirstHourRow, firstHourLampRow.length(), "firstHourLampRow");
	  if(ValidateUtil.ValidateLampColor(firstHourLampRow, 'R','O'))
	  {
		for(char lampStatus:firstHourLampRow.toCharArray())
		{
			if(lampStatus == 'R')
				firstHourLampRowCount = firstHourLampRowCount +5;		
		}
	  }
	  
   return firstHourLampRowCount;
	}
	
	public int convertSecondHourLampRow(String secondHourLampRow)
	{
		int secondHourLampRowCount = 0;
		ValidateUtil.validateLampRowLength(Contant.LampInFirstHourRow, secondHourLampRow.length(), "secondHourLampRow");
		if(ValidateUtil.ValidateLampColor(secondHourLampRow, 'R','O'))
		{
		for(char lampStatus:secondHourLampRow.toCharArray())
		{
			if(lampStatus == 'R' )
				secondHourLampRowCount = secondHourLampRowCount +1;		
		}
		}
		
		
   return secondHourLampRowCount;
	}
	
	public int convertFirstMinuteLampRow(String firstMinuteLampRow)
	{
		int firstMinuteLampRowCount = 0;
		ValidateUtil.validateLampRowLength(Contant.LampInFirstMinRow, firstMinuteLampRow.length(), "firstMinuteLampRow");
		
		if(ValidateUtil.ValidateLampColor(firstMinuteLampRow, 'R','O','Y'))
		{
		for(char lampStatus:firstMinuteLampRow.toCharArray())
		{
			if(lampStatus == 'R' || lampStatus == 'Y' )
				firstMinuteLampRowCount = firstMinuteLampRowCount +5;		
		}
		}
	
		return firstMinuteLampRowCount;
	}
	
	public int convertSecondMinuteLampRow(String secondMinuteLampRow)
	{
		int secondMinuteLampRowCount = 0;
		ValidateUtil.validateLampRowLength(Contant.LampInSecondMinRow, secondMinuteLampRow.length(), "secondHourLampRow");
		if(ValidateUtil.ValidateLampColor(secondMinuteLampRow,'O','Y'))
		{
		for(char lampStatus:secondMinuteLampRow.toCharArray())
		{
			if(lampStatus == 'Y')
				secondMinuteLampRowCount = secondMinuteLampRowCount +1;		
		}
		}
		
   return secondMinuteLampRowCount;
	}
	
	
	public int convertSecondLampRow(String secondsLampRow)
	{
		ValidateUtil.validateLampRowLength(Contant.LampInSecondRow, secondsLampRow.length(), "secondHourLampRow");
		if(ValidateUtil.ValidateLampColor(secondsLampRow,'O','Y'))
		{
		if ( (secondsLampRow.charAt(0)) == 'Y')
			return 2;
		else
			return 1;
		}
		
		
  return 0;
		
	}

}
