/*
 * PC ID: 110101
 * UVa ID: 100
 * 
 * Problem
 * -------
 * Consider the following algorithm to generate a sequence of numbers. Start 
 * with an integer n. If n is even, divide by 2. If n is odd, multiply by 3 and
 * add 1. Repeat this process with the new value of n, terminating when n = 1.
 * For example, the following sequence of numbers will be generated for n = 22:
 *
 *            22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1
 * It is conjectured (but not yet proven) that this algorithm will terminate at
 * n = 1 for every integer n. Still, the conjecture holds for all integers up
 * to at least 1, 000, 000.
 *
 * For an input n, the cycle-length of n is the number of numbers generated up
 * to and including the 1. In the example above, the cycle length of 22 is 16.
 * Given any two numbers i and j, you are to determine the maximum cycle length
 * over all numbers between i and j, including both endpoints.
 * 
 * Input
 * -----
 * The input will consist of a series of pairs of integers i and j, one pair of
 * integers per line. All integers will be less than 1,000,000 and greater
 * than 0.
 * 
 * Output
 * ------
 * For each pair of input integers i and j, output i, j in the same order in
 * which they appeared in the input and then the maximum cycle length for
 * integers between and including i and j. These three numbers should be
 * separated by one space, with all three numbers on one line and with one line
 * of output for each line of input.
 * 
 * Sample Input
 * ------------
 * 1 10
 * 100 200
 * 201 210
 * 900 1000
 *
 * Sample Output
 * -------------
 * 1 10 20
 * 100 200 125
 * 201 210 89
 * 900 1000 174
 */

/**
 * @author Prabu
 * Date: 14-Aug-2010
 */
import java.io.*;
import java.util.*;

public class PC110101_3Nplus1 {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110101_3Nplus1 solver = new PC110101_3Nplus1();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

/******************************************************************************/
    final static String FILENAME = "PC110101_3Nplus1";
    private static Scanner sc;
    private static PrintWriter out;
    private static final int MAX_LIMIT = 1000001;
    private static long[] cycleArray = new long[MAX_LIMIT];

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
        //sc = new Scanner(System.in);
        //out = new PrintWriter(System.out);
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

    void solve() throws IOException {
        //String line = sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.trim().length() == 0)
                return;

            Scanner sc1 = new Scanner(line);
            int num1 = sc1.nextInt();
            int num2 = sc1.nextInt();
            int min, max;
            long maxCycle = 0;

            if(num1 > num2) {
                min = num2;
                max = num1;
            }
            else {
                min = num1;
                max = num2;
            }

            for(int i = min; i <= max; i++) {
                long currentCycle = cycleCount(i);
                if(maxCycle < currentCycle) {
                    maxCycle = currentCycle;
                }
            }

            out.println(num1 + " " + num2 + " " + maxCycle);
            //line = sc.nextLine();
        }
    }

    long cycleCount(long n) {
        if(n == 1)
            return 1;
        if(n < MAX_LIMIT) {
            int ni = (int)n;
            if(cycleArray[ni] != 0)
                return cycleArray[ni];
            if(n%2 == 1)
                cycleArray[ni] = 1 + cycleCount(3*n+1);
            else
                cycleArray[ni] = 1 + cycleCount(n/2);
            return cycleArray[ni];
        }
        else {
            if(n%2 == 1)
                return 1 + cycleCount(3*n+1);
            else
                return 1 + cycleCount(n/2);
        }
    }
/******************************************************************************/
}

