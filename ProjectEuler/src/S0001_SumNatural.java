/*
 * Add all the natural numbers below one thousand that are multiples of 3 or 5.
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we
 * get 3, 5, 6 and 9. The sum of these multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 *
 */

/**
 *
 * @author Prabu
 * Date: 28-Aug-2010
 */
import java.io.*;
import java.util.*;

public class S0001_SumNatural {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0001_SumNatural solver = new S0001_SumNatural();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0001_SumNatural";
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
            int max = sc.nextInt() - 1;

            int sum = 0;
            /*for(int i = min; i < max; i++) {
                if(i%3 == 0 || i%5 == 0)
                    sum += i;
            }*/
            sum = sumDivisibleBy(3, max);
            sum += sumDivisibleBy(5, max);
            sum -= sumDivisibleBy(3*5, max);

            out.println("Case #" + tci + ": " + sum);
        }
    }

    int sumDivisibleBy(int n, int target) {
        int p = target / n;
        return n * ((p * (p + 1)) / 2);
    }
/******************************************************************************/
}
