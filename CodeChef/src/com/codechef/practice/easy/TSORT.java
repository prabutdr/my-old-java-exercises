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
import java.util.Arrays;
import java.util.StringTokenizer;

public class TSORT {
/*********************** WORK AREA - START ************************************/
    final static String FILENAME = "TSORT"; //without extensions (.IN, .OUT)

    /* // My Solution
    void solve() throws Exception {
        int tc = nextInt();
        int[] buffer = new int[tc];
        int i;
        for (i = 0; i < tc; i++) {
            buffer[i] = nextInt();
        }
        Arrays.sort(buffer);
        for (i = 0; i < tc; i++) {
            out.println(buffer[i]);
        }
    }*/

    void solve() throws Exception {
        final int MAX_NOS = 1000001;
        byte[] counts = new byte[MAX_NOS];
        int i;
        int tc = nextInt();
        for (i = 0; i < tc; i++) {
            counts[nextInt()]++;
        }

        for (i = 0; i < MAX_NOS; i++) {
            while(counts[i] != 0) {
                out.println(i);
                counts[i]--;
            }
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
            TSORT solver = new TSORT();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Throwable e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }
}

