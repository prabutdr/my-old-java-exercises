package com.wintech.prep.ch2;

import java.util.Arrays;

/**
 * Created by Prabu on 3/4/2016.
 */
public class BackTracking {
    public static void binary(byte[] a, int n) {
        if (n < 1) {
            System.out.println(Arrays.toString(a));
            return;
        }

        a[n - 1] = 0;
        binary(a, n - 1);
        a[n - 1] = 1;
        binary(a, n - 1);
    }

    public static void kstring(byte[] a, int n, int k) {
        if (n < 1) {
            System.out.println(Arrays.toString(a));
            return;
        }

        for (byte j = 0; j < k; j++) {
            a[n - 1] = j;
            kstring(a, n - 1, k);
        }
    }

    public static void main(String[] args) {
        byte[] a = new byte[3];
//        binary(a, a.length);
//        System.out.println();
//        a = new byte[5];
//        binary(a, a.length);
        kstring(a, a.length, 4);
    }
}
