package com.codility.L11_Sieve_Of_Eratosthenes.CountNonDivisible1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] solution(int[] A) {
        int[] copy = A.clone();
        Arrays.sort(copy);
        HashMap<Integer, ArrayList<Integer>> factors = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            //find all factors for a number
            ArrayList<Integer> currentFactors = new ArrayList<>();
            for (int j = 1; j <= Math.sqrt(A[i]); j++) {
                if (A[i] % j == 0) {
                    currentFactors.add(j);
                    if (j != A[i] / j) {
                        currentFactors.add(A[i] / j);
                    }
                }
            }
            factors.put(A[i], currentFactors);
        }
        ArrayList<Integer> one = new ArrayList<Integer>();
        one.add(1);
        factors.put(1, one);

        HashMap<Integer, Integer> distinct = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            if (distinct.containsKey(A[i])) {
                distinct.put(A[i], distinct.get(A[i]) + 1);
            } else {
                distinct.put(A[i], 1);
            }
        }

        int[] answer = new int[A.length];
        Arrays.fill(answer, A.length);
        for (int i = 0; i < A.length; i++) {
            ArrayList<Integer> currentFactors = factors.get(A[i]);
            for (int j = 0; j < currentFactors.size(); j++) {
                if (Arrays.binarySearch(copy, currentFactors.get(j)) >= 0) {
                    answer[i] -= distinct.get(currentFactors.get(j));
                }
            }
        }
        return answer;
    }
}