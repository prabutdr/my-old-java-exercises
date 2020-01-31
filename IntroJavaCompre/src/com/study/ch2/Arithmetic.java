/**
 * 
 */
package com.study.ch2;

/**
 * @author Prabu
 *
 */
public class Arithmetic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(Math.pow(2.5, 2));
		System.out.println(Math.pow(2.5, -2));
		System.out.println(Math.pow(-2.5, 2));
		System.out.println(Math.pow(-2.5, -2));
		
		System.out.println(78 % 4);
		System.out.println(78 % -4);
		System.out.println(-78 % 4);
		System.out.println(-78 % -4);
		
		double a = 2;
		a += a + 1;
		System.out.println("a = " + a);
		
		int i = 1;
		int newNum = 10 * (i++);
		System.out.println("newNum = " + newNum);
		
		newNum += 4.5;
		System.out.println("newNum = " + newNum);
		
		System.out.println(Math.rint(2.0));
		System.out.println(Math.rint(2.5));
		System.out.println(Math.rint(3.0));
		System.out.println(Math.rint(3.5));
		System.out.println(Math.rint(3.9));
		System.out.println(Math.rint(4.0));
	}

}
