package com.codility.L17_Dynamic_Programming;

/*
* For a given array A of N integers and a sequence S of N integers from the set {−1, 1}, we define val(A, S) as follows:

val(A, S) = |sum{ A[i]*S[i] for i = 0..N−1 }|

(Assume that the sum of zero elements equals zero.)

For a given array A, we are looking for such a sequence S that minimizes val(A,S).

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, computes the minimum value of val(A,S) from all possible values of val(A,S) for all possible sequences S of N integers from the set {−1, 1}.

For example, given array:

  A[0] =  1
  A[1] =  5
  A[2] =  2
  A[3] = -2
your function should return 0, since for S = [−1, 1, −1, 1], val(A, S) = 0, which is the minimum possible value.

Assume that:

N is an integer within the range [0..20,000];
each element of array A is an integer within the range [−100..100].
Complexity:

expected worst-case time complexity is O(N*max(abs(A))2);
expected worst-case space complexity is O(N+sum(abs(A))) (not counting the storage required for input arguments).
* */

import java.util.Arrays;

/**
 * Created by Chaklader on 7/6/18.
 */
public class MinAbsSum {


    /*
     * Given array of integers, find the lowest absolute sum of elements.
     * */

    /*
     * solution - A
     * */
    public int solution(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;

        // O(N)
        for (int i = 0; i < A.length; i++) {

            int value = Math.abs(A[i]);

            sum += value;

            if (max < value) {
                max = value;
            }

            A[i] = value;
        }

        /*
         * O(max(abs(A))) space but no more than
         * O(sum(abs(A))), so ignore it O(N)
         * */
        int[] counts = new int[max + 1];

        for (int value : A) {
            counts[value]++;
        }

        // O(sum(abs(A)))
        int[] r = new int[sum + 1];

        for (int i = 1; i < r.length; i++) {
            r[i] = -1;
        }

        /*
         * outer is O(max(abs(A))) inner is O(sum(abs(A))) which is
         * less than O(N * max(abs(A))) we don't care of 0 values
         * */
        for (int i = 1; i < counts.length; i++) {

            // we check r[j]. if it's not less than 0, then it means we've reached j value 
            // with previous steps, so no need to spend current
            // if it's less than 0, spend 1 current number if r[j - i] has been reached
            for (int j = 0; j < r.length; j++) {

                // negative value means we haven't reached this value, 
                // so we have to spend 1 current if we can
                if (r[j] >= 0) {
                    r[j] = counts[i];
                } else if (j - i >= 0 && r[j - i] > 0) {
                    r[j] = r[j - i] - 1;
                }

                /*
                 * the value in r[j] then means how many of the current
                 * values are left when we reached the value j
                 * */
            }
        }

        int result = sum;


        /*
         * don't have to traverse all the arrays, since i - the sum of elements.
         * if it's reachable then (sum - i) - reachable as well. so if the value
         * is reachable then the diff is abs(i - (sum - i)), which is the same as
         * abs(sum - 2 * i)
         * */
        for (int i = 0; i < r.length / 2 + 1; i++) {

            if (r[i] >= 0 && result > Math.abs(sum - 2 * i)) {

                result = Math.abs(sum - 2 * i);
            }
        }
        return result;
    }


    /*
     * solution - b
     * */
    public int solution1(int[] A) {

        if (A.length == 0) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;


        // O(N)
        for (int i = 0; i < A.length; i++) {

            int value = Math.abs(A[i]);

            sum += value;
            if (max < value) {
                max = value;
            }
            A[i] = value;
        }

        // O(max(abs(A))) space but no more than O(sum(abs(A))), so ignore it
        // O(N)
        int[] counts = new int[max + 1];
        for (int value : A) {
            counts[value]++;
        }

        // O(sum(abs(A)))
        int[] r = new int[sum + 1];
        for (int i = 1; i < r.length; i++) {
            r[i] = -1;
        }


        // outer is O(max(abs(A)))
        // inner is O(sum(abs(A))) which is less than O(N * max(abs(A)))
        // we don't care of 0 values
        for (int i = 1; i < counts.length; i++) {
            // we check r[j]. if it's not less than 0, then it means we've reached j value with previous steps, so no need to spend current
            // if it's less than 0, spend 1 current number if r[j - i] has been reached
            for (int j = 0; j < r.length; j++) {
                // negative value means we haven't reached this value, so we have to spend 1 current if we can
                if (r[j] >= 0) {
                    r[j] = counts[i];
                } else if (j - i >= 0 && r[j - i] > 0) {
                    r[j] = r[j - i] - 1;
                }
                // the value in r[j] then means how many of the current values are left when we reached the value j
            }
        }
        int result = sum;
        // don't have to traverse all the arrays, since i - the sum of elements. if it's reachable then (sum - i) - reachable as well.
        // so if the value is reachable then the diff is abs(i - (sum - i)), which is the same as abs(sum - 2 * i)
        for (int i = 0; i < r.length / 2 + 1; i++) {
            if (r[i] >= 0 && result > Math.abs(sum - 2 * i)) {
                result = Math.abs(sum - 2 * i);
            }
        }
        return result;
    }


    /*
     * solution - c
     * */
    public int solution2(int[] A) {

        int sum = 0;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            A[i] = Math.abs(A[i]);
            sum += A[i];
            max = Math.max(A[i], max);
        }
        int[] map = new int[sum + 1];
        int[] count = new int[max + 1];

        Arrays.fill(count, 0);
        Arrays.fill(map, -1);

        for (int i = 0; i < A.length; i++) {
            count[A[i]] += 1;
        }

        map[0] = 0;

        for (int a = 1; a <= max; a++) {

            if (count[a] > 0) {
                for (int j = 0; j <= sum; j++) {
                    if (map[j] >= 0) {
                        map[j] = count[a];
                    } else if (j >= a && map[j - a] > 0) {
                        map[j] = map[j - a] - 1;
                    }
                }
            }
        }

        int result = sum;

        for (int i = 0; i < sum / 2 + 1; i++) {
            if (map[i] >= 0) {
                result = Math.min(result, sum - 2 * i);
            }
        }

        return result;
    }
}
