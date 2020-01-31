/*
 * Find the 10001st prime.
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
 * that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 *
 */

/**
 *
 * @author Prabu
 * Date: 12-Sep-2010
 */

import java.io.*;
import java.util.*;

public class S0007_NthPrime {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0007_NthPrime solver = new S0007_NthPrime();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0007_NthPrime";
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
        long startTime = System.currentTimeMillis();
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int n = sc.nextInt();
            int i, j;
            long nextPrime, maxDiv;
            long[] primes = new long[n];
            primes[0] = 2;

            i = 1;
            nextPrime = 3;
            while(i < n) {
                maxDiv = (long)Math.sqrt(nextPrime);
                for(j = 0; j < i && primes[j] <= maxDiv; j++) {
                    if(nextPrime%primes[j] == 0) {
                        nextPrime += 2;
                        maxDiv = (long)Math.sqrt(nextPrime);
                        j = 0;
                    }
                }
                primes[i] = nextPrime;
                nextPrime += 2;
                i++;
            }

            out.println("Case #" + tci + ": " + primes[n - 1]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
