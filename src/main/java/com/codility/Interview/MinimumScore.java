package com.codility.Interview;


/*
You are playing A game with N cards. On each side of each card A positive integer is
written.
The score of the game is smallest positive integer that doesn't appear on the cards'
front faces.
You may decide which cards you want to flip over. Having flipped them, you then read

the numbers on the front faces of all the cards. What is the minimum game score you c
an achieve?


Write A function:

    class Solution {

        public int solution(int[] A, int[] B);
    }


that, given two arrays of integers A and B, both of length N, describing the numbers w
ritten on
the fronts and backs of all the cards, returns the minimum possible game score. For ex
ample,
 given A = [1, 2, 4, 3] and B = [1, 3, 2, 3], your function should return 2, as we cou
 ld
 flip second card such that the front-facing numbers were [1, 3, 4, 3] and the smalles
 t
 positive integer excluded from this sequence is 2. Given A = [3, 2, 1, 6, 5] and

 B = [4, 2, 1, 3, 3], your function should return 3, as we could flip first card such
 that
 the front-facing numbers were [4, 2, 1, 6, 5]. Given A = [1, 2] and B = [1, 2] your f
 unction
 should return 3, as no matter how we flip the cards the front-facing numbers will be
 [1, 2].
 Assume that: N is an integer within the range [1..100,000]; each element of arrays A,
  B is
 an integer within the range [1..100,000]; input arrays are of equal size. Complexity:

 expected worst-case time complexity is O(N); expected worst-case space complexity is
 O(N)
 (not counting the storage required for input arguments).
*/


import java.util.Arrays;


/**
 * Created by Chaklader on 7/5/18.
 */
public class MinimumScore {


    /*
     * solution - a
     * */
    public static int solution(int[] A, int[] B) {

        int N = A.length;

        int smallestPositive = getSmallestPositive(A);

        /*
         * as both of the array is same,  no chnage is required
         * */
        if (Arrays.equals(A, B)) {
            return smallestPositive;
        }

        for (int i = 0; i < N; i++) {

            if (A[i] == B[i] || A[i] > B[i]) {
                continue;
            }

            /*
             * A[i] is smaller than B[i]
             * */
            smallestPositive = A[i];
        }

        return smallestPositive;
    }


    /*
     * find the smallest positive missing number
     * */
    public static int getSmallestPositive(int[] A) {

        boolean[] counter = new boolean[A.length + 1];

        for (int a : A) {

            /*
             * Each element of array A is an integer within the range [−1,000,000..1,000,000]
             * However, we will need to find the smallest positive integer and hence, don't need
             * to consider all the numbers.
             * */
            if (a > 0 && a < counter.length) {
                counter[a - 1] = true;
            }
        }

        for (int j = 0; j < counter.length; j++) {

            if (!counter[j]) {
                return j + 1;
            }
        }

        return A.length + 1;
    }


    /*
     * solution - b
     * */
    public static int solution1(int[] A, int[] B) {

        int N = A.length;

        /*
         * if two arrays are equal,
         * */
        if (Arrays.equals(A, B)) {
            return findMissing(A);
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {

            int store = A[i];
            A[i] = B[i];
            int value = findMissing(A);

            A[i] = store;

            min = value < min ? value : min;
        }

        return min;
    }


    /*
     * Find the smallest positive missing
     * number in an array that contains both
     * positive and negative integers
     * */
    public static int findMissing(int A[]) {

        int N = A.length;

        /*
         * First separate positive and negative numbers
         * */
        int shift = segregate(A, N);

        /*
         * array to store the numbers excl. the zero and negatives
         * */
        int B[] = new int[N - shift];

        int j = 0;

        for (int i = shift; i < N; i++) {
            B[j] = A[i];
            j++;
        }

        /*
         * array with numbers > zero
         * */
        return findMissingPositive(B, j);
    }


    /*
     * puts all non-positive (0 and negative) numbers on
     * left side of A[] and return count of such numbers
     * */
    public static int segregate(int[] A, int N) {

        int j = 0, i;

        for (i = 0; i < N; i++) {

            if (A[i] <= 0) {

                int temp;
                temp = A[i];

                A[i] = A[j];
                A[j] = temp;

                /*
                 * increment count of non-positive integers
                 * */
                j++;
            }
        }

        return j;
    }

    /*
     * Find the smallest positive missing number in
     * an array that contains all positive integers
     * */
    public static int findMissingPositive(int B[], int N) {

        /*
         * N = 4
         *
         * A= [5, 3, 1, 9]
         *
         * B= [-5, 3, -1, 9]
         * */


        /*
         * Mark B[i] as visited by making B[B[i] - 1] negative.
         * Note that 1 is subtracted because index start from 0 and
         * positive numbers start from 1
         * */
        for (int i = 0; i < N; i++) {

            /*
             * if there are dups, we need to make sure the index is positive
             * */
            int index = Math.abs(B[i]) - 1;

            if (index < N && B[index] > 0) {
                B[index] = -B[index];
            }
        }

        /*
         * Return the first index value at which is positive
         * */
        for (int i = 0; i < N; i++) {

            if (B[i] > 0) {

                /*
                 * 1 is added becuase indexes
                 * */
                return i + 1;
            }
        }

        /*
         * start from 0
         * */
        return N + 1;
    }
}
