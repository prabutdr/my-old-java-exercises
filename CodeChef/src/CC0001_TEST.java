/*
 * A tutorial for this problem is available here

Your program is to use the brute-force approach in order to find the Answer to Life, the Universe, and Everything. More precisely... rewrite small numbers from input to output. Stop processing input after reading in the number 42. All numbers at input are integers of one or two digits.

Example
 Input:
1
2
88
42
99

Output:
1
2
88

 */

/**
 *
 * @author Prabu
 * @date 05-Apr-2011
 */

import java.io.*;
import java.util.*;

public class CC0001_TEST {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CC0001_TEST solver = new CC0001_TEST();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CC0001_TEST";
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
        int number;

        while(true) {
            number = sc.nextInt();
            if(number == 42)
                break;
            out.println(number);
        }
    }
/******************************************************************************/
}
