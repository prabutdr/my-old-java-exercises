/*
 * You are given the following information, but you may prefer to do some
 * research for yourself.
 *
 * 1 Jan 1900 was a Monday.
 * Thirty days has September, April, June and November.
 * All the rest have thirty-one, Saving February alone, Which has twenty-eight,
 * rain or shine.
 * And on leap years, twenty-nine.
 *
 * A leap year occurs on any year evenly divisible by 4, but not on a century
 * unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century
 * (1 Jan 1901 to 31 Dec 2000)?
 *
 */

/**
 * @author Prabu
 * @date 31-Oct-2010
 */

import java.io.*;
import java.util.*;

public class S0019_Calendar {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0019_Calendar solver = new S0019_Calendar();
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
    void solve() throws IOException {
        long startTime = System.currentTimeMillis();

        int[][] monthDays = {{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
                             {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
        };
        int year = 1900;
        int month = 1;
        int isLeapYear = 1;
        int dayOfWeek = 1;
        int sundayCount = 0;
        for(year = 1900; year <= 2000; year++) {
            isLeapYear = ((year%4 == 0 && year%100 != 0) ||  year%400 == 0)? 1: 0;
            for(month = 1; month <= 12; month++) {
                dayOfWeek = (dayOfWeek + monthDays[isLeapYear][month]) % 7;
                if(year != 1900 && dayOfWeek == 0) {
                    sundayCount++;
                }
            }
        }
        System.out.println(sundayCount);
        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
