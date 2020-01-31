package com.codechef.practice.easy;

/**
 * @author Prabu
 * @date 28-Nov-2011
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SUMTRIAN {
/*********************** WORK AREA - START ************************************/
    final static String FILENAME = "SUMTRIAN"; //without extensions (.IN, .OUT)

    void solve() throws Exception {
        int tc = nextInt();
        int rows, i, j, n, prevSum, tmpPrevSum;
        for (int tci = 1; tci <= tc; tci++) {
            rows = nextInt();
            int[] sums = new int[rows];

            for(i = 0; i < rows; i++) {
                prevSum = -1;
                for(j = 0; j <= i; j++) {
                    n = nextInt();
                    if(j == 0) {
                        tmpPrevSum = sums[j];
                        sums[j] += n;
                    }
                    else {
                        tmpPrevSum = sums[j];
                        sums[j] = (prevSum > sums[j]? prevSum: sums[j]) + n;
                    }
                    prevSum = tmpPrevSum;
                }
            }

            n = sums[0];
            for(i = 1; i < rows; i++) {
                if(n < sums[i]) {
                    n = sums[i];
                }
            }
            out.println(n);
        }
    }
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
            SUMTRIAN solver = new SUMTRIAN();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Throwable e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }
}
