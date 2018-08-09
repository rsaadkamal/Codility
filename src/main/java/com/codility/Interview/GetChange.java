package com.codility.Interview;

/*
*
* A vending machine has the following denominations: 1c, 5c, 10c, 25c, 50c, and $1. Your task is to write a

* program that will be used in a vending machine to return change. Assume that the vending machine will always

* want to return the least number of coins or notes. Devise a function getChange(M, P) where M is how much money

* was inserted into the machine and P the price of the item selected, that returns an array of integers

* representing the number of each denomination to return.


Example:
getChange(5, 0.99) // should return [1,0,0,0,0,4]

* */


import java.util.Arrays;

/**
 * Created by Chaklader on 8/9/18.
 */
public class GetChange {


    public static int[] solution(double M, double P) {

        // 1c, 5c, 10c, 25c, 50c, and $1

        double rest = (M - P) * 100;

        int index = 5;

        int[] divisors = {1, 5, 10, 25, 50, 100};

        int[] result = new int[6];

        while (rest > 0) {

            if (index < 0) break;

            int v = (int) rest / divisors[index];

            rest -= v * divisors[index];

            if (v > 0) {
                result[index] = v;
            }

            index--;
        }

        result[0] += Math.ceil(rest);

        return result;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(5.0, 0.99)));
        System.out.println(Arrays.toString(solution(3.14, 1.99)));
        System.out.println(Arrays.toString(solution(4.0, 3.14)));
    }
}
