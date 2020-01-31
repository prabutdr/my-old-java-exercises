/*
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 *
 * What is the sum of the digits of the number 21000?
 *
 */

/**
 * @author Prabu
 * @date 30-Oct-2010
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class S0016_SumDigit2Pow {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0016_SumDigit2Pow solver = new S0016_SumDigit2Pow();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0016_SumDigit2Pow";
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
            BigInteger bi = new BigInteger("1");
            bi = bi.shiftLeft(n);
            System.out.println(bi);
            int sum = 0;
            String strBI = bi.toString();
            for(int i = 0; i < strBI.length(); i++) {
                sum += strBI.charAt(i) - 48;
            }
            out.println("Case #" + tci + ": " + sum);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
