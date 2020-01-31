/*
 * What is the difference between the sum of the squares and the square of
 * the sums?
 *
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10)^2 = 55^2 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural
 * numbers and the square of the sum is 3025  385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred
 * natural numbers and the square of the sum.
 * 
 */

/**
 *
 * @author Prabu
 * Date: 12-Sep-2010
 */

import java.io.*;
import java.util.*;

public class S0006_DiffSumSquare {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0006_DiffSumSquare solver = new S0006_DiffSumSquare();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0006_DiffSumSquare";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

/******************************************************************************/
    void solve() throws IOException {
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int n = sc.nextInt();
            long sumOfSquares = ((long)n * (n + 1) * (2*n + 1)) / 6;
            long squareOfSum = ((long)n * (n + 1)) / 2;
            squareOfSum *= squareOfSum;

            out.println("Case #" + tci + ": " + Math.abs(sumOfSquares - squareOfSum));
        }
    }
/******************************************************************************/
}
