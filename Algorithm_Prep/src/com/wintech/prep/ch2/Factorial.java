package com.wintech.prep.ch2;

/**
 * Created by Prabu on 3/4/2016.
 */
public class Factorial {
    public static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("5! = " + factorial(5));
        System.out.println("0! = " + factorial(0));
        System.out.println("25! = " + factorial(25));
    }
}
