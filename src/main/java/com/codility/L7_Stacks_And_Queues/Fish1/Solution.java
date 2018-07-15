package com.codility.L7_Stacks_And_Queues.Fish1;

import java.util.Stack;

class Solution {
    public int solution(int[] A, int[] B) {
        Stack<Integer> upStream = new Stack<>();
        int survive = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[i] == 0) {
                if (upStream.size() > 0) {
                    boolean eaten = false;
                    while (upStream.size() > 0 && !eaten) {
                        if (A[i] > upStream.lastElement()) {
                            upStream.pop();
                            if (upStream.size() == 0) {
                                survive++;
                            }
                        } else {
                            eaten = true;
                        }
                    }
                } else {
                    survive++;
                }
            } else {
                upStream.push(A[i]);
            }
        }
        return upStream.size() + survive;
    }
}