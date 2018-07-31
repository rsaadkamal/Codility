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

import com.codility.L1_Iterations.BinaryGap;

import java.math.*;
import java.util.*;

/**
 * Created by Chaklader on 7/6/18.
 */
public class App {


    public static int solution(int[] A) {

        int N = A.length;

        List<Integer> peaks = new ArrayList<>();

        int size = 0;

        for (int i = 1; i < N - 1; i++) {

            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
                size++;
            }
        }

        int low = 1;
        int high = size;

        int result = 0;

        while (low <= high) {

            int k = (low + high) / 2;

            int marked = peaks.get(0);

            int count = 0;


            for (int i = 0; i < size; i++) {

                if (peaks.get(i) >= marked) {

                    count++;
                    marked = peaks.get(i) + k;

                    if (count == k) {
                        break;
                    }
                }
            }

            if (count == k) {
                result = count;
                low = k + 1;
            } else {
                high = k - 1;
            }
        }

        return result;
    }


    public static void main(String[] args) {


        int[] A = new int[12];

        A[0] = 1;
        A[1] = 5;
        A[2] = 3;
        A[3] = 4;
        A[4] = 3;
        A[5] = 4;
        A[6] = 1;
        A[7] = 2;
        A[8] = 3;
        A[9] = 4;
        A[10] = 6;
        A[11] = 2;


        System.out.println(solution(A));
    }
}

