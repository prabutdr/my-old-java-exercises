/*
 * Find the largest prime factor of a composite number.
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 * 
 */

/**
 *
 * @author Prabu
 * Date: 03-Sep-2010
 */

import java.io.*;
import java.util.*;

public class S0003_LargestPrimeFactor {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0003_LargestPrimeFactor solver = new S0003_LargestPrimeFactor();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0003_LargestPrimeFactor";
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
            long num = sc.nextLong();

            /*
            long pf = 1, mpf = 1, i;
            while(num > 1) {
                long maxDiv = (long)Math.sqrt(num) + 1;
                for(i = 2; i <= maxDiv; i++) {
                    if(num%i == 0) {
                        pf = i;
                        num = num / i;
                        break;
                    }
                }
                if(i == maxDiv+1) {
                    pf = num;
                    num = 1;
                }
                if(mpf < pf) {
                    mpf = pf;
                }
            }*/

            long factor;
            long lastfactor, maxfactor;

            if(num%2 == 0) {
                lastfactor = 2;
                do {
                    num /= 2;
                }
                while(num%2 == 0);
            }
            else {
                lastfactor = 1;
            }
            factor = 3;
            maxfactor = (long)Math.sqrt(num);
            while(num > 1 && factor <= maxfactor) {
                if(num%factor == 0) {
                    lastfactor = factor;
                    do {
                        num = num / factor;
                    }
                    while(num%factor == 0);
                    maxfactor = (long)Math.sqrt(num);
                }

                factor += 2;
            }
            if(num != 1)
                lastfactor = num;

            out.println("Case #" + tci + ": " + lastfactor);
        }
    }


/******************************************************************************/
}
