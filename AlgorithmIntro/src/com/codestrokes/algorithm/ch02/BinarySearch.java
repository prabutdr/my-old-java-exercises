/**
 * @author Prabu
 * @date Jun 4, 2011
 */
package com.codestrokes.algorithm.ch02;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        System.out.println("binarySearchIterative(array, 5): " + binarySearchIterative(array, 5));
        System.out.println("binarySearchIterative(array, 60): " + binarySearchIterative(array, 60));
        System.out.println("binarySearchRecursive(array, 5): " + binarySearchRecursive(array, 0, array.length-1, 5));
        System.out.println("binarySearchRecursive(array, 60): " + binarySearchRecursive(array, 0, array.length-1, 60));
    }

    static int binarySearchIterative(int[] array, int searchItem) {
        int beginIndex = 0;
        int endIndex = array.length - 1;
        int midIndex;
        while(beginIndex < endIndex) {
            midIndex = (beginIndex + endIndex) / 2;
            if(array[midIndex] == searchItem)
                return midIndex;
            else if(array[midIndex] < searchItem)
                beginIndex = midIndex + 1;
            else
                endIndex = midIndex - 1;
        }

        //not found
        return -1;
    }

    static int binarySearchRecursive(int[] array, int startIndex, int endIndex, int searchItem) {
        if(startIndex < endIndex) {
            int midIndex = (startIndex+endIndex) / 2;
            if(array[midIndex] == searchItem)
                return midIndex;
            else if(array[midIndex] < searchItem)
                return binarySearchRecursive(array, midIndex + 1, endIndex, searchItem);
            return binarySearchRecursive(array, startIndex, midIndex - 1, searchItem);
        }
        return -1;
    }
}
