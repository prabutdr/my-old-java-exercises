/*
 * To change this CC0003_Factorial, choose Tools | CC0003_Factorials
 * and open the CC0003_Factorial in the editor.
 */

/**
 *
 * @author Prabu
 * @date 09-Apr-2011
 */
import java.io.*;
import java.util.*;

public class CC0003_Factorial {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CC0003_Factorial solver = new CC0003_Factorial();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CC0003_Factorial";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";
        if (new File(inFileName).canRead()) {
            System.setIn(new FileInputStream(inFileName));
            System.setOut(new PrintStream(outFileName));
        }
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
            int n = sc.nextInt();
            int result = 0;

            while(n != 0) {
                result += (n / 5);
                n /= 5;
            }

            out.println(result);
        }
    }
/******************************************************************************/
}
