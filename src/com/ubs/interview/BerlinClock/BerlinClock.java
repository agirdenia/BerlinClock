package com.ubs.interview.BerlinClock;

public class BerlinClock implements Clock {

	
	Time time = new Time();
	
	@Override
	public Time getTime() {
	
		return this.time;
	}

	@Override
	public void setTime(Time time) {
		this.time = time;
	}

	
	public String[] showFromattedTime() {
		return new StandardToBerLinTimeConvertor().convertStanderToBerlinTime(time);
	}

}
