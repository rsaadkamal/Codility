package com.codility.L6_Sorting;

/*
* We draw N discs on A plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write A function:

class Solution { public int solution1(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


import java.util.Arrays;

/**
 * Created by Chaklader on 6/24/18.
 */
public class NumberOfDiscIntersections {


    /*
        -------------------------------------------------------------------
        Type        Size        Bytes Range
        -------------------------------------------------------------------
        byte        1 byte      -128 to 127

        short       2 bytes     -32,768 to 32,767

        int         4 bytes     -2,147,483,648 to 2,147,483, 647 (2 x 10ˆ9)

        long        8 bytes     -9,223,372,036,854,775,808 to (9 x 10ˆ18)
        9,223,372,036,854,775,807

        float       4 bytes     approximately ±3.40282347E+38F
        (6-7 significant decimal digits)
        Java implements IEEE 754 standard

        double      8 Bytes     approximately ±1.79769313486231570E+308
        (15 significant decimal digits)

        char        2 byte      0 to 65,536 (unsigned)

        boolean not precisely defined   true or false
        -------------------------------------------------------------------
    * */


    /*
     * Compute the number of intersections in A sequence of discs.
     * The J-th disc is drawn with its center at (J, 0) and radius
     * A[J].
     *
     * PREMISE: if (i + A[i]) > (j - A[j]), the intersection occurs.
     *
     * */

    /*
     * solution1 - A
     * */
    public static int solution(int[] A) {

        int intersections = 0;

        for (int i = 0; i < A.length - 1; i++) {

            for (int j = i + 1; j < A.length; j++) {

                /*
                 * intersection occurs between the disks
                 * */
                if ((long) A[i] + i >= j - (long) A[j]) {

                    intersections++;

                    if (intersections > 10000000) {
                        return -1;
                    }
                }
            }
        }

        return intersections;
    }


    /*
     * solution1 - B
     * */
    /*
     * Time complexity is O(N*log(N)) or O(N). The largest value of right-A[right]
     * is n-1. We just need to find right-A[right] > 0 and how many i+A[i] is smaller
     * than it.
     * */
    public int solution1(int[] A) {

        int N = A.length;
        int[] sum = new int[N];


        for (int i = 0; i < N; i++) {

            int right;

            /*
             * If The right point is lesser than the largest center
             * or (i+A[i]) <= (N-1) let sum[i+A[i]]++, means there
             * is one disk that i+A[i]
             * */
            if (N - i - 1 >= A[i]) {
                right = i + A[i];
            }

            /*
             * IF i+A[i] > N-1
             * */
            else {
                right = N - 1;
            }

            sum[right]++;
        }

        /*
         * sum[i] means that there are sum[i] number of values that <= i
         * */
        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1];
        }

        long ans = (long) N * (N - 1) / 2;

        for (int i = 0; i < N; i++) {

            int left;

            if (A[i] > i) {
                left = 0;
            }

            /*
             * Find the positive i - A[i]
             * */
            else {
                left = i - A[i];
            }

            /*
             * Find the number that is smaller than 1-A[i], sum[N-1]
             * will never be used as we only need sum[N-1-1] at most
             * */
            if (left > 0) {
                ans -= sum[left - 1];//.
            }
        }

        if (ans > 10000000) {
            return -1;
        }

        return (int) ans;
    }


    /*
     * solution1 - c
     * */
    public int solution2(int[] A) {


        int N = A.length;

        long[] lefts = new long[N];
        long[] rights = new long[N];

        for (int i = 0; i < N; i++) {

            lefts[i] = (long) i - (long) A[i];
            rights[i] = (long) i + (long) A[i];
        }

        Arrays.sort(lefts);
        Arrays.sort(rights);

        int[] lm = new int[lefts.length];
        int v = 0;

        for (int i = lefts.length - 2; i >= 0; i--) {

            if (lefts[i] != lefts[i + 1]) {
                v = lefts.length - i - 1;
            }

            lm[i] = v;
        }

        v = 0;
        int[] rl = new int[rights.length];

        for (int i = 1; i < rights.length; i++) {

            if (rights[i - 1] != rights[i]) {
                v = i;
            }

            rl[i] = v;
        }

        int c = 0;

        for (int i = 0; i < N; i++) {

            long ar = (long) i + (long) A[i];

            int idx = Arrays.binarySearch(lefts, ar);
            int e;

            if (idx < 0) {
                idx = -1 - idx;
                e = A.length - idx;
            } else {
                e = lm[idx];
            }

            long al = (long) i - (long) A[i];

            idx = Arrays.binarySearch(rights, al);

            if (idx < 0) {
                idx = -1 - idx;
                e += idx;
            } else {
                e += rl[idx];
            }

            c = c + (A.length - e - 1);

            if (c > 20000000) {
                return -1;
            }
        }

        return c / 2;
    }
}
