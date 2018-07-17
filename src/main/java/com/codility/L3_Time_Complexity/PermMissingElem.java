package com.codility.L3_Time_Complexity;

/*
* An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write A function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Assume that:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(1) (not counting the storage required for input arguments).
* */


import java.math.BigInteger;

/**
 * Created by Chaklader on 6/23/18.
 */
public class PermMissingElem {


    /*
     * sorting algorithm such as quick sort has time
     * complexity of O(N log(N)) which is greater than
     * O(N)
     * */

    /*
     * solution - a
     */
    /*
     * expected worst-case time complexity is O(N) and space complexity is O(1)
     * */
    public static int solution(int[] A) {

        // cant use additional storage
        // int N = A.length;

        for (int i = 0; i < A.length; i++) {

            // if we already put a 0 in the index, just skip this index
            if (A[i] == 0) {
                continue;
            }

            int index = A[i] - 1;

            /*
             * there must be numbers with index lass than N. We will
             * omit other numbers as not relevant for the solution
             * */
            // A = [2, 3, 1, 5]

            /*
             *
             * Algorithm
             * ---------
             *
             * i.   take the value of index and converted to an updated index
             * ii.  put 0 to the updated index
             * iii. keep in iterating with the updated index
             *
             * */
            while (index != -1 && index < A.length) {

                int updatedIndex = A[index] - 1;

                A[index] = 0;
                index = updatedIndex;
            }
        }

        for (int i = 0; i < A.length; i++) {

            if (A[i] != 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }


    /*
     * solution - b
     * */
    public int solution1(int[] A) {

        int N = A.length + 2;

        /*
         * we range of numbers within [1..(N + 1)]
         * */
        int sum = N * (N + 1) / 2;

        for (int a : A) {
            sum -= a;
        }

        return sum;
    }


    /*
     * solution - c
     */
    public int solution2(int[] A) {

        int tSum = 0;
        int N = A.length;

        for (int i = 0; i < N; i++) {
            tSum = tSum + A[i];
        }

        /*
         * the largest value within the range of [1..(N + 1)] is (N+1)
         * */
        int sum = (N + 1) * (N + 2) / 2;

        return (sum - tSum);
    }


    /*
     * solution - e
     */
    public int solution5(int[] A) {

        int N = A.length;

        /*
         * the largest value would be (N+1). We need an array of (N+2)
         * spaces that can accommodate the index value of (N+1)
         * */
        int[] C = new int[N + 2];

        for (int i = 0; i < N; i++) {
            C[A[i]] = -1;
        }

        /*
         * search from the index of 1 to upward
         * */
        for (int i = 1; i < (N + 2); i++) {

            if (C[i] == 0) {
                return i;
            }
        }

        return -1;
    }


    /*
     * solution - f
     */
    public int solution6(int[] A) {

        int N = A.length + 1;

        BigInteger formula = BigInteger.valueOf(N).multiply(BigInteger.valueOf((N + 1))).divide(BigInteger.valueOf(2));
        BigInteger sum = BigInteger.valueOf(0);

        for (int a : A) {
            sum = sum.add(BigInteger.valueOf(a));
        }

        return formula.subtract(sum).intValue();
    }


    public static void main(String[] args) {

        int[] A = {2, 3, 1, 5};
        System.out.println(solution(A));
    }
}
