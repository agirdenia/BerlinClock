package com.ubs.interview.BerlinClock;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class BerlinToStandardTimeConvertorTest {

	
	BerlinToStandardTimeConvertor berlinClock = new BerlinToStandardTimeConvertor();
	
	  @Test
	    public void testConvertFirstHourLampRow()
	    {
	    	Assert.assertEquals(0, berlinClock.convertFirstHourLampRow("OOOO"));
	    	Assert.assertEquals(10, berlinClock.convertFirstHourLampRow("RROO"));
	    	Assert.assertEquals(15, berlinClock.convertFirstHourLampRow("RRRO"));
	    	Assert.assertEquals(20, berlinClock.convertFirstHourLampRow("RRRR"));
	    	
	   
	    }
	    
	    @Test
	    public void testConvertSecondtHourLampRow()
	    {
	    	Assert.assertEquals(0, berlinClock.convertSecondHourLampRow("OOOO"));
	    	Assert.assertEquals(2, berlinClock.convertSecondHourLampRow("RROO"));
	    	Assert.assertEquals(3, berlinClock.convertSecondHourLampRow("RRRO"));
	    	Assert.assertEquals(4, berlinClock.convertSecondHourLampRow("RRRR"));
	    	
	   
	    }
	    
	    @Test
	    public void testConvertFirstMinuteLampRow()
	    {
	    	Assert.assertEquals(0, berlinClock.convertFirstMinuteLampRow("OOOOOOOOOOO"));
	    	Assert.assertEquals(15, berlinClock.convertFirstMinuteLampRow("YYROOOOOOOO"));
	    	Assert.assertEquals(35, berlinClock.convertFirstMinuteLampRow("YYRYYRYOOOO"));
	    	Assert.assertEquals(55, berlinClock.convertFirstMinuteLampRow("YYRYYRYYRYY"));
	    	
	   
	    }
	    
	    @Test
	    public void testConvertSecondMinuteLampRow()
	    {
	    	Assert.assertEquals(0, berlinClock.convertSecondMinuteLampRow("OOOO"));
	    	Assert.assertEquals(1, berlinClock.convertSecondMinuteLampRow("YOOO"));
	    	Assert.assertEquals(2, berlinClock.convertSecondMinuteLampRow("YYOO"));
	    	Assert.assertEquals(3, berlinClock.convertSecondMinuteLampRow("YYYO"));
	    	Assert.assertEquals(4, berlinClock.convertSecondMinuteLampRow("YYYY"));
	    	
	   
	    }
	    
	    @Test
	    public void testConvertSecondLampRow()
	    {
	    	Assert.assertEquals(1, berlinClock.convertSecondLampRow("O"));
	    	Assert.assertEquals(2, berlinClock.convertSecondLampRow("Y"));
	    	
	    	
	   
	    }
	    
	    
	    
	    @Test
	    public void testconvertBerlineTimeToTime() {
	    	String[] berlinTime = new String[] {"Y", "RROO", "RROO", "YYRYYRYYRYO", "YYOO"};
	        Time ExceptedTime = new Time(12,52,2);
	        Assert.assertEquals(ExceptedTime.getSeconds(),berlinClock.convertSecondLampRow(berlinTime[0]));
	        Assert.assertEquals(ExceptedTime.getHour(),berlinClock.convertFirstHourLampRow(berlinTime[1]) + berlinClock.convertSecondHourLampRow(berlinTime[2]));
	        Assert.assertEquals(ExceptedTime.getMinutes(),berlinClock.convertFirstMinuteLampRow(berlinTime[3]) + berlinClock.convertSecondMinuteLampRow(berlinTime[4]));
	    }
	    

}
