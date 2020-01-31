/*
 * PC ID: 110203
 * UVa ID: 10050
 * Name: Hartals
 *
 */

/**
 *
 * @author Prabu
 * Date: 15-Apr-2011
 */

import java.io.*;
import java.util.*;

public class PC110203_Hartals {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110203_Hartals solver = new PC110203_Hartals();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110203_Hartals";
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
        for(int tci = 1; tci <= tc; tci++) {
            int totalDays = sc.nextInt();
            int partyCount = sc.nextInt();
            HashSet<Integer> freqSet = new HashSet<Integer>();
            HashSet<Integer> lostWorkingDays = new HashSet<Integer>();
            int i, temp;

            for(i = 0; i < partyCount; i++) {
                freqSet.add(sc.nextInt());
            }

            for(Integer freq:freqSet) {
                for(i = freq; i <= totalDays; i+=freq) {
                    temp = i % 7;
                    if(temp != 6 && temp != 0) // Not saturday and sunday
                        lostWorkingDays.add(i);
                }
            }

            out.println(lostWorkingDays.size());
        }
    }
/******************************************************************************/
}
