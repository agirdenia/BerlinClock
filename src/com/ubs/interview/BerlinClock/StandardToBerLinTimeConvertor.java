package com.ubs.interview.BerlinClock;

import org.apache.commons.lang3.StringUtils;

public class StandardToBerLinTimeConvertor {
	
	

public String[] convertStanderToBerlinTime(Time time) {
	
    return new String[] {
    		processSecondsRow(time.getSeconds()),
    		processFirstHousrRow(time.getHour()),
    		processSecondHousrRow(time.getHour()),
    		processFirstMinutesRow(time.getMinutes()),
    		processSecondMinutesRow(time.getMinutes())
    };
}




    public String processSecondsRow(int seconds){
    	if(seconds%2==0) 
    		return "Y"; 
    	else return "O";
    }

    public String processFirstHousrRow(int hour){
    	int numberOfRedLampinTopHourRow = hour / Contant.hourPerLampInFirstRow;
    	return printLampRow("R", numberOfRedLampinTopHourRow, Contant.LampInFirstHourRow);
    }

    public String processSecondHousrRow(int hour){
    	int numberOfRedLampinSecondHourRow = hour % 5;
    	return printLampRow("R", numberOfRedLampinSecondHourRow, Contant.LampInSecondHourRow);
    }

    public String processFirstMinutesRow(int minutes){
    	char[] row = printLampRow("Y", minutes / Contant.minPerLampInFirstRow, Contant.LampInFirstMinRow).toCharArray();
    	changeToRedIfYellow(row, 2);
    	changeToRedIfYellow(row, 5);
    	changeToRedIfYellow(row, 8);
    	return new String(row);
    }

    public String processSecondMinutesRow(int minutes){
    	int numberOfRedLamp = minutes % Contant.minPerLampInFirstRow;
    	return printLampRow("Y", numberOfRedLamp, Contant.LampInSecondMinRow);
    }

    private String printLampRow(String light, int times, int length){
    	return StringUtils.repeat(light, times) + StringUtils.repeat("O", length - times);
    }

    private void changeToRedIfYellow(char[] row, int index){
    	if(row[index]=='Y') row[index] = 'R';
    }

	
    
  
}
