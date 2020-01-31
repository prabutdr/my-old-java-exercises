package com.codestrokes.algorithm.ch02;

import java.util.Arrays;

public class InsertionSortDemo {
    public static void main(String[] args) {
        // Get current time
        long start = System.currentTimeMillis();
        int[] array = {10, 4, 3, 6, 8, 2, 5, 4, 1};
        System.out.println("Before sort: " + Arrays.toString(array));
        insertionSort_Mine(array);
        System.out.println("After sort (Asc): " + Arrays.toString(array));
        insertionSortDesc(array);
        System.out.println("After sort (Desc): " + Arrays.toString(array));
        // Get elapsed time in milliseconds
        long elapsedTimeMillis = System.currentTimeMillis()-start;
        System.out.println("Elapsed Time: " + elapsedTimeMillis + "ms");
    }

    static void insertionSort(int[] array) {
        int i, j, key;
        for(j = 1; j < array.length; j++) {
            key = array[j];
            // Insert current key to appropriate position in array[0..j-1]
            i = j-1;
            while(i >= 0 && array[i] > key) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }

    static void insertionSortDesc(int[] array) {
        int i, j, key;
        for(j = 1; j < array.length; j++) {
            key = array[j];
            // Insert current key to appropriate position in array[0..j-1]
            i = j-1;
            while(i >= 0 && array[i] < key) {
                array[i+1] = array[i];
                i--;
            }
            array[i+1] = key;
        }
    }

    static void insertionSort_Mine(int[] array) {
        int i, j, key;
        for(j = 1; j < array.length; j++) {
            key = array[j];
            // Insert current key to appropriate position in array[0..j-1]
            for(i = j-1; i >= 0 && array[i] > key; i--) {
                array[i+1] = array[i];
            }
            array[i+1] = key;
        }
    }
}
