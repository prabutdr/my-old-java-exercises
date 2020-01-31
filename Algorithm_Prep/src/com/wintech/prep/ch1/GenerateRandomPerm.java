package com.wintech.prep.ch1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Prabu on 2/28/2016.
 */
public class GenerateRandomPerm {
    /**
     * Generate random sequence which contains 1 to n
     * inefficient way
     * @param n
     * @return
     */
    public static int[] generateRandomSeq(int n) {
        int[] sequence = new int[n];
        int random;
        Random randomGen = new Random();

        for (int i = 0; i < n; i++) {
            random = randomGen.nextInt(n) + 1;

            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] == random) {
                    random = randomGen.nextInt(n) + 1;
                    j = i;
                }
            }

            sequence[i] = random;
        }

        return sequence;
    }

    /**
     * Generate random sequence which contains 1 to n
     * inefficient way (just improved)
     * @param n
     * @return
     */
    public static int[] generateRandomSeq1(int n) {
        int[] sequence = new int[n];
        boolean[] used = new boolean[n];
        int random;
        Random randomGen = new Random();

        for (int i = 0; i < n; i++) {
            do {
                random = randomGen.nextInt(n);
            } while (used[random] == true);

            sequence[i] = random + 1;
            used[random] = true;
        }

        return sequence;
    }

    /**
     * Generate random sequence which contains 1 to n
     *
     * @param n
     * @return
     */
    public static int[] generateRandomSeq2(int n) {
        int[] sequence = new int[n];
        Random randomGen = new Random();

        for (int i = 0; i < n; i++) {
            sequence[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            swapReferences(sequence, i, randomGen.nextInt(i + 1));
        }

        return sequence;
    }

    private static void swapReferences(int[] sequence, int x, int y) {
        if (x == y) return;

        int temp = sequence[x];
        sequence[x] = sequence[y];
        sequence[y] = temp;
    }

    public static void main(String[] args) {
        ArrayList al;
        System.out.println(Arrays.toString(generateRandomSeq(6)));
        System.out.println(Arrays.toString(generateRandomSeq1(10)));
        System.out.println(Arrays.toString(generateRandomSeq2(10)));
    }
}
