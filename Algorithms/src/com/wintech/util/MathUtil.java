/**
 * @author Prabu @date Mar 2, 2012
 */
package com.wintech.util;

public class MathUtil {

    /**
     * Find Harmonic number
     *
     * Formulae: H(n) = 1 + 1/2 + 1/3 + .... + 1/n
     *
     * @param n
     * @return harmonic value for given integer
     */
    public static double harmonic(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += (1.0 / i);
        }
        return sum;
    }

    /**
     * Hypotenuse of triangle
     *
     * Formulae: c = square route of (a^2 + b^2)
     *
     * @param a & b - two double values
     * @return hypotenuse value
     */
    public static double hypotenuse(double a, double b) {
        return Math.sqrt(a * a + b * b);
    }

    /**
     * Find given number is prime or not
     *
     * @param a long value
     * @return true - if prime false - otherwise
     */
    public static boolean isPrime(long a) {
        if (a <= 2) {
            return false;
        }
        int limit = (int) Math.sqrt(a);
        for (int i = 2; i <= limit; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the correctly rounded positive square root of a value. Newton's
     * method
     *
     * Special cases: If the argument is NaN or less than zero, then the result
     * is NaN.
     *
     * @param c a value.
     * @return the positive square root of given value. If the argument is NaN
     * or less than zero, the result is NaN.
     */
    public static double sqrt(double c) {
        if (c < 0) {
            return Double.NaN;
        }
        double err = 1e-15;
        double t = c;
        while (java.lang.Math.abs(t - c / t) > err * t) {
            t = (c / t + t) / 2.0;
        }
        return t;
    }

    /**
     * Euclid’s algorithm
     *
     * Compute the greatest common divisor of two nonnegative integers p and q
     * as follows: If q is 0, the answer is p. If not, divide p by q and take
     * the remainder r. The answer is the greatest common divisor of q and r.
     *
     * @param p
     * @param q
     * @return Greatest common divisor of two nonnegative integers
     */
    public static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, (p % q));
    }

    /**
     * Test client for MathUtil
     * 
     * @param args 
     */
    public static void main(String[] args) {
        System.out.println("gcd(2, 4): " + gcd(2, 4));
        System.out.println("gcd(9, 5): " + gcd(9, 5));
        System.out.println("gcd(1111111, 1234567): " + gcd(1111111, 1234567));

        System.out.println("sqrt(2): " + MathUtil.sqrt(2));
        System.out.println("sqrt(-3): " + MathUtil.sqrt(-3));
        System.out.println("sqrt(16): " + MathUtil.sqrt(16));
        double d = MathUtil.sqrt(-1);
        System.out.println("d: " + d);
        System.out.println("d + 1: " + (d + 1));

        for (int i = 0; i <= 30; i++) {
            System.out.printf("isPrime(%d): %b\n", i, MathUtil.isPrime(i));
        }
    }
}
