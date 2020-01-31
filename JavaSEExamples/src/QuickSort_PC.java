/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prabu
 */
import java.util.*;

public class QuickSort_PC {
    public static void main(String[] args) {
        int[] array = {10, 2, 4, 4, 3, 7, 9, 8, 5, 6};
        //int[] array = {10, 2, 1, 5, 3};
        System.out.println("Before sort: " + Arrays.toString(array));
        quicksort(array, 0, array.length-1);
        System.out.println("After sort: " + Arrays.toString(array));
    }

    static void quicksort(int[] s, int l, int h) {
        int p;

        if((h-l) > 0) {
            p = partition(s, l, h);
        System.out.println("After partition: " + Arrays.toString(s));
        System.out.println("Pivot: " + p);
            //quicksort(s, l, p-1);
            //quicksort(s, p+1, h);
        }
    }

    static int partition(int[] s, int l, int h) {
        int i;
        int p;
        int firsthigh;
        int temp; //for swap

        p = h;
        firsthigh = l;
        for(i = l; i < h; i++) {
            if(s[i] < s[p]) {
                temp = s[i];
                s[i] = s[firsthigh];
                s[firsthigh] = temp;
                firsthigh++;
            }
        }
        temp = s[p];
        s[p] = s[firsthigh];
        s[firsthigh] = temp;

        return firsthigh;
    }
}
