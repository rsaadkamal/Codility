package com.codility.Interview;

/*
*
* // PROBLEM 1

/*
You are playing A game with N cards. On each side of each card A positive integer is written.
The score of the game is smallest positive integer that doesn't appear on the cards' front
faces. You may decide which cards you want to flip over. Having flipped them, you then read
the numbers on the front faces of all the cards. What is the minimum game score you can achieve?
Write A function: class Solution { public int solution1(int[] A, int[] B); } that, given two
arrays of integers A and B, both of length N, describing the numbers written on the fronts and
 backs of all the cards, returns the minimum possible game score. For example,
 given A = [1, 2, 4, 3] and B = [1, 3, 2, 3], your function should return 2, as we could
 flip second card such that the front-facing numbers were [1, 3, 4, 3] and the smallest
 positive integer excluded from this sequence is 2. Given A = [3, 2, 1, 6, 5] and
 B = [4, 2, 1, 3, 3], your function should return 3, as we could flip first card such that
 the front-facing numbers were [4, 2, 1, 6, 5]. Given A = [1, 2] and B = [1, 2] your function
 should return 3, as no matter how we flip the cards the front-facing numbers will be [1, 2].
 Assume that: N is an integer within the range [1..100,000]; each element of arrays A, B is
 an integer within the range [1..100,000]; input arrays are of equal size. Complexity:
 expected worst-case time complexity is O(N); expected worst-case space complexity is O(N)
 (not counting the storage required for input arguments).
*/


import java.util.Arrays;

/**
 * Created by Chaklader on 7/5/18.
 */
public class A {


    public static int solution(int[] A, int[] B) {

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


    /* Find the smallest positive missing
       number in an array that contains
       both positive and negative integers */
    public static int findMissing(int A[]) {

        int size = A.length;

        // First separate positive and
        // negative numbers
        int shift = segregate(A, size);
        int arr2[] = new int[size - shift];

        int j = 0;

        for (int i = shift; i < size; i++) {
            arr2[j] = A[i];
            j++;
        }

        // Shift the array and call
        // findMissingPositive for
        // positive part
        return findMissingPositive(arr2, j);
    }


    /* Utility function that puts all non-positive
       (0 and negative) numbers on left side of
       arr[] and return count of such numbers */
    public static int segregate(int arr[], int size) {
        int j = 0, i;
        for (i = 0; i < size; i++) {
            if (arr[i] <= 0) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                // increment count of non-positive
                // integers
                j++;
            }
        }

        return j;
    }

    /* Find the smallest positive missing
       number in an array that contains
       all positive integers */
    public static int findMissingPositive(int arr[], int size) {
        int i;

        // Mark arr[i] as visited by making
        // arr[arr[i] - 1] negative. Note that
        // 1 is subtracted because index start
        // from 0 and positive numbers start from 1
        for (i = 0; i < size; i++) {
            if (Math.abs(arr[i]) - 1 < size && arr[Math.abs(arr[i]) - 1] > 0)
                arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
        }

        // Return the first index value at which
        // is positive
        for (i = 0; i < size; i++)
            if (arr[i] > 0)
                return i + 1;  // 1 is added becuase indexes
        // start from 0

        return size + 1;
    }
}
