/*
 * To change this S0018_MaxTotalTriangle, choose Tools | S0018_MaxTotalTriangles
 * and open the S0018_MaxTotalTriangle in the editor.
 */

/**
 * @author Prabu
 * @date 31-Oct-2010
 */

import java.io.*;
import java.util.*;

public class S0018_MaxTotalTriangle {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0018_MaxTotalTriangle solver = new S0018_MaxTotalTriangle();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0018_MaxTotalTriangle";
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
        long startTime = System.currentTimeMillis();
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int n = sc.nextInt();
            int[][] triangle = new int[n][];
            int i, j;
            for(i=0; i < n; i++) {
                triangle[i] = new int[i+1];
                for(j=0; j <= i; j++) {
                    triangle[i][j] = sc.nextInt();
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }

            for(i=n-2; i >= 0; i--) {
                for(j=0; j < triangle[i].length; j++) {
                    if(triangle[i+1][j] > triangle[i+1][j+1])
                        triangle[i][j] += triangle[i+1][j];
                    else
                        triangle[i][j] += triangle[i+1][j+1];
                }
            }
            out.println("Case #" + tci + ": " + triangle[0][0]);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
