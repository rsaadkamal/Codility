package com.codility.L7_Stacks_And_Queues.Nesting1;

class Solution {
    public int solution(String S) {
        char closing = ')';
        int sum = 0;
        for (int i = 0; i < S.length(); i++) {
            char currentSymbol = S.charAt(i);
            if (currentSymbol == closing) {
                sum--;
            } else {
                sum++;
            }
            if (sum < 0) {
                return 0;
            }
        }
        return sum == 0 ? 1 : 0;
    }
}