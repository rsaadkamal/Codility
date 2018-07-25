package com.codility;


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

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by Chaklader on 7/6/18.
 */
public class App {


    public static int solution(int[] A) {

        int N = A.length;

        int[] sum = new int[N];

        for (int i = 0; i < N; i++) {

            int right;

            if (i + A[i] <= N - 1) {
                right = i + A[i];
            } else {
                right = N - 1;
            }

            sum[right]++;
        }


        for (int i = 1; i < N; i++) {
            sum[i] += sum[i - 1];
        }

        int total = (N * (N - 1)) / 2;

        for (int j = 0; j < N; j++) {

            int left;

            if (j - A[j] < 0) {
                left = 0;
            } else {
                left = j - A[j];
            }

            if (left > 0) {
                total -= sum[left - 1];
            }
        }

        return total;
    }


    public static void main(String[] args) {

        int[] A = new int[6];

        A[0] = 1;
        A[1] = 5;
        A[2] = 2;
        A[3] = 1;
        A[4] = 4;
        A[5] = 0;
    }
}

