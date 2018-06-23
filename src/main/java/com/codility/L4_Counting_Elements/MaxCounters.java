package com.codility.L4_Counting_Elements;


/*
* You are given N counters, initially set to 0, and you have two possible operations on
* them:

increase(X) − counter X is increased by 1,
getMaxElement counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is getMaxElement counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

The sequence should be returned as:

a structure Results (in C), or
a vector of integers (in C++), or
a record Results (in Pascal), or
an array of integers (in any other programming language).
For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

Assume that:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
Complexity:

expected worst-case time complexity is O(N+M);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


/**
 * Created by Chaklader on 6/23/18.
 */
public class MaxCounters {

    /*
     * If A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
     * If A[K] = N + 1 then operation K is getMaxElement counter.
     *
     * Assume that:
     *
     * N and M are integers within the range [1..100,000];
     * Each element of array A is an integer within the range [1..N + 1].
     * */


    /*
     * solution - a
     */
    public static int[] solution(int N, int[] A) {

        int[] counters = new int[N];

        int currMax = 0;
        int currMin = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] <= N) {

                counters[A[i] - 1] = Math.max(currMin, counters[A[i] - 1]);
                counters[A[i] - 1]++;

                currMax = Math.max(currMax, counters[A[i] - 1]);
            } else if (A[i] == N + 1) {
                currMin = currMax;
            }
        }

        for (int i = 0; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], currMin);
        }

        return counters;
    }


    /*
     * solution - b
     */
    public int[] solution1(int N, int[] A) {

        int P[] = new int[N];

        for (int i = 0; i < A.length; i++) {

            if (A[i] == N + 1) {
                maxCounter(P);
            } else {
                P[A[i] - 1]++;
            }
        }

        return P;
    }

    /*
     * set max to all the elements of the matrix
     * */
    public void maxCounter(int[] P) {

        int maxNo = getMaxElement(P);

        for (int i = 0; i < P.length; i++) {
            P[i] = maxNo;
        }
    }

    /*
     * get the max value of the matrix
     * */
    public int getMaxElement(int[] P) {

        int largest = P[0];

        for (int i = 1; i < P.length; i++) {
            if (P[i] > largest) {
                largest = P[i];
            }
        }

        return largest;
    }


    /*
     * solution - c
     */
    /*
     * Improve the previous method, time complexity is O(N+M).
     * Keep the lastUpdate as the lasgest value in the last
     * round
     * */
    public int[] solution2(int N, int[] A) {

        int P[] = new int[N];
        int max = 0;
        int lastUpdate = 0;

        for (int i = 0; i < A.length; i++) {

            if (A[i] < N + 1) {
                if (P[A[i] - 1] < lastUpdate) {
                    P[A[i] - 1] = lastUpdate + 1;
                } else {
                    P[A[i] - 1]++;
                }
                max = Math.max(max, P[A[i] - 1]);
            } else if (A[i] == N + 1) {
                lastUpdate = max;
            }
        }

        for (int i = 0; i < N; i++) {
            if (P[i] < lastUpdate) {
                P[i] = lastUpdate;
            }
        }
        return P;
    }


    /*
     * solution - d
     */
    public int[] solution3(int N, int[] A) {

        int max = 0;
        int setMax = 0;

        int[] result = new int[N];

        for (int a : A) {

            if (a >= 1 && a <= N) {

                int ci = a - 1;

                if (result[ci] < setMax) {
                    result[ci] = setMax;
                }

                result[ci]++;

                if (result[ci] > max) {
                    max = result[ci];
                }
            } else if (a == N + 1) {
                setMax = max;
            }
        }

        for (int i = 0; i < N; i++) {

            if (result[i] < setMax) {
                result[i] = setMax;
            }
        }

        return result;
    }
}
