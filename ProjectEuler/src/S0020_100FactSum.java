/*
 * Find the sum of digits in 100!
 *
 * n! means n x (n  1) x ... x 3 x 2 x 1
 *
 * Find the sum of the digits in the number 100!
 *
 */

/**
 * @author Prabu
 * @date 31-Nov-2010
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class S0020_100FactSum {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0020_100FactSum solver = new S0020_100FactSum();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0020_100FactSum";
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
            BigInteger bi = factorial(new BigInteger("" + n));

            int sum = 0;
            String strBI = bi.toString();
            for(int i = 0; i < strBI.length(); i++) {
                sum += strBI.charAt(i) - 48;
            }
            out.println("Case #" + tci + ": " + sum);
            //out.println("Case #" + tci + ": " + result);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }

    private BigInteger factorial(BigInteger n) {
        //System.out.println(n);
        if(n.equals(new BigInteger("1")))
            return new BigInteger("1");
        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }
/******************************************************************************/
}
