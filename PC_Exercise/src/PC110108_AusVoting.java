/*
 * PC ID: 110108
 * UVa ID: 10142
 * Name: Australian Voting
 *
 */

/**
 *
 * @author Prabu
 * Date: 28-Jan-2011
 */

import java.io.*;
import java.util.*;
import java.util.ArrayList;

public class PC110108_AusVoting {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110108_AusVoting solver = new PC110108_AusVoting();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110108_AusVoting";
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
        sc.nextLine();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int candidateCount = sc.nextInt();
            String[] candidateNames = new String[candidateCount];
            int[] scores = new int[candidateCount];
            ArrayList<int[]> ballots = new ArrayList();
            int i, minScore, maxScore;
            boolean[] isEliminatedCandidate = new boolean[candidateCount];

            sc.nextLine();
            for(i = 0; i < candidateCount; i++) {
                candidateNames[i] = sc.nextLine();
                //System.out.println(i + ": " + candidateNames[i] + ", Rank: " + scores[i]);
            }

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.trim().length() == 0)
                    break;

                //System.out.println(line);
                //ArrayList<Integer> list = new ArrayList<Integer>();
                int[] list = new int[candidateCount];

                i = 0;
                for(String item: line.split(" ")) {
                    list[i] = Integer.parseInt(item);
                    i++;
                }

                ballots.add(list);
            }

            // Count first choices
            for(i = 0; i < ballots.size(); i++) {
                scores[ballots.get(i)[0]-1]++;
            }

            int[] indices = new int[ballots.size()];
            while(true) {
                // Calculate min & max scores
                minScore = ballots.size();
                maxScore = 0;
                for(i = 0; i < candidateCount; i++) {
                    if(maxScore < scores[i])
                        maxScore = scores[i];
                    if(scores[i] != -1 && minScore > scores[i])
                        minScore = scores[i];
                }

                // If a person get more than 50% or more than one person
                // got same rank (tie), print them
                if((minScore == maxScore) || ((float)maxScore / ballots.size() > 0.5)) {
                    for(i = 0; i < candidateCount; i++) {
                        if(scores[i] == maxScore)
                            out.println(candidateNames[i]);
                    }
                    break;
                }

                // Eliminate lower vote candidates
                for(i = 0; i < candidateCount; i++) {
                    if(scores[i] == minScore) {
                        scores[i] = -1;
                        isEliminatedCandidate[i] = true;
                    }
                }

                /*
                System.out.println("Min Score: " + minScore);
                System.out.println("Max Score: " + maxScore);
                System.out.println("Elimited List: " + Arrays.toString(isEliminatedCandidate));*/

                // Redistribute low candidate votes to other non-eliminated
                // candidates
                for(i = 0; i < ballots.size(); i++) {
                    if(isEliminatedCandidate[ballots.get(i)[indices[i]] - 1]) {
                        while(isEliminatedCandidate[ballots.get(i)[indices[i]] - 1])
                            indices[i]++;
                        scores[ballots.get(i)[indices[i]] - 1]++;
                    }
                }
            }

            if(tci < tc)
                out.println();
        }
    }
/******************************************************************************/
}
