package com.codechef.practice.easy;

/**
 * @author Prabu
 * @date 29-Nov-2011
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TLG {
/*********************** WORK AREA - START ************************************/
    final static String FILENAME = "TLG"; //without extensions (.IN, .OUT)

    /* My old wrong solution
    void solve() throws Exception {
        int tc = nextInt();
        int lead, p1MaxLead, p2MaxLead;
        p1MaxLead = p2MaxLead = 0;
        for (int tci = 1; tci <= tc; tci++) {
            lead = nextInt() - nextInt();

            if(lead < 0) {
                //lead *= -1;
                if(p2MaxLead > lead || p2MaxLead == 0)
                    p2MaxLead -= lead;
            }
            else {
                if(p1MaxLead < lead)
                    p1MaxLead += lead;
            }
        }

        p2MaxLead *= -1;
        if(p1MaxLead > p2MaxLead) {
            out.println("1 " + p1MaxLead);
        }
        else {
            out.println("2 " + p2MaxLead);
        }
    }
    */
    void solve() throws Exception {
        int tc = nextInt();
        int p1Scores, p2Scores, W, L, tempDiff;
        p1Scores = p2Scores = 0;
        W = L = 0;
        for (int tci = 1; tci <= tc; tci++) {
            p1Scores += nextInt();
            p2Scores += nextInt();
            if(p2Scores > p1Scores) {
                tempDiff = p2Scores - p1Scores;
                if(L < tempDiff) {
                    W = 2;
                    L = tempDiff;
                }
            }
            else {
                tempDiff = p1Scores - p2Scores;
                if(L < tempDiff) {
                    W = 1;
                    L = tempDiff;
                }
            }
        }
        
        out.println(W + " " + L);
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
            TLG solver = new TLG();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Throwable e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }
}
