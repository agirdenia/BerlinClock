package com.ubs.interview.BerlinClock;

import static com.ubs.interview.BerlinClock.ValidateUtil.validateRange;


public  class Time {

	private int hour;
	private int minutes;
	private int seconds;

	
	public Time(){
		
	}

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

	public String toString()
	{
		return hour + ":" + minutes +  ":" + seconds;
		
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hour != other.hour)
			return false;
		if (minutes != other.minutes)
			return false;
		if (seconds != other.seconds)
			return false;
		return true;
	}
}