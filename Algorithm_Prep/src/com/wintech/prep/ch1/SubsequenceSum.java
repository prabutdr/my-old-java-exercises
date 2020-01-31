package com.wintech.prep.ch1;

/**
 * Created by Prabu on 2/28/2016.
 */
public class SubsequenceSum {
    public static void main(String[] args) {
        int[] sequence = {-2, 11, -4, 13, -5, -2};
        int[] sequence1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -2, 11, -4, 13, -5, -2};
        int[] sequence2 = {4, -3, 5, -2, -1, 2, 6, -2};

        System.out.println("Maximum sub sequence 1 - " + maxSubSeqSum1(sequence));
        System.out.println("Maximum sub sequence 1 - " + maxSubSeqSum1(sequence1));

        System.out.println("\nMaximum sub sequence 2 - " + maxSubSeqSum2(sequence));
        System.out.println("Maximum sub sequence 2 - " + maxSubSeqSum2(sequence1));

        System.out.println("\nMaximum sub sequence 3 - " + maxSubSeqSum3(sequence));
        System.out.println("Maximum sub sequence 3 - " + maxSubSeqSum3(sequence1));
        System.out.println("Maximum sub sequence 3 - " + maxSubSeqSum3(sequence2));

        System.out.println("\nMaximum sub sequence 4 - " + maxSubSeqSum4(sequence));
        System.out.println("Maximum sub sequence 4 - " + maxSubSeqSum4(sequence1));
        System.out.println("Maximum sub sequence 4 - " + maxSubSeqSum4(sequence2));

        System.out.println("\nMaximum sub sequence 5 - " + maxSubSeqSum5(sequence));
        System.out.println("Maximum sub sequence 5 - " + maxSubSeqSum5(sequence1));
        System.out.println("Maximum sub sequence 5 - " + maxSubSeqSum5(sequence2));
    }

    /**
     * Find maximum sub sequence sum (Qubic)
     * @param sequence
     * @return
     */
    public static int maxSubSeqSum1(int[] sequence) {
        int maxSum = 0;

        for (int i = 0; i < sequence.length; i++) {
            for (int j = i; j < sequence.length; j++) {
                int thisSum = 0;

                for (int k = i; k <= j; k++) {
                    thisSum += sequence[k];
                }

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Find maximum sub sequence sum (Quadratic)
     * @param sequence
     * @return
     */
    public static int maxSubSeqSum2(int[] sequence) {
        int maxSum = 0;

        for (int i = 0; i < sequence.length; i++) {
            int thisSum = 0;
            for (int j = i; j < sequence.length; j++) {
                thisSum += sequence[j];

                if (thisSum > maxSum) {
                    maxSum = thisSum;
                }
            }
        }

        return maxSum;
    }

    /**
     * Find maximum sub sequence sum using divide and conquer technique
     *
     * @param sequence
     * @return
     */
    public static int maxSubSeqSum3(int[] sequence) {
        return maxSubSeqReq(sequence, 0, sequence.length - 1);
    }

    private static int maxSubSeqReq(int[] sequence, int left, int right) {
        if (left == right) {
            if (sequence[left] > 0) {
                return sequence[left];
            }
            else {
                return 0;
            }
        }

        int center = (left + right) / 2;
        int maxLeftSum = maxSubSeqReq(sequence, left, center);
        int maxRightSum = maxSubSeqReq(sequence, center + 1, right);

        int maxLeftBorderSum = 0, leftBorderSum = 0;
        for (int i = center; i >= left; i--) {
            leftBorderSum += sequence[i];

            if (maxLeftBorderSum < leftBorderSum) {
                maxLeftBorderSum = leftBorderSum;
            }
        }

        int maxRightBorderSum = 0, rightBorderSum = 0;
        for (int i = center + 1; i <= right; i++) {
            rightBorderSum += sequence[i];

            if (maxRightBorderSum < rightBorderSum) {
                maxRightBorderSum = rightBorderSum;
            }
        }

        return max3(maxLeftSum, maxRightSum,
                (maxLeftBorderSum + maxRightBorderSum));
    }

    private static int max3(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > c)
            return b;
        else
            return c;
    }

    /**
     * Find maximum sub sequence sum - linear way
     * @param sequence
     * @return
     */
    public static int maxSubSeqSum4(int[] sequence) {
        int maxSubSeqSum = 0, thisSum = 0;

        for (int t: sequence) {
            thisSum += t;

            if (maxSubSeqSum < thisSum) {
                maxSubSeqSum = thisSum;
            }
            else if (thisSum < 0) {
                thisSum = 0;
            }
        }

        return maxSubSeqSum;
    }

    /**
     * Find maximum sub sequence sum - linear way (just improved little
     * @param sequence
     * @return
     */
    public static int maxSubSeqSum5(int[] sequence) {
        int maxSubSeqSum = 0, thisSum = 0;

        for (int t: sequence) {
//            if (t < 0) {
//                continue;
//            }

            thisSum += t;

            if (maxSubSeqSum < thisSum) {
                maxSubSeqSum = thisSum;
            }
            else if (thisSum < 0) {
                thisSum = 0;
            }
        }

        return maxSubSeqSum;
    }
}
