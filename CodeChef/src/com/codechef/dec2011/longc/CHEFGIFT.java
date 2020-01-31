package com.codechef.dec2011.longc;

/**
 * @author Prabu
 * @date 01-Dec-2011
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CHEFGIFT {
/*********************** WORK AREA - START ************************************/
    final static String FILENAME = "CHEFGIFT1"; //without extensions (.IN, .OUT)

    void solve() throws Exception {
        int tc = nextInt();
        int noTolls, noRoads, i, j, minRoadIdx, tmpRateForTrans;
        int currentRoadIdx, amountRemain, minRateForTransIdx, minRateForTrans;
        int[][] tollRates, mecRates;
        int[] roadTotals;

        for (int tci = 1; tci <= tc; tci++) {
            amountRemain = nextInt();
            noTolls = nextInt();
            noRoads = nextInt();

            tollRates = new int[noRoads][noTolls];
            mecRates = new int[noRoads][noRoads];
            roadTotals = new int[noRoads];
            minRoadIdx = 0;

            for(i = 0; i < noRoads; i++) {
                roadTotals[i] = 0;
                for(j = 0; j < noTolls; j++) {
                    tollRates[i][j] = nextInt();
                    roadTotals[i] +=  tollRates[i][j];
                }

                if(roadTotals[minRoadIdx] > roadTotals[i]) {
                    minRoadIdx = i;
                }
            }
            for(i = 0; i < noRoads; i++) {
                for(j = 0; j < noRoads; j++) {
                    mecRates[i][j] = nextInt();
                }
            }

            currentRoadIdx = minRoadIdx;
            for(i = 0; i < noTolls; i++) {
                /*minRoadIdx = 0;
                for(j = 0; j < noRoads; j++) {
                    roadTotals[j] -=  tollRates[j][i];
                    if(roadTotals[minRoadIdx] > roadTotals[j]) {
                        minRoadIdx = j;
                    }
                }*/

                minRateForTransIdx = currentRoadIdx;
                minRateForTrans = tollRates[currentRoadIdx][i];
                if(i != noTolls-1 && currentRoadIdx != minRoadIdx) {
                    minRateForTrans += mecRates[currentRoadIdx][minRoadIdx];
                }
                System.out.println("currentRoadIdx-0: " + currentRoadIdx);
                System.out.println("minRoadIdx-0: " + minRoadIdx);
                System.out.println("minRateForTransIdx-0: " + minRateForTransIdx);
                System.out.println("minRateForTrans-0: " + minRateForTrans);
                for(j = 0; j < noRoads; j++) {
                    if(currentRoadIdx == j)
                        continue;

                    if(i != 0) { // not first toll
                        tmpRateForTrans = mecRates[currentRoadIdx][j];
                    }
                    else {
                         tmpRateForTrans = 0;
                    }
                    tmpRateForTrans += tollRates[j][i];
                    if(i != noTolls-1 && j != minRoadIdx) { // last toll
                        tmpRateForTrans += mecRates[j][minRoadIdx];
                    }

                    if(tmpRateForTrans < minRateForTrans) {
                        minRateForTrans = tmpRateForTrans;
                        minRateForTransIdx = j;
                    }
                }

                System.out.println("currentRoadIdx: " + currentRoadIdx);
                System.out.println("minRateForTransIdx: " + minRateForTransIdx);
                if(minRateForTransIdx == currentRoadIdx) {
                    amountRemain -= tollRates[currentRoadIdx][i];
                }
                else {
                    if(i == 0) { // first toll
                        amountRemain -= tollRates[minRateForTransIdx][i];
                    }
                    else {
                        amountRemain -= (mecRates[currentRoadIdx][minRateForTransIdx]
                                + tollRates[minRateForTransIdx][i]);
                    }
                    currentRoadIdx = minRateForTransIdx;
                }
                System.out.println("amountRemain: " + amountRemain);

                if(amountRemain < 0) {
                    amountRemain = -1;
                    break;
                }
                
                minRoadIdx = 0;
                for(j = 0; j < noRoads; j++) {
                    roadTotals[j] -=  tollRates[j][i];
                    if(roadTotals[minRoadIdx] > roadTotals[j]) {
                        minRoadIdx = j;
                    }
                }
            }

            out.println(amountRemain);
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
        }
        else {
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
        if(tokens == null || !tokens.hasMoreTokens()) {
            String line = in.readLine();
            if(line == null) {
                eof = true;
                return null;
            }
            else {
                tokens = new StringTokenizer(line);
            }
        }
        return tokens.nextToken();
    }

    String nextLine() throws Exception {
        if(tokens == null || !tokens.hasMoreTokens()) {
            String line = in.readLine();
            if(line == null) {
                eof = true;
                return null;
            }
            else {
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
            CHEFGIFT solver = new CHEFGIFT();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        } catch (Throwable e) {
            System.err.println("Failed: " + e);
            e.printStackTrace(System.err);
        }
    }
}
