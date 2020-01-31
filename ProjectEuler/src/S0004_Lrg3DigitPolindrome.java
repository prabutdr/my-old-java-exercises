/*
 * Find the largest palindrome made from the product of two 3-digit numbers.
 *
 * A palindromic number reads the same both ways. The largest palindrome made
 * from the product of two 2-digit numbers is 9009 = 91  99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 */

/**
 *
 * @author Prabu
 * Date: 11-Sep-2010
 */
import java.io.*;
import java.util.*;

public class S0004_Lrg3DigitPolindrome {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0004_Lrg3DigitPolindrome solver = new S0004_Lrg3DigitPolindrome();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0004_Lrg3DigitPolindrome";
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
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int noOfDigit = sc.nextInt();
            int max = (int)Math.pow(10, noOfDigit) - 1;
            int min = (int)Math.pow(10, noOfDigit-1);

            //System.out.println(maxPolindrome(min, max));
            out.println("Case #" + tci + ": " + maxPolindrome(min, max));
        }
    }

    private long maxPolindrome(int min, int max) {
        long product;
        long polindrome = 0;

        int div = max - (max % 11);
        while(div >= min) {
            for(int i = max; i >= min; i--) {
                product = (long)i * div;
                if(polindrome > product)
                    break;
                if(isPolindrome(product)) {
                    //System.out.println(i + " * " + div);
                    //return product;
                    polindrome = product;
                }
            }
            div -= 11;
        }

        return polindrome;
    }

    private boolean isPolindrome(long num) {
        String str = "" + num;
        int start, end;
        start = 0;
        end = str.length() - 1;
        while(start < end) {
            if(str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
/******************************************************************************/
}
