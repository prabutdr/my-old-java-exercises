/**
 * @author Prabu
 * @date Mar 3, 2012
 */
package com.wintech.util;

import com.wintech.io.StdOut;
import java.util.Arrays;

public class ArrayUtil {
    /**
     * Reverse the elements within an array
     * 
     * @param array of integers
     * @return 
     */
    public static void reverse(int[] array) {
        int temp, midIndex;
        midIndex = array.length / 2;
        for(int i = 0; i < midIndex; i++) {
            // swap values
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * Find average value for given list of integers
     * 
     * @param array of integers
     * @return average
     */
    public static double average(int[] array) {
        double average = 0.0;
        for(int i = 0; i < array.length; i++) { // find sum
            average = average + array[i];
        }
        average = average / array.length;   // divide sum by count of nums
        return average;
    }

    /**
     * Find maximum value from given array
     * 
     * @param array of integers
     * @return maximum value from array
     */
    public static int max(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++) {
            if(max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
    
    /**
     * Remove duplicates from array and return subset of it
     * 
     * @param array - should be sorted
     * @return 
     */
    public static int[] removeDuplicates(int[] array) {
        int[] result = new int[array.length];
        int resultIdx = 0;
        for(int i = 0; i < array.length; ) {
            result[resultIdx] = array[i];

            do {
                i++;
            }
            while(i < array.length && result[resultIdx] == array[i]);
            resultIdx++; // increase result index
        }
        
        return Arrays.copyOf(result, resultIdx);
    }

    /**
     * Find minimum value from given array
     * 
     * @param array of integers
     * @return minimum value from array
     */
    public static int min(int[] array) {
        int min = array[0];
        for(int i = 1; i < array.length; i++) {
            if(min > array[i]) {
                min = array[i];
            }
        }
        return min;
    }
    
    /**
     * Test client
     * 
     * @param args 
     */
    public static void main(String[] args) {
        int[] array = {5, 4, 8, 9, 2, 9, 4};
        System.out.println("min(array): " + ArrayUtil.min(array));
        System.out.println("max(array): " + ArrayUtil.max(array));
        System.out.println("average(array): " + ArrayUtil.average(array));
        ArrayUtil.reverse(array);
        System.out.println("After reverse: " + java.util.Arrays.toString(array));
        
        Arrays.sort(array);
        StdOut.print(removeDuplicates(array));
    }
    
}
