package com.codility.L13_Fibonacci_Numbers.FibFrog;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    /**
     * The task is very similar with the coin changing problem. It's a classical dynamic programming problem.
     * The recurrence  relation in this case is:
     * K[i] = 0, if i == 0;
     * K[i] = min(j<=F.length)(K[i-F[j]]+1), if i > 0  and ( A[i] == 1 or i == A.length)
     * where K[i] is a number of jumps on i'th position
     * F - fibonacci sequence
     * A - the map of banks
     */
    public int solution(int A[]) {
        if (A.length <= 2) {
            return 1;
        }
        int[] fibonacciSequence = getFibonacciSequence(A.length + 1);
        int[] dynamicalMap = new int[A.length + 2];
        Arrays.fill(dynamicalMap, -1);
        dynamicalMap[0] = 0;
        for (int i = 0; i <= A.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int fibSequenceElement : fibonacciSequence) {
                int index = i - fibSequenceElement + 1;
                if (index < 0) {
                    break;
                }
                if (dynamicalMap[index] != -1 && (i == A.length || A[i] == 1)) {
                    min = Math.min(dynamicalMap[index] + 1, min);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dynamicalMap[i + 1] = min;
            }
        }
        return dynamicalMap[A.length + 1];
    }

    private int[] getFibonacciSequence(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(2);
        int i = 2;
        while (result.get(i - 1) < n) {
            result.add(result.get(i - 1) + result.get(i - 2));
            i++;
        }
        return result.stream().mapToInt(a -> a).toArray();
    }
}
