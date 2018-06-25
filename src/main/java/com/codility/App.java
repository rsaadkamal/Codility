package com.codility;


import java.util.*;

public class App {


    public static int gcd1(int a, int b) {

        if (a % b == 0) {
            return b;
        }
        return gcd1(b, a % b);
    }

    public static void main(String[] args) {

        System.out.println(gcd1(10, 4));
    }
}
