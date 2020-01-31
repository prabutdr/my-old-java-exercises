package com.wintech.prep.ch2;

/**
 * Created by Prabu on 3/4/2016.
 */
public class HanoiTower {
    public static void towerOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
        if (n == 1) {
            System.out.println("Move disk 1 from peg " + fromPeg + " to peg " + toPeg);
            return;
        }

        towerOfHanoi(n - 1, fromPeg, auxPeg, toPeg);
        System.out.println("Move disk from peg " + fromPeg + " to peg " + toPeg);
        towerOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
    }

    public static void main(String[] args) {
        towerOfHanoi(3, 'A', 'B', 'C');
    }
}
