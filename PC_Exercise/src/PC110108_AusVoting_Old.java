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

public class PC110108_AusVoting_Old {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            PC110108_AusVoting_Old solver = new PC110108_AusVoting_Old();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "PC110108_AusVoting_Old1";
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
        sc.nextLine();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            int candidateCount = sc.nextInt();
            String[] candidateNames = new String[candidateCount];
            int[] rankCount = new int[candidateCount];
            ArrayList<ArrayList<Integer>> ranks = new ArrayList();
            int i, minRankPos = -1, maxRankPos = -1;
            float totalBallots = 0;
            boolean[] isEliminatedCandidate = new boolean[candidateCount];

            sc.nextLine();
            for(i = 0; i < candidateCount; i++) {
                candidateNames[i] = sc.nextLine();
                //System.out.println(i + ": " + candidateNames[i] + ", Rank: " + rankCount[i]);
            }

            while(sc.hasNextLine()) {
                String line = sc.nextLine();
                if(line.trim().length() == 0)
                    break;

                //System.out.println(line);
                ArrayList<Integer> list = new ArrayList<Integer>();
                for(i = 0; i < candidateCount; i++)
                    list.add(new Integer(0));

                i = 0;
                for(String item: line.split(" ")) {
                    if(item.equals("1")) {
                        rankCount[i]++;
                        if(minRankPos == -1 || rankCount[minRankPos] >= rankCount[i])
                            minRankPos = i;
                        if(maxRankPos == -1 || rankCount[maxRankPos] <= rankCount[i])
                            maxRankPos = i;
                    }
                    //list.add(Integer.parseInt(item));
                    list.set(Integer.parseInt(item)-1, i);
                    i++;
                }
                ranks.add(list);
                /*
                ArrayList<Integer> list = new ArrayList<Integer>(20);
                i = 0;
                for(String item: line.split(" ")) {
                    if(item.equals("1")) {
                        rankCount[i]++;
                        if(rankCount[minRankPos] >= rankCount[i])
                            minRankPos = i;
                        if(rankCount[maxRankPos] <= rankCount[i])
                            maxRankPos = i;
                    }
                    list.add(Integer.parseInt(item));
                    i++;
                }
                ranks.add(list);*/
                totalBallots++;

                //line = sc.nextLine();
                //System.out.println(line);
            }

            
            System.out.println("Min Rank: " + rankCount[minRankPos] + ", " + minRankPos);
            System.out.println("Max Rank: " + rankCount[maxRankPos] + ", " + maxRankPos);
            System.out.println("Total Ballots: " + totalBallots);
            System.out.println(ranks);
            System.out.println();

            do {
                for(i = 0; i < candidateCount; i++) {
                    if(isEliminatedCandidate[i] == false)
                    System.out.println(i + ": " + candidateNames[i] + ", Rank: " + rankCount[i]);
                }

                if(rankCount[maxRankPos]/totalBallots > 0.5) {
                    //Max rank candidate win
                    out.println(candidateNames[maxRankPos]);
                    break;
                }
                else if(rankCount[maxRankPos] == rankCount[minRankPos]) {
                    for(i = 0; i < candidateCount; i++) {
                        if(rankCount[i] == rankCount[maxRankPos])
                            out.println(candidateNames[i]);
                    }
                    break;
                }

                //no one in tied or win status, eliminating lower candidate
                for(i = 0; i < candidateCount; i++) {
                    if(rankCount[i] != rankCount[minRankPos] || isEliminatedCandidate[i])
                        continue;

                    isEliminatedCandidate[i] = true;
                    for(int j = 0; j < totalBallots; j++) {
                        int idx = ranks.get(j).indexOf(i);
                        System.out.println(j + ", " + i + ", " + idx + ", " + ranks.get(j));
                        if(idx == 0)
                            rankCount[ranks.get(j).get(1)]++;
                        ranks.get(j).remove(idx);
                    }
                }
                System.out.println("break;");

                minRankPos = maxRankPos = -1;
                for(i = 0; i < candidateCount; i++) {
                    if(isEliminatedCandidate[i])
                        continue;
                    if(minRankPos == -1 || rankCount[minRankPos] >= rankCount[i])
                        minRankPos = i;
                    if(maxRankPos == -1 || rankCount[maxRankPos] <= rankCount[i])
                        maxRankPos = i;
                }
            } while(true);

            /*
            System.out.println("Min Rank: " + rankCount[minRankPos] + ", " + minRankPos);
            System.out.println("Max Rank: " + rankCount[maxRankPos] + ", " + maxRankPos);
            System.out.println("Total Ballots: " + totalBallots);
            for(i = 0; i < candidateCount; i++) {
                System.out.println("Rank " + i + ": " + rankCount[i]);
            }

            System.out.println(ranks);
            //out.println("Case #" + tci + ": " + result);*/
            if(tci < tc)
                out.println();
        }
        long endTime = System.currentTimeMillis();
        //System.out.println("Elapsed Time: " + (endTime - startTime) + " milliseconds");
    }
/******************************************************************************/
}
