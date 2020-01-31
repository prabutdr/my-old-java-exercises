/*
 * Find the only Pythagorean triplet, {a, b, c}, for which a + b + c = 1000.
 *
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which,
 *
 * a^2 + b^2 = c^2
 *
 * For example, 32 + 42 = 9 + 16 = 25 = 52.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 *
 * Formulae:
 * =========
 * All pythagorean triplets will satisfy the following condition,
 *      a=m^2-n^2   b=2mn   c=m^2+n^2
 *
 * In this case
 *      m^2-n^2 + 2mn + m^2+n^2 = 1000
 *      2m^2 + 2mn = 1000
 *      m^2 + mn = 500
 *      m(m+n) = 500 ==> sqrt(500) = 22.___
 *      20 * 25 = 500
 *  so m = 20, n = 5
 */

/**
 *
 * @author Prabu
 * Date: 03-Oct-2010
 */

import java.io.*;
import java.util.*;

public class S0009_PythagoreanTriplet {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0009_PythagoreanTriplet solver = new S0009_PythagoreanTriplet();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0009_PythagoreanTriplet";
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
            int sum = sc.nextInt();
            if(sum%2 == 1) {
                out.println("Case #" + tci + ": Invalid sum " + sum);
                continue;
            }
            int m = 1, n = 1, i;

            sum = sum / 2;
            i = (int)Math.sqrt(sum);
            for(; i > 1; i--) {
                if(sum%i == 0) {
                    m = i;
                    n = (sum / i) - m;
                    break;
                }
            }
            if(i == 1) {
                out.println("Case #" + tci + ": Invalid sum" + sum);
                continue;
            }

            int a = m*m - n*n;
            int b = 2*m*n;
            int c = m*m + n*n;
            out.println("Case #" + tci + ": " + m + " - " + n + " - " + a 
                    + " - " + b + " - " + c + " - " + (a*b*c));
        }
    }
/******************************************************************************/
}
