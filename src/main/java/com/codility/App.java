package com.codility;


import java.util.*;
import java.util.stream.IntStream;

public class App {


    public static int solution(int[] A) {

        int N = A.length;

        int[] maxStartingHere = new int[N];
        int[] maxEndingHere = new int[N];

        int maxSum = 0;

        for (int i = 1; i < N - 1; ++i) {

            maxSum = Math.max(0, A[i] + maxSum);
            maxEndingHere[i] = maxSum;
        }

        maxSum = 0;

        for (int i = N - 2; i > 0; --i) {

            maxSum = Math.max(0, A[i] + maxSum);
            maxStartingHere[i] = maxSum;
        }

        int maxDoubleSlice = 0;

        for (int i = 0; i < N - 2; ++i) {
            maxDoubleSlice = Math.max(maxDoubleSlice, maxEndingHere[i] + maxStartingHere[i + 2]);
        }

        return maxDoubleSlice;

    }

    public static void main(String[] args) {

        int[] A = {3, 2, 6, -1, 4, 5, -1, 2};
        System.out.println(solution(A));

    }
}
