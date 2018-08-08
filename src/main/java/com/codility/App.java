package com.codility;


import java.util.*;

public class App {


    public static int solution(int[] A) {


        int N = A.length;

        int low = 0;
        int high = N - 1;

        Arrays.sort(A);

        if (A[0] >= 0) {
            return 2 * A[0];
        }

        if (A[N - 1] <= 0) {
            return -2 * A[N - 1];
        }

        int min = Math.abs(A[low] + A[high]);

        while (low <= high) {

            int temp = Math.abs(A[low] + A[high]);

            min = min < temp ? min : temp;

            if (Math.abs(A[low + 1] + A[high]) <= temp) {

                low++;
            } else if (Math.abs(A[low] + A[high - 1]) <= temp) {

                high--;
            } else {

                low++;
                high--;
            }
        }

        return min;
    }

    public static void main(String[] args) {

        int[] B = new int[3];

        B[0] = 1;
        B[1] = 4;
        B[2] = -3;

        int[] A = new int[5];

        A[0] = -8;
        A[1] = 4;
        A[2] = 5;
        A[3] = -10;
        A[4] = 3;


        System.out.println(solution(B));
        System.out.println(solution(A));

    }
}

