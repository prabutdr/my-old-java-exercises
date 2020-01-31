/**
 * @author Prabu
 * @date Nov 28, 2011
 */
package com.codechef.practice.easy;

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
import java.util.Stack;
import java.util.StringTokenizer;

public class ONP {

    /*********************** WORK AREA - START ************************************/
    final static String FILENAME = "ONP"; //without extensions (.IN, .OUT)

    void solve() throws Exception {
        int tc = nextInt();
        for (int tci = 1; tci <= tc; tci++) {
            String line = in.readLine();
            Stack<String> stack = new Stack<String>();
            String op1, op2, op;

            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '(') {
                    continue;
                }

                if (line.charAt(i) == ')') {
                    op2 = stack.pop();
                    op = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2 + op);
                    continue;
                }

                stack.push(Character.toString(line.charAt(i)));
            }

            while (stack.size() > 1) {
                //System.out.println(stack);
                op2 = stack.pop();
                op = stack.pop();
                op1 = stack.pop();
                stack.push(op1 + op2 + op);
            }

            out.write(stack.pop() + "\n");
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
        } else {
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
        if (tokens == null || !tokens.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                eof = true;
                return null;
            } else {
                tokens = new StringTokenizer(line);
            }
        }
        return tokens.nextToken();
    }

    String nextLine() throws Exception {
        if (tokens == null || !tokens.hasMoreTokens()) {
            String line = in.readLine();
            if (line == null) {
                eof = true;
                return null;
            } else {
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
            ONP solver = new ONP();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Throwable e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }
}
