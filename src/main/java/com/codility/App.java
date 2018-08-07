package com.codility;


import java.util.*;

public class App {


    /*
     *  ALGORITHM
     *  ---------
     *
     *  i.   start with the maximum flag and gradually decrement to 1. The condition
     *       is distance >= flags if we need to maximize ie distance = flags
     *
     *  ii.  as we set the flag number, use that as distance too to count the number of flags
     *
     *  iii. as we decrement the values, if we reached the condition flags = assumption, return
     *       assumption as an answer
     * */
    public static int solution(int[] A) {

        int N = A.length;

        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < N - 1; i++) {

            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                peaks.add(i);
            }
        }

        int F = peaks.size();

        for (int i = F; i >= 1; i--) {


            int marked = peaks.get(0);
            int count = 0;

            for (int j = 0; j < F; j++) {

                if (peaks.get(j) >= marked) {

                    marked = peaks.get(j) + i;
                    count++;

                    // not necessary as the max value of count can be equal to the flags (ie peaks)
//                    if(count == i){
//                        break;
//                    }
                }
            }

            if (i == count) {
                return count;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        int[] A = new int[12];

        A[0] = 1;
        A[1] = 5;
        A[2] = 3;
        A[3] = 4;
        A[4] = 3;
        A[5] = 4;
        A[6] = 1;
        A[7] = 2;
        A[8] = 3;
        A[9] = 4;
        A[10] = 6;
        A[11] = 2;

        System.out.println(solution(A));

    }
}

