/*
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out
 * in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens. For example, 342 (three hundred and
 * forty-two) contains 23 letters and 115 (one hundred and fifteen) contains
 * 20 letters. The use of "and" when writing out numbers is in compliance with
 * British usage.
 *
 */

/**
 * @author Prabu
 * @date 30-Oct-2010
 */

import java.io.*;
import java.util.*;

public class S0017_LettersRequired {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0017_LettersRequired solver = new S0017_LettersRequired();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "FileName";
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
    public String[] ones = {"One", "Two", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine"};
    public String[] elevens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    public String[] tens = {"Twenty", "Thirty", "Forty", "Fifty",
        "Sixty", "Seventy", "Eighty", "Ninety"};
    public String hundred = "Hundred";
    public String thousand = "OneThousand";


    void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int totalLetter  = 0;
        int tmpLength = 0;
        int tmpOnesLength = 0;
        for(int i=0; i < ones.length; i++) {
            tmpLength += ones[i].length();
        }
        totalLetter = tmpLength * 9; //within hundred, nine times
        tmpOnesLength = (tmpLength * 100); //one hundred, two hundred...

        tmpLength = 0;
        for(int i=0; i < elevens.length; i++) {
            tmpLength += elevens[i].length();
        }
        totalLetter += tmpLength;

        tmpLength = 0;
        for(int i=0; i < tens.length; i++) {
            tmpLength += tens[i].length();
        }
        totalLetter += (tmpLength * 10); //within hundred, ten times

        totalLetter *= 10; //within thousand, repeat above ten times

        tmpLength = hundred.length();
        totalLetter += (tmpLength * 900); //word hundred, nine hundred time
        tmpLength = "And".length();
        totalLetter += (tmpLength * (900 - 9));
        totalLetter += thousand.length();
        totalLetter += tmpOnesLength;

        System.out.println(totalLetter);

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
