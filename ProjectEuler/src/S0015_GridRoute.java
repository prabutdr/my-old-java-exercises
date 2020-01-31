/*
 * Starting in the top left corner in a 20 by 20 grid, how many routes are there
 * to the bottom right corner?
 *
 * Starting in the top left corner of a 22 grid, there are 6 routes (without
 * backtracking) to the bottom right corner.
 *
 * How many routes are there through a 2020 grid?
 *
 * Reference:
 * http://www.joaoff.com/2008/01/20/a-square-grid-path-problem/
 */

/**
 *
 * @author Prabu
 * @date 20-Oct-2010
 */

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class S0015_GridRoute {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0015_GridRoute solver = new S0015_GridRoute();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0015_GridRoute";
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
    //int routeCount;
    //int size;

    void solve() throws IOException {
        long startTime = System.currentTimeMillis();
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int size = sc.nextInt();

            BigInteger dividend = factorial(new BigInteger("" + 2 * size));
            BigInteger divisor = factorial(new BigInteger("" + size));
            divisor = divisor.multiply(divisor);
            
            out.println("Case #" + tci + ": " + dividend.divide(divisor));
            /*size = size + 1;
            long routeCount = 0;
            int[][] grid = new int[size][size];

            int r, c;
            r = c = 0;
            do {
                if(grid[r][c] == 0) {
                    grid[r][c]++;
                    if(c != size-1)
                        c++;
                }
                else if(grid[r][c] == 1) {
                    grid[r][c]++;
                    if(r != size-1)
                        r++;
                }
                else {
                    grid[r][c] = 0;
                    if(c != 0 && grid[r][c-1] != 0) {
                        c--;
                    }
                    else {
                        r--;
                    }
                }
                if(r == size-1 && c == size-1) {
                    routeCount++;
                    if(c != 0 && grid[r][c-1] != 0) {
                        c--;
                    }
                    else {
                        r--;
                    }
                }
                *for(int i = 0; i < size; i++) {
                    for(int j = 0; j < size; j++)
                        System.out.print(grid[i][j] + " ");
                    System.out.println();
                }
                System.out.println("row: " + r + " col: " + c);*
            } 
            while(c != 0 || r != 0 || grid[r][c] != 2);
            System.out.println("Case #" + tci + ": " + routeCount);*/
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }

    /*private void travel(int row, int col) {
        if(row == size && col == size) {
            routeCount++;
            return;
        }
        travel(row+1, col);
        travel(row, col+1);
    }*/
    private BigInteger factorial(BigInteger n) {
        //System.out.println(n);
        if(n.equals(new BigInteger("1")))
            return new BigInteger("1");
        return n.multiply(factorial(n.subtract(new BigInteger("1"))));
    }
/******************************************************************************/
}
