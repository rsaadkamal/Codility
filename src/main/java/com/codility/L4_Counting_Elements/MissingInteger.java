package com.codility.L4_Counting_Elements;

/*
* This is A demo task.

Write A function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Assume that:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Chaklader on 6/23/18.
 */
public class MissingInteger {


    /*
     * solution - A
     * */
    public static int solution(int[] A) {

        ArrayList<Integer> numbers = IntStream.of(A).boxed()
                .filter(x -> x > 0).sorted().distinct()
                .collect(Collectors.toCollection(ArrayList<Integer>::new));

        if (numbers.size() == 0) {
            return 1;
        }

        for (int i = 0; i < numbers.size(); i++) {

            if (numbers.get(i) != i + 1) {
                return i + 1;
            }
        }

        return numbers.size() + 1;
    }


    /*
     * solution - B
     * */
    public int solution1(int[] A) {

        boolean[] counter = new boolean[A.length + 1];

        for (int a : A) {

            /*
             * Each element of array A is an integer within the range [−1,000,000..1,000,000]
             * However, we will need to find the smallest positive integer and hence, don't need
             * to consider all the numbers.
             * */
            if (a > 0 && a < counter.length) {
                counter[a - 1] = true;
            }
        }

        for (int j = 0; j < counter.length; j++) {

            if (!counter[j]) {
                return j + 1;
            }
        }

        return A.length + 1;
    }

}