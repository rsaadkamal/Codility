package com.codility.L15_Caterpiller_Method;

/*
* Let A be a non-empty array consisting of N integers.

The abs sum of two for a pair of indices (P, Q) is the absolute value |A[P] + A[Q]|, for 0 ≤ P ≤ Q < N.

For example, the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3

has pairs of indices (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2).
The abs sum of two for the pair (0, 0) is A[0] + A[0] = |1 + 1| = 2.
The abs sum of two for the pair (0, 1) is A[0] + A[1] = |1 + 4| = 5.
The abs sum of two for the pair (0, 2) is A[0] + A[2] = |1 + (−3)| = 2.
The abs sum of two for the pair (1, 1) is A[1] + A[1] = |4 + 4| = 8.
The abs sum of two for the pair (1, 2) is A[1] + A[2] = |4 + (−3)| = 1.
The abs sum of two for the pair (2, 2) is A[2] + A[2] = |(−3) + (−3)| = 6.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the minimal abs sum of two for any pair of indices in this array.

For example, given the following array A:

  A[0] =  1
  A[1] =  4
  A[2] = -3
the function should return 1, as explained above.

Given array A:

  A[0] = -8
  A[1] =  4
  A[2] =  5
  A[3] =-10
  A[4] =  3
the function should return |(−8) + 5| = 3.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


import java.util.Arrays;

public class MinAbsSumOfTwo {


    /*
     * solution - a
     */
    public static int solution(int[] A) {

        /*
         * int[] A = {1, 4, -3}
         * */
        Arrays.sort(A);

        return getMinSum(A);
    }

    public static int getMinSum(int[] A) {

        /*
         * all positives
         * */
        if (A[0] >= 0) {
            return A[0] * 2;
        }

        /*
         * all negatives
         * */
        if (A[A.length - 1] <= 0) {
            return -A[A.length - 1] * 2;
        }

        int end = A.length - 1;
        int start = 0;
        int min = Math.abs(A[start] + A[end]);

        while (start <= end) {

            int tmp = Math.abs(A[start] + A[end]);

            min = Math.min(min, tmp);

            if (Math.abs(A[start + 1] + A[end]) <= tmp) {
                start++;
            } else if (Math.abs(A[start] + A[end - 1]) <= tmp) {
                end--;
            } else {
                start++;
                end--;
            }
        }

        return min;
    }


    /*
     * solution - b
     */
    public static int solution1(int[] A) {

        Arrays.sort(A);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            min = Math.min(min, Math.abs(A[i] + findBestMatch(-A[i], A)));
        }

        return min;
    }

    public static int findBestMatch(int target, int[] A) {

        if (A.length == 1) {
            return A[0];
        }

        int begin = 0;
        int end = A.length - 1;

        while (begin <= end) {

            int middle = (begin + end) / 2;

            if (A[middle] == target) {
                return A[middle];
            }

            if (end - begin == 1) {
                return Math.abs(A[end] - target) < Math.abs(A[begin] - target) ? A[end] : A[begin];
            }

            if (A[middle] > target) {
                end = middle;
            } else {
                begin = middle;
            }
        }

        return A[0];
    }


    /*
     * solution - c
     */
    public int solution2(int[] A) {

        int N = A.length;
        Arrays.sort(A);

        int tail = 0;
        int head = N - 1;

        int minAbsSum = Math.abs(A[tail] + A[head]);

        while (tail <= head) {

            int currentSum = A[tail] + A[head];

            minAbsSum = Math.min(minAbsSum, Math.abs(currentSum));

            /*
             * If the sum has become positive, we
             * should know that the head can be moved
             * left
             * */
            if (currentSum <= 0) {
                tail++;
            } else {
                head--;
            }
        }

        return minAbsSum;
    }


    /*
     * solution - d
     */
    public int solution3(int[] A) {

        Arrays.sort(A);
        int j = A.length - 1;

        int result = Integer.MAX_VALUE;

        for (int value : A) {

            int best = Math.abs(value + A[j]);

            /*
             * beast min abs value for A is -A with j we move from the end to the
             * beginning of the array if abs starts growing, it will never be less
             * again so we find the best value for the i-th element A[i] <= A[i + 1],
             * so A[i + 1]-th best summand is to the left from A[i]-th it cannot be
             * to the right of j-th position (just draw A plot with x axis to see i)
             * */
            while (j > 0 && Math.abs(value + A[j - 1]) <= best) {
                j--;
                best = Math.abs(value + A[j]);
            }

            if (result > best) {
                result = best;
            }
        }

        return result;
    }
}
