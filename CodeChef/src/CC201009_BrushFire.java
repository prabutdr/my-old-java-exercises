/*
 * Help! A brush fire has started near your house and you are the only one who
 * can help extinguish it. The only tool you have at your disposal is a single
 * fireproof barrier that can protect one bush at a time, provided the bush has
 * not yet caught fire already. For simplicity, we will assume the flames spread
 * according to the following discrete time model.
 *
 * Initially, a single bush, say s, is on fire. You choose a bush, say k, to
 * save. The flames then leap from s to every bush near s with the exception of
 * bush k if it was near s. Say these new burning bushes form a set B. Bush s
 * is then reduced to ashes and will never burn again. Now that the bushes in B
 * are on fire, you may move the protective barrier from bush k to some other
 * bush k'. The flames leap from bushes in B to every bush that has not yet
 * burned (i.e. not s or in B) and is close enough to some bush in B except,
 * perhaps, bush k'. Say this new set of burning bushes is B'. The bushes in
 * set B are reduced to ashes and will never burn again. Now, you may move the
 * protective barrier from k' to another bush to protect it from the flames
 * that will spread from bushes in B' and so on. This process repeats until
 * there are no more bushes on fire.
 *
 * The bushes are arranged in a peculiar manner. Before the fire started, each
 * bush was close enough to spread a fire to at most three other bushes.
 * Moreover, the bush that was initially on fire is actually close enough to
 * only at most two other bushes. It is understood that for any two bushes A
 * and B, if bush A is close enough to bush B then bush B is also close enough
 * to bush A. Finally, the graph underlying the "close enough" relation has no
 * cycles.
 *
 * For whatever reason, some of the bushes hold some sentimental value to you.
 * For this reason, you want to save all of these bushes.
 *
 * Input
 * -----
 * The first line of the input contains a single integer T ≤ 40 indicating the
 * number of test cases that will follow. Each test case begins with three
 * integers n, s, and t satisfying 1 ≤ n ≤ 10,000 and both s and t are between
 * 1 and n. Here, n is the number of bushes (indexed from 1 to n), s is the
 * index of the bush that is initially on fire, and t is the number of bushes
 * you want to save.
 *
 * Following this, there are n lines describing the "close enough" relation.
 * The i'th line starts with an integer 0 ≤ ci ≤ 3 meaning bush i is close
 * enough to ci other bushes. The remaining ci integers on this line are the
 * indices of the bushes that bush i is close to. As mentioned earlier, the
 * input will be such that if bush i is close enough to bush j, then bush j is
 * also close enough to bush i. Finally, we also guarantee that cs ≤ 2.
 *
 * The last line of input for each test case consists of t distinct integers
 * between 1 and n. These correspond to indices of bushes you want to save.
 *
 * Test cases are separated by a single blank line (including a blank line
 * preceding the first test case).
 *
 * Output
 * ------
 * For each test case, you are to output a single line consisting of either
 * "yes" or "no", depending on whether or not it is possible to save all of the
 * indicated bushes.
 *
 * Example
 * -------
 * Input:
 *
 * 3
 *
 * 3 1 2
 * 2 2 3
 * 1 1
 * 1 1
 * 2 3
 *
 * 3 1 1
 * 2 2 3
 * 1 1
 * 1 1
 * 2
 *
 * 7 1 3
 * 2 2 3
 * 3 1 4 5
 * 3 1 6 7
 * 1 2
 * 1 2
 * 1 3
 * 1 3
 * 4 5 7
 *
 * Output:
 *
 * no
 * yes
 * yes
 *
 */

/**
 *
 * @author Prabu
 * Date: 04-Sep-2010
 * Status: Timeout
 */

import java.io.*;
import java.util.*;

public class CC201009_BrushFire {
    @SuppressWarnings("CallToThreadDumpStack")
    public static void main(String[] args) {
        try {
            CC201009_BrushFire solver = new CC201009_BrushFire();
            solver.openIO();
            solver.solve();
            solver.closeIO();
        }
        catch(Exception e) {
            System.out.println("Failed: " + e);
            e.printStackTrace();
        }
    }

    final static String FILENAME = "CC201009_BrushFire";
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
    public static final byte NOT_FIRED = 0;
    public static final byte FIRED = 1;
    public static final byte PROTECTED = 2;
    public static final byte SENTIMENTAL_BUSH = 3;
    int n, s, t;
    byte[] bushStatus;
    int[][] cer;
    int[] bushWeight;
    //int[] sortIB;
    int i, j;
    int fireCount;

