/*
 * PC ID: 110104
 * UVa ID: 706
 * Name: LC-Display
 *
 * Problem
 * -------
 * A friend of yours has just bought a new computer. Before this, the most
 * powerful machine he ever used was a pocket calculator. He is a little
 * disappointed because he liked the LCD display of his calculator more than
 * the screen on his new computer! To make him happy, write a program that
 * prints numbers in LCD display style.
 *
 * Input
 * -----
 * The input file contains several lines, one for each number to be displayed.
 * Each line contains integers s and n, where n is the number to be displayed
 * ( 0n99, 999, 999) and s is the size in which it shall be displayed ( 1s10).
 * The input will be terminated by a line containing two zeros, which should
 * not be processed.
 *
 * Output
 * ------
 * Print the numbers specified in the input file in an LCD display-style using
 * s ``-'' signs for the horizontal segments and s ``|'' signs for the vertical
 * ones. Each digit occupies exactly s + 2 columns and 2s + 3 rows. Be sure to
 * fill all the white space occupied by the digits with blanks, including the
 * last digit. There must be exactly one column of blanks between two digits.
 *
 * Output a blank line after each number. You will find an example of each
 * digit in the sample output below.
 *
 * Sample Input
 * ------------
 * 2 12345
 * 3 67890
 * 0 0
 *
 * Sample Output
 * -------------
 *     --   --        --
 *  |    |    | |  | |
 *  |    |    | |  | |
 *     --   --   --   --
 *  | |       |    |    |
 *  | |       |    |    |
 *     --   --        --
 *
 *  ---   ---   ---   ---   ---
 * |         | |   | |   | |   |
 * |         | |   | |   | |   |
 * |         | |   | |   | |   |
 *  ---         ---   ---
 * |   |     | |   |     | |   |
 * |   |     | |   |     | |   |
 * |   |     | |   |     | |   |
 *  ---         ---   ---   ---
 *
 */

/**
 * @author Prabu
 * Date: 16-Aug-2010
 */

import java.io.*;
import java.util.*;

public class PC110104_LCD_Display {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110104_LCD_Display solver = new PC110104_LCD_Display();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

/******************************************************************************/
    final static String FILENAME = "PC110104_LCD_Display";
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
    public static final int LCD_WIDTH = 3;
    public static final int LCD_HEIGHT = 5;
    public static final String[] digit = {
        " -     -  -     -  -  -  -  - ",
        "| |  |  |  || ||  |    || || |",
        "       -  -  -  -  -     -  - ",
        "| |  ||    |  |  || |  || |  |",
        " -     -  -     -  -     -  - "
    };

    void solve() throws IOException {
        while(true) {
            int s = sc.nextInt();
            int n = sc.nextInt();

            if(s == 0 && n == 0)
                return;

            String ns = "" + n;
            int[] nb = new int[ns.length()];
            for(int i = 0; i < ns.length(); i++) {
                nb[i] = ns.charAt(i) - 48;
            }

            for(int h = 0; h < LCD_HEIGHT; h++) {
                int rr = (h%2 == 0)? 1: s;
                while(rr > 0) {
                    for(int i = 0; i < nb.length; i++) {
                        int cs = nb[i] * LCD_WIDTH;
                        int ce = cs + LCD_WIDTH;
                        for(int w = cs; w < ce; w++) {
                            int cr = (w == cs+1)? s: 1;
                            while(cr > 0) {
                                out.print(digit[h].charAt(w));
                                cr--;
                            }
                        }
                        if(i != nb.length - 1)
                          out.print(" "); //space between digits
                    }
                    out.println();
                    rr--;
                }
            }
            out.println();
        }
    }
/******************************************************************************/
}
