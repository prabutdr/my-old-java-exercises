/**
 * Created by Prabu on 2/28/2016.
 */
package com.wintech.prep.ch1;

import java.util.Arrays;

public class K_Largest {
    public static void main(String[] args) {
        int[] numbers = {3, 8, 9, 78, 34, 28, 17, 3, 6};
        selectionSort(numbers);
        System.out.println("Numbers after sorted - " + Arrays.toString(numbers));
        System.out.println("5th Largest - " + numbers[4]);
        System.out.println("2th Largest - " + numbers[1]);
    }

    public static void selectionSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            int nextLargeIdx = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[nextLargeIdx] < numbers[j]) {
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
