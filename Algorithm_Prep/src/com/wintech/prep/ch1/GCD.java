package com.wintech.prep.ch1;

/**
 * Created by Prabu on 2/28/2016.
 */
public class GCD {
    public static long gcd(long m, long n) {
        long remainder;
        while (n != 0) {
            remainder = m % n;
            m = n;
            n = remainder;
        }

        return m;
    }

    public static long pow(long x, int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return x;

        if ((n % 2) == 0)
            return pow(x * x, n / 2);
        else
            return pow(x * x, n / 2) * x;
    }

    public static void main(String[] args) {
        System.out.println(gcd(0, 0));
        System.out.println(gcd(1, 0));
        System.out.println(gcd(1, 1));
        System.out.println(gcd(1, 2));
        System.out.println(gcd(2, 16));
        System.out.println(gcd(1989, 1590));

        System.out.println("Exponential - " + pow(1000, 4));
    }
}
