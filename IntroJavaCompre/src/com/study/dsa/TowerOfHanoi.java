/**
 * 
 */
package com.study.dsa;

/**
 * @author Prabu
 *
 */
public class TowerOfHanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		towerOfHanoi(3, 'A', 'B', 'C');

	}

	public static void towerOfHanoi(int n, char fromPeg, char toPeg, char auxiliaryPeg) {
		if (n == 1) {
			System.out.println("Move disk 1 from " + fromPeg + " to " + toPeg);
			return;
		}
		
		towerOfHanoi(n - 1, fromPeg, auxiliaryPeg, toPeg);
		System.out.println("Move disk from " + fromPeg + " to " + toPeg);
		towerOfHanoi(n - 1, auxiliaryPeg, toPeg, fromPeg);
		
	}
}
