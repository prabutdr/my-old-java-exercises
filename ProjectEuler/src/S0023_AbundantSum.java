/*
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 *
 * A perfect number is a number for which the sum of its proper divisors is
 * exactly equal to the number. For example, the sum of the proper divisors of
 * 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less
 * than n and it is called abundant if this sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest
 * number that can be written as the sum of two abundant numbers is 24. By
 * mathematical analysis, it can be shown that all integers greater than 28123
 * can be written as the sum of two abundant numbers. However, this upper limit
 * cannot be reduced any further by analysis even though it is known that the
 * greatest number that cannot be expressed as the sum of two abundant numbers
 * is less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum
 * of two abundant numbers.
 *
 */

/**
 * @author Prabu
 * @date 31-Oct-2010
 */

import java.io.*;
import java.util.*;

public class S0023_AbundantSum {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0023_AbundantSum solver = new S0023_AbundantSum();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0023_AbundantSum";
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
            int size = sc.nextInt();
            int[] numbers = new int[size];
            ArrayList<Integer> abundantNums = new ArrayList<Integer>();
            int sum = 0;

            for(int i=0; i < size; i++) {
                numbers[i] = i + 1;
                sum += numbers[i];
                //System.out.println("Plus: " + numbers[i]);
                if(isAbundant(numbers[i])) {
                    abundantNums.add(numbers[i]);
                }
            }
            //System.out.println(abundantNums);

            for(int i=0; i < abundantNums.size(); i++) {
                for(int j = i; j < abundantNums.size(); j++) {
                    int index = abundantNums.get(i) + abundantNums.get(j) - 1;
                    if(index < size) {
                        sum -= numbers[index];
                        //System.out.println("Minus: " + numbers[index]);
                        numbers[index] = 0;
                    }
                }
            }
            out.println("Case #" + tci + ": " + sum);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }

    private boolean isAbundant(int n) {
        int sum = 1;
        int limit = (int)Math.sqrt(n);
        for(int j=2; j <= limit && sum <= n; j++) {
            if(n%j == 0) {
                sum += (n/j);
                if((n/j) != j) sum += j;
                //System.out.print((n/j) + " " + j + " ");
            }
        }
        //System.out.println(n + ": " + sum);

        if(sum <= n)
            return false;
        else
            return true;
    }
/******************************************************************************/
}
