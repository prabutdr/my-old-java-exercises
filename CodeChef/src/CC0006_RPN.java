/*
 * To change this CC0006_RPN, choose Tools | CC0006_RPNs
 * and open the CC0006_RPN in the editor.
 */

/**
 *
 * @author Prabu
 */

import java.io.*;
import java.util.*;

public class CC0006_RPN {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CC0006_RPN solver = new CC0006_RPN();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CC0006_RPN";
    private static BufferedReader in;
    private static BufferedWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        in = new BufferedReader(new FileReader(inFileName));
        out = new BufferedWriter(new FileWriter(outFileName));
    }

    void closeIO() throws IOException {
        out.close();
        in.close();
    }

/******************************************************************************/
    void solve() throws IOException {
        int tc = Integer.parseInt(in.readLine());
        for(int tci = 1; tci <= tc; tci++) {
            String line = in.readLine();
            Stack<String> stack = new Stack<String>();
            String op1, op2, op;

            for(int i = 0; i < line.length(); i++) {
                if(line.charAt(i) == '(')
                    continue;

                if(line.charAt(i) == ')') {
                    op2 = stack.pop();
                    op = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2 + op);
                    continue;
                }

                stack.push(Character.toString(line.charAt(i)));
            }

            while(stack.size() > 1) {
                System.out.println(stack);
                    op2 = stack.pop();
                    op = stack.pop();
                    op1 = stack.pop();
                    stack.push(op1 + op2 + op);
            }

            out.write(stack.pop() + "\n");
        }
    }
/******************************************************************************/
}
