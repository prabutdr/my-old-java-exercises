/**
 * @author Prabu
 * @date Mar 18, 2012
 */
package com.wintech.algorithm;

import com.wintech.io.StdOut;

public class Binomials {
    public static int binomial(int n, int k) {
        if(n == 0 || k < 0) return 1;
        return binomial(n-1, k) + binomial(n-1, k-1);
    }
    
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j <= i; j++) {
                StdOut.print(binomial(i, j) + " ");
            }
            StdOut.println();
        }
    }
}
