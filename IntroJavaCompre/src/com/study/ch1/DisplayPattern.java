/**
 * 
 */
package com.study.ch1;

/**
 * @author Prabu
 *
 */
public class DisplayPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 5;
		char ch = '*';

		// Pattern 1
		for (int i = 1; i <= n; i++) {
			// To provide enough spaces prior to print each line
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			
			boolean isEvenLine = ((i % 2) == 0);
			int charCountForLine = (2 * (i - 1) + 1);
			
			// To print actual chars for each line
			for (int j = 1; j <= charCountForLine; j++) {
				if (isEvenLine) {
					// For even lines, print only first & last characters,
					// remaining would be spaces
					if (j == 1 || j == charCountForLine) {
						System.out.print(ch);
					} else {
						System.out.print(" ");
					}
				} else {
					// For odd lines, print all chars
					System.out.print(ch);
				}
			}
			System.out.println();
		}
	}

}
