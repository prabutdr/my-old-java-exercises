/*
 * PC ID: 110201
 * UVa ID: 10038
 * Name: Jolly Jumpers
 *
 */

/**
 *
 * @author Prabu
 * Date: 10-Apr-2011
 */

import java.io.*;
import java.util.*;

public class PC110201_JollyJumpers {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110201_JollyJumpers solver = new PC110201_JollyJumpers();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110201_JollyJumpers";
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
        while(sc.hasNextLine()) {
            int n = sc.nextInt();
            boolean[] foundFlag = new boolean[n-1];
            int n1, n2, temp;

            n1 = sc.nextInt();
            while(--n > 0) {
                n2 = sc.nextInt();
                temp = Math.abs(n1 - n2);
                if(temp == 0 || temp > foundFlag.length || foundFlag[--temp] == true)
                    break;

                foundFlag[temp] = true;
                n1 = n2;
            }

            if(n == 0)
                out.println("Jolly");
            else {
                out.println("Not jolly");
            }
            sc.nextLine(); // To move next line
        }
    }
/******************************************************************************/
}
