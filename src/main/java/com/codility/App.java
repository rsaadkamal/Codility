package com.codility;


import java.util.*;
import java.util.stream.IntStream;

public class App {


    public static int solution(int[] A) {

        int peakCount = 0;

        ArrayList<Integer> peaks = new ArrayList<Integer>();

        /*
         * add all the peaks of the segments in the list
         * */
        for (int i = 1; i < A.length - 1; i++) {

            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                peaks.add(i);
                peakCount++;
            }
        }

        int numOfPeaks = peaks.size();
        int N = A.length;

        for (int sizeOfBlock = 1; sizeOfBlock <= N; sizeOfBlock++) {

            /*
             * A block need atleast elements equal
             * to or grater than of peak numbers
             *
             * ------------------------------------------------------
             * i.   N = array length
             * ii.  B = number of numOfBlocks
             * iii. E = number of elements in a block >= num of peaks
             * ------------------------------------------------------
             *
             * finally, B = N/(E >= num of peaks)
             * */

            int numOfBlocks = N / sizeOfBlock;

            if (N % sizeOfBlock != 0 || numOfBlocks > peakCount) {
                continue;
            }

            boolean success = true;
            int threshold = 0;

            for (int i = 0; i < numOfPeaks; i++) {

                /*
                 * Peaks = [3, 5, 10]
                 * */
                if (peaks.get(i) / sizeOfBlock > threshold) {
                    success = false;
                    break;
                }

                if (peaks.get(i) / sizeOfBlock == threshold) {
                    threshold++;
                }
            }

            if (threshold != numOfBlocks) {
                success = false;
            }

            if (success) {
                return numOfBlocks;
            }
        }

        return 0;
    }


    public static void main(String[] args) {

        int[] A = {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(solution(A));
    }
}
