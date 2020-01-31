/**
 * 
 */
package com.study.ch2;

/**
 * @author Prabu
 *
 */
public class CurrentTime {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long totalMilliSeconds = System.currentTimeMillis();
		
		long totalSeconds = totalMilliSeconds / 1000;
		long currentSecond = totalSeconds % 60;
		long totalMinutes = totalSeconds / 60;
		long currentMinute = totalMinutes % 60;
		long totalHours = totalMinutes / 60;
		long currentHour = totalHours % 24;
		
		System.out.printf("Current time %02d:%02d:%02d GMT", currentHour, currentMinute, currentSecond);

	}

}
