/**
 * @author Prabu
 * @date Jun 4, 2011
 *
 * Consider the problem of adding two n-bit binary integers, stored in two n-element
arrays A and B. The sum of the two integers should be stored in binary form in
an (n + 1)-element array C. State the problem formally and write pseudocode for
adding the two integers.
 */
package com.codestrokes.algorithm.ch02;

import java.util.Arrays;

public class AddNBitNumbers {
    public static void main(String[] args) {
        int[] a = {1, 0, 1, 1, 1};
        int[] b = {0, 1, 1, 1, 0};
        int[] c = new int[a.length + 1];

        int carry = 0, temp, i;
        for(i = a.length - 1; i >= 0; i--) {
            temp = a[i] + b[i] + carry;
            c[i + 1] = temp % 2;
            carry = temp / 2;
        }
        c[i + 1] = carry;
        
        System.out.println("a: " + Arrays.toString(a));
        System.out.println("b: " + Arrays.toString(b));
        System.out.println("c: " + Arrays.toString(c));
    }
}
