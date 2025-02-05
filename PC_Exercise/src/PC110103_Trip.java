/*
 * PC ID: 110103
 * UVa ID: 10137
 *
 * A group of students are members of a club that travels annually to different
 * locations. Their destinations in the past have included Indianapolis,
 * Phoenix, Nashville, Philadelphia, San Jose, and Atlanta. This spring they are
 * planning a trip to Eindhoven.
 *
 * The group agrees in advance to share expenses equally, but it is not
 * practical to share every expense as it occurs. Thus individuals in the group
 * pay for particular things, such as meals, hotels, taxi rides, and plane
 * tickets. After the trip, each student's expenses are tallied and money is
 * exchanged so that the net cost to each is the same, to within one cent. In
 * the past, this money exchange has been tedious and time consuming. Your job
 * is to compute, from a list of expenses, the minimum amount of money that
 * must change hands in order to equalize (within one cent) all the students'
 * costs.
 *
 * Input
 * -----
 * Standard input will contain the information for several trips. Each trip
 * consists of a line containing a positive integer n denoting the number of
 * students on the trip. This is followed by n lines of input, each containing
 * the amount spent by a student in dollars and cents. There are no more than
 * 1000 students and no student spent more than $10,000.00. A single line
 * containing 0 follows the information for the last trip.
 *
 * Output
 * ------
 * For each trip, output a line stating the total amount of money, in dollars
 * and cents, that must be exchanged to equalize the students' costs.
 *
 * Sample Input
 * ------------
 * 3
 * 10.00
 * 20.00
 * 30.00
 * 4
 * 15.00
 * 15.01
 * 3.00
 * 3.01
 * 0
 *
 * Sample Output
 * -------------
 * $10.00
 * $11.99
 *
 */

/**
 * @author Prabu
 * Date: 15-Aug-2010
 */

import java.io.*;
import java.util.*;

public class PC110103_Trip {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110103_Trip solver = new PC110103_Trip();
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
    final static String FILENAME = "PC110103_Trip";
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

/******************************************************************************/
    void solve() throws IOException {
        while(true) {
            int count = sc.nextInt();
            if(count == 0)
                return;

            double[] expenses = new double[count];
            double totalAmt = 0, avg, exchangeAmtMax = 0, exchangeAmtMin = 0;
            for(int i = 0; i < count; i++) {
                expenses[i] = sc.nextDouble();
                totalAmt += expenses[i];
                //System.out.println(expenses[i]);
            }
            avg = totalAmt / count;

            //System.out.println("Total: " + totalAmt);
            //System.out.println("Avg: " + avg);
            for(int i = 0; i < count; i++) {
                if(avg > expenses[i])
                    exchangeAmtMin += (Math.floor((avg - expenses[i]) * 100) / 100);
                else
                    exchangeAmtMax += (Math.floor((expenses[i] - avg) * 100) / 100);
            }

            out.printf("$%.2f", (exchangeAmtMin > exchangeAmtMax) ? exchangeAmtMin: exchangeAmtMax);
            out.println();
        }
    }
/******************************************************************************/
}
