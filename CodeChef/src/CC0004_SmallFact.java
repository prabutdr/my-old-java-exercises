/*
 * To change this CC0004_SmallFact, choose Tools | CC0004_SmallFacts
 * and open the CC0004_SmallFact in the editor.
 */

/**
 *
 * @author Prabu
 * @date 09-Apr-2011
 */

import java.io.*;
import java.util.*;

public class CC0004_SmallFact {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CC0004_SmallFact solver = new CC0004_SmallFact();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CC0004_SmallFact";
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
    private int[] digits = new int[200];
    private int digLength;
    
    void solve() throws IOException {
        int tc = sc.nextInt();
        int n;
        for(int tci = 1; tci <= tc; tci++) {
            n = sc.nextInt();
            out.println(findBigFactorial(n));
        }
    }

    private String findBigFactorial(int n) {
        if(n == 0) {
            return "1";
        }
        if(n < 0) {
            throw new IllegalArgumentException("Parameter should not be negative");
        }
        //System.out.println("Begin - " + n);

        digits[0] = 1;
        digLength = 1;
        int carry, temp;

        for(int i = 2; i <= n; i++) {
            carry = temp = 0;
            for(int k = 0; k < digLength; k++) {
                temp = digits[k] * i + carry;
                digits[k] = temp % 10;
                carry = temp / 10;
            }

            while(carry != 0) {
                digits[digLength++] = carry % 10;
                carry /= 10;
            }
            //System.out.println(Arrays.toString(digits) + ", " + i);
        }

        StringBuilder result = new StringBuilder("");
        for(int i = digLength - 1; i >= 0; i--) {
            result.append(digits[i]);
        }
        return result.toString();
    }
/******************************************************************************/
}
