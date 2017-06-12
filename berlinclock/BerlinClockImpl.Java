package com.ubs.interview.BerlinClock;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.text.StrBuilder;

public class BerlinClockImpl  implements Clock {
	
	private String second;
	private String hour1;
	private String hour2;
	private String minutes1;
	private String minutes2;
	private  final int LampInFirstHourRow = 4;
	private  final int LampInSecondHourRow = 4;
	private  final int LampInFirstMinRow =11;
	private  final int LampInSecondMinRow = 4;
	private  final int hourPerLampInFirstRow = 5;
	private  final int minPerLampInFirstRow =5;

	
   
public static void main(String args[])
{
	System.out.print(new BerlinClockImpl().convertToBerlinTime(new Time(21,15,05)));
}
	
	
public BerlinClockImpl() {
		
		// TODO Auto-generated constructor stub
	}


public String[] convertToBerlinTime(Time time) {
	
    return new String[] {
    		processSecondsRow(time.getSeconds()),
    		processFirstHousrRow(time.getHour()),
    		processSecondHousrRow(time.getHour()),
    		processFirstMinutesRow(time.getMinutes()),
    		processSecondMinutesRow(time.getMinutes())
    };
}

	@Override
	public String toString(){
    	return new StrBuilder()
    		.appendWithSeparators(
    			new String[]{ second, hour1, hour2, minutes1, minutes2 }, 
    			System.lineSeparator()
    		).toString();
	}

    public String processSecondsRow(int seconds){
    	if(seconds%2==0) 
    		return "Y"; 
    	else return "O";
    }

    public String processFirstHousrRow(int hour){
    	int numberOfRedLampinTopHourRow = hour / hourPerLampInFirstRow;
    	return printLampRow("R", numberOfRedLampinTopHourRow, LampInFirstHourRow);
    }

    public String processSecondHousrRow(int hour){
    	int numberOfRedLampinSecondHourRow = hour % 5;
    	return printLampRow("R", numberOfRedLampinSecondHourRow, LampInSecondHourRow);
    }

    public String processFirstMinutesRow(int minutes){
    	char[] row = printLampRow("Y", minutes / minPerLampInFirstRow, LampInFirstMinRow).toCharArray();
    	changeToRedIfYellow(row, 2);
    	changeToRedIfYellow(row, 5);
    	changeToRedIfYellow(row, 8);
    	return new String(row);
    }

    public String processSecondMinutesRow(int minutes){
    	int numberOfRedLamp = minutes % minPerLampInFirstRow;
    	return printLampRow("Y", numberOfRedLamp, LampInSecondMinRow);
    }

    private String printLampRow(String light, int times, int length){
    	return StringUtils.repeat(light, times) + StringUtils.repeat("O", length - times);
    }

    private void changeToRedIfYellow(char[] row, int index){
    	if(row[index]=='Y') row[index] = 'R';
    }

	@Override
	public com.ubs.interview.BerlinClock.Time getTime() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTime(com.ubs.interview.BerlinClock.Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String showFromattedTime() {
		// TODO Auto-generated method stub
		return null;
	}

    
  public int convertFirstHourLampRow(String firstHourLampRow)
	{
		int firstHourLampRowCount = 0;
		for(char lampStatus:firstHourLampRow.toCharArray())
		{
			if(lampStatus == 'R')
				firstHourLampRowCount = firstHourLampRowCount +5;		
		}
		
   return firstHourLampRowCount;
	}
	
	public int convertSecondHourLampRow(String secondHourLampRow)
	{
		int secondHourLampRowCount = 0;
		for(char lampStatus:secondHourLampRow.toCharArray())
		{
			if(lampStatus == 'R')
				secondHourLampRowCount = secondHourLampRowCount +1;		
		}
		
   return secondHourLampRowCount;
	}
	
	public int convertSecondMinuteLampRow(String secondHourLampRow)
	{
		int secondMinuteLampRowCount = 0;
		for(char lampStatus:secondHourLampRow.toCharArray())
		{
			if(lampStatus == 'R')
				secondMinuteLampRowCount = secondMinuteLampRowCount +1;		
		}
		
   return secondMinuteLampRowCount;
	}
	
	
	public int convertFirstMinuteLampRow(String firstMinuteLampRow)
	{
		int firstMinuteLampRowCount = 0;
		for(char lampStatus:firstMinuteLampRow.toCharArray())
		{
			if(lampStatus == 'R')
				firstMinuteLampRowCount = firstMinuteLampRowCount +5;		
		}
		return firstMinuteLampRowCount;
	}
	

	public int convertSecondLampRow(String firstMinuteLampRow)
	{
		int firstMinuteLampRowCount = 0;
		for(char lampStatus:firstMinuteLampRow.toCharArray())
		{
			if(lampStatus == 'R')
				firstMinuteLampRowCount = firstMinuteLampRowCount +5;		
		}
		return firstMinuteLampRowCount;
	}
}
