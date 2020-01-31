/**
 * 
 */
package com.study.ch1;

/**
 * @author Prabu
 *
 */
public class PrintTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		
		System.out.println("      a    a^2    a^3");
		for (int i = 1; i <= n; i++) {
			System.out.printf("  %5d  %5d  %5d%n", i, (i * i), (i * i * i));
		}
	}

}
