package com.ubs.interview.BerlinClock;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class StandardToBerLinTimeConvertorTest {

	StandardToBerLinTimeConvertor berlinClock = new StandardToBerLinTimeConvertor();
	 
    // Yellow lamp should blink on/off every two seconds
    @Test
    public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
        Assert.assertEquals("Y", berlinClock.processSecondsRow(0));
        Assert.assertEquals("O", berlinClock.processSecondsRow(1));
        Assert.assertEquals("O", berlinClock.processSecondsRow(59));
    }
 
    // Top hours should have 4 lamps
    @Test
    public void testFirstHoursShouldHave4Lamps() {
        Assert.assertEquals(4, berlinClock.processFirstHousrRow(0).length());
        Assert.assertEquals(4, berlinClock.processFirstHousrRow(13).length());
        Assert.assertEquals(4, berlinClock.processFirstHousrRow(24).length());
    }
 
    // Top hours should light a red lamp for every 5 hours
    @Test
    public void testProcessFirstHousrRow() {
        Assert.assertEquals("OOOO", berlinClock.processFirstHousrRow(0));
        Assert.assertEquals("RROO", berlinClock.processFirstHousrRow(13));
        Assert.assertEquals("RRRO", berlinClock.processFirstHousrRow(17));
        Assert.assertEquals("RRRR", berlinClock.processFirstHousrRow(23));
        Assert.assertEquals("RRRR", berlinClock.processFirstHousrRow(24));
    }
 
    // Bottom hours should have 4 lamps
    @Test
    public void testSecondHoursShouldHave4Lamps() {
        Assert.assertEquals(4, berlinClock.processSecondHousrRow(0).length());
        Assert.assertEquals(4, berlinClock.processSecondHousrRow(13).length());
        Assert.assertEquals(4, berlinClock.processSecondHousrRow(21).length());
    }
 
    // Bottom hours should light a red lamp for every hour left from top hours
    @Test
    public void testProcessSecondHousrRow() {
        Assert.assertEquals("OOOO", berlinClock.processSecondHousrRow(0));
        Assert.assertEquals("RROO", berlinClock.processSecondHousrRow(12));
        Assert.assertEquals("RRRO", berlinClock.processSecondHousrRow(13));
        Assert.assertEquals("RRRO", berlinClock.processSecondHousrRow(23));
        Assert.assertEquals("RRRR", berlinClock.processSecondHousrRow(24));
    }
 
    // Top minutes should have 11 lamps
    @Test
    public void testFirstMinutesShouldHave11Lamps() {
        Assert.assertEquals(11, berlinClock.processFirstMinutesRow(0).length());
        Assert.assertEquals(11, berlinClock.processFirstMinutesRow(37).length());
        Assert.assertEquals(11, berlinClock.processFirstMinutesRow(57).length());
    }
 
    // Top minutes should have 3rd, 6th and 9th lamps in red to indicate first quarter, half and last quarter
    @Test
    public void testFirstMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
    	 String zeroQuaterminutes = berlinClock.processFirstMinutesRow(0);
    	String firstQuaterminutes = berlinClock.processFirstMinutesRow(18);
        String SecondQuaterminutes = berlinClock.processFirstMinutesRow(35);
        String ThirdQuaterminutes = berlinClock.processFirstMinutesRow(52);
        
        Assert.assertEquals("O", zeroQuaterminutes.substring(2, 3));
        Assert.assertEquals("O", zeroQuaterminutes.substring(5, 6));
        Assert.assertEquals("O", zeroQuaterminutes.substring(8, 9));
        
        Assert.assertEquals("R", firstQuaterminutes.substring(2, 3));
        Assert.assertEquals("O", firstQuaterminutes.substring(5, 6));
        Assert.assertEquals("O", firstQuaterminutes.substring(8, 9));
        
        Assert.assertEquals("R", SecondQuaterminutes.substring(2, 3));
        Assert.assertEquals("R", SecondQuaterminutes.substring(5, 6));
        Assert.assertEquals("O", SecondQuaterminutes.substring(8, 9));
        
        
        Assert.assertEquals("R", ThirdQuaterminutes.substring(2, 3));
        Assert.assertEquals("R", ThirdQuaterminutes.substring(5, 6));
        Assert.assertEquals("R", ThirdQuaterminutes.substring(8, 9));
    }
 
    // Top minutes should light a yellow lamp for every 5 minutes unless it's first quarter, half or last quarter
    @Test
    public void testFirstMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
        Assert.assertEquals("OOOOOOOOOOO", berlinClock.processFirstMinutesRow(0));
        Assert.assertEquals("YYROOOOOOOO", berlinClock.processFirstMinutesRow(17));
        Assert.assertEquals("YYRYYRYOOOO", berlinClock.processFirstMinutesRow(38));
        Assert.assertEquals("YYRYYRYYRYY", berlinClock.processFirstMinutesRow(59));
    }
 
    // Bottom minutes should have 4 lamps
    @Test
    public void testBottomMinutesShouldHave4Lamps() {
        Assert.assertEquals(4, berlinClock.processSecondMinutesRow(0).length());
    }
 
    // Bottom minutes should light a yellow lamp for every minute left from top minutes
    @Test
    public void testProcessSecondMinutesRow() {
        Assert.assertEquals("OOOO", berlinClock.processSecondMinutesRow(0));
        Assert.assertEquals("YYOO", berlinClock.processSecondMinutesRow(12));
        Assert.assertEquals("YYYO", berlinClock.processSecondMinutesRow(18));
        Assert.assertEquals("YYYY", berlinClock.processSecondMinutesRow(59));
    }
 
    
    
    // Berlin Clock should result in array with 5 elements
    @Test
    public void testBerlinClockShouldResultInArrayWith5Elements()  {
        Assert.assertEquals(5, berlinClock.convertStanderToBerlinTime( new Time(21,15,05)).length);
    }
 
    @Test
    public void testBerlinClockShouldResultInCorrectSecondsHoursAndMinutes() {
        String[] berlinTime = berlinClock.convertStanderToBerlinTime(new Time(12,52,22));
        String[] expected = new String[] {"Y", "RROO", "RROO", "YYRYYRYYRYO", "YYOO"};
        Assert.assertEquals(expected.length, berlinTime.length);
        for (int index = 0; index < expected.length; index++) {
            Assert.assertEquals(expected[index], berlinTime[index]);
        }
    }

}
