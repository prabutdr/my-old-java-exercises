/**
 * @author Prabu
 * @date Mar 3, 2012
 */
package com.wintech.algorithm;

import com.wintech.io.In;
import com.wintech.io.StdOut;
import com.wintech.util.ArrayUtil;
import com.wintech.adt.StopWatch;
import java.util.Arrays;

public class BinarySearch {
    /**
     * Index of key in array[]
     * NOTE: Using Recursion
     * 
     * @param key
     * @param array - should be sorted
     * @return  rank of a key if exist
     *          -1 otherwise
     */
    public static int rankUsingRecursion(int key, int[] array) {
        return rankUsingRecursion(key, array, 0, array.length - 1);
    }

    /**
     * Index of key in array[], if present, is not larger than hi
     * and not smaller than li.
     * NOTE: Using Recursion
     * 
     * @param key
     * @param array - should be sorted
     * @param li
     * @param hi
     * @return  rank of a key if exist
     *          -1 otherwise
     */
    public static int rankUsingRecursion(int key, int[] array, int li, int hi) {
        if(li > hi)
            return -1; // no match found
        
        int mid = (li + hi) / 2;
        if(array[mid] < key)
            return rankUsingRecursion(key, array, mid+1, hi);
        if(array[mid] > key)
            return rankUsingRecursion(key, array, li, mid-1);

        return mid;
    }
    
    /**
     * Exercise method to know depth
     * @param key
     * @param array
     * @param li
     * @param hi
     * @return 
     */
    private static int rankUsingRecursion(int key, int[] array, int li, int hi, int depth) {
        StdOut.printf("(%6d, %6d, %6d)\n", li, hi, depth);
        if(li > hi)
            return -1; // no match found
        
        int mid = (li + hi) / 2;
        if(array[mid] < key)
            return rankUsingRecursion(key, array, mid+1, hi, depth+1);
        if(array[mid] > key)
            return rankUsingRecursion(key, array, li, mid-1, depth+1);

        return mid;
    }

    /**
     * Find index/rank of key in array[]
     * 
     * @param key
     * @param array - should be sorted
     * @return  rank of a key if exist
     *          -1 otherwise
     */
    public static int rank(int key, int[] array, int li, int hi) {
        int mi;
        while(li <= hi) {
            mi = li + (hi - li) / 2;
            if(array[mi] < key)
                li = mi + 1;
            else if(array[mi] > key)
                hi = mi - 1;
            else
                return mi;
        }
        return -1;
    }
    
    /**
     * Find index/rank of key in array[]
     * 
     * @param key
     * @param array - should be sorted
     * @return  rank of a key if exist
     *          -1 otherwise
     */
    public static int rank(int key, int[] array) {
        int li = 0;
        int hi = array.length - 1;
        return rank(key, array, li, hi);
    }
    
    /**
     * Find count of elements smaller than given key
     * 
     * @param key
     * @param array - should be sorted
     * @return 
     */
    public static int smallerElementsCount(int key, int[] array) {
        int li = 0;
        int hi = array.length - 1;
        int rank = 0;
        while(li <= hi) {
            rank = li + (hi - li) / 2;
            if(array[rank] < key)
                li = rank + 1;
            else if(array[rank] > key)
                hi = rank - 1;
            else
                break;
        }

        if(li <= hi) { // key found at rank pos, then eliminate equivalent to key
            do {
                rank--;
            }
            while(rank >= 0 && array[rank] == key);
            return rank + 1;
        }
        else {  // key not found, return lower index
            return li;
        }
    }
    
    /**
     * Find count of elements larger than given key
     * 
     * @param key
     * @param array - should be sorted
     * @return 
     */
    public static int largerElementsCount(int key, int[] array) {
        int li = 0;
        int hi = array.length - 1;
        int rank = 0;
        while(li <= hi) {
            rank = li + (hi - li) / 2;
            if(array[rank] < key)
                li = rank + 1;
            else if(array[rank] > key)
                hi = rank - 1;
            else
                break;
        }

        if(li <= hi) { // key found at rank pos, then eliminate equivalent to key
            do {
                rank++;
            }
            while(rank < array.length && array[rank] == key);
            return array.length - rank;
        }
        else {  // key not found
            return array.length - li;
        }
    }
    
    /**
     * Find count of elements equals to given key
     * 
     * @param key
     * @param array - should be sorted
     * @return 
     */
    public static int equalElementsCount(int key, int[] array) {
        int li = 0;
        int hi = array.length - 1;
        int rank = 0;
        while(li <= hi) {
            rank = li + (hi - li) / 2;
            if(array[rank] < key)
                li = rank + 1;
            else if(array[rank] > key)
                hi = rank - 1;
            else
                break;
        }

        if(li <= hi) { // key found, then eliminate equivalent to key
            int count = 0;
            // count current and lower elements which are equal to key
            li = rank;
            do {
                count++;
                li--;
            }
            while(li >= 0 && array[li] == key);
            
            // count higher elements which are equal to key
            hi = rank + 1;
            while(hi < array.length && array[hi] == key) {
                count++;
                hi++;
            }
            return count;
        }
        
        return 0;
    }
    
    /**
     * Test client for binary search
     * 
     * @param args 
     */
    public static void main(String[] args) {
        /* Test set 1
//        int[] array = {5, 4, 8, 2, 9, 4};
//        Arrays.sort(array);
//        for(int i = 0; i <= 10; i++) {
//            System.out.printf("rank(%d, array): %d\n", i, 
//                    BinarySearch.rank(i, array));
//        }
        int[] whitelist = new In("IO/largeW.txt").readInts();
        char which = '+';
//        Out out = new Out("IO/largeW_out.txt");
//        for(int i = 0; i < whitelist.length; i++) {
//            out.printf("%6d\n", whitelist[i]);
//        }
//        out.close();
        Arrays.sort(whitelist);
        StopWatch stopWatch = new StopWatch();
        whitelist = ArrayUtil.removeDuplicates(whitelist);
        StdOut.println("Elapsed time - 1: " + stopWatch.elapsedTimeMillis());
        
        In in = new In("IO/largeT.txt");
        int key, count = 0;
        //StdOut.print(whitelist);
        while(!in.isEmpty()) {
            key = in.readInt();
            //StdOut.println("Key: " + key);
            if(which == '+' && rank(key, whitelist) < 0) { // not much difference between recursion
                StdOut.println(key);
                count++;
            }
            else if(which == '-' && rank(key, whitelist) >= 0) { // not much difference between recursion
                StdOut.println(key);
                count++;
            }
            //StdOut.println("************************************************");
        }
        StdOut.println("Count: " + count);
        StdOut.println("Elapsed time - 2: " + stopWatch.elapsedTimeMillis());*/
        
        /*** Test set 2 ***/
        int[] array = {1, 3, 4, 4, 4, 4, 4, 6, 8};
        Arrays.sort(array);
        for(int i = -1; i < 12; i++) {
            StdOut.printf("smallerElementsCount(%d, array) : %d\n", i, 
                    smallerElementsCount(i, array));
        }
        StdOut.println();
        for(int i = -1; i < 12; i++) {
            StdOut.printf("largerElementsCount(%d, array) : %d\n", i, 
                    largerElementsCount(i, array));
        }
        StdOut.println();
        for(int i = -1; i < 12; i++) {
            StdOut.printf("equalElementsCount(%d, array) : %d\n", i, 
                    equalElementsCount(i, array));
        }
    }

}
