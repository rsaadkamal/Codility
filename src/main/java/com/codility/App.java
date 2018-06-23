package com.codility;


import java.util.*;

public class App {


    /*
    * If A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
	* If A[K] = N + 1 then operation K is max counter.
    * */
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


    public static void main(String[] args) {

        int[] A = new int[7];

        A[0] = 3;
        A[1] = 4;
        A[2] = 4;
        A[3] = 6;
        A[4] = 1;
        A[5] = 4;
        A[6] = 4;

        solution(5, A);
    }
}
