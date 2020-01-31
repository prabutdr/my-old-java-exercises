/*
 * Evaluate the sum of all amicable pairs under 10000.
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n
 * which divide evenly into n).
 * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and
 * each of a and b are called amicable numbers.
 *
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44,
 * 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4,
 * 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 *
 */

/**
 * @author Prabu
 * @date 31-Oct-2010
 */

import java.io.*;
import java.util.*;

public class S0021_AmicableSum {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0021_AmicableSum solver = new S0021_AmicableSum();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "FileName";
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

        int SIZE = 10000;
        int[] sums = new int[SIZE];
        boolean[] amicableFlag = new boolean[SIZE];

        for(int i = 1; i < SIZE; i++) {
            int sum = 1;
            int limit = (int)Math.sqrt(i);
            System.out.print(i + ": 1 ");
            for(int j=2; j <= limit; j++) {
                if(i%j == 0) {
                    sum += (i/j);
                    sum += j;
                    System.out.print((i/j) + " " + j + " ");
                }
            }
            sums[i] = sum;
            System.out.println(": " + sums[i]);
        }

        int amicableSum = 0;
        for(int i = 1; i < SIZE; i++) {
            if(amicableFlag[i] == true)
                continue;
            if(sums[i] < SIZE && i != sums[i] && i == sums[sums[i]]) {
                amicableSum += i;
                amicableSum += sums[i];
                amicableFlag[i] = true;
                amicableFlag[sums[i]] = true;
                System.out.println(i + " " + sums[i]);
            }
        }

        System.out.println("Result: " + amicableSum);

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
