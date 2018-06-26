package com.codility.L5_Prefix_Sums;

/*
* A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */

/**
 * Created by Chaklader on 6/23/18.
 */
public class MinAvgTwoSlice {

    /*
     * The goal is to find the starting
     * position of a slice whose average
     * is minimal.
     * */

    /*
     * solution - a
     * */
    public static int solution(int[] A) {

        /*
		ALGORITHM
		---------

		PREMISE: The slice provides the min average will formed of 2 to 3 elements

			0.   Define the startIndex = 0 and endIndex = 1
			i.   Get the avg for the initial 2 elments (with these indexs)
			ii.  Get the avg for the initial 3 elments by moving the end index one step
			iii. Update the result comparing them
			iv.  Move forward the endIndex 1 step and repeat the process x
        */

        /*
         * initially, define a demo slice and minimal
         * average for slice. Then, keep it updating
         * by moving forward.
         * */

        int startIndex = 0;
        int endIndex = 1;

        int resultIndex = 0;
        int currentSum = A[0] + A[1];

        double min = (double) currentSum / 2;
        double temporaryMin = min;

        while (true) {

            /*
             * when there is a slice with 2 element,
             * move forward the end index by one step
             * and make a 3 element slice.
             * */
            if (endIndex - startIndex == 1) {

                endIndex++;

                if (endIndex == A.length) {
                    return resultIndex;
                }

                currentSum += A[endIndex];
            }

            /*
             * we have a 3 element slice. Update that to
             * a 2 element slice by removing the start
             * element
             * */
            else {
                currentSum -= A[startIndex];
                startIndex++;
            }

            temporaryMin = (double) currentSum / (endIndex - startIndex + 1);

            if (temporaryMin < min) {
                resultIndex = startIndex;
                min = temporaryMin;
            }
        }
    }


    /*
     * solution - b
     * */
    public static int solution1(int[] A) {

        int startIndex = 0;
        double min = (double) (A[0] + A[1]) / 2;

        for (int j = 0; j < A.length - 2; j++) {

            if ((double) (A[j] + A[j + 1]) / 2 < min) {
                min = (double) (A[j] + A[j + 1]) / 2;
                startIndex = j;
            }

            if ((double) (A[j] + A[j + 1] + A[j + 2]) / 3 < min) {
                min = (double) (A[j] + A[j + 1] + A[j + 2]) / 3;
                startIndex = j;
            }
        }

        if ((double) (A[A.length - 1] + A[A.length - 2]) / 2 < min) {
            return A.length - 2;
        }

        return startIndex;
    }


    /*
     * solution - c
     */
    public int solution2(int[] A) {

        double minAvg = 100000;
        int index = 0;

        if (A.length <= 2) {
            return 0;
        }

        for (int i = 0; i < A.length - 2; i++) {

            if ((A[i] + A[i + 1]) / 2.0 < minAvg) {
                minAvg = (A[i] + A[i + 1]) / 2.0;
                index = i;
            }

            if ((A[i] + A[i + 1] + A[i + 2]) / 3.0 < minAvg) {

                minAvg = (A[i] + A[i + 1] + A[i + 2]) / 3.0;
                index = i;
            }
        }

        int aMax = A.length - 2;

        if ((A[aMax] + A[aMax + 1]) / 2.0 < minAvg) {

            minAvg = (A[aMax] + A[aMax + 1]) / 2.0;
            index = aMax;
        }

        return index;
    }
}
