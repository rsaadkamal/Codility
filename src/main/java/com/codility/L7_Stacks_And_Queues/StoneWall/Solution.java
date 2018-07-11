package com.codility.L7_Stacks_And_Queues.StoneWall;

class Solution {

    public static int solution(int[] data) {
        int[] stack = new int[data.length];
        int counter = 0;
        int result = 0;
        for (int i : data) {
            while (counter > 0 && stack[counter - 1] > i) {
                counter -= 1;
            }
            if (!(counter > 0 && stack[counter - 1] == i)) {
                stack[counter] = i;
                result++;
                counter++;
            }
        }
        return result;
    }
}