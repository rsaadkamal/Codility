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
     * solution - A
     * */
    public int solution(int[] A) {

        int N = A.length;
        int[] container = new int[N + 2];

        for (int i = 0; i < N; i++) {
            container[A[i]] = 1;
        }

        for (int i = 1; i < (N + 2); i++) {

            if (container[i] == 0) {
                return i;
            }
        }

        return -1;
    }


    /*
     * solution - B
     * */
    public int solution1(int[] A) {

        int N = A.length + 2;
        long sum = N * (N + 1) / 2;

        for (final int a : A) {
            sum -= a;
        }

        return (int) sum;
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

        int sum = (N + 1) * (N + 2) / 2;
        return (sum - tSum);
    }


    /*
     * solution - d
     */
    /*
     * If A[i]= n, then set A[n-1] = 0. The space j !=0, then return (j+1) is missing
     * */
    public int solution4(int[] A) {


        for (int i = 0; i < A.length; i++) {

            if (A[i] == 0) {
                continue;
            }

            int index = A[i] - 1;

            while (index != -1 && index < A.length) {

                int next = A[index] - 1;

                A[index] = 0;
                index = next;
            }
        }

        for (int i = 0; i < A.length; i++) {

            if (A[i] != 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }


    public int solution5(int[] A) {

        int n = A.length + 1;
        //https://en.wikipedia.org/wiki/1_%2B_2_%2B_3_%2B_4_%2B_%E2%8B%AF
        //BigInteger is cheating
        BigInteger formula = BigInteger.valueOf(n).multiply(BigInteger.valueOf((n + 1))).divide(BigInteger.valueOf(2));
        BigInteger sum = BigInteger.valueOf(0);
        for (int number : A) {
            sum = sum.add(BigInteger.valueOf(number));
        }
        return formula.subtract(sum).intValue();
    }
}
