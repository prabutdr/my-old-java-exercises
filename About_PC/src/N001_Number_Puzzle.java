/*
 * Objective
 * ---------
 * 25 years ago, a British computer magazine had a programming contest and this
 * was one of the puzzles.  There are a large number of 9 digit integers in the
 * range 123456789 to 987654321 where each digit only appears once. What is the
 * 100,000th number in this sequence?
 *
 * Example
 * -------
 * The first number is 123456789, the second is 123456798, the third is
 * 123456879 and so on. No digit can repeat so 122345675 is not a valid number
 * in this sequence.
 *
 * The problem was "Write a program in Ansi C, C++ or C# 2.0 (C# 1.0 is allowed)
 * that outputs the 100,000th number as fast as possible. Use any algorithm,
 * except you cannot pre-calculate the answer and then write a program that
 * just prints the result. Your entry must calculate the number!". This ran
 * through June 2007
 */

/*
 * @author Prabu
 * Date: 14-Aug-2010
 */

import java.io.*;
import java.util.*;

public class N001_Number_Puzzle {
    final static String FILENAME = "N001_Number_Puzzle";
    private static Scanner sc;
    private static PrintWriter out;

    static void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    static void closeIO() throws IOException {
        out.close();
        sc.close();
    }

    static void solve() throws IOException {
        int tc = sc.nextInt();
        for(int tci = 1; tci <= tc; tci++) {
            long startTime = new Date().getTime();
            int noOfDigits = sc.nextInt();
            int n = sc.nextInt();
            StringBuilder digits = new StringBuilder("123456789".substring(0, noOfDigits));
            StringBuffer result = new StringBuffer(noOfDigits);

            n--;
            for(int i = 1; i <= noOfDigits; i++) {
                //System.out.println(noOfDigits - i);
                int index = n / factorial(noOfDigits - i);
                index %= digits.length();
                result.append(digits.charAt(index));
                digits.deleteCharAt(index);
            }
            long endTime = new Date().getTime();

            out.println("Case #" + tci + ": " + result + " " + (endTime - startTime));
        }
    }

    static int factorial(int n) {
        if(n == 1 || n == 0)
            return 1;
        else
            return n * factorial(n - 1);
    }

    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            openIO();
            solve();
            closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }
}

