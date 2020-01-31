/*
 * Work out the first ten digits of the sum of the following one-hundred
 * 50-digit numbers.
 *
 */

/**
 * @author Prabu
 * @date 20-Oct-2010
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class S0013_FirstTenDigit {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0013_FirstTenDigit solver = new S0013_FirstTenDigit();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0013_FirstTenDigit";
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
        BigInteger total = new BigInteger("0");
        sc.nextLine();
        for(int tci = 1; tci <= tc; tci++) {
            BigInteger bi = new BigInteger(sc.nextLine());
            total = total.add(bi);
            //System.out.println(bi + " " + total);
        }
        out.println(total.toString().substring(0, 10));
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
