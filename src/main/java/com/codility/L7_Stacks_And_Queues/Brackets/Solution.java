package com.codility.L7_Stacks_And_Queues.Brackets;

import java.util.*;

class Solution {
    public int solution(String S) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put(']', '[');
        brackets.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            char bracket = S.charAt(i);
            if (isClosingBracket(bracket)) {
                if (stack.size() == 0) {
                    return 0;
                }
                if (stack.lastElement() != brackets.get(bracket)) {
                    return 0;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(bracket);
            }
        }
        if (stack.size() != 0) {
            return 0;
        }
        return 1;
    }

    private boolean isClosingBracket(char bracket) {
        return new ArrayList<>(Arrays.asList(')', ']', '}')).contains(bracket);
    }
}