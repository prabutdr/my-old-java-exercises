/*
 * Calculate the sum of all the primes below two million.
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 */

/**
 *
 * @author Prabu
 */

import java.io.*;
import java.util.*;

public class S0010_SumPrimes {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0010_SumPrimes solver = new S0010_SumPrimes();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0010_SumPrimes";
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
    ArrayList<Integer> primes = new ArrayList<Integer>();

    void solve() throws IOException {
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int n = sc.nextInt();
            primes.clear();
            primes.add(2); //1st prime
            long sum = primes.get(0);
            for(int i = 3; i <= n; i+=2) {
                if(isPrime(i)) {
                    primes.add(i);
                    sum += i;
                    System.out.println(i);
                }
            }
            out.println("Case #" + tci + ": " + sum);
        }
    }

    private boolean isPrime(int num) {
        int max = (int)Math.sqrt(num) + 1;

        for(int primeN: primes) {
            if(primeN > max)
                return true;
            if(num%primeN == 0)
                return false;
        }

        return true;
    }
/******************************************************************************/
}
