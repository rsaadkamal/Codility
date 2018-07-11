package com.codility.L16_Greedy_Algorithms.TieRopes;

public class Solution {
    public int solution(int K, int[] A) {

        int counter = 0;
        int sum = 0;
        for (int i : A) {
            sum += i;
            if (sum >= K) {
                sum = 0;
                counter++;
            }
        }
        return counter;
    }
}
