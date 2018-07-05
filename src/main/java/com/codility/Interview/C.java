package com.codility.Interview;


/*
Every week or so, John travels to another city to meet his business partners. He always uses the
same highway, and since the trip is quite long, he stops at some rest areas to eat and refuel.
He has A fixed habit of stopping exactly three times: the first time to eat some light salad,
the second time to eat A pizza, and the third time to eat some nice cake. Different rest areas
offer different kinds of food, and John knows the exact locations of his favorite places: There
are N rest stops offering salads; the K-th stop is located at A[K] kilometers from the beginning
of the highway. There are N stops offering pizzas; the K-th stop is located at B[K] kilometers.
Finally, there are N stops offering cakes; the K-th stop is located at C[K] kilometers. Apart
from his fixed habit, John likes to change small details, so he never visits the same three
places more than once. He wonders how many journeys he must make before he is forced to repeat
A triplet of rest stops that he has used previously. Write A function:


class Solution { public int solution(int[] A, int[] B, int[] C); } that, given three non-empty
arrays A, B, C consisting of N integers each, denoting the locations of rest stops offering
different types of food, returns the number of ways John can pick three stops in different
locations (two locations are different if they have different distance from the beginning of
the highway), such that the first stop offers salad, the second one offers pizza, and the third
one offers cake. If the calculated result is greater than 1,000,000,000 the function should
return −1. Note that the rest stops can be given in any order and there could be many rest stops
of the same kind at the same kilometer. For example, given N = 2, A = [29, 50], B = [61, 37],
C = [37, 70], the function should return 3, since there are three ways to stop: (29, 37, 70),
or (29, 61, 70), or (50, 61, 70). The first triplet means that John can stop for salad at the
29th kilometer of his travel, for pizza at the 37th kilometer, and for cake at the 70th kilometer.
Given N = 2, A = [29, 29], B = [61, 61], C = [70, 70], the function should return 8, since there
are two ways of choosing each of the stops, making it 2*2*2 = 8. Given N = 1, A = [5], B = [5],
C = [5], the function should return 0. Assume that: N is an integer within the range [1..40,000];
each element of arrays A, B, C is an integer within the range [1..1,000,000,000].

Complexity: expected worst-case time complexity is O(N*log(N)); expected worst-case space
complexity is O(N) (not counting the storage required for input arguments).
*/


import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Chaklader on 7/5/18.
 */
public class C {


    public static int solution1(int[] A, int[] B, int[] C) {

        int N = A.length;
        int count = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {

            stack.push(A[i]);

            for (int j = 0; j < N; j++) {

                if (B[j] > stack.peek()) {
                    stack.push(B[j]);
                    System.out.println(Arrays.toString(stack.toArray()));
                }

                for (int k = 0; k < N; k++) {

                    if (C[k] > stack.peek()) {
                        stack.push(C[k]);
                        System.out.println(Arrays.toString(stack.toArray()));
                    }
                }
            }

            if (stack.size() == 3) {

                count++;
//                System.out.println(Arrays.toString(stack.toArray()));
            }
            stack.clear();


        }

        return count;
    }
}
