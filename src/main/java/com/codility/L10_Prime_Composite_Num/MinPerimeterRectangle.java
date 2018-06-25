package com.codility.L10_Prime_Composite_Num;

/*
* An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

(1, 30), with a perimeter of 62,
(2, 15), with a perimeter of 34,
(3, 10), with a perimeter of 26,
(5, 6), with a perimeter of 22.
Write a function:

class Solution { public int solution(int N); }

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Assume that:

N is an integer within the range [1..1,000,000,000].
Complexity:

expected worst-case time complexity is O(sqrt(N));
expected worst-case space complexity is O(1).
* */

/**
 * Created by Chaklader on 6/25/18.
 */
public class MinPerimeterRectangle {


    /*
     * solution -a
     */
    public static int solution(int N) {

        int min = Integer.MAX_VALUE;

        for (int i = 1; i * i <= N; i++) {

            if (N % i == 0) {
                min = 2 * (i + N / i) < min ? 2 * (i + N / i) : min;
            }
        }

        return min;
    }


    /*
     * solution - b
     */
    public int solution1(int N) {

        int min = 1 + N;
        int i = 1;

        while (i * i <= N) {

            if (N % i == 0) {
                min = Math.min(min, N / i + i);
            }

            i++;
        }

        return 2 * min;
    }


    /*
     * solution - c
     */
    public int solution2(int N) {

        int i = 1;
        int result = Integer.MAX_VALUE;

        while (i * i <= N) {

            if (N % i == 0) {

                int b = N / i;
                int currPerimeter = 2 * (i + b);

                if (currPerimeter < result) {
                    result = currPerimeter;
                }
            }

            i++;
        }

        return result;
    }
}
