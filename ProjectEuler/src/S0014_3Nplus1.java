/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prabu
 */

import java.io.*;
import java.util.*;

public class S0014_3Nplus1 {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0014_3Nplus1 solver = new S0014_3Nplus1();
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
    final static String FILENAME = "S0014_3Nplus1";
    private static Scanner sc;
    private static PrintWriter out;
    private static final int MAX_LIMIT = 1000001;
    private static long[] cycleArray = new long[MAX_LIMIT];

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
        //String line = sc.nextLine();
        while(sc.hasNextLine()) {
            String line = sc.nextLine();
            if(line.trim().length() == 0)
                return;

            Scanner sc1 = new Scanner(line);
            int num1 = sc1.nextInt();
            int num2 = sc1.nextInt();
            int min, max;
            long maxCycle = 0;
            int maxCycleNum = 0;

            if(num1 > num2) {
                min = num2;
                max = num1;
            }
            else {
                min = num1;
                max = num2;
            }

            for(int i = min; i <= max; i++) {
                long currentCycle = cycleCount(i);
                if(maxCycle < currentCycle) {
                    maxCycle = currentCycle;
                    maxCycleNum = i;
                }
            }

            out.println(num1 + " " + num2 + " " + maxCycle + " " + maxCycleNum);
            //line = sc.nextLine();
        }
    }

    long cycleCount(long n) {
        if(n == 1)
            return 1;
        if(n < MAX_LIMIT) {
            int ni = (int)n;
            if(cycleArray[ni] != 0)
                return cycleArray[ni];
            if(n%2 == 1)
                cycleArray[ni] = 1 + cycleCount(3*n+1);
            else
                cycleArray[ni] = 1 + cycleCount(n/2);
            return cycleArray[ni];
        }
        else {
            if(n%2 == 1)
                return 1 + cycleCount(3*n+1);
            else
                return 1 + cycleCount(n/2);
        }
    }
/******************************************************************************/
}

