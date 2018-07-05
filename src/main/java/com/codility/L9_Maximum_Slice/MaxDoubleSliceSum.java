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
     * solution - A
     */
    public static int solution(int[] A) {

        int max = 0;

        int N = A.length;

        int[] A1 = new int[N];
        int[] A2 = new int[N];

        for (int i = 1; i < N - 1; i++) {
            A1[i] = Math.max(A1[i - 1] + A[i], 0);
        }

        for (int i = N - 2; i >= 1; i--) {
            A2[i] = Math.max(A2[i + 1] + A[i], 0);
        }

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, A1[i - 1] + A2[i + 1]);
        }

        return max;
    }


    /*
     * solution - B
     */
    public int solution1(int[] A) {

        int sum = 0;
        int[] lms = new int[A.length];

        int minSum = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {

            sum += A[i];
            if (sum < minSum) {
                minSum = sum;
            }

            lms[i] = minSum;
        }

        int total = sum;
        sum = 0;

        int[] rms = new int[A.length];
        minSum = Integer.MAX_VALUE;

        for (int i = A.length - 1; i >= 0; i--) {
            sum += A[i];
            if (sum < minSum) {
                minSum = sum;
            }
            rms[i] = minSum;
        }

        int result = Integer.MIN_VALUE;

        for (int i = 1; i < A.length - 1; i++) {

            sum = total - A[i] - lms[i - 1] - rms[i + 1];
            if (result < sum) {
                result = sum;
            }
        }

        return result;
    }
}
