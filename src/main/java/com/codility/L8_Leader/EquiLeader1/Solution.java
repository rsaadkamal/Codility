package com.codility.L8_Leader.EquiLeader1;

import java.util.Stack;

class Solution {
    public int solution(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty()) {
                stack.push(A[i]);
            } else {
                if (stack.lastElement() != A[i]) {
                    stack.pop();
                } else {
                    stack.push(A[i]);
                }
            }
        }
        if (stack.isEmpty()) {
            return 0;
        }

        int total = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == stack.lastElement()) {
                total++;
            }
        }
        int leader = 0;
        if (total <= A.length / 2) {
            return 0;
        } else {
            leader = stack.lastElement();
        }

        int left = 0;
        int result = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == leader) {
                left++;
            }
            int right = total - left;
            if (left > (i + 1) / 2 && right > (A.length - i - 1) / 2) {
                result++;
            }
        }
        return result;
    }
}