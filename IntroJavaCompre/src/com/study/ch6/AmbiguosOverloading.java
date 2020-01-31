/**
 * 
 */
package com.study.ch6;

/**
 * @author Prabu
 *
 */
public class AmbiguosOverloading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(max(1F, 3));
		
		char[] riyaa = {'R', 'i', 'y', 'a', 'a'};
		System.out.println(riyaa);
		System.out.println((new AmbiguosOverloading[]{}).getClass().getName());
		System.out.println((new long[]{}).getClass().getName());
	}

	public static double max(int a, double b) {
		if (a > b)
			return a;
		else
			return b;
	}

	public static double max(double a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}
}
