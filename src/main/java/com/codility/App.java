package com.codility;


import java.util.*;

/**
 * Created by Chaklader on 7/6/18.
 */
public class App {


    public static void main(String[] args) {

        int N = 100000000;

        for (int i = 1; i < N; i++) {

            if ((i % 2 == 0) && (i % 3 != 0 && i / 3 == 1)) {
                System.out.println(i);
            }
        }
    }
}

