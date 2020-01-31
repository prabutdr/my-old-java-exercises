/*
 * Find the sum of all the even-valued terms in the Fibonacci sequence which do
 * not exceed four million.
 *
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be:
 *
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 *
 * Find the sum of all the even-valued terms in the sequence which do not
 * exceed four million.
 *
 */

/**
 *
 * @author Prabu
 * Date: 28-Aug-2010
 */
import java.io.*;
import java.util.*;

public class S0002_SumEvenFibonacci {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0002_SumEvenFibonacci solver = new S0002_SumEvenFibonacci();
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
    static final int FOUR_MILLION = 4000000;

    void solve() throws IOException {
        long sum = 0;

        /*
        long n1 = 1;
        long n2 = 1;
        long temp;

        while(n2 <= FOUR_MILLION) {
            if(n2%2 == 0)
                sum += n2;
            
            temp = n2;
            n2 = n1 + n2;
            n1 = temp;
        }*/
        //4613732

        //Revised
        long a = 1;
        long b = 1;
        long c = a + b;
        while(c <= FOUR_MILLION) {
            sum += c;
            a = b + c;
            b = c + a;
            c = a + b;
        }

        System.out.println("Result: " + sum);
    }
/******************************************************************************/
}
