package com.wintech.prep.ch2;

/**
 * Created by Prabu on 3/4/2016.
 */
public class PrintRec {
    public static void print(int n) {
        if (n == 0)
            return;

        System.out.println(n);
        print(n - 1);
    }

    public static void main(String[] args) {
        print(5);
    }
}
