package com.codility.L14_Binary_Search_Algorithm;

/*
* You are given integers K, M and a non-empty array A consisting of N integers. Every element of the array is not greater than M.

You should divide this array into K blocks of consecutive elements. The size of the block is any integer between 0 and N. Every element of the array should belong to some block.

The sum of the block from X to Y equals A[X] + A[X + 1] + ... + A[Y]. The sum of empty block equals 0.

The large sum is the maximal sum of any block.

For example, you are given integers K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
The array can be divided, for example, into the following blocks:

[2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
[2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
[2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
[2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.

Write a function:

class Solution { public int solution(int K, int M, int[] A); }

that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.

For example, given K = 3, M = 5 and array A such that:

  A[0] = 2
  A[1] = 1
  A[2] = 5
  A[3] = 1
  A[4] = 2
  A[5] = 2
  A[6] = 2
the function should return 6, as explained above.

Assume that:

N and K are integers within the range [1..100,000];
M is an integer within the range [0..10,000];
each element of array A is an integer within the range [0..M].
Complexity:

expected worst-case time complexity is O(N*log(N+M));
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
* */


/*
* Task Score 100%
* Correctness 100%
* Performance 100%
* /


/**
 * Created by Chaklader on 6/28/18.
 */
public class MinMaxDivision {

    /*
     * You should divide this array into K blocks of consecutive elements.
     * The size of the block is any integer between 0 and N. Every element
     * of the array should belong to some block. The goal is to minimize the
     * large sum.
     * */

    /*
     * solution -a
     */
    public static int solution(int K, int M, int[] A) {


        int sum = 0;
        int max = 0;

        /*
         * Get the sum and miximum value of the provided array
         * */
        for (int i = 0; i < A.length; i++) {
            max = max >= A[i] ? max : A[i];
            sum += A[i];
        }

        /*
         * Get an approximate value for the large sum for
         * a block. We will do the optimization later
         * */
        int idealMin = Math.max((int) Math.ceil((double) sum / K), max);

        return searchI(idealMin, sum, A, K);
    }


    /*
     * conduct a binary search iteratively
     * to minimize the large sum
     * */
    public static int searchI(int min, int max, int[] A, int K) {

        int minimizedLargedSum = 0;

        int minimumValue = min;
        int maximumValue = max;

        while (minimumValue <= maximumValue) {

            int middle = (minimumValue + maximumValue) / 2;

            if (verify(middle, A, K)) {
                maximumValue = middle - 1;
                minimizedLargedSum = middle;
            } else {
                minimumValue = middle + 1;
            }
        }

        return minimizedLargedSum;
    }


    /*
     * conduct a binary search recursively
     * */
    public static int searchR(int min, int max, int[] A, int K) {

        if (max - min < 2) {

            if (verify(min, A, K)) {
                return min;
            } else {
                return max;
            }
        }

        int middle = (min + max) / 2;

        if (verify(middle, A, K)) {
            return searchR(min, middle, A, K);
        } else {
            return searchR(middle, max, A, K);
        }
    }


    public static boolean verify(int middle, int[] A, int K) {

        int sliceSum = 0;

        int countOfBlocks = 1;

        int N = A.length;

        /*
         * check if we can divide the array in K parts with sum
         * of each part <= proposed value (ie middle)
         */
        for (int i = 0; i < N; i++) {

            if (sliceSum + A[i] <= middle) {
                sliceSum += A[i];
            } else {

                countOfBlocks++;
                sliceSum = A[i];

                if (countOfBlocks > K) {
                    return false;
                }
            }
        }

        return true;
    }


    /*
     * solution - b
     */
    public int solution1(int K, int M, int[] A) {

        int min = 0;
        int max = 0;

        /*
         * get the sum as max, and the largest number as min
         * */
        for (int i = 0; i < A.length; i++) {
            max += A[i];
            min = Math.max(min, A[i]);
        }

        int result = max;

        while (min <= max) {

            int mid = (min + max) / 2;
            if (divisionSolvable(mid, K - 1, A)) {
                max = mid - 1;
                result = mid;
            } else {
                min = mid + 1;
            }
        }

        return result;
    }


    private boolean divisionSolvable(int mid, int k, int[] a) {

        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if (sum > mid) {
                sum = a[i];
                k--;
            }
            if (k < 0) {
                return false;
            }
        }

        return true;
    }


    /*
     * solution - c
     */
    public int solution2(int K, int M, int[] A) {

        int max = 0;
        int sum = 0;

        for (int value : A) {

            if (value > max) {
                max = value;
            }
            sum += value;
        }

        /*
         * two trivial cases. if K is 1, then
         * all the elements inside one group
         * */
        if (K == 1) {
            return sum;
        }


        /*
         * If K is more than number of elements, some of them may be empty,
         * but, all the elements may be split to the groups of 1 element.
         * large sum will be equal to max element value.
         * */
        if (K >= A.length) {
            return max;
        }


        /*
         * The result is somewhere between max(n) and sum(n). use binary search to
         * find the correct one. max value of sum is n * M, max(n) can be 0 if all
         * the elements are 0. So at most we perform binary search on the interval
         * from 0 to n * M which is O(log(n * M))
         * */
        int begin = max;
        int end = sum;
        int result = sum;


        /*
         * time complexity is O(n * log(M * n)) in total
         * */
        while (begin <= end) {

            int medium = (begin + end) / 2;

            if (isDivisible(A, medium, K)) {
                result = medium;
                end = medium - 1;
            } else {
                begin = medium + 1;
            }
        }

        return result;
    }


    /*
     * time complexity is O(n) in total
     * */
    private boolean isDivisible(int[] a, int size, int k) {

        int sum = 0;
        int stepsLeft = k - 1; // first is started already

        for (int value : a) {

            sum += value;

            if (sum > size) {
                sum = value;
                stepsLeft--;
            }
        }

        return stepsLeft >= 0;
    }
}
