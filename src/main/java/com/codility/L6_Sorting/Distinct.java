package com.codility.L6_Sorting;

/*
* Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

Assume that:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Complexity:

expected worst-case time complexity is O(N*log(N));
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


import java.util.*;
import java.util.stream.IntStream;

/**
 * Created by Chaklader on 6/24/18.
 */
public class Distinct {


    /*
     * solution - a
     */
    public static int solution(int[] A) {

        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int i = 0; i < A.length; i++) {

            Integer value = frequencies.containsKey(A[i]) ? frequencies.get(A[i]) + 1 : 1;
            frequencies.put(A[i], value);
        }

        return frequencies.size();
    }


    /*
     * solution - b
     */
    public static int solution1(int[] A) {


        Integer[] boxedA = Arrays.stream(A).boxed().toArray(Integer[]::new);
//        Integer[] boxedA1 = IntStream.of(A).boxed().toArray( Integer[]::new );

        Set<Integer> mySet = new HashSet<Integer>(Arrays.asList(boxedA));

//        Set<Integer> mySet = new HashSet<Integer>();
//        Collections.addAll(mySet, boxedA);

        // In Java 9+, if unmodifiable set is ok:
        // Set<Integer> mySet = Set.of(boxedA);

        // In Java 10+, the generic type parameter can be inferred from the arrays component type:
        // var mySet = Set.of(boxedA);
        return mySet.size();
    }


    /*
     * solution - c
     */
    public static int solution2(int[] A) {

        Arrays.sort(A);
        int dups = 0;

        for (int i = 1; i < A.length; i++) {

            if (A[i] == A[i - 1]) {
                dups++;
            }
        }

        return A.length - dups;
    }


    /*
     * solution - d
     */
    public int solution3(int[] A) {

        if (A.length <= 0) {
            return 0;
        }

        Arrays.sort(A);
        int prevElm = A[0], count = 1;

        for (int i = 1; i < A.length; i++) {

            if (A[i] != prevElm) {
                prevElm = A[i];
                count++;
            }
        }

        return count;
    }
}
