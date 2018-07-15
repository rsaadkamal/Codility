package com.codility.L4_Counting_Elements;


/*
* A small frog wants to get to the other side of A river. The frog is initially located on one bank of the river (position 0) and wants to get to the opposite bank (position X+1). Leaves fall from A tree onto the surface of the river.

You are given an array A consisting of N integers representing the falling leaves. A[K] represents the position where one leaf falls at time K, measured in seconds.

The goal is to find the earliest time when the frog can jump to the other side of the river. The frog can cross only when leaves appear at every position across the river from 1 to X (that is, we want to find the earliest moment when all the positions from 1 to X are covered by leaves). You may assume that the speed of the current in the river is negligibly small, i.e. the leaves do not change their positions once they fall in the river.

For example, you are given integer X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
In second 6, A leaf falls into position 5. This is the earliest time when leaves appear in every position across the river.

Write A function:

class Solution { public int solution(int X, int[] A); }

that, given A non-empty array A consisting of N integers and integer X, returns the earliest time when the frog can jump to the other side of the river.

If the frog is never able to jump to the other side of the river, the function should return −1.

For example, given X = 5 and array A such that:

  A[0] = 1
  A[1] = 3
  A[2] = 1
  A[3] = 4
  A[4] = 2
  A[5] = 3
  A[6] = 5
  A[7] = 4
the function should return 6, as explained above.

Assume that:

N and X are integers within the range [1..100,000];
each element of array A is an integer within the range [1..X].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(X) (not counting the storage required for input arguments).
* */


import java.util.Arrays;

/**
 * Created by Chaklader on 6/23/18.
 */
public class FrogRiverOne {


    /*
     * solution - A
     * */
    public static int solution(int[] A, int X) {

        int distanceFilled = 0;

        boolean[] hasLeaf = new boolean[X + 1];

        for (int i = 0; i < A.length; i++) {

            if (!hasLeaf[A[i]] && A[i] <= X) {
                hasLeaf[A[i]] = true;
                distanceFilled++;
            }

            if (distanceFilled == X) {
                return i;
            }
        }

        return -1;
    }


    /*
     * solution - B
     * */
    public int solution1(int X, int[] A) {


        int count = X;
        int[] positions = new int[X];

        for (int spaceIndex = 0; spaceIndex < X; spaceIndex++) {
            positions[spaceIndex] = -1;
        }

        for (int timeIndex = 0; timeIndex < A.length; timeIndex++) {

            if (positions[A[timeIndex] - 1] == -1) {

                positions[A[timeIndex] - 1] = 1;
                count--;

                if (count == 0) {
                    return timeIndex;
                }
            }
        }

        return -1;
    }


    /*
     * solution - c
     * */
    public int solution(int X, int[] A) {

        int[] positions = new int[X];

        int distance = X;
        int i;

        for (i = 0; distance != 0 && i < A.length; i++) {

            if (A[i] <= X && positions[A[i] - 1] == 0) {
                positions[A[i] - 1] = 1;
                distance--;
            }
        }

        if (distance > 0) {
            return -1;
        }

        return i - 1;
    }


    public int solution4(int X, int[] A) {

        int path[] = new int[X];
        int sum = X * (X + 1) / 2;
        int pathSum = 0;
        Arrays.fill(path, -1);
        for (int i = 0; i < A.length; i++) {
            if (path[A[i] - 1] == -1) {
                path[A[i] - 1] = A[i];
                pathSum += A[i];
            }
            if (pathSum == sum) {
                return i;
            }
        }
        return -1;
    }
}
