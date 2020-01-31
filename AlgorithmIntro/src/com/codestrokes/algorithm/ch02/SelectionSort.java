/**
 * @author Prabu
 * @date Jun 4, 2011
 */
package com.codestrokes.algorithm.ch02;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        // Get current time
        long start = System.currentTimeMillis();
        int[] array = {10, 4, 3, 6, 8, 2, 5, 4, 1};
        System.out.println("Before sort: " + Arrays.toString(array));
        selectionSort(array);
        System.out.println("After sort (Asc): " + Arrays.toString(array));

        // Get elapsed time in milliseconds
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("Elapsed Time: " + elapsedTimeMillis + "ms");
    }

    static void selectionSort(int[] array) {
        int i, j, min, temp;
        for(i = 0; i < array.length - 1; i++) {
            min = i;
            for(j = i+1; j < array.length; j++) {
                if(array[min] > array[j])
                    min = j;
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
}
