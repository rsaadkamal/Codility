package com.codility.L3_Time_Complexity;

/*
* A non-empty array A consisting of N integers is given. Array A represents numbers on A tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
We can split this tape in four places:

P = 1, difference = |3 − 10| = 7
P = 2, difference = |4 − 9| = 5
P = 3, difference = |6 − 7| = 1
P = 4, difference = |10 − 3| = 7
Write A function:

class Solution { public int solution1(int[] A); }

that, given A non-empty array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3
  A[1] = 1
  A[2] = 2
  A[3] = 4
  A[4] = 3
the function should return 1, as explained above.

Assume that:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−1,000..1,000].
Complexity:

expected worst-case time complexity is O(N);
expected worst-case space complexity is O(N) (not counting the storage required for input arguments).
* */


/**
 * Created by Chaklader on 6/23/18.
 */

/*
 * Given A non-empty array A of N integers, returns the minimal difference that can be achieved.
 * */
public class TapeEquilibrium {


    /*
     * solution1 - A
     * */
    public static int solution(int[] A) {

        int res = Integer.MAX_VALUE;

        int tmp = 0;
        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }

        for (int i = 0; i < A.length - 1; i++) {
            tmp += A[i];
            res = Math.min(res, Math.abs(tmp - (sum - tmp)));
        }
        return res;
    }


    /*
     * solution1-B
     * */
    public int solution1(int[] A) {

        int N = A.length;
        if (N == 1) {
            return A[0];
        }

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += A[i];
        }

        int least = Math.abs(A[0] - (sum - A[0]));

        int leftSum = 0;

        for (int i = 1; i < A.length; i++) {

            for (int j = 0; j < i; j++) {
                leftSum += A[j];
            }

            least = less(least, Math.abs(leftSum - (sum - leftSum)));
            leftSum = 0;
        }

        return least;
    }

    public int less(int i, int j) {
        if (i <= j) {
            return i;
        } else {
            return j;
        }
    }


    /*
     * solution1 - c
     * */
    public int solution3(int[] A) {

        int sum = 0;
        int result = Integer.MAX_VALUE;

        for (final int value : A) {
            sum += value;
        }

        int left = 0;
        int right = sum;

        for (int i = 1; i < A.length; i++) {

            left += A[i - 1];
            right -= A[i - 1];

//            if (Math.abs(right - left) < result) {
//                result = Math.abs(right - left);
//            }

            result = Math.max(Math.abs(right - left), result);
        }

        return result;
    }
}
