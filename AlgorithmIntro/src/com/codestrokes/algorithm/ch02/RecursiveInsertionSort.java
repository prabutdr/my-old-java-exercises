/**
 * @author Prabu
 * @date Jun 4, 2011
 */
package com.codestrokes.algorithm.ch02;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
        // Get current time
        long start = System.currentTimeMillis();
        int[] array = {10, 4, 3, 6, 8, 2, 5, 4, 1};
        System.out.println("Before sort: " + Arrays.toString(array));
        insertionSort(array, array.length - 1);
        System.out.println("After sort (Asc): " + Arrays.toString(array));
        // Get elapsed time in milliseconds
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("Elapsed Time: " + elapsedTimeMillis + "ms");
    }

    static void insertionSort(int[] array, int itemIdx) {
        if(itemIdx <= 0)
            return;
        insertionSort(array, itemIdx - 1);
        int key, i;
        key = array[itemIdx];
            // Insert current key to appropriate position in array[0..j-1]
            for(i = itemIdx-1; i >= 0 && array[i] > key; i--) {
                array[i+1] = array[i];
            }
            array[i+1] = key;

    }
}
