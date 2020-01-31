/*
 * Using names.txt (right click and 'Save Link/Target As...'), a 46K text file
 * containing over five-thousand first names, begin by sorting it into
 * alphabetical order. Then working out the alphabetical value for each name,
 * multiply this value by its alphabetical position in the list to obtain a
 * name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which
 * is worth 3 + 15 + 12 + 9 + 14 = 53, is the 938th name in the list. So, COLIN
 * would obtain a score of 938  53 = 49714.
 *
 * What is the total of all the name scores in the file?
 *
 */

/**
 * @author Prabu
 * @date 31-Nov-2010
 */

import java.io.*;
import java.util.*;

public class S0022_NameScore {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            S0022_NameScore solver = new S0022_NameScore();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "S0022_NameScore";
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

        TreeSet<String> namelist = new TreeSet<String>();
        sc.useDelimiter(",");
        while(sc.hasNext()) {
            namelist.add(sc.next());
        }
        
        int position = 1, i, score;
        long totalScore;
        totalScore = 0;
        for(String name: namelist) {
            score = 0;
            for(i = 0; i < name.length(); i++) {
                score += (name.charAt(i) - 64);
            }
            totalScore += (score * position);
            position++;
        }

        System.out.println("Result: " + totalScore);

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
