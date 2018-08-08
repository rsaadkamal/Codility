package com.codility;


import com.codility.Graphs_Trees.BinarySearchTree;

import java.util.*;

public class App {


    public static int solution(int N) {

        int result = 0;

        String s = String.valueOf(N);
        int M = s.length();

        String t = s.substring(0, 1);
        boolean check = false;

        for (int i = 1; i < M; i++) {

            if (!t.equals(s.substring(i, i + 1))) {
                 check = true;
            }
        }

        /*
        * all are same
        * */
        if(!check){
            return 1;
        }

        Set<String> set = permutation(s);

        result = set.size();
        return result;
    }

    public static Set<String> permutation(String str) {

        Set<String> lis = new HashSet<>();

        permutation("", str, lis);
        return lis;
    }

    private static void permutation(String prefix, String str,
                                    Set<String> set) {

        int N = str.length();

        if (N == 0) {

            if (!prefix.startsWith("0")) {
                set.add(prefix);
            }
        } else {

            for (int i = 0; i < N; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1), set);
            }
        }
    }




    public static void main(String[] args) {

        System.out.println(solution(123));
    }
}

