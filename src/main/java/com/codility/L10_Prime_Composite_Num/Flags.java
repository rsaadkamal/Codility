package com.codility.L10_Prime_Composite_Num;

/*
* A non-empty array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
has exactly four peaks: elements 1, 3, 5 and 10.

You are going on A trip to A range of mountains whose relative heights are represented by array A, as shown in A figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.



Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

two flags, you can set them on peaks 1 and 5;
three flags, you can set them on peaks 1, 5 and 10;
four flags, you can set only three flags, on peaks 1, 5 and 10.
You can therefore set A maximum of three flags in this case.

Write A function:

class Solution { public int solution(int[] A); }

that, given A non-empty array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2
the function should return 3, as explained above.

Assume that:

N is an integer within the range [1..400,000];
each element of array A is an integer within the range [0..1,000,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */

import java.util.*;

/**
 * Created by Chaklader on 6/25/18.
 */
public class Flags {


    /*
     * Flags can only be set on peaks. What's more, if you take K flags, then the
     * distance between any two flags should be greater than or equal to K. The
     * distance between indices P and Q is the absolute value |P − Q|.
     *
     * Given A non-empty array A of N integers, returns the maximum number of flags
     * that can be set on the peaks of the array.
     * */

    // int[] A = {1,5,3,4,3,4,1,2,3,4,6,2}

    /*
     * solution -a
     */
    public static int solution(int[] A) {

        int N = A.length;

        /*
         * next =  [1, 1, 3, 3, 5, 5, 10, 10, 10, 10, 10, -1]
         * */
        int[] next = nextPeak(A);

        int i = 1;
        int result = 0;


        /*
         * This is for reducing the number of iteration
         * when N = 12 this will provide all the devisors
         * of N and i * i <= N or i <= N will also work.
         *
         * For i*i <= N, [1, 4, 9, 16, 25, 36, 49, 64, 81]
         * For i* (i-1) <= N, [0, 2, 6, 12, 20, 30, 42, 56, 72]
         * */
        while ((i - 1) * i <= N) {

            int posIndex = 0;
            int numberOfFlags = 0;

            while (posIndex < N && numberOfFlags < i) {

                /*
                 * next =  [1, 1, 3, 3, 5, 5, 10, 10, 10, 10, 10, -1]
                 * */
                posIndex = next[posIndex];

                /*
                 * we reached in the end
                 * */
                if (posIndex == -1) {
                    break;
                }

                numberOfFlags += 1;
                posIndex += i;
            }

            /*
             * maximize the number of flags for the whole segment
             * */
            result = Math.max(result, numberOfFlags);
            i++;
        }

        return result;
    }


    public static int[] nextPeak(int[] A) {

        int N = A.length;

        ArrayList<Integer> peaks = new ArrayList<Integer>();

        /*
         * List addition is deterministic and sequential
         * */
        for (int i = 1; i < A.length - 1; i++) {

            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int[] next = new int[N];
        next[N - 1] = -1;

        /*
         * result array [1, 1, 3, 3, 5, 5, 10, 10, 10, 10, 10, -1]
         * */
        for (int i = N - 2; i >= 0; i--) {
            if (peaks.contains(i)) {
                next[i] = i;
            } else {
                next[i] = next[i + 1];
            }
        }

        return next;
    }


    /*
     * solution - b
     */
    public int solution1(int[] A) {


        ArrayList<Integer> list = new ArrayList<Integer>();

        /*
         * add all the peaks in the list
         * */
        for (int i = 1; i < A.length - 1; i++) {

            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                list.add(i);
            }
        }

        int N = list.size();

        if (N == 0 || N == 1) {
            return list.size();
        }

        int startFlag = 1;
        int endFlag = N;

        int result = 1;

        /*
         * the number of flags will be between [1
         * to endFlag] and we use a binary search
         * */
        while (startFlag <= endFlag) {

            int middleFlag = (startFlag + endFlag) / 2;
            boolean success = false;

            int numOfUsedFlag = 0;
            int markedIndex = list.get(0);

            for (int i = 0; i < N; i++) {

                if (list.get(i) >= markedIndex) {

                    numOfUsedFlag++;
                    markedIndex = list.get(i) + middleFlag;

                    if (numOfUsedFlag == middleFlag) {
                        success = true;
                        break;
                    }
                }
            }

            if (success) {
                result = middleFlag;
                startFlag = middleFlag + 1;
            } else {
                endFlag = middleFlag - 1;
            }
        }

        return result;
    }


    /*
     * solution - c
     */
    public int solution2(int[] A) {

        if (A.length < 3) {
            return 0;
        }

        int[] nexts = new int[A.length];
        int next = A.length;

        nexts[A.length - 1] = A.length;
        int peaks = 0;

        for (int i = A.length - 2; i >= 1; i--) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                next = i;
                peaks++;
            }
            nexts[i] = next;
        }

        nexts[0] = next;
        if (peaks == 0) {
            return 0;
        }

        int result = 1;
        int start = nexts[0];

        int p = 1;
        int maxp = 1;

        while (maxp * maxp <= A.length) {
            maxp++;
        }

        /*
         * there might be A situation when the peaks are packed, for
         * intstance 010001000100010. sqrt(n) = 3, but the answer is 4
         * */
        if (maxp * maxp != A.length) {
            maxp++;
        }

        /*
         * cant be no more than total peaks
         * */
        if (peaks < maxp) {
            maxp = peaks;
        }

        /*
         * outer loop is O(sqrt(n)) and each inner loop is performed no
         * more than p which is no more than O(sqrt(n)) it gives total
         * O(n) complexity
         * */
        while (p <= maxp) {

            int setFlags = 0;

            for (int j = start; setFlags < p && j < A.length; j = (j + p < nexts.length ? nexts[j + p] : A.length)) {
                setFlags++;
            }

            if (result < setFlags) {
                result = setFlags;
            }

            p++;
        }

        return result;
    }
}
