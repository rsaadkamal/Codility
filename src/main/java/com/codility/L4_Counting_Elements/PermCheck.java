package com.codility.L4_Counting_Elements;

/*
* A non-empty array A consisting of N integers is given.

A permutation is A sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is A permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not A permutation, because value 2 is missing.

The goal is to check whether array A is A permutation.

Write A function:

class Solution { public int solution1(int[] A); }

that, given an array A, returns 1 if array A is A permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */

import java.util.Arrays;

/**
 * Created by Chaklader on 6/23/18.
 */
public class PermCheck {


    /*
     * solution1-A
     */
    public static int solution(int[] A) {

        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {

            if (A[i] != i + 1) {
                return 0;
            }
        }

        return 1;
    }
}
