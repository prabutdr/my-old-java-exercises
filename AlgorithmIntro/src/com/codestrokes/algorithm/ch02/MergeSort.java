/**
 * @author Prabu
 * @date Jun 4, 2011
 */
package com.codestrokes.algorithm.ch02;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        // Get current time
        long start = System.currentTimeMillis();
        int[] array = {10, 4, 3, 6, 8, 2, 5, 4, 1};
        System.out.println("Before sort: " + Arrays.toString(array));
        mergeSort(array, 0, array.length - 1);
        System.out.println("After sort (Asc): " + Arrays.toString(array));
        // Get elapsed time in milliseconds
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("Elapsed Time: " + elapsedTimeMillis + "ms");
    }

    static void mergeSort(int[] array, int startIndex, int endIndex) {
        if(startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(array, startIndex, midIndex);
            mergeSort(array, midIndex + 1, endIndex);
            merge(array, startIndex, midIndex, endIndex);
        }
    }

    static void merge(int[] array, int startIndex, int midIndex, int endIndex) {
        int[] tempArray = new int[endIndex-startIndex+1];
        int i, j, k;
        k = 0;
        i = startIndex;
        j = midIndex + 1;
        while(i <= midIndex && j <= endIndex) {
            if(array[i] < array[j]) {
                tempArray[k] = array[i];
                i++;
            }
            else {
                tempArray[k] = array[j];
                j++;
            }
            k++;
        }

        for(; i <= midIndex; i++) {
            tempArray[k++] = array[i];
        }
        for(; j <= endIndex; j++) {
            tempArray[k++] = array[j];
        }

        for(i = 0, j = startIndex; i < tempArray.length; i++, j++) {
            array[j] = tempArray[i];
        }
    }
}
