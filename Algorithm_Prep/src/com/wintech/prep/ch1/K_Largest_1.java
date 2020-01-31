/**
 * Created by Prabu on 2/28/2016.
 */
package com.wintech.prep.ch1;

import java.util.Arrays;

public class K_Largest_1 {
    public static void main(String[] args) {
        Integer i;

        int[] numbers = {3, 8, 9, 78, 34, 28, 17, 3, 6};
        sortDesc(numbers, 0, numbers.length - 1);
        System.out.println("Numbers after sorted 1 - " + Arrays.toString(numbers));
        System.out.println("5th Largest - " + findLargest(numbers, 5));
        System.out.println("2th Largest - " + findLargest(numbers, 2));
    }

    public static int findLargest(int[] numbers, int k) {
        assert (numbers.length >= k);
        k--;

        sortDesc(numbers, 0, k);

        for (int i = k; i < numbers.length; i++) {
            if (numbers[i] < numbers[k]) continue;

            int temp = numbers[k];
            numbers[i] = numbers[k];
            numbers[k] = temp;

            sortDesc(numbers, 0, k);
        }

        return numbers[k];
    }




    public static void sortDesc(int[] numbers, int startIdx, int endIdx) {
        // Sort first k element first (using selection sort)
        for (int i = endIdx; i >= 0; i--) {
            int nextLargeIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (numbers[nextLargeIdx] > numbers[j]) {
                    nextLargeIdx = j;
                }
            }

            if (nextLargeIdx != i) {
                // swap is required to move next large item to current location
                int temp = numbers[i];
                numbers[i] = numbers[nextLargeIdx];
                numbers[nextLargeIdx] = temp;
            }
        }
    }
}
