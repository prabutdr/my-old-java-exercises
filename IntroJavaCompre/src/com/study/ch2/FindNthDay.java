/**
 * 
 */
package com.study.ch2;

/**
 * @author Prabu
 *
 */
public class FindNthDay {

	enum WeekDay {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WeekDay today = WeekDay.TUESDAY;
		int n = 100;
		
		n += today.ordinal();
		n = n % 7;
		System.out.println("Target day - " + WeekDay.values()[n]);

		System.out.println("Number with undrescores - " + 234_85_7896);
	}

}
