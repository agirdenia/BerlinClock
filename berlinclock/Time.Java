package com.ubs.interview.BerlinClock;

import static com.ubs.interview.BerlinClock.ValidateTimeUtil.validateRange;


public  class Time {

	private int hour;
	private int minutes;
	private int seconds;

	public Time(int hour, int minutes, int seconds){
		validateRange(24, 0,hour, "hour");
		validateRange(60, 0,minutes, "minutes");
		validateRange(60,0, seconds, "seconds"); 
		
		this.hour = hour;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	
}