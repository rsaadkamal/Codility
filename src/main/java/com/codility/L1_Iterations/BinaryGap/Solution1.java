package com.codility.L1_Iterations.BinaryGap;

class Solution {
    public int solution(int N) {
        String binary = Integer.toBinaryString(N);
        System.out.println(binary);
        int max = 0;
        int zerosCount = 0;
        // star with 1 because leading element is always '1'
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                zerosCount++;
            } else {
                max = Math.max(zerosCount, max);
                zerosCount = 0;
            }
        }
        return max;
    }
}