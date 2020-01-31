/**
 * 
 */
package com.study.ch7;

import java.util.Date;

/**
 * @author Prabu
 *
 */
public class VarArgsDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printAll(1, 2, 3, 4);
		printAll(new int[]{1, 2, 3});
		System.out.println("Date: " + new Date());
	}

	private static void printAll(int a, int... args) {
		System.out.println("Using var args.");
		for (int num: args) {
			System.out.println(num);
		}
	}

	private static void printAll(int[] args) {
		System.out.println("Using array input.");
		for (int num: args) {
			System.out.println(num);
		}
	}
}
