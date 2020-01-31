/**
 * 
 */
package com.study.ch2;

import java.util.Scanner;

/**
 * @author Prabu
 *
 */
public class CalculateArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int j, k;
//		int i = j = k = 0;
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter radius to calculate area - ");
		if (scanner.hasNextDouble()) {
			double radius = scanner.nextDouble();
			
			double area = 3.14 * radius * radius;
			
			System.out.println("Area - " + area);
		} else {
			System.out.println("You are not entered valid radius, given input - " + scanner.nextLine());
		}
		
		scanner.close();
	}

}
