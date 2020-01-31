/*
 * PC ID: 110102
 * UVa ID: 10189
 *
 * Problem
 * -------
 * Have you ever played Minesweeper? This cute little game comes with a certain
 * operating system whose name we can't remember. The goal of the game is to
 * find where all the mines are located within a M x N field.
 *
 * The game shows a number in a square which tells you how many mines there are
 * adjacent to that square. Each square has at most eight adjacent squares. The
 * 4 x 4 field on the left contains two mines, each represented by a ``*''
 * character. If we represent the same field by the hint numbers described
 * above, we end up with the field on the right:
 *
 *     *...
 *     ....
 *     .*..
 *     ....
 *
 *     *100
 *     2210
 *     1*10
 *     1110
 *
 * Input
 * -----
 * The input will consist of an arbitrary number of fields. The first line of
 * each field contains two integers n and m ( 0 < n, m100) which stand for the
 * number of lines and columns of the field, respectively. Each of the next n
 * lines contains exactly m characters, representing the field.
 *
 * Safe squares are denoted by ``.'' and mine squares by ``*,'' both without
 * the quotes. The first field line where n = m = 0 represents the end of input
 * and should not be processed.
 *
 * Output
 * ------
 * For each field, print the message Field #x: on a line alone, where x stands
 * for the number of the field starting from 1. The next n lines should contain
 * the field with the ``.'' characters replaced by the number of mines adjacent
 * to that square. There must be an empty line between field outputs.
 *
 * Sample Input
 * ------------
 *     4 4
 *     *...
 *     ....
 *     .*..
 *     ....
 *     3 5
 *     **...
 *     .....
 *     .*...
 *     0 0
 *
 * Sample Output
 * -------------
 * Field #1:
 * *100
 * 2210
 * 1*10
 * 1110
 *
 * Field #2:
 * **100
 * 33200
 * 1*100
 * 
 */

/**
 * @author Prabu
 * Date: 15-Aug-2010
 */

import java.io.*;
import java.util.*;

public class PC110102_Minesweeper {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110102_Minesweeper solver = new PC110102_Minesweeper();
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
    final static String FILENAME = "PC110102_Minesweeper";
    private static Scanner sc;
    private static PrintWriter out;

    void openIO() throws IOException {
        String inFileName = "IO/Input/" + FILENAME + ".IN";
        String outFileName = "IO/Output/" + FILENAME + ".OUT";

        sc = new Scanner(new File(inFileName));
        out = new PrintWriter(new File(outFileName));
        //sc = new Scanner(System.in);
        //out = new PrintWriter(System.out);
    }

    void closeIO() throws IOException {
        out.close();
        sc.close();
    }

    void solve() throws IOException {
        int tc = 1;
        while(true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if(n == 0 && m == 0) {
                return;
            }
            sc.nextLine();
            //System.out.println(n + " " + m);

            char[][] grid = new char[n][];

            for(int i = 0; i < n; i++) {
                String line = sc.nextLine();
                //System.out.println("Input: " + line);
                line = line.replace('.', '0');
                grid[i] = line.toCharArray();
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(grid[i][j] == '*') {
                        //mine found
                        int rrs, rre, rcs, rce;
                        rrs = (i == 0)? i: i-1;
                        rre = (i == n-1)? i: i+1;
                        rcs = (j == 0)? j: j-1;
                        rce = (j == m-1)? j: j+1;

                        for(int ii = rrs; ii <= rre; ii++) {
                            for(int jj = rcs; jj <= rce; jj++) {
                                if(grid[ii][jj] == '*')
                                    continue;
                                grid[ii][jj]++;
                            }
                        }
                    }
                }
            }

            if(tc != 1)
                out.println();

            out.println("Field #" + tc + ":");
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    out.print(grid[i][j]);
                }
                out.println();
            }
            tc++;
        }
    }
/******************************************************************************/
}

