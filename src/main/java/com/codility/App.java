package com.codility;


import java.util.*;

public class App {


    public static int kThSmallestElement(int[] arr, int k) {

        return kThSmallestElement(arr, 0, arr.length - 1, k);
    }

    public static int kThSmallestElement(int[] arr, int left, int right, int k) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int index = partition(arr, left, right);

        if (index - left == k - 1) {
            return arr[index];
        } else if (index - left > k - 1) {
            return kThSmallestElement(arr, left, index - 1, k);
        } else {
            return kThSmallestElement(arr, index + 1, right, k - left + (index + 1));
        }
    }

    private static int partition(int[] arr, int left, int right) {

        int value = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {

            if (arr[j] < value) {

                if (i != j) {

                    arr[i] ^= arr[j];
                    arr[j] ^= arr[i];
                    arr[i] ^= arr[j];

                    i++;
                }
            }
        }

        if (i != right) {

            arr[i] ^= arr[right];
            arr[right] ^= arr[i];
            arr[i] ^= arr[right];
        }

        return i;
    }


    public static void main(String[] args) {

        int[] arr = {12, 445, 5, 6, 78};
        System.out.println(kThSmallestElement(arr, 2));
    }
}
