package com.codility.L7_Stacks_And_Queues;

/*
* A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


import java.util.Stack;

/**
 * Created by Chaklader on 6/24/18.
 */
public class Brackets {

    /*
    Name of the brackets
    --------------------
    i.   Parentheses ( )
    ii.  Square brackets [ ]
    iii. Braces { }
    iv.  Angle brackets ⟨ ⟩
    */


    /*
     * String "{[()()]}" is properly nested but "([)()]" is not.
     * */
    /*
     * solution - a
     */
    public static int solution(String S) {


        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {

            if (stack.size() == 0) {
                stack.push(S.charAt(i));
            } else {
                if (isMatch(stack.peek(), S.charAt(i))) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }
        }
        return stack.size() == 0 ? 1 : 0;
    }


    private static boolean isMatch(char a, char b) {

        switch (a) {

            case '{': {
                return b == '}';
            }
            case '(': {
                return b == ')';
            }
            case '[': {
                return b == ']';
            }

            default:
                return false;
        }
    }


    /*
     * solution - b
     */
    public int solution1(String S) {

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < S.length(); i++) {

            switch (S.charAt(i)) {

                case '(':
                case '[':
                case '{':

                    stack.push(S.charAt(i));
                    break;


                case ')':
                    if (stack.isEmpty() || stack.peek() != '(') {
                        return 0;
                    } else {
                        stack.pop();
                    }
                    break;


                case ']':
                    if (stack.isEmpty() || stack.peek() != '[') {
                        return 0;
                    } else {
                        stack.pop();
                    }
                    break;


                case '}':
                    if (stack.isEmpty() || stack.peek() != '{') {
                        return 0;
                    } else {
                        stack.pop();
                    }

                    break;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }


    /*
     * solution - c
     */
    public int solution2(String s) {

        int numOfParentheses = 0;
        int numOfBraces = 0;
        int numOfSquareBrackets = 0;

        char[] storage = new char[s.length()];
        int index = 0;

        for (char ch : s.toCharArray()) {

            switch (ch) {

                case '(': {
                    numOfParentheses++;
                    storage[index++] = ch;
                    break;
                }

                case '{': {
                    numOfBraces++;
                    storage[index++] = ch;
                    break;
                }

                case '[': {
                    numOfSquareBrackets++;
                    storage[index++] = ch;
                    break;
                }

                case ')': {
                    if (index > 0 && storage[index - 1] == '(') {
                        numOfParentheses--;
                        index--;
                    } else {
                        return 0;
                    }
                    break;
                }

                case '}': {
                    if (index > 0 && storage[index - 1] == '{') {
                        numOfBraces--;
                        index--;
                    } else {
                        return 0;
                    }
                    break;
                }

                case ']': {
                    if (index > 0 && storage[index - 1] == '[') {
                        numOfSquareBrackets--;
                        index--;
                    } else {
                        return 0;
                    }
                    break;
                }
            }

            if (numOfParentheses < 0 || numOfBraces < 0 || numOfSquareBrackets < 0) {
                return 0;
            }
        }

        /*
         * check if the count of all kind of brackets are zero
         * */
        if (numOfParentheses == 0 && numOfBraces == 0 && numOfSquareBrackets == 0) {
            return 1;
        }

        return 0;
    }
}