    void solve() throws IOException {
        int tc = sc.nextInt();
        //System.out.println(tc);
        for(int tci = 1; tci <= tc; tci++) {
            n = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
            bushStatus = new byte[n + 1];
            cer = new int[n + 1][4];
            bushWeight = new int[n + 1];
            //sortIB = new int[t];
            fireCount = 0;

            bushWeight[0] = 0;
            for(i = 1; i <= n; i++) {
                bushStatus[i] = 0;
                bushWeight[i] = 0;
                cer[i][0] = sc.nextInt();
                for(j = 1; j <= cer[i][0]; j++) {
                    cer[i][j] = sc.nextInt();
                }
            }
            for(i = 0; i < t; i++) {
                bushStatus[sc.nextInt()] = SENTIMENTAL_BUSH;
            }

            calcBushWeight(s, 0); // Calculate weight from root
            
            /*System.out.println(n + " " + s + " " + t);
            for(i = 1; i <= n; i++) {
                for(j = 0; j <= cer[i][0]; j++) {
                    System.out.print(cer[i][j] + " ");
                }
                System.out.println();
            }
            for(i = 0; i < t; i++) {
                System.out.print(indicatedBush[i] + " ");
            }
            System.out.println("\n");

            fire(s, 1);
            for(i = 1; i <= n; i++) {
                System.out.print(bushFired[i] + " ");
            }
            System.out.println("\n");
            for(i = 1; i <= n; i++) {
                System.out.print(bushWeight[i] + " ");
            }
            System.out.println();*/

            System.out.println(fireIsSafe());
        }
    }

    private int calcBushWeight(int bushIdx, int parentIdx) {
        if(bushStatus[bushIdx] == SENTIMENTAL_BUSH)
            bushWeight[bushIdx]++;

        /*if(cer[bushIdx][0] == 1)
            return 0;*/

        if(cer[bushIdx][0] >= 1 && cer[bushIdx][1] != parentIdx)
            bushWeight[bushIdx] += calcBushWeight(cer[bushIdx][1], bushIdx);
        if(cer[bushIdx][0] >= 2 && cer[bushIdx][2] != parentIdx)
            bushWeight[bushIdx] += calcBushWeight(cer[bushIdx][2], bushIdx);
        if(cer[bushIdx][0] >= 3 && cer[bushIdx][3] != parentIdx)
            bushWeight[bushIdx] += calcBushWeight(cer[bushIdx][3], bushIdx);

        return bushWeight[bushIdx];
    }

    private String fireIsSafe() {
        int bushIdx = s;
        int parentIdx = 0, nextBushIdx;
        while(bushIdx != 0) {
            //System.out.println(bushIdx);
            if(bushStatus[bushIdx] == SENTIMENTAL_BUSH)
                return "no";

            bushStatus[bushIdx] = FIRED;
            nextBushIdx = 0;

            if(cer[bushIdx][0] >= 1 && cer[bushIdx][1] != parentIdx)
                nextBushIdx = cer[bushIdx][1];
            if(cer[bushIdx][0] >= 2 && cer[bushIdx][2] != parentIdx
                    && bushWeight[nextBushIdx] > bushWeight[cer[bushIdx][2]])
                nextBushIdx = cer[bushIdx][2];
            if(cer[bushIdx][0] >= 3 && cer[bushIdx][3] != parentIdx
                    && bushWeight[nextBushIdx] > bushWeight[cer[bushIdx][3]])
                nextBushIdx = cer[bushIdx][3];

            parentIdx = bushIdx;
            bushIdx = nextBushIdx;
        }

        return "yes";
    }

    /*private void fire(int pos, int iter) {
        if(bushFired[pos] != 0 || fireCount == n)
            return;

        bushFired[pos] = iter;
        fireCount++;
        iter++;

        while(cer[pos][0] > 0) {
            fire(cer[pos][cer[pos][0]], iter);
            cer[pos][0]--;
        }
    }

    private String possibleToSave() {
        for(i = 0; i < t; i++) {
            sortIB[i] = bushFired[indicatedBush[i]];
            for(j = i; j >= 1; j--) {
                if(sortIB[j] < sortIB[j-1]) {
                    if(sortIB[j-1] > j)
                        return "no";
                    int temp = sortIB[j-1];
                    sortIB[j-1] = sortIB[j];
                    sortIB[j] = temp;
                }
            }
        }
        return "yes";
    }*/
/******************************************************************************/
}
