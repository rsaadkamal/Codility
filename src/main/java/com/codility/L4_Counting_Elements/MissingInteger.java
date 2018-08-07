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


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Chaklader on 6/23/18.
 */
public class MissingInteger {


    /*
     * solution - a
     * */
    public static int solution(int[] A) {

        int N = A.length;

        if (N == 0) {
            return 1;
        }

        ArrayList<Integer> list = IntStream.of(A).boxed()
                .filter(x -> x > 0).sorted().distinct()
                .collect(Collectors.toCollection(ArrayList<Integer>::new));

        int M = list.size();

        for (int i = 0; i < M; i++) {

            if (list.get(i) != i + 1) {
                return i + 1;
            }
        }

        /*
         * all the numbers are in sequence
         * */
        return M + 1;
    }


    /*
     * solution - b
     * */
    public static int solution1(int[] A) {

        int N = A.length;

        boolean[] counter = new boolean[N + 1];

        int M = counter.length;

        for (int a : A) {

            /*
             * we consider only the numbers with range of  [1,2,3,....N]
             * */
            if (a > 0 && a < M) {

                int j = a - 1;
                counter[j] = true;
            }
        }

        for (int i = 0; i < counter.length; i++) {

            if (!counter[i]) {
                return i + 1;
            }
        }

        return N + 1;
    }


    /*
     * solution - c
     * */
    public static int solution2(int[] A) {

        Set<Integer> set = new TreeSet<>();

        for (int a : A) {
            set.add(a);
        }

        int N = set.size();

        int[] C = new int[N];

        int index = 0;

        for (int a : set) {
            C[index++] = a;
        }


        for (int i = 0; i < N; i++) {

            if (C[i] > 0 && C[i] <= N) {
                C[i] = 0;
            }
        }

        for (int i = 0; i < N; i++) {

            if (C[i] != 0) {
                return (i + 1);
            }
        }

        return (N + 1);
    }


    /*
     * solution - d
     * */
    public int solution3(int[] A) {

        int[] C = new int[A.length];

        int N = A.length;

        for (int i = 0; i < A.length; i++) {

            /*
             * we consider only the numbers with range of  [1,2,3,..,..,N]
             * */
            if (A[i] > 0 && A[i] <= N) {
                C[A[i] - 1] = A[i];
            }
        }

        for (int i = 0; i < C.length; i++) {

            if (C[i] == 0) {
                return i + 1;
            }
        }

        return A.length + 1;
    }


    /*
     * solution - e
     * */
    /*
     * if A = [-1,2] the solution breaks
     * */
    public static int solution4(int[] A) {

        int N = A.length;

        /*
         * Mark A[i] as visited by making A[A[i] - 1] negative
         * */
        for (int i = 0; i < N; i++) {

            /*
             * we need the absolute value for the duplicates
             * */
            int j = Math.abs(A[i]) - 1;

            if (j >= 0 && j < N && A[j] > 0) {
                A[j] = -A[j];
            }
        }

        for (int i = 0; i < N; i++) {

            if (A[i] > 0) {
                return i + 1;
            }
        }

        return N + 1;
    }


    /*
     * solution - f
     * */
    public static int solution5(int[] A) {

        Set<Integer> set = new HashSet<>();

        int N = A.length;

        for (int a : A) {

            if (a > 0 && a <= N) {
                set.add(a);
            }
        }

        for (int i = 0; i < N; i++) {
            if (!set.contains(i + 1)) {
                return i + 1;
            }
        }

        return (N + 1);
    }


    /*
     * solution - g
     * */
    public static int solution6(int[] A) {

        int N = A.length;

        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {

            if (A[i] > 0 && A[i] <= N) {
                set.add(A[i]);
            }
        }

        int index = 1;

        for (int a : set) {
            if (a > index) {
                return index;
            }

            index++;
        }

        return (N + 1);
    }


    /*
     * solution - h
     * */
    public static int solution7(int[] A) {

        int N = A.length;

        /*
         * set positions of non-positive or out of
         * range elements as free (use 0 as marker)
         * */
        for (int i = 0; i < N; i++) {

            if (A[i] <= 0 || A[i] > A.length) {
                A[i] = 0;
            }
        }

        /*
         * iterate through the whole array again
         * mapping elements [1,n] to positions [0, n-1]
         * */
        for (int i = 0; i < N; i++) {

            int prev = A[i];

            /*
             * while elements are not on their correct
             * positions keep putting them there
             * */
            while (prev > 0 && A[prev - 1] != prev) {

                int next = A[prev - 1];

                A[prev - 1] = prev;
                prev = next;
            }
        }

        /*
         * the first unmapped position is the smallest element
         * */
        for (int i = 0; i < N; i++) {

            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return N + 1;
    }


    /*
     * solution - i
     * */
    /*
     * if A = [-1,2] the solution works fine
     * */
    public static int solution8(int[] A) {

        int N = A.length;

        int[] C = new int[N];

        /*
         * Mark A[i] as visited by making A[A[i] - 1] negative
         * */
        for (int i = 0; i < N; i++) {

            /*
             * we need the absolute value for the duplicates
             * */
            int j = Math.abs(A[i]) - 1;

            if (j >= 0 && j < N && A[j] > 0) {
                C[j] = -A[j];
            }
        }

        for (int i = 0; i < N; i++) {

            if (C[i] == 0) {
                return i + 1;
            }
        }

        return N + 1;
    }


    public static void main(String[] args) {

        // this would return 1 as this is the missign smallest positive integer
        int[] A = {3, 0, 14, 78, 90};

    }

}