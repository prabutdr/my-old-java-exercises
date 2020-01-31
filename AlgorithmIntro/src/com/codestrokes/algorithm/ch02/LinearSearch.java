/**
 * @author Prabu
 * @date May 22, 2011
 */
package com.codestrokes.algorithm.ch02;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {10, 4, 3, 6, 8, 2, 5, 4, 1};
        System.out.println(linearSearch(array, 5));
        System.out.println(linearSearch(array, 7));
    }

    static int linearSearch(int[] array, int value) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == value)
                return i; // return item index
        }

        return -1; // not found
    }
}
