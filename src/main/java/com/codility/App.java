package com.codility;


import java.util.*;
import java.util.stream.IntStream;

public class App {


    public static void printMatrix(int[][] grid) {

        for (int r = 0; r < grid.length; r++) {

            for (int c = 0; c < grid[r].length; c++) {

                System.out.print(grid[r][c] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[] C = new int[5];

        C[0] = 4;
        C[1] = 6;
        C[2] = 7;
        C[3] = 10;
        C[4] = 2;

        int M = C.length;

        int[][] sortedNail = new int[M][2];

        for (int i = 0; i < M; i++) {
            sortedNail[i][0] = C[i];
            sortedNail[i][1] = i;
        }

        System.out.println("\n\n");
        printMatrix(sortedNail);



        Arrays.sort(sortedNail, (int x[], int y[]) -> x[0] - y[0]);

        System.out.println("\n\n");
        printMatrix(sortedNail);
    }
}
