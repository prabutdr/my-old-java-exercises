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
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

public class PERMUT2 {
/*********************** WORK AREA - START ************************************/
    final static String FILENAME = "PERMUT2"; //without extensions (.IN, .OUT)

    //my solution
    void solve() throws Exception {
        int n, i, ti;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        n = nextInt();
        while(n != 0) {
            for(i = 1; i <= n; i++) {
                ti = nextInt();
                if(ti != i) {
                    if(map.containsKey(ti)) {
                        if(map.get(ti) == i) {
                            map.remove(ti);
                        }
                        else {
                            if(i != n) {
                                nextLine();
                            }
                            break;
                        }
                    }
                    else {
                        map.put(i, ti);
                    }
                }
            }

            if(map.isEmpty()) {
                out.println("ambiguous");
            }
            else {
                out.println("not ambiguous");
            }

            map.clear();
            n = nextInt();
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
            long startTime = new Date().getTime();
            PERMUT2 solver = new PERMUT2();
            solver.openIO();
            solver.solve();
            solver.closeIO();
            long endTime = new Date().getTime();
            System.out.println("Elapsed Time: " + (endTime - startTime));
        } catch (Throwable e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }
}

