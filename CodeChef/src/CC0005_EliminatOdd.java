/**
 * @author Prabu
 * @date 23-Nov-2011
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CC0005_EliminatOdd {
/*********************** WORK AREA - START ************************************/
    final static String FILENAME = "CC0005_EliminatOdd"; //without extensions (.IN, .OUT)

    void solve() throws Exception {
        int tc = nextInt();
        int n, k;
        System.out.println("Math.log(2): " + Math.log(2));
        for(int tci = 1; tci <= tc; tci++) {
            n = nextInt();
            System.out.println("Math.log(n): " + Math.log(n));
            System.out.println("(Math.log(n)/Math.log(2)): " + (Math.log(n)/Math.log(2)));
            out.println(1 << ((int)(Math.log(n)/Math.log(2))));
        }
    }

    /*
    //my solution - 1
    void solve() throws Exception {
        int tc = nextInt();
        int n, k;
        for (int tci = 1; tci <= tc; tci++) {
            n = nextInt();
            k = 1;
            //System.out.println("Before - n: " + n + ", k: " + k);
            while ((n >>= 1) != 0) {
                k <<= 1;
                //System.out.println("Inside - n: " + n + ", k: " + k);
            }
            //System.out.println("After - n: " + n + ", k: " + k);

            out.println(k);
        }
    }*/
/*********************** WORK AREA - END **************************************/

    private BufferedReader in;
    private PrintWriter out;
    private StringTokenizer tokens;
    private boolean eof;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";
        if (new File(inFileName).canRead()) {
            in = new BufferedReader(
                    new InputStreamReader(new FileInputStream(inFileName)));
            out = new PrintWriter(new PrintStream(outFileName));
        }
        else {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
        }

        eof = false;
    }

    void closeIO() throws IOException {
        out.close();
        in.close();
    }

    String nextToken() throws Exception {
        if(tokens == null || !tokens.hasMoreTokens()) {
            String line = in.readLine();
            if(line == null) {
                eof = true;
                return null;
            }
            else {
                tokens = new StringTokenizer(line);
            }
        }
        return tokens.nextToken();
    }

    String nextLine() throws Exception {
        if(tokens == null || !tokens.hasMoreTokens()) {
            String line = in.readLine();
            if(line == null) {
                eof = true;
                return null;
            }
            else {
                tokens = new StringTokenizer(line);
            }
        }
        return tokens.nextToken("\n");
    }

    int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }

    public static void main(String[] args) {
        try {
            CC0005_EliminatOdd solver = new CC0005_EliminatOdd();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Throwable e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }
}
