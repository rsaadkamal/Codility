package com.codility.L9_Maximum_Slice;

/*
* A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called A double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2

contains the following example double slices:

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write A function:

class Solution { public int solution(int[] A); }

that, given A non-empty array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A has A sum of greater than 17.

Assume that:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


/**
 * Created by Chaklader on 6/24/18.
 */
public class MaxDoubleSliceSum {


    /*
     * A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a
     * double slice. The sum of double slice (X, Y, Z) is the total
     * of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2]
     * + ... + A[Z − 1]. The goal is to find the maximal sum of any
     * double slice.
     * */


    /*
     * solution - a
     * */
    public static int solution(int[] A) {

        int N = A.length;

        int[] maxStartingHere = new int[N];
        int[] maxEndingHere = new int[N];

        int maxSum = 0;

        for (int i = 1; i < N - 1; ++i) {

            maxSum = Math.max(0, A[i] + maxSum);
            maxEndingHere[i] = maxSum;
        }

        maxSum = 0;

        for (int i = N - 2; i > 0; --i) {

            maxSum = Math.max(0, A[i] + maxSum);
            maxStartingHere[i] = maxSum;
        }



        int maxDoubleSlice = 0;

        for (int i = 0; i < N - 2; ++i) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i + 2]);
        }

        return maxDoubleSlice;

    }

    /*
     * solution - b
     */
    public static int solution1(int[] A) {

        int max = 0;

        int N = A.length;

        int[] A1 = new int[N];
        int[] A2 = new int[N];

        /*
         * A1[i - 1] is the maximum sub array on the left of index i
         * */
        for (int i = 1; i < N - 1; i++) {
            A1[i] = Math.max(A1[i - 1] + A[i], 0);
        }

        /*
         * A2[i + 1] is the maximum sub array on the right of index i
         * */
        for (int i = N - 2; i >= 1; i--) {
            A2[i] = Math.max(A2[i + 1] + A[i], 0);
        }


        /*
         * A1[i - 1] is the maximum sub array on the left of
         * index i and A2[i + 1] is the maximum sub array on
         * the right of index i
         * */
        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, A1[i - 1] + A2[i + 1]);
        }

        return max;
    }


    /*
     * solution - c
     */
    public int solution2(int[] A) {

        int sum = 0;

        int N = A.length;

        int[] lms = new int[N];

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            sum += A[i];

            /*
             * sum will decrease in case of negative values
             * */
            if (sum < minSum) {
                minSum = sum;
            }

            lms[i] = minSum;
        }

        int totalSum = sum;
        sum = 0;

        int[] rms = new int[N];
        minSum = Integer.MAX_VALUE;

        for (int i = N - 1; i >= 0; i--) {

            sum += A[i];

            if (sum < minSum) {
                minSum = sum;
            }

            rms[i] = minSum;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < N - 1; i++) {

            sum = totalSum - A[i] - lms[i - 1] - rms[i + 1];

            if (result < sum) {
                result = sum;
            }
        }

        return result;
    }
}
