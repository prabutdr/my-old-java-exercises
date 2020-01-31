/*
 * What is the smallest number divisible by each of the numbers 1 to 20?
 *
 * 2520 is the smallest number that can be divided by each of the numbers
 * from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 *
 */

/**
 *
 * @author Prabu
 * Date: 11-Sep-2010
 */

import java.io.*;
import java.util.*;

public class S0005_LCM {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0005_LCM solver = new S0005_LCM();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0005_LCM";
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
            int min = sc.nextInt();
            int max = sc.nextInt();
            ArrayList<Integer> factors = new ArrayList<Integer>();
            int num;

            for(int i = max; i >= min; i--) {
                /*if(i%2 != 0)
                    continue;*/
                num = i;
                for(Integer div:factors) {
                    if(num%div == 0)
                        num /= div;
                }

                while(num != 1) {
                    for(int j = 2; j <= num; j++) {
                        if(num%j == 0) {
                            factors.add(j);
                            num /= j;
                            break;
                        }
                    }
                }
            }
            int result = 1;
            for(Integer fact: factors) {
                result *= fact;
            }
            out.println("Case #" + tci + ": " + result);
        }
    }
/******************************************************************************/
}
