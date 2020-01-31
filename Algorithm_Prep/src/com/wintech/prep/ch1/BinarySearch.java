package com.wintech.prep.ch1;

import java.util.Arrays;

/**
 * Created by Prabu on 2/28/2016.
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -2, 11, -4, 13, -5, -2};
        Arrays.sort(sequence);
        System.out.println("Sequence - " + Arrays.toString(sequence));
        System.out.println("Find item 7 - " + binarySearch(sequence, 7));
        System.out.println("Find item -2 - " + binarySearch(sequence, -2));
        System.out.println("Find item 100 - " + binarySearch(sequence, 100));

        System.out.println("\nFind item 7 - " + binarySearch1(sequence, 7));
        System.out.println("Find item -2 - " + binarySearch1(sequence, -2));
        System.out.println("Find item 100 - " + binarySearch1(sequence, 100));
    }

    public static int binarySearch(int[] sequence, int item) {
        int low = 0;
        int high = sequence.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (sequence[mid] == item) {
                return mid;
            } else if (sequence[mid] < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public static int binarySearch1(int[] sequence, int item) {
        return binarySearchRec(sequence, item, 0, sequence.length - 1);
    }

    public static int binarySearchRec(int[] sequence, int item, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if (sequence[mid] == item)
            return mid;
        else if (sequence[mid] < item)
            return binarySearchRec(sequence, item, mid + 1, right);
        else
            return binarySearchRec(sequence, item, left, mid - 1);
    }
}
